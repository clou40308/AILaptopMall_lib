package com.ailaptopmall.entity;

import com.ailaptopmall.exception.AILMDataInvalidException;

public class Product {

	private int id; // 編號 PKey(equals + hashCode), AUTO-INCREMENT

	private String name; // 名稱 unique, required, 1~60個字元

	private double unitPrice; // 單價 required, >0 , 定價(售價)

	private int stock; // 庫存 required，負數

	private String photoUrl; // 圖片連結 optional

	private String category; // 總類, required, null,""~250個字元

	private String maker;// 廠牌 required

	private String cpu;// required

	private String description = ""; // optional, 0~250個字元

	public Product() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id >= 0) {
			this.id = id;
		} else {
			String msg = String.format("產品編號(%s)不得為負數\n", id);
			throw new AILMDataInvalidException(msg);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 查詢定價(即為售價)
	 * 
	 * @return double型別的定價(即為售價)
	 */
	public double getUnitPrice() {
		return unitPrice;
	}

	/**
	 * 指派定價
	 * 
	 * @param unitPrice double型別，代表定價
	 */
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return 
				this.getClass().getSimpleName()
				+ "[產品編號=" + id + ", 名稱=" + name 
				+ ",\n 定價=" + unitPrice + ", 庫存=" + stock + ", 分類=" + category 
				+ ",\n 圖片=" + photoUrl 
				+ ",\n 廠牌=" + maker
				+ ",\n CPU=" +  cpu
				+ ",\n 說明=" + description 
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Product other = (Product) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

}
