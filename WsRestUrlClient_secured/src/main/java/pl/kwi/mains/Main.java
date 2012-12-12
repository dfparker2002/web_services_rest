package pl.kwi.mains;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;
import java.util.List;

import pl.kwi.entities.UserEntity;
import pl.kwi.entities.UsersEntity;
import pl.kwi.helpers.JaxbHelper;
import sun.misc.BASE64Encoder;

public class Main {
	
	
	private static final String BASIC_URL = "http://localhost:8080/WsRestJerseyServer_secured";
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "admin";
	

	/**
	 * Main method of client.
	 * 
	 * @param args array of String from command line
	 */
	public static void main(String[] args) {
		
		String option = args[0];
		String arg1 = null;
		String arg2 = null;
		
		if(args.length >= 2){
			arg1 = args[1];
		}
		
		if(args.length >= 3){
			arg2 = args[2];
		}
		
		Main main = new Main();
		
		if("-create".equals(option)){
			main.create(arg1);
		}
		if("-read".equals(option)){
			main.read(arg1);
		}
		if("-readAll".equals(option)){
			main.readAll();
		}
		if("-update".equals(option)){
			main.update(arg1, arg2);
		}
		if("-delete".equals(option)){
			main.delete(arg1);
		}
		
	}
	
	public void create(String name){
		
		try {			
			
			URL url = new URL(BASIC_URL + "/rest/user");
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Content-Type", "application/xml");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Authorization", getCredentialsBasic()); 
			
			UserEntity user = new UserEntity();
			user.setName(name);
			OutputStream os = conn.getOutputStream();
			JaxbHelper.setObjectToOutputStream(UserEntity.class, user, os);
			os.flush();
			
			System.out.println("Status: " + conn.getResponseCode());
						
			InputStream is = conn.getInputStream();
			user = (UserEntity)JaxbHelper.getObjectFromInputStream(UserEntity.class, is);
			
			System.out.println(MessageFormat.format("Create user with id: {0} and name: {1}", user.getId(), user.getName()));
			
			conn.disconnect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void read(String id){
		
		try {
			
			URL url = new URL(BASIC_URL + "/rest/user/" + id);
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Authorization", getCredentialsBasic()); 
			
			System.out.println("Status: " + conn.getResponseCode());
			
			InputStream is = conn.getInputStream();
			UserEntity user = (UserEntity)JaxbHelper.getObjectFromInputStream(UserEntity.class, is);
			
			System.out.println(MessageFormat.format("Read user with id: {0} and name: {1}", user.getId(), user.getName()));
			
			conn.disconnect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void readAll(){
		
		try {
			
			URL url = new URL(BASIC_URL + "/rest/user");
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Authorization", getCredentialsBasic()); 
			
			System.out.println("Status: " + conn.getResponseCode());
			
			InputStream is = conn.getInputStream();
			UsersEntity users = (UsersEntity)JaxbHelper.getObjectFromInputStream(UsersEntity.class, is);
			List<UserEntity> userList = users.getUsers();
			
			for (UserEntity user : userList) {
				System.out.println(MessageFormat.format("Read user with id: {0} and name: {1}", user.getId(), user.getName()));
			}
			
			conn.disconnect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void update(String id, String name){
		
		try {
			
			URL url = new URL(BASIC_URL + "/rest/user");
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/xml");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Authorization", getCredentialsBasic()); 
			
			UserEntity user = new UserEntity();
			user.setId(Long.valueOf(id));
			user.setName(name);
			OutputStream os = conn.getOutputStream();
			JaxbHelper.setObjectToOutputStream(UserEntity.class, user, os);
			os.flush();
			
			System.out.println("Status: " + conn.getResponseCode());
						
			InputStream is = conn.getInputStream();
			user = (UserEntity)JaxbHelper.getObjectFromInputStream(UserEntity.class, is);
			
			System.out.println(MessageFormat.format("Update user with id: {0} and name: {1}", user.getId(), user.getName()));
			
			conn.disconnect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void delete(String id){
		
		try {
			
			URL url = new URL(BASIC_URL + "/rest/user/" + id);
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("DELETE");
			conn.setRequestProperty("Authorization", getCredentialsBasic()); 
			
			System.out.println("Status: " + conn.getResponseCode());
			
			System.out.println(MessageFormat.format("Delete user with id: {0}", id));
			
			conn.disconnect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private String getCredentialsBasic(){
		
		BASE64Encoder enc = new BASE64Encoder();
	    String userpassword = USERNAME + ":" + PASSWORD;
	    String encoded = enc.encode( userpassword.getBytes() );
	    return "Basic " + encoded; 
		
	}
	
	//TODO Kwi	
	private String getCredentialsDigest(){
		
		return null;
		
	}


}
