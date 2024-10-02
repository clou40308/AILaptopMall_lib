package com.ailaptopmall.entity;

public class OrderItem {
	private int orderId; 			//Pkey
	private Product product;    	//PKey
	private String sizeName="";	//Pkey
	private String specName="";		//Pkey
	
//	private double listPrice; 		//必要, 交易時定價
//	private String discountString;  //必要, 交易時折扣	
//	public double getListPrice() {
//		return listPrice;
//	}
//	public void setListPrice(double listPrice) {
//		this.listPrice = listPrice;
//	}
//	public String getDiscountString() {
//		return discountString;
//	}
//	public void setDiscountString(String discountString) {
//		this.discountString = discountString;
//	}
	
	private double price; 			//必要, 交易價
	private int quantity;	
	
	//必要,
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	public String getSpecName() {
		return specName;
	}
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	//依據畫面定義getter
	public int getProductId() {
		return product.getId();
	}
	
	public String getProductName() {
		return product.getName();
	}
	
	public String getPhotoUrl() {
		return product.getPhotoUrl();
	}
	
	public double getAmount() {
		return price * quantity;
	}	
	
	@Override
	public String toString() {
		return "訂單明細 [訂單編號=" + orderId
				+ String.format(", 購買產品=%s:%s-%s-%s",getProductId(), getProductName(), sizeName, specName)				
				+ ",\n 售價=" + price + ", 數量=" + quantity + "個, 小計:" + getAmount()
				+ "元,\n 圖片url=" + getPhotoUrl() + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderId;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((sizeName == null) ? 0 : sizeName.hashCode());
		result = prime * result + ((specName == null) ? 0 : specName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		OrderItem other = (OrderItem) obj;
		if (sizeName == null) {
			if (other.sizeName != null) {
				return false;
			}
		} else if (!sizeName.equals(other.sizeName)) {
			return false;
		}
		if (orderId != other.orderId) {
			return false;
		}
		if (product == null) {
			if (other.product != null) {
				return false;
			}
		} else if (!product.equals(other.product)) {
			return false;
		}
		if (specName == null) {
			if (other.specName != null) {
				return false;
			}
		} else if (!specName.equals(other.specName)) {
			return false;
		}
		return true;
	}
}
