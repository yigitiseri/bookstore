package com.bookstore.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.contract.IBookApiService;
import com.bookstore.pojo.ProductServiceOutput;

@Controller
public class ProductController {

	@Autowired
	IBookApiService bookApiService;

	@RequestMapping("/product/{prodcutId}")
	public String welcome(@PathVariable("prodcutId") String prodcutId,Map<String, Object> model) {
		ProductServiceOutput output =bookApiService.getProductDetail(prodcutId);
		model.put("output",output);
		return "product";
	}

}
