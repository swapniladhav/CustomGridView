package org.nisum.service;

import java.util.List;

import org.nisum.model.Employee;
import org.nisum.mongo.MongoDbConnection;
import org.nisum.repository.ConnectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

@Service
public class EmployeeService {

	@Autowired
	private ConnectRepository connectRepository;

	public void connectRepo( List<Employee>  connect) {
		connectRepository.save(connect);
	}

	public List<Employee> getUserByName(String userName) {
		return connectRepository.findByName(userName);
	}

  

	public List<Employee> getAllUser() {
		return (List<Employee>) connectRepository.findAll();
	}

	public void deleteAllUser() {
		connectRepository.deleteAll();
	}

	public void deleteUserByName(String Name){
		MongoDbConnection mongoDbConnection = MongoDbConnection.getConnection();
		DB db = mongoDbConnection.getMongodb().getDB("Employee");
		DBCollection table = db.getCollection("Employee");
		BasicDBObject document = new BasicDBObject();
		document.put("name", Name);
		 
		WriteResult wr = table.remove(document);
		
	}

	public long getCount() {
		return connectRepository.count();
	}

	public Employee getUserByUserNameAndUserEmail(String userName,
			String userEmail) {
		MongoDbConnection mongoDbConnection = MongoDbConnection.getConnection();
		DB db = mongoDbConnection.getMongodb().getDB("connect");
		DBCollection table = db.getCollection("Connect");
		BasicDBObject document = new BasicDBObject();
		document.put("userName", userName);
		document.put("userEmail", userEmail);
		DBCursor dbCorsor = table.find(document);
		Employee connect = new Employee();
		while (dbCorsor.hasNext()){
			DBObject dbObject = dbCorsor.next();
		
			
		}

		return connect;
	}
}

