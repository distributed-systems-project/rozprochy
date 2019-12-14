package pl.edu.agh.distributedsystems.reservationservice;

import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.distributedsystems.reservationservice.client.BuildingClient;
import pl.edu.agh.distributedsystems.reservationservice.dao.Reservation;
import pl.edu.agh.distributedsystems.reservationservice.dao.ReservationRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired BuildingClient buildingClient;

    @PostMapping
    public ResponseEntity<?> createReservation(@Valid @RequestBody Reservation reservation) {
        try {
            buildingClient.findByHotel(reservation.getHotelId().longValue());
            return ResponseEntity.ok(reservationRepository.save(reservation));
        } catch (FeignException e) {
            return ResponseEntity.badRequest().body("No such hotel");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable(value = "id") Long reservationID) {
        Optional<Reservation> reservation = reservationRepository.findById(reservationID);

        if(reservation.isPresent()) {
            return ResponseEntity.ok(reservation.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getReservations() {
        return ResponseEntity.ok(reservationRepository.findAll());
    }
}
