package sprint1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class products_in_stores {
	public
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	Integer store_id;

	Integer amount=0;//system amount
	Integer views=0,buys=0;
	String name="",category="";
	String price="";
	Integer quantity=0; //store
//	Integer system_product_id;
	public products_in_stores(Integer amount, Integer views, Integer buys, String name, String category,
			String price, Integer quantity, Integer store_id) {
		super();
		this.amount = amount;
		this.views = views;
		this.buys = buys;
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.store_id = store_id;
//		this.system_product_id = system_product_id;
	}
	public products_in_stores() {
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
	}
	public Integer getBuys() {
		return buys;
	}
	public void setBuys(Integer buys) {
		this.buys = buys;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getStore_id() {
		return store_id;
	}
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
//	public Integer getSystem_product_id() {
//		return system_product_id;
//	}
//	public void setSystem_product_id(Integer system_product_id) {
//		this.system_product_id = system_product_id;
//	}
	public void equal(products_in_stores t) {
		this.amount = t.amount;
		this.views = t.views;
		this.buys =t.buys;
		this.name = t.name;
		this.category = t.category;
		this.price = t.price;
		this.quantity = t.quantity;
		this.store_id = t.store_id;
		this.id=t.getId();
//		this.system_product_id = t.system_product_id;
		
	}
	public void set_data(Product t,Integer storeID ,Integer quantity) {
		this.amount = 0;
		this.views = 0;
		this.buys =0;
		this.name = t.name;
		this.category = t.category;
		this.price = "0";
		this.quantity = quantity;
		this.store_id = storeID;
//		this.system_product_id = t.getId();
		
	}
}
