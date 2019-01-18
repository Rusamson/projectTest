package samson.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Booking { 
	private String id;
	private String sourceId;
	private String targetId;
	private String name;
	private String status; 
	private boolean visibility;
	private String time;
	private String street;
	private String city;
	private String country;
	private String location;
	private String message;
	private String timestamp;
	
	public Booking(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 
		timestamp =  dtf.format(now);
	}

	public Booking(String id, String sourceId, String targetId, String name, String status, boolean visibility,
			String time, String street, String city, String country, String location, String message) {
		//super();
		this.id = id;
		this.sourceId = sourceId;
		this.targetId = targetId;
		this.name = name;
		this.status = status;
		this.visibility = visibility;
		this.time = time;
		this.street = street;
		this.city = city;
		this.country = country;
		this.location = location;
		this.message = message;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 
		timestamp =  dtf.format(now);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimestamp() {
		return timestamp;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", sourceId=" + sourceId + ", targetId=" + targetId + ", name=" + name
				+ ", status=" + status + ", visibility=" + visibility + ", time=" + time + ", street=" + street
				+ ", city=" + city + ", country=" + country + ", location=" + location + ", message=" + message
				+ ", timestamp=" + timestamp + "]";
	} 
   
    
}
	