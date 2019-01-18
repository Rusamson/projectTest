package samson.model;
 

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date; 
/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author Samson
 *
 */
 
public class User {
	private String id;
	private String firstname; 
	private String surname;
	private String phone;	
	private String email;
	private String password;
	private String dob;
	private String gender;	
	private String type;	
	private String street;
	private String city;
	private String country;
	private String coordinates;	
	private String joined;
	public User(String id, String firstname, String surname, String phone, String email, String password, String dob,
			String gender, String type, String street, String city, String country, String coordinates) {
		//super();
		this.id = id;
		this.firstname = firstname;
		this.surname = surname;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
		this.type = type;
		this.street = street;
		this.city = city;
		this.country = country;
		this.coordinates = coordinates;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 
		this.joined = dtf.format(now);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	public String getJoined() {
		return joined;
	}
	/*public void setJoined(String joined) {
		this.joined = joined;
	}*/
	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", surname=" + surname + ", phone=" + phone + ", email="
				+ email + ", password=" + password + ", dob=" + dob + ", gender=" + gender + ", type=" + type
				+ ", street=" + street + ", city=" + city + ", country=" + country + ", coordinates=" + coordinates
				+ ", joined=" + joined + "]";
	}
	
	
}