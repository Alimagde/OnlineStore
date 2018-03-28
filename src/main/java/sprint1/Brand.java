package sprint1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Brand {
	public Brand() {}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id=0;
	String name = " ",category=" ";
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
	public Brand(String a, String b) {
		this.name = a;
		this.category= b;
	}
}

