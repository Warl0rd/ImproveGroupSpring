package ru.sokolov.pricelist.dao;

/**
 * Util class, containing parameters of request
 * @author SokolovVS
 */
public class ReqParameters {
	
	private String productCathegory;
	
	private String productName;
	
	private String productMinPrice;
	
	private String productMaxPrice;
	
	/**
	 * Default constructor without parameters
	 */
	public ReqParameters() {}

	/**
	 * @return True if all request parameters are empty
	 */
	public boolean isEmpty() {
		boolean cathegory = "".equals(productCathegory);
		boolean name = "".equals(productName);
		boolean minPrice = "".equals(productMinPrice);
		boolean maxPrice = "".equals(productMaxPrice);
		
		return cathegory & name & minPrice & maxPrice;
	}

	public String getProductCathegory() {
		return productCathegory;
	}

	public void setProductCathegory(String productCathegory) {
		this.productCathegory = productCathegory;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductMinPrice() {
		return productMinPrice;
	}

	public void setProductMinPrice(String productMinPrice) {
		this.productMinPrice = productMinPrice;
	}

	public String getProductMaxPrice() {
		return productMaxPrice;
	}

	public void setProductMaxPrice(String productMaxPrice) {
		this.productMaxPrice = productMaxPrice;
	}
}
