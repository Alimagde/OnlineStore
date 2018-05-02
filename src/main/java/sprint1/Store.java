package sprint1;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Store {
private 
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
Integer id;
String name="",type="",category="",owner_username="",state="";
Integer views=0;

public Store() {}

public String getState() {
	return state;
}	

public void setState(String state) {
	this.state = state;
}

public Integer getViews() {
	return views;
}

public void setViews(Integer views) {
	this.views = views;
}

public String getName() {
	return name;
}
public String get_string_id() {
	return id.toString();	
}


public void setName(String name) {
	this.name = name;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getCategory() {
	return category;
}

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public void setCategory(String category) {
	this.category = category;
}

public String getOwner_username() {
	return owner_username;
}

public void setOwner_username(String owner_username) {
	this.owner_username = owner_username;
}

public Store(String name, String type, String category, String owner_username) {
	super();
	this.name = name;
	this.type = type;
	this.category = category;
	this.owner_username = owner_username;
}
public String get_state() {
	return state;
	}
public void set_state(String s) {
	state=s;
	}

public void equal(Store s) {
	this.category=s.getCategory();
	this.id=s.getId();
	this.name=s.getName();
	this.type=s.getType();
	this.state=s.get_state();
	this.views=s.getViews();
	this.owner_username=s.getOwner_username();

	
}



}
