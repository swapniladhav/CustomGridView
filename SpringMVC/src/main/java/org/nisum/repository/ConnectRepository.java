package org.nisum.repository;

import org.nisum.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.lang.String;
import java.util.List;

@Repository
public interface ConnectRepository extends CrudRepository<Employee, String> {

	List<Employee> findByName(String name);
	
	
	
}

