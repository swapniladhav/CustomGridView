package org.nisum.repository;

import org.nisum.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking, String> {

	public Booking findByUserName(String userName);

}
