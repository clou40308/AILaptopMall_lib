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
			+ " category, maker, cpu, description, discount FROM products";	
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
				p.setCpu(rs.getString("cpu"));
				p.setDescription(rs.getString("description"));                
				
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
					p.setCpu(rs.getString("cpu"));
					p.setDescription(rs.getString("description"));    
					
					list.add(p);
				}
			}			
		} catch (SQLException e) {
			throw new AILMException("用[關鍵字查詢產品]失敗", e);
		} 	
		
		return list;
	}
}
