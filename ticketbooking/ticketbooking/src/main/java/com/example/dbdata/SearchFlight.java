package com.example.dbdata;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SearchFlight {
        private long toCity;
        private long fromCity;
        private LocalDate journeyDate;
        private String bookingClass;

}
