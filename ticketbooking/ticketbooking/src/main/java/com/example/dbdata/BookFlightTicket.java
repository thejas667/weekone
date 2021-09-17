package com.example.dbdata;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
public class BookFlightTicket implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private long numberOfBooking;
        @OneToMany(mappedBy = "bookFlightTicket", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        private Set<PassangerDtl> passangerDlt;
        private long loggedInUserId;
        private long flightId;
        private LocalDate dateOfJourney;
        private String bookingClass;
        private long totTickets;


}
