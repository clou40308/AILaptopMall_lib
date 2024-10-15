package com.ailaptopmall.entity;

public class Spec {
	private int productId; // PKey
	private String sizeName; // PKey
	private String specName; // PKey
	private int stock; // 必要
	private double unitPrice; // 必要, 定價
	private double price; // 必要, 折扣後售價
	private int ordinal; // 非必要
	private String photoUrl;
	private String description1;
	private String description2;
	private String description3;

	public Spec() {
		super();
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getPrice() {
		return Math.round(price);
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getDescription1() {
		return description1;
	}

	public void setDescription1(String description1) {
		this.description1 = description1;
	}

	public String getDescription2() {
		return description2;
	}

	public void setDescription2(String description2) {
		this.description2 = description2;
	}

	public String getDescription3() {
		return description3;
	}

	public void setDescription3(String description3) {
		this.description3 = description3;
	}

	@Override
	public String toString() {
		return "Spec [產品編號=" + productId + ", 螢幕尺吋=" + sizeName + ", 規格=" + specName + ", 庫存=" + stock
				+ "\n, 定價=" + unitPrice + ", 售價=" + price + ", 序號=" + ordinal + ", 圖片網址=" + photoUrl
				+ "\n, 描述_1=" + description1 + ", 描述_2=" + description2 + ", 描述_3=" + description3
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productId;
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
		Spec other = (Spec) obj;
		if (productId != other.productId) {
			return false;
		}
		if (sizeName == null) {
			if (other.sizeName != null) {
				return false;
			}
		} else if (!sizeName.equals(other.sizeName)) {
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
