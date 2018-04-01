package sprint1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
@Autowired
User_repo repo;
@Autowired
product_repo prepo;
@Autowired

store_repo srepo;


@GetMapping("/register")
public String show_register_form(Model model) {
model.addAttribute("user", new User())	;
return	"register";
}
@PostMapping("/register")
public String register(Model model,@ModelAttribute User user) {
	model.addAttribute("user", new User());
	
	repo.save(user);
	
	return "log-in";

}



@GetMapping("/log-in")
public String show_log_in_form(Model model) {
model.addAttribute("user", new User());
return	"log-in";
}

@PostMapping("/log-in")
public String log_in(Model model,@ModelAttribute User user) {
	
	model.addAttribute("user", new User());
	Iterable<User> temp=repo.findAll();
	List<User> arr=new ArrayList();
	for(User u : temp) {
		arr.add(u);
	}
	
	for(int i=0;i<arr.size();i++) {
		if(arr.get(i).getUsername().equals(user.getUsername())) {
			if(arr.get(i).getPassword().equals(user.getPassword())) {
				if(arr.get(i).getType().equals("buyer")) {
					System.out.println("logged");
					model.addAttribute("input",new Input());
					return "show_stores_to_user";
				}
				else if(arr.get(i).getType().equals("store owner")) {
					return "add-store";
					
				}
				else {//admin
					return "add-product";
				}
			}
			
		}
	}
	
	return "log-in";

}


@GetMapping("/show-store")
public String show_store(Model model) {
	
	Iterable<Store> temp=srepo.findAll();
	List<Store> arr=new ArrayList();
	List<Store> arr2=new ArrayList();

	for(Store store : temp) {
		arr.add(store);
	}
	for(int i=0;i<arr.size();i++) {
		if(arr.get(i).get_state().equals("verified")) {
			arr2.add(arr.get(i));
		}
	}
	model.addAttribute("stores", arr2);
	model.addAttribute("input",new Input());
	
	return "show_stores_to_user";
	
}
Store selected_store=new Store();
@PostMapping("/select-stores")
public String view_store_products(Model model ,@ModelAttribute Input input) {
	
	//Store store_temp=new Store();
	Iterable<Store> temp=srepo.findAll();
	List<Store> array=new ArrayList();
	for(Store store : temp) {
		array.add(store);
	}
	for(int i=0;i<array.size();i++) {
		if(array.get(i).get_string_id().equals(input.in)) {
			//.equal(array.get(i));
			selected_store.equal(array.get(i));
			break;
		}
	}
	List<Product> array2=new ArrayList();
	for(int i=0;i<selected_store.products.size();i++) {
		array2.add(selected_store.products.get(i));
	}
	model.addAttribute("input", new Input());
	model.addAttribute("products", array2);
	return "show-products-to-buy";
}
Integer sel_id=0,index=0;;
Store s=new Store();
@PostMapping("/select-products")
public String select_product(Model model,@ModelAttribute Input input) {
Integer selected_id=Integer.valueOf(input.in);

	sel_id=selected_id;
	
	return "/view-product";
}
@GetMapping("/view-products")
public String view_to_buy(Model model) {
	Product temp_product=new Product();

	for(int i=0;i<selected_store.products.size();i++)
	{
		if(selected_store.products.get(i).getId()==sel_id) {
			temp_product.equal(selected_store.products.get(i));
			s.equal(selected_store);
			index=i;
			break;
		}
	}
	selected_store.setViews(selected_store.getViews()+1);
	selected_store.products.get(index).setViews(selected_store.products.get(index).getViews()+1);
	model.addAttribute("product",temp_product);
	model.addAttribute("input",new Input());
	return "view-product";
}
@PostMapping("/buy-products")
public String buy_product(Model model,@ModelAttribute Input input ) {

Integer quantity=Integer.valueOf(input.in);
if(selected_store.products.get(index).getQuantity()<quantity) {
	return null;
	
}

else {
	selected_store.products.get(index).setBuys(selected_store.products.get(index).getBuys()+1);

	selected_store.products.get(index).setAmount(selected_store.products.get(index).getAmount()-quantity);
	srepo.delete(s);
	srepo.save(selected_store);

return "show-products-to-buy";}
}
//@GetMapping("/show-product")
//public String show_products(Model model) {
//	Iterable<Product> tempo=prepo.findAll();
//	List<Product> array=new ArrayList();
//	for(Product pro : tempo) {
//		array.add(pro);
//	}
//	model.addAttribute("product", array);
//	model.addAttribute("input", new Input());
//
//	return "show-products-to-buy";
//}


//@PostMapping("/select-product")
//public String select_product(Model model,@ModelAttribute Input input) {
//Integer selected_id=Integer.valueOf(input.in);
//
//	sel_id=selected_id;
//	
//	return "/view-product";
//}

//@GetMapping("/view-product")
//public String view_to_buy(Model model) {
//	Product temp_product=new Product();
//	Iterable<Product> tempo=prepo.findAll();
//	List<Product> array=new ArrayList();
//	for(Product pro : tempo) {
//		array.add(pro);
//	}
//	for(int i=0;i<array.size();i++)
//	{
//		if(array.get(i).getId()==sel_id) {
//			temp_product=array.get(i);
//			p=temp_product;
//		}
//	}
//	model.addAttribute("product",temp_product);
//	model.addAttribute("input",new Input());
//	return "view-product";
//}


//@PostMapping("/buy-product")
//public String buy_product(Model model,@ModelAttribute Input input ) {
//
//Integer quantity=Integer.valueOf(input.in);
//if(p.quantity<quantity) {
//	return null;
//	
//}
//
//else {
//	Product temp=new Product();
//	temp.equal(p);
//	p.setQuantity(p.quantity-quantity);
//	prepo.delete(temp);
//	
//	prepo.save(p);
//	
//
//return "show-products-to-buy";}
//}

}
