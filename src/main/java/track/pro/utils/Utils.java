package track.pro.utils;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.web.multipart.MultipartFile;

public class Utils {
	
//	public static void main(String[] args) {
//		
//	}
	 
	public static String generateSalt() {
		final int SALT_LENGTH = 10;
		String saltChars = "abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
 
		StringBuilder strSalt = new StringBuilder(SALT_LENGTH);
 
		SecureRandom random = new SecureRandom();
 
		for (int i = 0; i < SALT_LENGTH; i++) {
 
			int randomIndex = random.nextInt(saltChars.length());
			System.out.println("Random Index:" + randomIndex);
			strSalt.append(saltChars.charAt(randomIndex));
		}
		return strSalt.toString();
	}
 
	public static String generateHash(String inputString) {
 
		String strHash = "";
 
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
 
			byte[] hashBytes = messageDigest.digest(inputString.getBytes());
			strHash = bytesToHex(hashBytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
 
		return strHash;
	}
 
	private static String bytesToHex(byte[] bytes) {
 
		StringBuilder hexString = new StringBuilder(2 * bytes.length);
 
		for (byte b : bytes) {
			String hex = Integer.toHexString(0xff & b);
			if (hex.length() == 1) {
				hexString.append("0");
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}
 
	public static String getBase64Image(MultipartFile image) {
		return null;
	}
	
	public static MultipartFile convertToMultipart(Blob image) {
		byte[] imageBytes = null;
		try {
			imageBytes = image.getBytes(1,  (int) image.length());
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		MultipartFile multipartImage = new MultiPartImpl(imageBytes, "image.png", "image/png");
		return multipartImage;
	}
	
	public static Blob convertToBlob(MultipartFile image)  {
		SerialBlob imageBlob = null;
		try {
			byte[] imageBytes = image.getBytes();
			imageBlob = new SerialBlob(imageBytes);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return imageBlob;
	}
 
 
 
 
}
