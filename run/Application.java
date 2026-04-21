package com.run;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.SelectionQuery;

import com.entities.Booking;
import com.entities.Movie;
import com.util.HibernateUtil;

public class Application 
{
	public static void main(String[] args) 
	{
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		
		session.beginTransaction();
		
		MutationQuery mq=session.createNativeMutationQuery("ALTER TABLE movie MODIFY ticketPrice FLOAT");
		mq.executeUpdate();
		
		session.getTransaction().commit();
		
		
		
	}

	private static void updateTicketPrice(Session session) {
		session.beginTransaction();
		
		MutationQuery mq=session.createMutationQuery("UPDATE Movie SET ticketPrice=1.1*ticketPrice");
		mq.executeUpdate();
		
		session.getTransaction().commit();
	}

	private static void aggregateFunctions(Session session) {
		session.beginTransaction();
		
		SelectionQuery<Integer> sq=session.createSelectionQuery("SELECT max(ticketPrice) From Movie",Integer.class);
		System.out.println(sq.getSingleResult());
		
		SelectionQuery<Double> sq1=session.createSelectionQuery("SELECT avg(ticketPrice) From Movie",Double.class);
		System.out.println(sq1.getSingleResult());
		
		session.getTransaction().commit();
	}

	private static void orderByDesc(Session session) {
		SelectionQuery<Movie> sq=session.createSelectionQuery("From Movie ORDER BY ticketPrice DESC",Movie.class);
		List<Movie> movieList=sq.list();
		movieList.forEach(System.out::println);
		
		session.getTransaction().commit();
	}

	private static void movieTitles(Session session) {
		session.beginTransaction();
				
				SelectionQuery<String> sq=session.createSelectionQuery("SELECT movieName From Movie",String.class);
				List<String> movieList=sq.list();
				movieList.forEach(System.out::println);
				
				session.getTransaction().commit();;
	}

	private static void ratingGreaterEight(Session session) {
				session.beginTransaction();
				SelectionQuery<Movie> sq=session.createSelectionQuery("From Movie where movieRating>8",Movie.class);
				List<Movie> movieList=sq.list();
				movieList.forEach(System.out::println);
				session.getTransaction();
	}

	private static void delete(Session session) {
		session.beginTransaction();
		MutationQuery mq=session.createMutationQuery("DELETE from Booking where movie.movieId=?1");
		mq.setParameter(1, 2);
		mq.executeUpdate();
		
		MutationQuery mq1=session.createMutationQuery("DELETE from Movie where movieId=?1");
		mq1.setParameter(1, 2);
		mq1.executeUpdate();
		session.getTransaction().commit();
	}

	private static void updateNumberOfTickets(Session session) {
		session.beginTransaction();
		
		
		session.getTransaction().commit();
	}

	private static void updateTicket(Session session) {
		session.beginTransaction();
		
		MutationQuery mq1=session.createMutationQuery("UPDATE Movie set ticketPrice=?1 where movieId=?2");
		mq1.setParameter(1, 240);
		mq1.setParameter(2,3);
		mq1.executeUpdate();
		
		MutationQuery mq2=session.createMutationQuery("UPDATE Booking set numberOfTickets=?1 where bookingId=?2");
		mq2.setParameter(1,5);
		mq2.setParameter(2,2);
		mq2.executeUpdate();
	
		List<Booking> bookingList = session.createSelectionQuery("FROM Booking", Booking.class).list();
		for (Booking b : bookingList) {
		    int newTotal = b.getNumberOfTickets() * b.getMovie().getTicketPrice();
		    b.setTotalCost(newTotal);
		}

		session.getTransaction().commit();
		
	
	}

	private static void readAllBookings(Session session) {
		session.beginTransaction();
		
		SelectionQuery<Booking> sq=session.createSelectionQuery("From Booking",Booking.class);
		List<Booking> movieList=sq.list();
		movieList.forEach(System.out::println);
		
		session.getTransaction();
	}

	private static void readAllMovies(Session session) {
		session.beginTransaction();
		
		SelectionQuery<Movie> sq=session.createSelectionQuery("From Movie",Movie.class);
		List<Movie> movieList=sq.list();
		movieList.forEach(System.out::println);
		
		session.getTransaction();
	}

	private static void insert(Session session) {
		session.beginTransaction();
		
		Movie m1=new Movie("Leo","Action",8.5f,200);
		Booking b1=new Booking("Ravi",2,2*m1.getTicketPrice());
		Booking b2=new Booking("Teja",8,8*m1.getTicketPrice());
		b1.setMovie(m1);
		b2.setMovie(m1);

		List<Booking> bList1=new ArrayList<>();
		bList1.add(b1);
		bList1.add(b2);
		m1.setBookings(bList1);
		
		
		Movie m2=new Movie("Jailer","Drama",8.0f,180);
		Booking b3=new Booking("Kona",3,3*m2.getTicketPrice());
		Booking b4=new Booking("Kumar",1,1*m2.getTicketPrice());
		Booking b5=new Booking("Durga",6,6*m2.getTicketPrice());
		Booking b6=new Booking("Prasad",2,2*m2.getTicketPrice());
		b3.setMovie(m2);
		b4.setMovie(m2);
		b5.setMovie(m2);
		b6.setMovie(m2);
		
		List<Booking> bList2=new ArrayList<>();
		bList2.add(b3);
		bList2.add(b4);
		bList2.add(b5);
		bList2.add(b6);
		m2.setBookings(bList2);
		
		
		Movie m3=new Movie("F3","Comedy",8.3f,150);
		Booking b7=new Booking("Vijay",7,7*m3.getTicketPrice());
		Booking b8=new Booking("Mani",2,2*m3.getTicketPrice());
		Booking b9=new Booking("Kanna",4,4*m3.getTicketPrice());
		Booking b10=new Booking("Bunny",9,9*m3.getTicketPrice());
		b7.setMovie(m3);
		b8.setMovie(m3);
		b9.setMovie(m3);
		b10.setMovie(m3);
		
		List<Booking> bList3=new ArrayList<>();
		bList3.add(b7);
		bList3.add(b8);
		bList3.add(b9);
		bList3.add(b10);
		m3.setBookings(bList3);
		
		
		session.persist(m1);
		session.persist(m2);
		session.persist(m3);
		
		session.getTransaction().commit();
	}

}
