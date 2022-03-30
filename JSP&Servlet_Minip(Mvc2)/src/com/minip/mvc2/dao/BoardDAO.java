package com.minip.mvc2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.minip.mvc2.dto.BoardVO;
import com.minip.mvc2.util.DBManager;

public class BoardDAO {
	
	private BoardDAO() { }
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}
	
	public List<BoardVO> selectAllBoards(int page) {
		
		int startNum = (page-1)*10;
		int endNum = 10;
		String sql = "SELECT * FROM(SELECT *, @ROWNUM:=@ROWNUM+1 as row_num FROM board, (SELECT @ROWNUM:=0) as r)t LIMIT ?, ?";
		List<BoardVO> list = new ArrayList<BoardVO>();
		try (Connection conn = DBManager.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql); ){
			 pstmt.setInt(1, startNum);
			 pstmt.setInt(2, endNum);
			 ResultSet rs = pstmt.executeQuery();
			 while(rs.next()) {
				 BoardVO bVo = new BoardVO();
				 bVo.setNum(rs.getInt("num"));
				 bVo.setName(rs.getNString("name"));
				 bVo.setEmail(rs.getNString("email"));
				 bVo.setPass(rs.getNString("pass"));
				 bVo.setTitle(rs.getNString("title"));
				 bVo.setContent(rs.getNString("content"));
				 bVo.setReadCount(rs.getInt("readcount"));
				 bVo.setWriteDate(rs.getTimestamp("writedate"));
				 list.add(bVo);				 			 
			 }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void insertBoard(BoardVO bVo) {
		
		String sql = "insert into Board(name, email, pass, title, content) values(?, ?, ?, ?, ?)";
		
		try (Connection conn = DBManager.getConnection(); 
			 PreparedStatement pstmt = conn.prepareStatement(sql); ){
			 pstmt.setString(1, bVo.getName());
			 pstmt.setNString(2, bVo.getEmail());
			 pstmt.setNString(3, bVo.getPass());
			 pstmt.setString(4, bVo.getTitle());
			 pstmt.setString(5, bVo.getContent());
			 pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateReadCount(String num) {
		
		String sql = "update board set readcount = readcount+1 where num = ?";
		try (Connection conn = DBManager.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql); ){
			 pstmt.setNString(1, num);
			 pstmt.executeUpdate();
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public BoardVO selectOneBoardByNum(String num) {
		
		String sql = "select * from board where num = ?";
		BoardVO bVo = null;
		ResultSet rs = null;
		
		try (Connection conn = DBManager.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql); ){
			 pstmt.setString(1, num);
			 rs = pstmt.executeQuery();
			 
			 if(rs.next()) {
				 bVo = new BoardVO();
				 bVo.setNum(rs.getInt("num"));
				 bVo.setName(rs.getNString("name"));
				 bVo.setPass(rs.getNString("pass"));
				 bVo.setEmail(rs.getNString("email"));
				 bVo.setTitle(rs.getNString("title"));
				 bVo.setContent(rs.getNString("content"));
				 bVo.setWriteDate(rs.getTimestamp("writedate"));
				 bVo.setReadCount(rs.getInt("readcount"));
				 
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs);
		}
		return bVo;
		
	}
	
	public void updateBoard(BoardVO bVo) {
		
		String sql = "update board set name = ?, email = ?, pass = ?,"
					+ "title = ?, content = ? where num = ?";
		
		try (Connection conn = DBManager.getConnection(); 
			 PreparedStatement pstmt = conn.prepareStatement(sql); ){
			 pstmt.setNString(1, bVo.getName());
			 pstmt.setNString(2, bVo.getEmail());
			 pstmt.setString(3, bVo.getPass());
			 pstmt.setNString(4, bVo.getTitle());
			 pstmt.setString(5, bVo.getContent());
			 pstmt.setInt(6, bVo.getNum());
			 pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public BoardVO checkPassWord(String pass, String num) {
		
		String sql = "select * from board where pass = ? and num = ?";
		ResultSet rs = null;
		BoardVO bVo = null;
		
		try (Connection conn = DBManager.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql); ){
			 pstmt.setString(1, pass);
			 pstmt.setString(2, num);
			 rs = pstmt.executeQuery();
			 if (rs.next()) {
				 bVo = new BoardVO();
				 bVo.setNum(rs.getInt("num"));
				 bVo.setName(rs.getNString("name"));
				 bVo.setEmail(rs.getNString("email"));
				 bVo.setPass(rs.getNString("pass"));
				 bVo.setTitle(rs.getNString("title"));
				 bVo.setContent(rs.getNString("context"));
				 bVo.setReadCount(rs.getInt("readcount"));
				 bVo.setWriteDate(rs.getTimestamp("writedate"));
				 
			 }				 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs);
		}
		return bVo;
	}
	
	public void deleteBoard(String num) {
		
		String sql = "delete from board where num = ?";
		try (Connection conn = DBManager.getConnection(); 
			 PreparedStatement pstmt = conn.prepareStatement(sql); ){
			 pstmt.setNString(1, num);
			 pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public int sqlRow() {
		
		String sql = "select count(*) as count from board";
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
