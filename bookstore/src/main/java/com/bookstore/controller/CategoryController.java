package com.bookstore.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.contract.IBookApiService;
import com.bookstore.pojo.PaginatedServiceOutput;


@Controller
public class CategoryController {
	
	@Autowired
	IBookApiService bookApiService;

	@RequestMapping("/category/{categoryId}")
	public String getCategory(@PathVariable("categoryId") String categoryId,Map<String, Object> model) {
		PaginatedServiceOutput output =bookApiService.getPaginated(categoryId);
		model.put("output",output);
		return "category";
	}
}
