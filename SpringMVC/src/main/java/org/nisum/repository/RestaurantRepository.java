package org.nisum.repository;

import java.util.List;

import org.nisum.model.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, String> {
	
	public Restaurant findByName(String name);
	
	public List<Restaurant> findByLocation(String location);

	public List<Restaurant> findByCapacity(int capacity);

	public List<Restaurant> findByLocationAndCapacity(String location, int capacity);
	
}
