package com.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="movie")
public class Movie 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int movieId;
	
	private String movieName;
	private String movieGenre;
	private float movieRating;
	private int ticketPrice;
	
	@OneToMany(mappedBy="movie",cascade=CascadeType.ALL)
	private List<Booking> bookings;

	public Movie(String movieName, String movieGenre, float movieRating, int ticketPrice, List<Booking> booking) {
		super();
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieRating = movieRating;
		this.ticketPrice = ticketPrice;
		this.booking = booking;
	}
	
	
	public Movie(String movieName, String movieGenre, float movieRating, int ticketPrice) {
		super();
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieRating = movieRating;
		this.ticketPrice = ticketPrice;
	}





	public Movie() {
		super();
	}

	public Movie(int movieId, String movieName, String movieGenre, float movieRating, int ticketPrice,
			List<Booking> booking) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieRating = movieRating;
		this.ticketPrice = ticketPrice;
		this.booking = booking;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public float getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(float movieRating) {
		this.movieRating = movieRating;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBookings(List<Booking> bList) {
		this.bookings = bList;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieGenre=" + movieGenre
				+ ", movieRating=" + movieRating + ", ticketPrice=" + ticketPrice + "]";
	}


}
