package samson;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

import samson.model.*;
/**
 * Servlet implementation class MainController
 */
@WebServlet("/index")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Map<String, Person> apiCache = new HashMap<String, Person>();
    int size = 0;
    /**
     * Default constructor. 
     */
    public MainController() {
        // TODO Auto-generated constructor stub
    	System.out.println("MainController");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("application/json;charset=UTF-8");
		response.setContentType("application/json");
		ServletOutputStream out = response.getOutputStream();
		
	   if(request.getParameter("operation").equals("user")) {
			GsonBuilder gsonMapBuilder = new GsonBuilder();
			Gson gsonObject = gsonMapBuilder.create();
			String JSONObject = gsonObject.toJson(apiCache.get(request.getParameter("id")));
			if(!JSONObject.equals("null")) {
	        out.print(JSONObject);
			}
	        out.flush();
	   }
	   if(request.getParameter("operation").equals("all")) { 
			GsonBuilder gsonMapBuilder = new GsonBuilder();
			Gson gsonObject = gsonMapBuilder.create();
			String JSONObject = gsonObject.toJson(apiCache);
			if(!apiCache.isEmpty()) {
	        out.print(JSONObject);
	        }
	        out.flush();			
	   }		
		
		if(request.getParameter("operation").equals("add")) {
			if(!request.getParameter("name").trim().equals("")) {
					String name = (String) request.getParameter("name");
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
					LocalDateTime now = LocalDateTime.now();  
					Person p =  new Person();
					p.setName(name);
					p.setId(Integer.toString(size));
					p.setJoinedSince(dtf.format(now));
					apiCache.put(Integer.toString(size), p);
					size ++;
					System.out.println("user added ");
			}
		}   
		
		//this will go in post 
		   if(request.getParameter("operation").equals("login")) {
			   
			   //need a helper method to search for the person from the cash 
			   Person p = new Person();
			   p.setName("samson");
			   p.setPassword("password"); 
			   
			   String name = request.getParameter("name");
			   String password = request.getParameter("password");
			   if(p.getName().equals(name) && p.getPassword().equals(password)) {
		        out.print("login Succesful");
			   }else {
		        out.print("login Failed");	
			   }
		        out.flush();
		   }

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	}

}
