package samson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import samson.model.Booking;
import samson.model.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static Map<String, User> userCache = new HashMap<String, User>();  
	   User u1 = new User("1","dolly","kamaliza","514 222 3500"," dolly1@hotmail.com ","dolly","15-04-1970","F","care"," rue Des Saules ","Mirabel","Canada","");
	   User u2 = new User("2"," angelos "," muhire ","514 444 3520"," angelos1hotmail.com "," angelos ","15-04-1990","F","care"," rue De Lublin "," Laval ","Canada","");
	   User u3 = new User("3"," jeannino "," Simone ","514 230 1500"," jeannino1@hotmail.com "," jeannino ","20-03-1985","F","care"," Lachapelle "," Montreal ","Canada","");
	   User u4 = new User("4"," gennet "," brown ","514 240 1700"," gennet1@hotmail.com "," gennet ","13-04-1989","F","care"," Saint Paul "," Chateauguay ","Canada","");
	   User u5 = new User("5"," fidman"," brown ","514 140 1717"," fidman1@hotmail.com "," fidman ","15-04-1970","M","care"," Saint Paul "," Chateauguay ","Canada","");
	   User u6 = new User("6"," monica "," terry ","514 220 8000"," monica1@hotmail.com "," monica ","04-03-1982","F","care"," Dollar "," Montréal ","Canada","");
	   User u7 = new User("7"," olliy "," luke ","514 111 5400"," olliy1@hotmail.com "," olliy ","13-04-1969","F","care"," Aylwin "," Montréal ","Canada","");
	   User u8 = new User("8"," ireno "," dawson ","514 230 6677"," ireno1@hotmail.com "," ireno ","11-11-1990","F","care"," Hebert "," Montréal ","Canada","");
	   User u9 = new User("9"," florento "," dawson ","514 240 0055"," florento1@hotmail.com "," florento ","20-11-1979","F","care"," Veilliette "," Montréal ","Canada","");
	   User u10 = new User("10"," rachero "," kim ","514 720 0088"," rachero1@hotmail.com "," rachero ","04-03-1982","F","care"," 42e avenue "," Montréal ","Canada","");
	   User u11 = new User("11"," nadjery "," mimi ","514 660 0125"," nadjery1@hotmail.com "," nadjery ","13-04-1969","F","care"," Nellygan "," Montréal ","Canada","");
	   User u12 = new User("12"," beatty "," amani ","514 330 0238"," beatty1@hotmail.com "," beatty ","11-11-1990","F","care"," Tecumseh "," Montréal ","Canada","");
	   User u13 = new User("13"," nelito "," kerry ","514 526 0256"," nelito1@hotmail.com "," nelito ","17-11-1998","F","care"," Terrasse Turcotte  "," Montréal ","Canada","");
	   User u14 = new User("14"," rozzy "," thomson ","857 240 1122"," rozzy1@hotmail.com "," rozzy ","13-12-2000","F","care"," massachusetts  street"," Boston ","USA","");
	   User u15 = new User("15"," dodieu "," mboka ","514 120 6347"," dodieu1hotmail.com "," dodieu ","10-12-1999","M","care"," Central "," Montreal", "Canada","");
/*	   

"1","dolly","kamaliza","514 222 3500"," dolly1@hotmail.com ","dolly","15-04-1970","F","care"," rue Des Saules ","Mirabel","Canada",""
"2"," angelos "," muhire ","514 444 3520"," angelos1hotmail.com "," angelos ","15-04-1990","F","care"," rue De Lublin "," Laval ","Canada",""
"3"," jeannino "," Simone ","514 230 1500"," jeannino1@hotmail.com "," jeannino ","20-03-1985","F","care"," Lachapelle "," Montreal ","Canada",""
"4"," gennet "," brown ","514 240 1700"," gennet1@hotmail.com "," gennet ","13-04-1989","F","care"," Saint Paul "," Chateauguay ","Canada",""
"5"," fidman"," brown ","514 140 1717"," fidman1@hotmail.com "," fidman ","15-04-1970","M","care"," Saint Paul "," Chateauguay ","Canada",""
"6"," monica "," terry ","514 220 8000"," monica1@hotmail.com "," monica ","04-03-1982","F","care"," Dollar "," Montréal ","Canada",""
"7"," olliy "," luke ","514 111 5400"," olliy1@hotmail.com "," olliy ","13-04-1969","F","care"," Aylwin "," Montréal ","Canada",""
"8"," ireno "," dawson ","514 230 6677"," ireno1@hotmail.com "," ireno ","11-11-1990","F","care"," Hebert "," Montréal ","Canada",""
"9"," florento "," dawson ","514 240 0055"," florento1@hotmail.com "," florento ","20-11-1979","F","care"," Veilliette "," Montréal ","Canada",""
"10"," rachero "," kim ","514 720 0088"," rachero1@hotmail.com "," rachero ","04-03-1982","F","care"," 42e avenue "," Montréal ","Canada",""
"11"," nadjery "," mimi ","514 660 0125"," nadjery1@hotmail.com "," nadjery ","13-04-1969","F","care"," Nellygan "," Montréal ","Canada",""
"12"," beatty "," amani ","514 330 0238"," beatty1@hotmail.com "," beatty ","11-11-1990","F","care"," Tecumseh "," Montréal ","Canada",""
"13"," nelito "," kerry ","514 526 0256"," nelito1@hotmail.com "," nelito ","17-11-1998","F","care"," Terrasse Turcotte  "," Montréal ","Canada",""
"14"," rozzy "," thomson ","857 240 1122"," rozzy1@hotmail.com "," rozzy ","13-12-2000","F","care"," massachusetts  street"," Boston ","USA",""
"15"," dodieu "," mboka ","514 120 6347"," dodieu1hotmail.com "," dodieu ","10-12-1999","M","care"," Central "," Montreal", "Canada",""


*/
	   
	
	private int size = 5;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        userCache.put("1", u1);
        userCache.put("2", u2);
        userCache.put("3", u3);
        userCache.put("4", u4);
        userCache.put("5", u5); 
        
        userCache.put("6", u6);
        userCache.put("7", u7);
        userCache.put("8", u8);
        userCache.put("9", u9);
        userCache.put("10", u10); 
        
        userCache.put("11", u11);
        userCache.put("12", u12);
        userCache.put("13", u13);
        userCache.put("14", u14);
        userCache.put("15", u15); 
    } 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		ServletOutputStream out = response.getOutputStream();
		   if(request.getParameter("operation").equals("all")) {
					GsonBuilder gsonMapBuilder = new GsonBuilder();
					Gson gsonObject = gsonMapBuilder.create();
					String JSONObject = gsonObject.toJson(userCache.values());
					if(!JSONObject.equals("null")) {
			        out.print(JSONObject);
					}
			        out.flush();
			   }
		   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
