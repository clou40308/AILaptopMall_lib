package com.ailaptopmall.entity;

public class CartItem {
	private Product theProduct; // PKey
	private Size theSize; // PKey
	private Spec theSpec; // PKey

	public Product getTheProduct() {
		return theProduct;
	}

	public void setTheProduct(Product theProduct) {
		this.theProduct = theProduct;
	}

	public Size getTheSize() {
		return theSize;
	}

	public void setTheSize(Size theSize) {
		this.theSize = theSize;
	}

	public Spec getTheSpec() {
		return theSpec;
	}

	public void setTheSpec(Spec theSpec) {
		this.theSpec = theSpec;
	}

	//根據購物車畫面設計getter	
	public int getProductId() {
		return theProduct.getId();
	}
	
	public String getProductName() {
		return theProduct.getName();
	}
	
	public String getSizeName() {
		if(theSize!=null) {
			return theSize.getSizeName();
		}else {
			return "";
		}
	}
	
	public String getSpecName() {
		if(theSpec!=null) {
			return theSpec.getSpecName();
		}else {
			return "";
		}
	}
	
	public int getStock() {
		if(theSpec!=null) {
			return theSpec.getStock();
		}else if(theSize!=null) {
			return theSize.getStock();
		}else {
			return theProduct.getStock();
		}
	}
	
	public String getPhotoUrl() {
		if(theSpec!=null && theSpec.getPhotoUrl()!=null) {
			return theSpec.getPhotoUrl();
		}else {
			return theProduct.getPhotoUrl();
		}
	}
	
	public double getListPrice() {
		if(theSpec!=null) {
			return theSpec.getUnitPrice();
		}else{
			if(theProduct instanceof SpecialOffer) {
				return ((SpecialOffer)theProduct).getListPrice();
			}else {
				return theProduct.getUnitPrice();
			}
		}
	}
	
	public double getPrice() {
		if(theSpec!=null) {
			return theSpec.getPrice();
		}else{
			return theProduct.getUnitPrice();
		}
	}
	
	public String getDiscountString() {
		if(theProduct instanceof SpecialOffer) {
			return ((SpecialOffer)theProduct).getDiscountString();
		}else {
			return "";
		}
	}	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((theProduct == null) ? 0 : theProduct.hashCode());
		result = prime * result + ((theSize == null) ? 0 : theSize.hashCode());
		result = prime * result + ((theSpec == null) ? 0 : theSpec.hashCode());
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
		CartItem other = (CartItem) obj;
		if (theProduct == null) {
			if (other.theProduct != null) {
				return false;
			}
		} else if (!theProduct.equals(other.theProduct)) {
			return false;
		}
		if (theSize == null) {
			if (other.theSize != null) {
				return false;
			}
		} else if (!theSize.equals(other.theSize)) {
			return false;
		}
		if (theSpec == null) {
			if (other.theSpec != null) {
				return false;
			}
		} else if (!theSpec.equals(other.theSpec)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "購物明細 [編號=" + getProductId() 
					+ String.format(", Product-Size-Spec=%s-%s-%s",getProductName(),getSizeName(),getSpecName())
					+ ", 庫存=" + getStock() 
					+ "\n, 圖片網址=" + getPhotoUrl() 
					+ "\n 定價" + getListPrice()	+ ", 折扣=" + getDiscountString()+ ", 售價=" + getPrice() + "\n"
					+ "]";
	}
	
}
