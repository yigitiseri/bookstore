package com.bookstore.contract;

import com.bookstore.pojo.BookItem;
import com.bookstore.pojo.BookStoreModel;
import com.bookstore.pojo.PaginatedServiceOutput;
import com.bookstore.pojo.TaxonomyCategories;

public interface IBookService {
	
	public TaxonomyCategories getTaxonomy();
	
	public PaginatedServiceOutput getAllBooks(String nextPath,String category);
	
}
