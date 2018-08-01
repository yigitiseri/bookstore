package com.bookstore.pojo;

import java.util.List;

public class BookStoreModel {
	
	public List<PaginatedServiceOutput> paginatedList;
	public TaxonomyCategories taxonomyCatagories;

	public List<PaginatedServiceOutput> getPaginatedList() {
		return paginatedList;
	}

	public void setPaginatedList(List<PaginatedServiceOutput> paginatedList) {
		this.paginatedList = paginatedList;
	}

	public TaxonomyCategories getTaxonomyCatagories() {
		return taxonomyCatagories;
	}

	public void setTaxonomyCatagories(TaxonomyCategories taxonomyCatagories) {
		this.taxonomyCatagories = taxonomyCatagories;
	}




	
	
}
