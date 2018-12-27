package samson.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class History {
	private Map<String, Record> recordsCache ;

public History() {
	recordsCache = new HashMap<String, Record>();
}

 public void add(Record record ) {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	LocalDateTime now = LocalDateTime.now(); 
	String key = dtf.format(now);
	recordsCache.put(key, record);
 }
 public    Collection<Record> getAll() {
	 return  recordsCache.values();
 }
}
