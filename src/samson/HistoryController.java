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

import samson.model.History;
import samson.model.Record;

/**
 * Servlet implementation class HistoryController
 */
@WebServlet("/history")
public class HistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Map<String, History> historicCache = new HashMap<String, History>();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		ServletOutputStream out = response.getOutputStream();
		
		   if(request.getParameter("operation").equals("add")) {
			   
			   Record record = new Record();
			   record.setAction(request.getParameter("action"));
			   record.setTargetId(request.getParameter("targetId"));
			   
			   if(historicCache.get(request.getParameter("id")) != null ) {
			   History history = historicCache.get(request.getParameter("id"));
			   history.add(record);
			   historicCache.remove(request.getParameter("id"));
			   historicCache.put(request.getParameter("id"), history);
			   }else {
				   History history = new History(); 
				   history.add(record); 
				   historicCache.put(request.getParameter("id"), history);  
			   }
		   }    
		   if(request.getParameter("operation").equals("user")) {
				GsonBuilder gsonMapBuilder = new GsonBuilder();
				Gson gsonObject = gsonMapBuilder.create();
				String JSONObject = gsonObject.toJson(historicCache.get(request.getParameter("id")));
				if(!JSONObject.equals("null")) {
		        out.print(JSONObject);
				}
		        out.flush();
		   }
		   if(request.getParameter("operation").equals("all")) {
				GsonBuilder gsonMapBuilder = new GsonBuilder();
				Gson gsonObject = gsonMapBuilder.create();
				String JSONObject = gsonObject.toJson(historicCache.values());
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
