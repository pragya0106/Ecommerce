package com.ecommerce.to;

public class ProductTO {
	private int productId;
	private String productName;
	private int price;
	private String productCategory;

	public ProductTO(int productId, String productName, int price, String productCategory) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.productCategory = productCategory;

	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
}
