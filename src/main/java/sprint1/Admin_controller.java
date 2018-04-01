package sprint1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Admin_controller {
	@Autowired
	product_repo prepo;
	@Autowired

	store_repo srepo;
	@Autowired

	brand_repo rip;
	
	@GetMapping("/add-product")
	public String show_add_product_form(Model model) {
	model.addAttribute("product", new Product())	;
	return	"add-product";
	}
	
	
	@PostMapping("/add-product")
	public String addProduct(Model model,@ModelAttribute Product p) {
		model.addAttribute("product", new Product());
		prepo.save(p);
		return "add-product";

	}
	@GetMapping("/show-stores")
	public String show_stores(Model model) {
		
		Iterable<Store> temp=srepo.findAll();
		List<Store> arr=new ArrayList();
		List<Store> arr2=new ArrayList();

		for(Store st : temp) {
			arr.add(st);
		}
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i).get_state().equals("pending")) arr2.add(arr.get(i));
			
		}
		model.addAttribute("input",new Input());
		model.addAttribute("stores", arr2);

		return	"Show_Stores_to_Admin";
	}
	
	
	@PostMapping("/add")
	public String input_form_store(Model model,@ModelAttribute Input in) {
		model.addAttribute("input",new Input());
		Store s =new Store();
		Iterable<Store> temp=srepo.findAll();
		List<Store> arr=new ArrayList();
		List<Store> arr2=new ArrayList();

		for(Store st : temp) {
			arr.add(st);
		}
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i).get_state().equals("pending")) arr2.add(arr.get(i));
			
			
		}
		for(int i=0;i<arr2.size();i++) {
			
			if(arr2.get(i).get_string_id().equals(in.getIn())) {
				s.equal(arr2.get(i));
				break;

			}
		}
		
		srepo.delete(s);
		
		s.set_state("verified");
		srepo.save(s);

		return "show_stores_to_admin";
	}


	@GetMapping("/Show-Stores-to-Admin")
	public String showStores(Model model){
		Iterable<Store> temp=srepo.findAll();
		List<Store> arr=new ArrayList();
			for(Store store : temp) {
				arr.add(store);
			}
		model.addAttribute("stores", arr);
		return "Show-Stores-to-Admin";
	}
	
	@GetMapping("/add-brand")
	public String show_add_brand_form(Model model) {
	model.addAttribute("brand", new Brand())	;
		return	"add-brand";
	}
	@PostMapping("/add-brand")
	public String addBrand(Model model,@ModelAttribute Brand p) {
		model.addAttribute("brand", new Brand());
			rip.save(p);
		return "add-brand";

	}
	
//	@GetMapping("/Show-product-to-owner")
//	public String showproduct(Model model){
//		
//		Iterable<Product> temp=prepo.findAll();
//		List<Product> arr=new ArrayList();
//		for(Product pro : temp) {
//			arr.add(pro);
//		}
//		for(int i=0;i<arr.size();i++)System.out.println(arr.get(i).getName());
//		model.addAttribute("product", arr);
//		
//		model.addAttribute("input", new Input());
//
//		return "Show-product-to-owner";
//	}
	
	
}
