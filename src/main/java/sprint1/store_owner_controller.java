package sprint1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
public class store_owner_controller implements Serializable {
	@Autowired
	store_repo repo;
	@Autowired
	product_repo rep;
	@Autowired
	products_in_store_repo p_s_repo;
	

	
	@GetMapping("/add-store")
	public String show_add_store_form(Model model) {
	model.addAttribute("store", new Store());
	return	"add-store";
	
	
	}
	@PostMapping("/add-store")
	public String add_store(Model model,@ModelAttribute Store store) {
		model.addAttribute("store", new Store());
		store.set_state("pending");
		
		repo.save(store);
		
		return "add-store";

	}
	

	@GetMapping("/Show-product-to-owner")
	public String showproduct(Model model){
		
		List<Product> arr=new ArrayList();
		Iterable<Product> temp=rep.findAll();

		for(Product pro : temp) {
			arr.add(pro);
		}
		//arr=get_arraylist_product();
		for(int i=0;i<arr.size();i++) 
		model.addAttribute("product", arr);
		
		model.addAttribute("input", new Input());

		return "Show-product-to-owner";
	}
	@PostMapping("/add-product-to-store")
	public String add_product(Model model,@ModelAttribute Input p) throws IOException {
		model.addAttribute("input", new Input());
		
		
		Iterable<Product> temp_product=rep.findAll();

		List<Product> product_arr=new ArrayList();
		for(Product pro : temp_product) {
			product_arr.add(pro);
		}

		Product input_product=new Product();
		products_in_stores product_in_store=new products_in_stores();
	
		
		
		for(int i = 0 ; i < product_arr.size() ; i++) {
			if(p.in.equals(Integer.toString(product_arr.get(i).getId()))) {
				input_product.equal(product_arr.get(i));
				break;
			}		
		}	
		

		if(input_product.getAmount()>=Integer.parseInt(p.in3)) {
			rep.delete(input_product);
		input_product.setAmount(input_product.getAmount()-Integer.parseInt(p.in3));
		rep.save(input_product);
		product_in_store.set_data(input_product,Integer.parseInt(p.in2), Integer.parseInt(p.in3));
		p_s_repo.save(product_in_store);
		
		}
		return "store_owner_main";
	}
	
	@GetMapping("/show-stat")
	String show_stat() {
		int no_view=0,no_buys=0,no_sold_out=0;
		return null;
		
		
	}

	
}
