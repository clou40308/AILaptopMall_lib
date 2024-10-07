package com.ailaptopmall.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ailaptopmall.entity.Product;
import com.ailaptopmall.entity.Size;
import com.ailaptopmall.entity.Spec;
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
			"SELECT id, name, products.unit_price, IFNULL(SUM(product_size_specs.stock),products.stock) AS stock, "
			+ " products.photo_url, category, maker, description, products.release_date, discount , "
			+ " product_sizes.product_id, product_sizes.size_name, "
			+ " IFNULL(product_sizes.release_date,products.release_date) AS size_release_date, "
			+ " IFNULL(SUM(product_size_specs.stock),product_sizes.stock) AS size_stock, product_sizes.ordinal, "
			+ " COUNT(spec_name) AS spec_count "
			+ " FROM products "
			+ " LEFT JOIN product_sizes ON products.id=product_sizes.product_id "
			+ " LEFT JOIN product_size_specs ON products.id = product_size_specs.product_id "
			+ "	AND (product_sizes.size_name= product_size_specs.size_name "
			+ " OR product_sizes.size_name IS NULL) "
			+ "	WHERE products.id=? "
			+ "	GROUP BY products.id,product_sizes.size_name ";
	
	
//			"SELECT id, name, unit_price, products.stock, photo_url, category, maker, description, products.release_date, discount, "
//			+ " product_id, size_name, "
//			+ " IFNULL(product_sizes.release_date,products.release_date) AS size_release_date, "
//			+ " product_sizes.stock AS size_stock "
//			+ "	FROM products "
//			+ "	LEFT JOIN product_sizes ON products.id=product_sizes.product_id"
//			+ "	WHERE id=? ORDER BY product_sizes.ordinal";

//					"SELECT id, name, unit_price, stock, photo_url, "
//					+" category, maker, description, release_date, discount FROM products "
//					+" WHERE id=? ";
	
	Product selectProductById(String id) throws AILMException{
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
						p.setSpecCount(rs.getInt("spec_count"));
					}
						//讀取size資料
						String sizeName = rs.getString("size_name");//size_name為PKEY
						if(sizeName!=null) {
							Size size = new Size();
							size.setSizeName(sizeName);
							size.setStock(rs.getInt("size_stock"));
							size.setReleaseDate(LocalDate.parse(rs.getString("size_release_date")));
							
							p.add(size);	
						
						}
						//System.out.println(p); //for test
				}
			}
		} catch (SQLException e) {
			throw new AILMException("[用id查詢產品]失敗", e);
		}		
		return p;
	}
	
	private static final String SELECT_PRODUCT_SPECS_BY_ID_AND_SIZENAME =
			"SELECT product_id, size_name, spec_name, product_size_specs.stock, product_size_specs.unit_price, "
			+ "	product_size_specs.unit_price * (100-products.discount) / 100 AS price, "
			+ " product_size_specs.photo_url, description_1, description_2, description_3, ordinal "
			+ "	FROM product_size_specs JOIN products ON product_size_specs.product_id = products.id "
			+ " WHERE product_id=? AND size_name=? ORDER BY ordinal";
	
	List<Spec> selectProductSpecsByIdAndSizeName(String productId, String sizeName) throws AILMException {
		List<Spec> list = new ArrayList<>();		
		try (	Connection connection = MySQLConnection.getConnection(); //1,2.取得連線
				PreparedStatement pstmt = connection.prepareStatement(SELECT_PRODUCT_SPECS_BY_ID_AND_SIZENAME); //3.準備指令
				){
					//3.1傳入?的值
					pstmt.setString(1, productId);
					pstmt.setString(2, sizeName);			
					try(	ResultSet rs = pstmt.executeQuery(); //4.執行指令
							){
						//5. 處理rs
						while(rs.next()) {
							Spec spec = new Spec();
							spec.setProductId(rs.getInt("product_id"));
							spec.setSizeName(rs.getString("size_name"));
							spec.setSpecName(rs.getString("spec_name"));
							spec.setStock(rs.getInt("stock"));
							spec.setUnitPrice(rs.getDouble("unit_price"));
							spec.setPrice(rs.getDouble("price"));
							spec.setOrdinal(rs.getInt("ordinal"));
							
							spec.setPhotoUrl(rs.getString("photo_url"));
							spec.setDescription1(rs.getString("description_1"));
							spec.setDescription2(rs.getString("description_2"));
							spec.setDescription3(rs.getString("description_3"));
							list.add(spec);
						}
					}
		} catch (SQLException e) {
			throw new AILMException("查詢[指定產品-螢幕尺寸]的specLis失敗!", e);
		}		
		return list;		
	}

	//取5個亂數id的產品
	private static final String SELECT_RANDOM_PRODUCTS =
			"SELECT id, name, unit_price, stock, photo_url, category, maker, description, release_date, discount "
			+ " FROM products "
			+ " ORDER BY RAND() "
			+ " LIMIT 6 ";
	List<Product> selectRandomProducts()  throws AILMException {
		List<Product> list = new ArrayList<>();		
		//JDBC 1~5
		try (
				Connection connection = MySQLConnection.getConnection(); //1,2 取得連線
				PreparedStatement pstmt = connection.prepareStatement(SELECT_RANDOM_PRODUCTS); //3.準備指令						
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
			throw new AILMException("[查詢5個亂數產品失敗]失敗", e);
		}
		return list;	
	}
	
}
