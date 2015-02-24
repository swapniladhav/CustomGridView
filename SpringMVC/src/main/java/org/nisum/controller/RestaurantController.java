package org.nisum.controller;

import java.util.List;

import org.nisum.model.Restaurant;
import org.nisum.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	@RequestMapping(value="/restaurant", method=RequestMethod.POST)
	public ResponseEntity<String> createRestaurant(@RequestBody  Restaurant restaurant){
		restaurantService.createRestaurant(restaurant);
		return new ResponseEntity<String>("Restaurant Created", HttpStatus.OK);
	}
	
	@RequestMapping(value="/restaurant/find-all", method=RequestMethod.GET)
	public ResponseEntity<List<Restaurant>> getAllRestaurants(){
		return new ResponseEntity<List<Restaurant>>(restaurantService.getAllRestaurant(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/restaurant", method=RequestMethod.GET)
	public ResponseEntity<List<Restaurant>> getRestaurantsByLocation(@RequestParam(value = "location", required = true) String location){
		List<Restaurant> restaurants = restaurantService.getRestaurantByLocation(location);
		return new ResponseEntity<List<Restaurant>>(restaurants, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/restaurant/capacity", method=RequestMethod.GET)
	public ResponseEntity<List<Restaurant>> getRestaurantsByCapacity(@RequestParam(value = "capacity", required = true) int capacity){
		List<Restaurant> restaurants = restaurantService.getRestaurantByCapacity(capacity);
		return new ResponseEntity<List<Restaurant>>(restaurants, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/restaurant/criteria", method=RequestMethod.GET)
	public ResponseEntity<List<Restaurant>> getRestaurantsByLocationAndCapacity(@RequestParam(value = "location", required = true) String location,@RequestParam(value = "capacity", required = true) int capacity){
		List<Restaurant> restaurants = restaurantService.getRestaurantByLocationAndCapacity(location,capacity);
		return new ResponseEntity<List<Restaurant>>(restaurants, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/restaurant/id", method=RequestMethod.GET)
	public ResponseEntity<Restaurant> getRestaurantById(@RequestParam(value = "id", required = true) String id){
		Restaurant restaurant = restaurantService.getRestaurantById(id);
		return new ResponseEntity<Restaurant>(restaurant, HttpStatus.OK);
	}
	
	
}
