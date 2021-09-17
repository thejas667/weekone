package com.example.dbdata;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "flight_schedule")
public class FlightSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long flightCode;

    private LocalTime takeOff;

    private LocalTime landingTime;

    private Long airCraft;

    private String days;

    private Long bussinessClassSeats;

    private Double bussinessClassSeatCost;

    private Long firstClassSeats;

    private Double firstClassSeatCost;

    private Long secondClassSeats;

    private Double secondClassSeatCost;

    private Long thirdClassSeats;

    private Double thirdClassSeatCost;

    private String meal;

    private Long fromCity;

    private Long toCity;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_fk", nullable = false)
    private Airline airline;

}
