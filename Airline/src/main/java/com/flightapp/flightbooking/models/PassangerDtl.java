package com.flightapp.flightbooking.models;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


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
