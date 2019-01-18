package samson.model;

public class UserTest {
public static void main(String[] args) {
	System.out.println("start");
	//String id, String firstname, String surname, String phone, String email, String password, String dob,
	//String gender, String type, String street, String city, String country, String coordinates
	//User u = new User("","","","","","","","","","","","","");
	User u = new User("0","samson","rukundo","0894892552","samson@hotmail.com","samson","23-11-1990","M","Client","5 best street , Nangor Road","Dublin","Ireland","53.15488,35.25878995");
	
	System.out.println(u.toString());
}
}
