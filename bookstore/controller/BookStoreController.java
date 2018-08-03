package com.bookstore.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.contract.IBookApiService;
import com.bookstore.contract.IBookService;
import com.bookstore.pojo.BookStoreModel;
import com.bookstore.pojo.PaginatedServiceOutput;
import com.bookstore.pojo.TaxonomyCategories;
import com.bookstore.pojo.TaxonomyServiceOutput;

@Controller
public class BookStoreController {
	
	@Autowired
	IBookService bookService;
	
	@Autowired
	IBookApiService bookApiService;

	@RequestMapping(value="/bookstore")
	public String getBookStore(Map<String, Object> model) {
		TaxonomyCategories bookCategory = bookService.getTaxonomy();		
		model.put("bookCategory",bookCategory);			
		model.put("message", this.message);
		return "bookstore";
	}

	@RequestMapping(value={"/", "/home"})
	public String getHome(Map<String, Object> model) {
		String page = null;
		String category= null;
		PaginatedServiceOutput output = bookService.getAllBooks(page,category);		
		model.put("output",output);
		return "category";
	}
	
	@RequestMapping(value="/home/{page}/{categoryId}")
	public String getHomePage(@PathVariable("page") String page,
		@PathVariable("categoryId") String categoryId,Map<String, Object> model) {
		PaginatedServiceOutput output = bookService.getAllBooks(page,categoryId);		
		model.put("output",output);
		return "category";
	}
}