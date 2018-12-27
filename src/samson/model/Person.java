package samson.model;

public class Person {
private String id;
private String name;
private String joinedSince;
private String password;

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getJoinedSince() {
	return joinedSince;
}
public void setJoinedSince(String joinedSince) {
	this.joinedSince = joinedSince;
}

}
