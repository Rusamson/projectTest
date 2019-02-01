package samson.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group {
	private Map<String, GroupRecord> recordsCache ;

public Group() {
	recordsCache = new HashMap<String, GroupRecord>();
}

 public void add(GroupRecord record  ) { 
	recordsCache.put(record.getEmail(), record);
 }
 public    Collection<GroupRecord> getAll() {
	 return  recordsCache.values();
 }
}
