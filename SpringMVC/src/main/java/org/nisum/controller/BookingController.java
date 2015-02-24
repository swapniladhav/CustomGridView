package org.nisum.controller;

import org.nisum.model.Booking;
import org.nisum.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@RequestMapping(value = "/booking", method = RequestMethod.POST)
	public ResponseEntity<String> bookRestaurants(@RequestBody Booking booking) {
		bookingService.bookRestaurant(booking);
		return new ResponseEntity<String>("Succesfully Booked", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/booking", method = RequestMethod.GET)
	public ResponseEntity<Booking> getBookingsByName(@RequestParam(value = "username", required = true) String userName) {
		Booking booking = bookingService.getBookingByName(userName);
		return new ResponseEntity<Booking>(booking, HttpStatus.OK);
	}

}
