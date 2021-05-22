package com.bailiban.aigou.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name ="s_user")
public class User {
@Id
@GeneratedValue(generator = "uuid")
@GenericGenerator(name = "uuid", strategy = "uuid")
private  String id;
private String username;

private String password;
private int type;


public int getType() {
	return type;
}

public void setType(int type) {
	this.type = type;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}



public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

}
