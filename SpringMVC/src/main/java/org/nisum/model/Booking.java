package org.nisum.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "Bookings")
public class Booking extends AuditEntity {
	private String userName;

	private String userEmail;

	private String userContact;

	private String restoName;

	private String restoId;

	private Date bookingDate;
}
