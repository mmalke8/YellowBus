package events;


public class Alert extends Notice {
	public Alert(long count, java.sql.Timestamp timestamp, long busId, long parentId,
			String message){
		super(count, timestamp, busId, parentId, message);
	}	
}

