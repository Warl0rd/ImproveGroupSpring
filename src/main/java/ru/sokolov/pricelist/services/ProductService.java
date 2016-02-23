package ru.sokolov.pricelist.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ru.sokolov.pricelist.dao.ProductDao;
import ru.sokolov.pricelist.dao.ReqParameters;
import ru.sokolov.pricelist.models.Product;

@Service
public class ProductService {
	
	private ProductDao productDao;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public List<Product> findAll() {
		return productDao.findAll();
	}
	
	public List<Product> findAppropriate(ReqParameters parameters) {
		return (List<Product>) productDao.findAppropriate(parameters);
	}
}
