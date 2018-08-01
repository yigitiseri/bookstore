package com.bookstore.pojo;

import java.util.List;

public class TaxonomyChildren extends TaxonomyItem {
	
	private List<TaxonomyItem> children;
	private String thumbnailImage;

	public List<TaxonomyItem> getChildren() {
		return children;
	}

	public void setChildren(List<TaxonomyItem> children) {
		this.children = children;
	}

	public String getThumbnailImage() {
		return thumbnailImage;
	}

	public void setThumbnailImage(String thumbnailImage) {
		this.thumbnailImage = thumbnailImage;
	}
	
	
}
