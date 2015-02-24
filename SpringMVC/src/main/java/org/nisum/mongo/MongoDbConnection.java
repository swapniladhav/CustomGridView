package org.nisum.mongo;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

public class MongoDbConnection {

	@Autowired
	private MongoClient mongoClient;

	@Autowired
	private Mongo mongodb;

	private MongoDbConnection(MongoClient mongoClient, Mongo mongodb) {
		super();
		this.mongoClient = mongoClient;
		this.mongodb = mongodb;
	}

	public MongoDbConnection()  {
		try {
			this.mongodb = new Mongo("localhost", 27017);
			this.mongoClient =  new MongoClient("localhost", 27017);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static MongoDbConnection getConnection() {
			return new MongoDbConnection(); 
	}

	public MongoClient getMongoClient() {
		return mongoClient;
	}

	public void setMongoClient(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}

	public Mongo getMongodb() {
		return mongodb;
	}

	public void setMongodb(Mongo mongodb) {
		this.mongodb = mongodb;
	}

}
