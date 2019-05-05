package wan.cloud.note.util;

import java.security.MessageDigest;
import java.util.UUID;



public class noteUtil {

	public static String MD(String msg) throws Exception{
		MessageDigest mDigest=MessageDigest.getInstance("MD5");
		byte[] input=msg.getBytes();
		byte[] output=mDigest.digest(input);
		BASE64Encoder base=new BASE64Encoder();
		
		String code=base.encode(output);
		return code;
		
	}
	public static String createID(){
		UUID uuid=UUID.randomUUID();
		return uuid.toString();
	}
	public static void main(String[] args) {
		System.out.println(createID());
	}
}
