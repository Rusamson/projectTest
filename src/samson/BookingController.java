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

/**
 * Servlet implementation class BookingController
 */
@WebServlet("/booking")
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Map<String, Booking> bookingCache = new HashMap<String, Booking>();  
	Booking b1 = new Booking("0","1","2","pending",true,"2019/01/24 12:12:00"," premade 1");
	Booking b2 = new Booking("1","1","2","accepted",true,"2019/01/24 12:12:00"," premade 2");
	Booking b3 = new Booking("2","1","2","cancelled",true,"2019/01/24 12:12:00"," premade 3");
	Booking b4 = new Booking("3","1","2","pending",false,"2019/01/24 12:12:00"," premade 4");
	Booking b5 = new Booking("4","1","2","pending",true,"","premade 5");
	
	
	
	private int size = 5;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingController() {
        super();
        bookingCache.put("0", b1);
        bookingCache.put("1", b2);
        bookingCache.put("2", b3);
        bookingCache.put("3", b4);
        bookingCache.put("4", b5);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		ServletOutputStream out = response.getOutputStream();
		
		   if(request.getParameter("operation").equals("add")) {
			   
			   Booking booking = new Booking();
			   booking.setSourceId(request.getParameter("sourceId"));
			   booking.setTargetId(request.getParameter("targetId"));
			   booking.setTime(request.getParameter("time")); 
			   booking.setVisibility(true);
			   booking.setStatus(request.getParameter("status"));
			   booking.setMessage(request.getParameter("message")); 
			   
			   if(bookingCache.get(request.getParameter("id")) != null ) {  
			   bookingCache.remove(request.getParameter("id"));
			   bookingCache.put(request.getParameter("id"), booking);
			   }else {  
				   bookingCache.put(Integer.toString(size), booking);  
				   size++;
			   }
		   }    
		   if(request.getParameter("operation").equals("retrieve")) {
				GsonBuilder gsonMapBuilder = new GsonBuilder();
				Gson gsonObject = gsonMapBuilder.create();
				String JSONObject = gsonObject.toJson(bookingCache.get(request.getParameter("id")));
				if(!JSONObject.equals("null")) {
		        out.print(JSONObject);
				}
		        out.flush();
		   }
		   if(request.getParameter("operation").equals("all")) {
				GsonBuilder gsonMapBuilder = new GsonBuilder();
				Gson gsonObject = gsonMapBuilder.create();
				String JSONObject = gsonObject.toJson(bookingCache.values());
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
