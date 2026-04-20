package com.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="booking")
public class Booking 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	
	private String customerName;
	private int numberOfTickets;
	private int totalCost;
	
	@ManyToOne(fetch=FetchType.LAZY) //lazy=withoutMovieDetails
	@JoinColumn(name="movieId")
	private Movie movie;

	public Booking() {
		super();
	}

	public Booking(String customerName, int numberOfTickets, int totalCost) {
		super();
		this.customerName = customerName;
		this.numberOfTickets = numberOfTickets;
		this.totalCost = totalCost;
	}

	public Booking(String customerName, int numberOfTickets, int totalCost, Movie movie) {
		super();
		this.customerName = customerName;
		this.numberOfTickets = numberOfTickets;
		this.totalCost = totalCost;
		this.movie = movie;
	}

	public Booking(int bookingId, String customerName, int numberOfTickets, int totalCost, Movie movie) {
		super();
		this.bookingId = bookingId;
		this.customerName = customerName;
		this.numberOfTickets = numberOfTickets;
		this.totalCost = totalCost;
		this.movie = movie;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getNumberOfTickets() {
		return numberOfTickets;
	}

	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", customerName=" + customerName + ", numberOfTickets="
				+ numberOfTickets + ", totalCost=" + totalCost + "]";
	}
	

}
