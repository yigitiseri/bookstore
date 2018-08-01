package com.bookstore.contract;

import java.util.List;

import com.bookstore.pojo.Item;
import com.bookstore.pojo.PaginatedServiceOutput;
import com.bookstore.pojo.ProductServiceOutput;
import com.bookstore.pojo.TaxonomyServiceOutput;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface IBookApiService {
	
	final String apiKey ="wcam6n8ykumn3xyph5dnec26";
	
	@RequestLine("GET")
	@Headers("Content-Type: application/json")
	public Item findAll();
	
	@RequestLine("GET /taxonomy?format=json&apiKey="+apiKey)
	@Headers("Content-Type: application/json")
	public TaxonomyServiceOutput getTaxonomy();
		
	@RequestLine("GET /paginated/items?format=json&category={categoryId}&count=20&apiKey="+apiKey)
	@Headers("Content-Type: application/json")
	public PaginatedServiceOutput getPaginated(@Param("categoryId") String categoryId);
	
	@RequestLine("GET /paginated/items?format=json&category={categoryId}&count=20&maxId={maxId}&apiKey="+apiKey)
	@Headers("Content-Type: application/json")
	public PaginatedServiceOutput getPaginated(@Param("categoryId") String categoryId,@Param("maxId") String maxId);
			
	@RequestLine("GET /paginated/items?format=json&category={categoryId}&count=1&apiKey="+apiKey)
	@Headers("Content-Type: application/json")
	public PaginatedServiceOutput getThumbnailImage(@Param("categoryId") String categoryId);

	@RequestLine("GET /items/{productId}?format=json&apiKey="+apiKey)
	@Headers("Content-Type: application/json")
	public ProductServiceOutput getProductDetail(@Param("productId") String productId);

}
