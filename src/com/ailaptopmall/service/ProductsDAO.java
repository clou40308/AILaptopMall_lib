package com.ailaptopmall.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ailaptopmall.entity.Product;
import com.ailaptopmall.entity.SpecialOffer;
import com.ailaptopmall.exception.AILMException;

public class ProductsDAO {
	
	private static final String SELECT_ALL_PRODUCTS=
			"SELECT id, name, unit_price, stock, photo_url, "
			+" category, maker, description, release_date, discount FROM products";	
	List<Product> selectAllProducts()throws AILMException{
		List<Product> list = new ArrayList<>();		
		//JDBC 1~5
		try (
				Connection connection = MySQLConnection.getConnection(); //1,2 取得連線
				PreparedStatement pstmt = connection.prepareStatement(SELECT_ALL_PRODUCTS + " ORDER BY RAND()"); //3.準備指令						
				ResultSet rs = pstmt.executeQuery(); //4.執行指令
			){
			while(rs.next()) { //5.處理rs
				Product p; //可能是Product物件或SpecialOffer物件
				
				int discount = rs.getInt("discount");
				if(discount > 0) {
					p = new SpecialOffer();
					((SpecialOffer)p).setDiscount(discount);
				}else {
					p = new Product();
				}
				
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setUnitPrice(rs.getDouble("unit_price"));
				p.setStock(rs.getInt("stock"));
				p.setPhotoUrl(rs.getString("photo_url"));
				p.setCategory(rs.getString("category"));
				p.setMaker(rs.getString("maker"));
				p.setDescription(rs.getString("description"));                
				p.setReleaseDate(rs.getString("release_date"));
				
				list.add(p);
			}
		} catch (SQLException e) {
			throw new AILMException("[查詢全部產品]失敗", e);
		}
		return list;	
	}
	
	private static final String SELECT_PRODUCTS_BY_KEYWORD = SELECT_ALL_PRODUCTS 
				 + " WHERE name LIKE ?";	
	List<Product> selectProductsByKeyword(String keyword)throws AILMException{
		List<Product> list = new ArrayList<>();
		//JDBC 1~5
		try (
				Connection connection = MySQLConnection.getConnection(); //1,2 取得連線
				PreparedStatement pstmt = connection.prepareStatement(SELECT_PRODUCTS_BY_KEYWORD);//3.準備指令				
			){
			//3.1 傳入?的值
			pstmt.setString(1, '%'+keyword+'%');
			try(ResultSet rs = pstmt.executeQuery(); //4.執行指令
			){
				while(rs.next()) { //5.處理rs
					Product p; //可能是Product物件或SpecialOffer物件					
					int discount = rs.getInt("discount");
					if(discount > 0) {
						p = new SpecialOffer();
						((SpecialOffer)p).setDiscount(discount);
					}else {
						p = new Product();
					}
					
					p.setId(rs.getInt("id"));
					p.setName(rs.getString("name"));
					p.setUnitPrice(rs.getDouble("unit_price"));
					p.setStock(rs.getInt("stock"));
					p.setPhotoUrl(rs.getString("photo_url"));
					p.setCategory(rs.getString("category"));
					p.setMaker(rs.getString("maker"));
					p.setDescription(rs.getString("description"));    
					p.setReleaseDate(rs.getString("release_date"));
					
					list.add(p);
				}
			}			
		} catch (SQLException e) {
			throw new AILMException("用[關鍵字查詢產品]失敗", e);
		} 	
		
		return list;
	}
	
	private static final String SELECT_PRODUCTS_BY_MAKER=SELECT_ALL_PRODUCTS 
				+ " WHERE maker=? ";
	List<Product> selectProductsByMaker(String maker) throws AILMException{
		List<Product> list = new ArrayList<>();
		//JDBC 1~5
		try (
				Connection connection = MySQLConnection.getConnection(); //1,2 取得連線
				PreparedStatement pstmt = connection.prepareStatement(SELECT_PRODUCTS_BY_MAKER);//3.準備指令				
			){
			//3.1 傳入?的值
			pstmt.setString(1, maker);
			try(ResultSet rs = pstmt.executeQuery(); //4.執行指令
			){
				while(rs.next()) { //5.處理rs
					Product p; //可能是Product物件或SpecialOffer物件					
					int discount = rs.getInt("discount");
					if(discount > 0) {
						p = new SpecialOffer();
						((SpecialOffer)p).setDiscount(discount);
					}else {
						p = new Product();
					}
					
					p.setId(rs.getInt("id"));
					p.setName(rs.getString("name"));
					p.setUnitPrice(rs.getDouble("unit_price"));
					p.setStock(rs.getInt("stock"));
					p.setPhotoUrl(rs.getString("photo_url"));
					p.setCategory(rs.getString("category"));
					p.setMaker(rs.getString("maker"));
					p.setDescription(rs.getString("description"));    
					p.setReleaseDate(rs.getString("release_date"));
					
					list.add(p);
				}
			}			
		} catch (SQLException e) {
			throw new AILMException("用[廠牌查詢產品]失敗", e);
		} 	
		return list;		
	}
	
	private static final int LIMIT_NUM = 5;
	private static final String SELECT_LATEST_PRODUCTS = 
			SELECT_ALL_PRODUCTS
			+ "  ORDER BY release_date DESC"
			+ "  LIMIT " + LIMIT_NUM;
	List<Product> selectLatestProducts() throws AILMException{
		List<Product> list = new ArrayList<>();		
		//JDBC 1~5
		try (
				Connection connection = MySQLConnection.getConnection(); //1,2 取得連線
				PreparedStatement pstmt = connection.prepareStatement(SELECT_LATEST_PRODUCTS); //3.準備指令						
				ResultSet rs = pstmt.executeQuery(); //4.執行指令
			){
			while(rs.next()) { //5.處理rs
				Product p; //可能是Product物件或SpecialOffer物件
				
				int discount = rs.getInt("discount");
				if(discount > 0) {
					p = new SpecialOffer();
					((SpecialOffer)p).setDiscount(discount);
				}else {
					p = new Product();
				}
				
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setUnitPrice(rs.getDouble("unit_price"));
				p.setStock(rs.getInt("stock"));
				p.setPhotoUrl(rs.getString("photo_url"));
				p.setCategory(rs.getString("category"));
				p.setMaker(rs.getString("maker"));
				p.setDescription(rs.getString("description"));    
				p.setReleaseDate(rs.getString("release_date"));
				
				list.add(p);
			}
		} catch (SQLException e) {
			throw new AILMException("[查詢最新上架產品]失敗", e);
		}
		return list;	
	}
	
	private static final String SELECT_PRODUCT_BY_ID =
					"SELECT id, name, unit_price, stock, photo_url, "
					+" category, maker, description, release_date, discount FROM products "
					+" WHERE id=? ";
	public Product selectProductById(String id) throws AILMException{
		Product p = null;
		try (
				Connection connection = MySQLConnection.getConnection(); //1,2. 取得連線
				PreparedStatement pstmt = connection.prepareStatement(SELECT_PRODUCT_BY_ID); //3.準備指令
				){
			//3.1 傳入?的值
			pstmt.setString(1, id);
			try(
				ResultSet rs = pstmt.executeQuery(); //4. 執行指令
			){
				//5.處理rs
				while(rs.next()) {
					if(p==null) {
						//讀取產品資料
						int discount = rs.getInt("discount");
						if(discount>0) {
							p = new SpecialOffer();
							((SpecialOffer)p).setDiscount(discount);
						}else {					
							p = new Product();
						}
						
						p.setId(rs.getInt("id"));
						p.setName(rs.getString("name"));
						p.setUnitPrice(rs.getDouble("unit_price"));
						p.setStock(rs.getInt("stock"));
						p.setPhotoUrl(rs.getString("photo_url"));
						p.setCategory(rs.getString("category"));
						p.setMaker(rs.getString("maker"));
						p.setDescription(rs.getString("description"));    
						p.setReleaseDate(rs.getString("release_date"));
					}
				}
			}
		} catch (SQLException e) {
			throw new AILMException("[用id查詢產品]失敗", e);
		}		
		return p;
	}
}
