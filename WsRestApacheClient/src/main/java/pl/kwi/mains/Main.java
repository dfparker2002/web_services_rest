package pl.kwi.mains;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.entity.StringEntity;

import pl.kwi.entities.UserEntity;
import pl.kwi.entities.UsersEntity;
import pl.kwi.helpers.JaxbHelper;

public class Main {
	
	
	private static final String BASIC_URL = "http://localhost:8080/WsRestJerseyServer";

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
			
			DefaultHttpClient httpClient = new DefaultHttpClient();
			
			HttpPut request = new HttpPut(BASIC_URL + "/rest/user");
			request.addHeader("accept", "application/xml");
			
			UserEntity user = new UserEntity();
			user.setName(name);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			JaxbHelper.setObjectToOutputStream(UserEntity.class, user, baos);
			baos.flush();			
			StringEntity input = new StringEntity(baos.toString());
			input.setContentType("application/xml");
			request.setEntity(input);
			
			HttpResponse response = httpClient.execute(request);
			
			System.out.println("Status: " + response.getStatusLine().getStatusCode());
			
			InputStream is = response.getEntity().getContent();
			user = (UserEntity)JaxbHelper.getObjectFromInputStream(UserEntity.class, is);
			
			System.out.println(MessageFormat.format("Create user with id: {0} and name: {1}", user.getId(), user.getName()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void read(String id){
		
		try {
			
			DefaultHttpClient httpClient = new DefaultHttpClient();
			
			HttpGet request = new HttpGet(BASIC_URL + "/rest/user/" + id);
			request.addHeader("accept", "application/xml");
						
			HttpResponse response = httpClient.execute(request);
			
			System.out.println("Status: " + response.getStatusLine().getStatusCode());
			
			InputStream is = response.getEntity().getContent();
			UserEntity user = (UserEntity)JaxbHelper.getObjectFromInputStream(UserEntity.class, is);
			
			System.out.println(MessageFormat.format("Create user with id: {0} and name: {1}", user.getId(), user.getName()));
			
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
			
			System.out.println("Status: " + conn.getResponseCode());
			
			InputStream is = conn.getInputStream();
			UsersEntity users = (UsersEntity)JaxbHelper.getObjectFromInputStream(UsersEntity.class, is);
			List<UserEntity> userList = users.getUsers();
			
			for (UserEntity user : userList) {
				System.out.println(MessageFormat.format("Read user with id: {0} and name: {1}", user.getId(), user.getName()));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void update(String id, String name){
		
		try {
			
			DefaultHttpClient httpClient = new DefaultHttpClient();
			
			HttpPost request = new HttpPost(BASIC_URL + "/rest/user");
			request.addHeader("accept", "application/xml");
			
			UserEntity user = new UserEntity();
			user.setId(Long.valueOf(id));
			user.setName(name);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			JaxbHelper.setObjectToOutputStream(UserEntity.class, user, baos);
			baos.flush();			
			StringEntity input = new StringEntity(baos.toString());
			input.setContentType("application/xml");
			request.setEntity(input);
			
			HttpResponse response = httpClient.execute(request);
			
			System.out.println("Status: " + response.getStatusLine().getStatusCode());
			
			InputStream is = response.getEntity().getContent();
			user = (UserEntity)JaxbHelper.getObjectFromInputStream(UserEntity.class, is);
			
			System.out.println(MessageFormat.format("Update user with id: {0} and name: {1}", user.getId(), user.getName()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void delete(String id){
		
		try {
			
			DefaultHttpClient httpClient = new DefaultHttpClient();
			
			HttpDelete request = new HttpDelete(BASIC_URL + "/rest/user/" + id);
						
			HttpResponse response = httpClient.execute(request);
			
			System.out.println("Status: " + response.getStatusLine().getStatusCode());
			
			System.out.println(MessageFormat.format("Delete user with id: {0}", id));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
