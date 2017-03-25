package Model;

import java.security.MessageDigest;

public class MD5Digest {
	public static String getMD5(String Original) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(Original.getBytes());
			byte[] digist = md.digest();
			StringBuffer sb = new StringBuffer();
			for(byte b : digist){
				sb.append(String.format("%2x", b&0xff));
			}
			return sb.toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Original;
		
	}
}
