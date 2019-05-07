package pnp.mpithi.loginsignup.controllers;

import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pnp.mpithi.loginsignup.model.Customer;
import pnp.mpithi.loginsignup.services.CustomerService;
import pnp.mpithi.loginsignup.validation.CustomerValidation;

@Controller
@RequestMapping(value="/customer" )
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	// following 2 methods are use for register processing
	
	//this method return only register page when request comes to /customer/register 
	@RequestMapping(value= "/register", method= RequestMethod.GET)
	public String showForm(ModelMap model){
		model.put("customerData", new Customer());
		return "register/register";
	}
	
	// this method is used to processing registration form when customer submit form
	//we catch whole form data inside @Model Attribute Annotation Customer object
	//after that we validate that form if any field is empty or not
	//then we process it by calling service method
	@RequestMapping(value= "/register", method= RequestMethod.POST)
	public String saveForm(ModelMap model, 
			@ModelAttribute("customerData")@Valid Customer customer, 
			BindingResult br, HttpSession session){
		
		CustomerValidation customerValidation = new CustomerValidation();
		
		customerValidation.validate(customerValidation, br);
		
		if (br.hasErrors()){
			
			return "register/register";
			
		} else {
			
			customerService.saveCustomer(customer);
			session.setAttribute("customer", customer);
			return "redirect:success";
		}
		
	}
	
	// following 2 methods are use for login processing
	//this method return only register page when request comes to /customer/register 
		@RequestMapping(value= "/login", method= RequestMethod.GET)
		public String showLogin(ModelMap model, HttpSession session){

			if (session.getAttribute("customer") == null){
				model.put("customerData", new Customer());
				return "login/login";
			} else {
				return "redirect:success";
			}
			
		}
		
		//this method process the login form and authenticate customer if login is valid
		@RequestMapping(value= "/login", method= RequestMethod.POST)
		public String doLogin(ModelMap model, 
				@ModelAttribute("customerData")@Valid Customer customer, 
				BindingResult br, HttpSession session){
			
			if (customer.getEmail() != null && customer.getPassword() != null && session.getAttribute("customer") == null){
				customer = customerService.loginCustomer(customer);
				if (customer != null){
					session.setAttribute("customer", customer);
					return "redirect:success";
				} else {
					model.put("failed", "Login Failed.");
					return "login/login";
				} 
			} else {
				return "redirect:success";
			}
			
		}
		
		//this method is used to logout
		@RequestMapping(value= "/logout", method= RequestMethod.GET)
		public String logout(ModelMap model, HttpSession session){
			session.removeAttribute("customer");
			return "register/login";
		} 
		
		//this method is used to redirect to success.jsp page
		@RequestMapping(value= "/success", method= RequestMethod.GET)
		public String logout(Locale locale, ModelMap model){
			model.put("success", new Customer());
			return "success";
		}
}
