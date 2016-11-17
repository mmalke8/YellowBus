package events;


public abstract class Notice{
	private long count;
	private java.sql.Timestamp timestamp;
	private long busId;
	private long parentId;
	private String message;
	
	public Notice(long count, java.sql.Timestamp timestamp, long busId, long parentId,
			String message){
		this.count = count;
		this.timestamp = timestamp;
		this.busId = busId;
		this.parentId = parentId;
		this.message = message;
	}
	public long getCount(){
		return count;
	}
	public long getBusId(){
		return busId;
	}
	public long getParentId(){
		return parentId;
	}
	public java.sql.Timestamp getTimestamp(){
		return timestamp;
	}
	public String getMessage(){
		return message;
	}
	
	public String toString(){
		String tmp = "";
		tmp += "count: " + getCount();
		tmp += " timestamp: " + getTimestamp();
		tmp += " busId: " + getBusId();
		tmp += " parentId: " + getParentId();
		tmp += " message: " + getMessage();
		return tmp;
	}
}
