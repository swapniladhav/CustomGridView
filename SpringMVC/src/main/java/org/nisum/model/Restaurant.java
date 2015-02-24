package org.nisum.model;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "Restaurants")
public class Restaurant extends AuditEntity {

	private String name;

	private String location;

	private String street;

	private String city;

	private int capacity;

	private String contactNumber;

}
