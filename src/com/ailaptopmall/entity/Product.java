package com.ailaptopmall.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ailaptopmall.exception.AILMDataInvalidException;

public class Product {

	private int id; // 編號 PKey(equals + hashCode), AUTO-INCREMENT

	private String name; // 名稱 unique, required, 1~60個字元

	private double unitPrice; // 單價 required, >0 , 定價(售價)

	private int stock; // 庫存 required，負數

	private String photoUrl; // 圖片連結 optional

	private String category; // 總類, required, null,""~250個字元

	private String maker;// 廠牌 required

	private String description = ""; // optional, 0~250個字元
	
	private LocalDate releaseDate; // required
	
	private int specCount;
	
	public int getSpecCount() {
		return specCount;
	}

	public void setSpecCount(int specCount) {
		this.specCount = specCount;
	}

	//螢幕尺吋清單
	private List<Size> sizeList = new ArrayList<>();
	
	public List<Size> getSizeList() {
		//return sizeList; //不應直接回傳正本
		return new ArrayList<>(sizeList); //應return複本
		//return Collections.unmodifiableList(sizeList); //或return不可變更的正本
	}

	//取代集合屬性的setter: add, (update, remove用不到)
	public void add(Size size) {
		sizeList.add(size);
	}	
	
	public Size findSize(String sizeName) {
		Size theSize = null;
		if(sizeList.size()>0 && sizeName!=null) {	
			for(int i=0;i<sizeList.size();i++) {
				Size size = sizeList.get(i);
				if(size!=null && size.getSizeName().equals(sizeName)) {
					theSize = size;
					break;
				}
			}
		}
		return theSize;
	}
	
	//集合屬性不可直接set
//	public void setColorsList(List<Size> sizeList) {
//		this.sizeList = sizeList;
//	}
	
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
		return Math.round(unitPrice);
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
		if(sizeList!=null && sizeList.size()>0) {
			int sum = 0;
			for(Size size:sizeList) {
				sum = sum + size.getStock();
			}
			return sum;
		}
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	/**
	 * 屬性 releaseDate 的 setter
	 * @param releaseDate LocalDate型別
	 */
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	/**
	 * 將符合iso-8601的日期字串轉換成LocalDate物件
	 * 再呼叫setReleaseDate(LocalDate物件)**間接**指派給產品的releaseDate屬性
	 * @param dateStr String型別
	 */
	public void setReleaseDate(String dateStr) {
		if(dateStr!=null) {
			LocalDate date = LocalDate.parse(dateStr);			
			this.setReleaseDate(date);
		}else {
			
		}
	}
	
	@Override
	public String toString() {
		return 
				this.getClass().getSimpleName()
				+ "[產品編號=" + id + ", 名稱=" + name 
				+ ",\n 定價=" + unitPrice + ", 庫存=" + stock + ", 分類=" + category 
				+ ",\n 圖片=" + photoUrl 
				+ ",\n 廠牌=" + maker
				+ ",\n 說明=" + description 
				+ ",\n 上架時間=" + releaseDate
				+ ",\n 螢幕尺吋清單=" + sizeList
				+ ",\n 規格總數=" + specCount
				+ "]\n";
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
