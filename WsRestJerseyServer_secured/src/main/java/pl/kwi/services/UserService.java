package pl.kwi.services;

import java.util.List;

import pl.kwi.daos.UserDao;
import pl.kwi.entities.UserEntity;

public class UserService {

	private UserDao userDao;
	
	
	public UserService(){
		userDao = new UserDao();
	}
	
	public Long createUser(UserEntity user){
		
		userDao.create(user);
		return user.getId();
		
	}
	
	public UserEntity readUser(Long id){
		
		return userDao.read(id);
		
	}
	
	public void updateUser(UserEntity user){
		
		userDao.update(user);
		
	}
	
	public void deleteUser(UserEntity user){
		
		userDao.delete(user);
		
	}
	
	public void deleteUser(Long id){
		
		UserEntity user = userDao.read(id);
		userDao.delete(user);
		
	}
	
	public List<UserEntity> getUserList(){
		
		return userDao.findAll();
		
	}

}
