package events;


public class Notification extends Notice{
	
	public Notification(long count, java.sql.Timestamp timestamp, long busId, long parentId,
			NotificationMessage message){
		super(count, timestamp, busId, parentId, Notification.messageToString(message));
	}
	
	public static String messageToString(NotificationMessage tmp){
		String returned = "";
		switch(tmp){
			case ETA5Min:
				returned = "ETA5Min";
				break;
			case LeftSchool:
				returned = "LeftSchool";
				break;
			case ArrivedSchool:
				returned = "ArrivedSchool";
				break;
			default:
				returned = null;
		}
		return returned;
	}
	public static NotificationMessage stringToMessage(String tmp){
		NotificationMessage returned = null;
		switch(tmp){
			case "ETA5Min":
				returned = NotificationMessage.ETA5Min;
				break;
			case "LeftSchool":
				returned = NotificationMessage.LeftSchool;
				break;
			case "ArrivedSchool":
				returned = NotificationMessage.ArrivedSchool;
				break;
			default:
				returned = null;
		}
		return returned;
	}
}


