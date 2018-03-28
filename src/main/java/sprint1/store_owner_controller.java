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
public class store_owner_controller {
	@Autowired
	store_repo repo;
	@Autowired
	product_repo rep;

	@GetMapping("/add-store")
	public String show_add_store_form(Model model) {
	model.addAttribute("store", new Store());
	return	"add-store";
	
	
	}
	@PostMapping("/add-store")
	public String add_store(Model model,@ModelAttribute Store store) {
		model.addAttribute("store", new Store());
		
		repo.save(store);
		
		return "add-store";

	}
	

	@GetMapping("/Show-product-to-owner")
	public String showproduct(Model model){
		
		Iterable<Product> temp=rep.findAll();
		List<Product> arr=new ArrayList();
		for(Product pro : temp) {
			arr.add(pro);
		}
		for(int i=0;i<arr.size();i++)System.out.println(arr.get(i).getName());
		model.addAttribute("product", arr);
		
		model.addAttribute("input", new Input());

		return "Show-product-to-owner";
	}
	@PostMapping("/add-product-to-store")
	public String add_product(Model model,@ModelAttribute Input p) {
		model.addAttribute("input", new Input());
		
		
		Iterable<Product> temp_product=rep.findAll();
		Iterable<Store> temp_store=repo.findAll();

		List<Product> product_arr=new ArrayList();
		for(Product pro : temp_product) {
			product_arr.add(pro);
		}
		List<Store> store_arr=new ArrayList();
		for(Store store : temp_store) {
			store_arr.add(store);
		}
		
		
		
		Store input_store=new Store();
		Product input_product=new Product();
		
		
		
		for(int i = 0 ; i < product_arr.size() ; i++) {
			if(p.in.equals(product_arr.get(i).getId())) {
				input_product.equal(product_arr.get(i));
				break;
			}		
		}	
		
		for(int i = 0; i < store_arr.size() ; i++) {
			if(p.in2.equals(store_arr.get(i).getId())) {
				input_store.equal(store_arr.get(i));
				break;
			}
		}
		
		input_store.products.add(input_product);

		return "";
	}

	
}
