package com.bookstore.pojo;

import java.util.List;

public class TaxonomyCategories extends TaxonomyItem {
	
	private List<TaxonomyChildren> children;

	public List<TaxonomyChildren> getChildren() {
		return children;
	}

	public void setChildren(List<TaxonomyChildren> children) {
		this.children = children;
	}

	
}
