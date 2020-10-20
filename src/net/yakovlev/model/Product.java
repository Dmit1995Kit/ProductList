package net.yakovlev.model;

public class Product {

	private static final long serialVersionUID = 1L;
	
	private String code; 
	private String name;
	private float price;
	private String score;
	
	public Product() {
		
	}

	public Product(String code, String name, float price, String score) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.score = score;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	
}
