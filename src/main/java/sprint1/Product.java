package sprint1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
private
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
Integer id;
Integer amount=0;
Integer views=0,buys=0;
public Integer getBuys() {
	return buys;
}
public void setBuys(Integer buys) {
	this.buys = buys;
}
String name="",category="";
String price_range="";
Integer quantity=0;

public Product() {}
public Product(Integer id, String name, String category, String price_range) {
	super();
	this.id = id;
	this.name = name;
	this.category = category;
	this.price_range = price_range;
}

public Integer getViews() {
	return views;
}
public void setViews(Integer views) {
	this.views = views;
}
public Integer getQuantity() {
	return quantity;
}

public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}


public Integer getAmount() {
	return amount;
}
public void setAmount(Integer amount) {
	this.amount = amount;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getPrice_range() {
	return price_range;
}
public void setPrice_range(String price_range) {
	this.price_range = price_range;
}
public void equal(Product p) {
	
	this.name=p.getName();
	this.category= p.getCategory();
	this.id=p.getId();
	this.price_range=p.getPrice_range();
	this.quantity=p.getQuantity();
	
}



}
