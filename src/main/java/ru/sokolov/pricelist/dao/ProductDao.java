package ru.sokolov.pricelist.dao;

import java.util.List;

import ru.sokolov.pricelist.models.Product;

public interface ProductDao {
	
	public List<Product> findAll();
	
	public List<Product> findAppropriate(ReqParameters reqParameters);
	
}
