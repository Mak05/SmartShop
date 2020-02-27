package com.mak.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mak.dao.InventoryDao;
import com.mak.model.Product;
import com.mak.model.Search;
import com.mak.model.Users;
import com.mak.service.ProductServiceIntf;
import com.mak.service.UserService;

@RestController
public class CustomerController {

	private static final Logger logger = LogManager.getLogger(CustomerController.class);

	@Autowired
	ProductServiceIntf productService;

	@Autowired
	UserService userService;

	@Autowired
	InventoryDao dao;

	@RequestMapping("/admin")
	public void admin(Principal principal, HttpServletResponse res) {
		try {
			String loggedInUserName = principal.getName();
			Object loggedUser = (Object) userService.findByRole(loggedInUserName);
			if ((boolean) loggedUser.equals("A")) {
				res.sendRedirect("/shop");
			} else if ((boolean) loggedUser.equals("U")) {
				res.sendRedirect("/home");
			}
		} catch (Exception e) {
			logger.info(e);
		}
	}

	@RequestMapping(value = "/home")
	public ModelAndView homePage(Map<String, Object> map) {
		map.put("productList", productService.listProducts());
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/products")
	public ModelAndView products(@ModelAttribute("Search") Search search, Model model, Map<String, Object> map) {
		logger.info("Search Controller");
		map.put("productList", productService.searchProduct("%"+search.getSearchItem()+"%"));
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/shop")
	public ModelAndView addInventory(@ModelAttribute("inventory") Product inventory,Map<String, Object> map) {
		map.put("productList", productService.listProducts());
		return new ModelAndView("addInventory");
	}
	
	@RequestMapping(value = "/product")
	public ModelAndView updateProduct(@ModelAttribute("inventory") Product inventory,Map<String, Object> map) {
		map.put("productList", productService.listProducts());
		return new ModelAndView("addInventory");
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public ModelAndView SavePage(@Valid @ModelAttribute("inventory") Product inventory, Map<String, Object> map,
			BindingResult theBindingResult) {
		
		if (theBindingResult.hasErrors()) {
			map.put("productList", productService.listProducts());
			return new ModelAndView("addInventory").addObject("message", "Please fill the mandatory fields");
		} else {
			logger.info("Inserting the Product Details");
			productService.addProduct(inventory);
			map.put("productList", productService.listProducts());
			return new ModelAndView("addInventory").addObject("message", "Product details are successfully added");
		}
		
	}

	@RequestMapping(value = "/product", method = RequestMethod.PUT)
	public ModelAndView editCart(HttpServletRequest request, @ModelAttribute("product") Product product,Map<String, Object> map) {
		int id = Integer.parseInt(request.getParameter("id"));
		Product editedProduct = productService.getById(id);
		map.put("productList", productService.listProducts());
		return new ModelAndView("edit", "editedProduct", editedProduct);
	}


}
