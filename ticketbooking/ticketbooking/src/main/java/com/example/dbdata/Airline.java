package com.example.dbdata;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
public class Airline implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String airlineName;

    private String ownerName;

    private String ownerMobile;

    @OneToMany(mappedBy = "airline", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Address> ownerAddress;

    @OneToMany(mappedBy = "airline", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<FlightSchedule> flightSchedules;

    private String airlineLogo;

    private Long totFlights;

    private Long activeFlights;

    private String status;

}
