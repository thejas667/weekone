package com.example.dbdata;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class PassangerDtl implements Serializable {
        /**
         *
         */
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String passangerName;
        private long passangerAge;
        private String foodType;
        private Character gender;
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "book_flight_fk", nullable = false)
        private BookFlightTicket bookFlightTicket;
        private String ticketStatus;


}
