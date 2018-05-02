package sprint1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class collab {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	Integer Store_id;
	String user_name;

	public Integer getStore_id() {
		return Store_id;
	}

	public void setStore_id(Integer store_id) {
		Store_id = store_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

}
