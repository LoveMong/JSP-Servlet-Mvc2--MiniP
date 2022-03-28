package com.minip.mvc2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.minip.mvc2.dto.ProductVO;
import com.minip.mvc2.util.DBManager;

public class ProductDAO {
	
	private ProductDAO() {}
	
	private static ProductDAO instance = new ProductDAO();
	
	public static ProductDAO getInstance() {
		
		return instance;
		
	}
	
	
	public List<ProductVO> selectAllProducts() {
		
		String sql = "select * from product order by code desc";
		List<ProductVO> list = new ArrayList<ProductVO>();
		try (Connection conn = DBManager.getConnection(); 
			 PreparedStatement pstmt = conn.prepareStatement(sql); ){
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

}