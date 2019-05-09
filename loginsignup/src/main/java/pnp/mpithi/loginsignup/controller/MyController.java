package pnp.mpithi.loginsignup.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pnp.mpithi.loginsignup.model.Customer;
import pnp.mpithi.loginsignup.model.Login;
import pnp.mpithi.loginsignup.service.CustomerService;

@Controller
public class MyController {

	@Autowired
	private CustomerService customerService;
	
	
	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value ="/" ,method=RequestMethod.GET)
	public String homePage(){
		return "home";
	}
	
	@RequestMapping(value ="/login" ,method=RequestMethod.GET)
	public String loginPage(Model model){
		model.addAttribute("login", new Login());
		return "login";
	}

	@RequestMapping(value ="/register" ,method=RequestMethod.GET)
	public String registerPage(Model model){
		model.addAttribute("customer", new Customer());
		return "register";
	}
	
	@RequestMapping(value ="/registerSuccess" ,method=RequestMethod.POST)
	public ModelAndView registerSuccess(@Valid @ModelAttribute("customer") Customer customer,BindingResult bindingResult){
		
		if(bindingResult.hasErrors()){
			return new ModelAndView("register");
		}
		
		getCustomerService().registerCustomer(customer);
		ModelAndView modelAndView = new ModelAndView("welcome");
		modelAndView.addObject("customer", customer);
		
		return modelAndView;
	}
	@RequestMapping(value ="/loginSuccess" ,method=RequestMethod.POST)
	public ModelAndView loginSuccess(@Valid @ModelAttribute("login") Login login,BindingResult bindingResult){
		
		if(bindingResult.hasErrors()){
			return new ModelAndView("login");
		}
		
		ModelAndView modelAndView = new ModelAndView("welcome");
		Customer customer = getCustomerService().validateCustomerCredential(login.getEmail(), login.getPassword());
		if(customer != null){
			modelAndView.addObject("customer", customer);
			return modelAndView;
		}else{
			 modelAndView = new ModelAndView("notFound");
		}
		
		return modelAndView;
	}
	
	@ModelAttribute
	public void headerMessage(Model model){
		model.addAttribute("headerMessage", "Welcome to Pick and Pay Online Shopping");
		
	}
}
