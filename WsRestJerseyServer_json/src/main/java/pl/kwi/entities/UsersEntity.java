package pl.kwi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UsersEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<UserEntity> users = new ArrayList<UserEntity>();
	
	public List<UserEntity> getUsers() {
		return users;
	}
	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}	

}
