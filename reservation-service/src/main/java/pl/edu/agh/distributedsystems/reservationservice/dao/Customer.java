package pl.edu.agh.distributedsystems.reservationservice.dao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String secondName;
    private String phoneNumber;
    private String address;
    private String pesel;
}
