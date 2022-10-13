package Model;

import java.io.IOException;

public interface Model {
	
	public static int SEND_HANDLE = 1;
    public static int SEND_COMMENT = 2;
    public static int GET_COMMENT_COUNT = 3;
    public static int GET_COMMENT = 4;
	String convert(String source) throws IOException;

}
