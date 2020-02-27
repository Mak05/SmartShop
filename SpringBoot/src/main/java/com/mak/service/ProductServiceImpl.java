package com.mak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mak.dao.InventoryDao;
import com.mak.model.Product;

@Service
public class ProductServiceImpl implements ProductServiceIntf {

	@Autowired
	InventoryDao productDao;

	public void addProduct(Product product) {
		
		productDao.save(product);
	}

	public List<Product> listProducts() {
		List<Product> productList = (List<Product>) productDao.findAll();

		return productList;
	}

	public List<Product> searchProduct(String searchItem) {
		List<Product> productList = (List<Product>) productDao.findBySearchItem(searchItem);
		return productList;
	}

	@Override
	public Product getById(int id) {
		
		return productDao.findOne(id);
	}

}
