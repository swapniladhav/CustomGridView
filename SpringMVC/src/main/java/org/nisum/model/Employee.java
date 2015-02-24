package org.nisum.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
@Document(collection = "Employee")
public class Employee implements Serializable{
	private static final long serialVersionUID = -7788619177798333712L;
	private int id; 
    private String name;
     private Date createdDate;
 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	  @JsonSerialize(using = DateSerializer.class)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	} 
	
      
}
