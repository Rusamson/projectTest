package samson.model;

public class GroupRecord {
private String id;
private String email;
private String firstname;
private String surname;
public GroupRecord(String id, String email, String firstname, String surname) {
	//super();
	this.id = id;
	this.email = email;
	this.firstname = firstname;
	this.surname = surname;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
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
@Override
public String toString() {
	return "GroupRecord [id=" + id + ", email=" + email + ", firstname=" + firstname + ", surname=" + surname + "]";
}

}
