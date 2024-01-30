package demo.util;

public class Constants {
	
	
	public static final String API_SUBMIT_RESULT = "api.submit.result";
	public static final String API_SLOT_CHECK = "api.slot.check";
	
	public static final String REQUEST = "request";
	public static final String FAILED = "Failed";
	public static final String ACCEPT = "accept";

	
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String APPLICATION_JSON = "application/json";
	public static final String AUTHORIZATION = "authorization";
	public static final String COUNT = "count";
	public static final String X_AUTH_TOKEN = "x-authenticated-user-token";
	
	public static final String MSG_UNAUTHORIZED_USER = "Unauthorized";
	public static final String MSG_INVALID_REQUEST = "Invalid request: Email ID not provided";
	public static final String MSG_INVALID_FIELD = "Invalid field: ";
	public static final String ERROR = "ERROR";
	

	public static final String TOPIC_NAME = "dl_test";
    public static final String GROUP_ID = "group_id";
	private Constants() {
		throw new IllegalStateException("Utility class");
	}

}
