package pl.edu.agh.distributedsystems.reservationservice.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Customer customer;

    private Date placedAtDate;
    private Date startDate;
    private Date endDate;

    private Integer hotelId;
    private Integer roomNumber;
}
