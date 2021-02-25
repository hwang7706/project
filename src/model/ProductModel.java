package model;

public class ProductModel {
	 private int product_id; // 상품 uid 
	 private String product_name; // 상품 이름
	 private int price;			// 상품 가격
	 private String description; //상품 설명
	 private String picture_url; // 상품 url
	 private String file1; 		//첨부 파일
	 private String file1_thum; // 첨부파일 썸네일
	 private String date;// 올린 날짜
	 private String category;
	 private String discount;
	
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getFile1_thum() {
		return file1_thum;
	}
	public void setFile1_thum(String file1_thum) {
		this.file1_thum = file1_thum;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicture_url() {
		return picture_url;
	}
	public void setPicture_url(String picture_url) {
		this.picture_url = picture_url;
	}
	public String getFile1() {
		return file1;
	}
	public void setFile1(String file1) {
		this.file1 = file1;
	}
}
