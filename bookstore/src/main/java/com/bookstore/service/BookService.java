package com.bookstore.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.contract.IBookApiService;
import com.bookstore.contract.IBookService;
import com.bookstore.pojo.BookStoreModel;
import com.bookstore.pojo.PaginatedServiceOutput;
import com.bookstore.pojo.TaxonomyCategories;
import com.bookstore.pojo.TaxonomyServiceOutput;

@Service
public class BookService implements IBookService{

	@Autowired
	IBookApiService bookApiService;
	
	private String bookCategoryId = "3920";
	
	@Override
	public TaxonomyCategories getTaxonomy() {
		// Firstly, check books categoryId and using this id gets image for every category.
		TaxonomyServiceOutput output = bookApiService.getTaxonomy();
		List<TaxonomyCategories> categories =output.getCategories();
		Optional<TaxonomyCategories> bookCategory= findBooks(categories, "Books");
//		bookCategory.get().getChildren().stream().forEach(chidren ->{
//			PaginatedServiceOutput paginatedOutput = bookApiService.getThumbnailImage(chidren.getId());
//			String thumbnailImage =paginatedOutput.getItems().get(0).getThumbnailImage();
//			chidren.setThumbnailImage(thumbnailImage);
//		});
		return bookCategory.get();
	}
	
	@Override
	public PaginatedServiceOutput getAllBooks(String nextPath,String category) {
		if(nextPath == null || category == null) {
			 return bookApiService.getPaginated(bookCategoryId);
		}else {
			return bookApiService.getPaginated(category,nextPath);
		}
	}
	
	private final Optional<TaxonomyCategories> findBooks(Collection<TaxonomyCategories> categories, String category){
	    return categories.stream().filter(c -> c.getName().equals(category)).findAny();
	}


}
