package com.example.dbdata;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Address implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String street;

    private String pinCode;

    private String city;

    private String state;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "airline_fk", nullable = false)
    private Airline airline;


}
