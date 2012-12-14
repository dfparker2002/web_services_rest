package pl.kwi.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserEntity implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	
	
	public UserEntity(){}
	
	public UserEntity(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
