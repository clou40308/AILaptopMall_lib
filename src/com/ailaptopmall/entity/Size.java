package com.ailaptopmall.entity;

import java.time.LocalDate;

import com.ailaptopmall.exception.AILMDataInvalidException;

public class Size {

	private String sizeName; // 必要, PKEy

	private int stock; // 必要

	private LocalDate releaseDate;
	
	public Size() {
		
	}

	public String getSizeName() {
		return sizeName;
	}

	public void setSizeName(String sizeName) {
		if(sizeName !=null && (sizeName=sizeName.trim()).length()>0) {
			this.sizeName = sizeName;
		}else {
			throw new AILMDataInvalidException("螢幕尺寸名稱必須有值");
		}
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "螢幕尺寸 [名稱=" + sizeName + ", 庫存=" + stock + ", 上架日期=" + releaseDate + "]\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sizeName == null) ? 0 : sizeName.hashCode());
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
		Size other = (Size) obj;
		if (sizeName == null) {
			if (other.sizeName != null) {
				return false;
			}
		} else if (!sizeName.equals(other.sizeName)) {
			return false;
		}
		return true;
	}

}
