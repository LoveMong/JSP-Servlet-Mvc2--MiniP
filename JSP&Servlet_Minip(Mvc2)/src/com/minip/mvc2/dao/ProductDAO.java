package com.minip.mvc2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.map.PassiveExpiringMap;

import com.minip.mvc2.dto.ProductVO;
import com.minip.mvc2.util.DBManager;

public class ProductDAO {
	
	private ProductDAO() {}
	
	private static ProductDAO instance = new ProductDAO();
	
	public static ProductDAO getInstance() {
		
		return instance;
		
	}
	
	
	public List<ProductVO> selectAllProducts(int page) {
		
		int startNum = (page-1)*10;
		int endNum = 10;
		String sql = "SELECT * FROM(SELECT *, @ROWNUM:=@ROWNUM+1 as row_num FROM product, (SELECT @ROWNUM:=0) as r)t LIMIT ?, ?";
		
//		"SELECT *"
//		 + "FROM("  
//		 +	   "SELECT *, @ROWNUM:=@ROWNUM+1 as row_num"
//		 +     "FROM product, (SELECT @ROWNUM:=0) as r)"
//		 + "t LIMIT ?, ?";
		List<ProductVO> list = new ArrayList<ProductVO>();
		try (Connection conn = DBManager.getConnection(); 
			 PreparedStatement pstmt = conn.prepareStatement(sql); ){
			 pstmt.setInt(1, startNum);
			 pstmt.setInt(2, endNum);
			 ResultSet rs = pstmt.executeQuery();
			 while (rs.next()) {
				 ProductVO pVo = new ProductVO();
				 pVo.setCode(rs.getInt("code"));
				 pVo.setName(rs.getNString("name"));
				 pVo.setPrice(rs.getInt("price"));
				 pVo.setPictureUrl(rs.getNString("pictureUrl"));
				 pVo.setDescription(rs.getString("description"));
				 list.add(pVo);
			 }			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void insertProduct(ProductVO pVo) {
		
		String sql = "insert into product (name, price, pictureUrl, description) values(?, ?, ?, ?)";
		try (Connection conn = DBManager.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql); ){
			 pstmt.setNString(1, pVo.getName());
			 pstmt.setInt(2, pVo.getPrice());
			 pstmt.setString(3, pVo.getPictureUrl());
			 pstmt.setString(4, pVo.getDescription());
			 pstmt.executeUpdate();		
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ProductVO selectProductByCode(Integer code) {
		
		String sql = "select * from product where code = ?";
		ProductVO pVo = null;
		ResultSet rs = null;
		
		try (Connection conn = DBManager.getConnection(); 
			 PreparedStatement pstmt = conn.prepareStatement(sql); ){
			 pstmt.setInt(1, code);
			 rs = pstmt.executeQuery();
			 if (rs.next()) {
				 pVo = new ProductVO();
				 pVo.setCode(rs.getInt("code"));
				 pVo.setName(rs.getNString("name"));
				 pVo.setPrice(rs.getInt("price"));
				 pVo.setPictureUrl(rs.getNString("pictureurl"));
				 pVo.setDescription(rs.getNString("description"));
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs);
		}
		return pVo;
	}
	
	public void updateProduct(ProductVO pVo) {
		
		String sql = "update product set name=?, price=?, pictureurl=?, description=? where code=?";
		try (Connection conn = DBManager.getConnection(); 
			 PreparedStatement pstmt = conn.prepareStatement(sql); ){
			 pstmt.setNString(1, pVo.getName());
			 pstmt.setInt(2, pVo.getPrice());
			 pstmt.setNString(3, pVo.getPictureUrl()	);
			 pstmt.setNString(4, pVo.getDescription());
			 pstmt.setInt(5, pVo.getCode());
			 pstmt.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteProduct(Integer code) {
		
		String sql = "delete from product where code = ?";
			
		try (Connection conn = DBManager.getConnection(); 
			 PreparedStatement pstmt = conn.prepareStatement(sql); ){
			 pstmt.setInt(1, code);
			 pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public int sqlRow() {
		
		String sql = "select count(*) as count from product";
		ResultSet rs = null;
		int result = 0;
					
		try (Connection conn = DBManager.getConnection(); 
			 PreparedStatement pstmt = conn.prepareStatement(sql);){
			 rs = pstmt.executeQuery();
			 if (rs.next()) {
				 
				result = rs.getInt("count");
				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs);
		}
		
		return result;
		
	}
}
