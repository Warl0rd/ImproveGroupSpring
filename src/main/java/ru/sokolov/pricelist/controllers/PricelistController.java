package ru.sokolov.pricelist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ru.sokolov.pricelist.dao.ReqParameters;
import ru.sokolov.pricelist.models.Product;
import ru.sokolov.pricelist.services.ProductService;

@Controller
public class PricelistController {
	
	public ProductService productService;
	
	@Autowired(required=true)
	@Qualifier(value="productService")
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value="/pricelist", method=RequestMethod.GET)
	public ModelAndView getAllProducts() {
		
		System.out.println("Enter to get method");
		
		List<Product> products = productService.findAll();
		
		ModelAndView model = new ModelAndView("index");
		model.addObject("products", products);
		
		System.out.println("Exit from get method");
		
		return model;
	}
	
	@RequestMapping(value="/pricelist", method=RequestMethod.POST)
	public ModelAndView getAppropriateProducts(@ModelAttribute("reqParameters") ReqParameters reqParameters) {
		
		System.out.println("Enter to post method");
		
		List<Product> products = productService.findAppropriate(reqParameters);
		
		ModelAndView model = new ModelAndView("index");
		model.addObject("products", products);
		
		System.out.println("Exit from post method");
		
		return model;
	}
}
