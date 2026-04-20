package com.util;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.entities.Booking;
import com.entities.Movie;

public class HibernateUtil 
{
	public static SessionFactory sessionFactory=null;
	
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory==null)
		{
			Configuration cfg=new Configuration();
			cfg.configure("hibernate.cfg.xml");
			cfg.addAnnotatedClass(Booking.class);
			cfg.addAnnotatedClass(Movie.class);
			sessionFactory=cfg.buildSessionFactory();
			return sessionFactory;
		}
		else
		{
			return sessionFactory;
		}
	}
	

}
