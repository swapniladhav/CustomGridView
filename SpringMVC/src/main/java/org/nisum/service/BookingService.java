package org.nisum.service;

import org.nisum.model.Booking;
import org.nisum.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;

	public void bookRestaurant(Booking booking) {
		bookingRepository.save(booking);
	}

	public Booking getBookingByName(String userName) {
		return bookingRepository.findByUserName(userName);
	}

}
