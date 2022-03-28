package com.minip.mvc2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.minip.mvc2.dto.MemberVO;
import com.minip.mvc2.encript.BCrypt;
import com.minip.mvc2.util.DBManager;


public class MemberDAO {
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		
		return instance;
		
	}
	
	// 사용자 인증시 사용하는 메소드
	public int userCheck(String userid, String pwd) {
		
		int result = -1;
		String sql = "select pwd from member where userid = ?";
		ResultSet rs = null;
		try (Connection conn = DBManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql); ){
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if(rs.getNString("pwd") != null &&
						BCrypt.checkpw(pwd, rs.getNString("pwd"))) {
					result = 1;
					System.out.println(result);
				}else {
					result = 0;
				}
			}else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs);
		}

		return result;
		
	}
	
	public MemberVO getMember(String userid) {
		
		MemberVO mVo = null;
		String sql = "select * from member where userid = ?";
		ResultSet rs = null;
		try (Connection conn = DBManager.getConnection(); 
			 PreparedStatement pstmt = conn.prepareStatement(sql); ){
			 pstmt.setString(1, userid);
			 rs = pstmt.executeQuery();
			 if(rs.next()) {
				 mVo = new MemberVO();
				 mVo.setName(rs.getString("name"));
				 mVo.setUserid(rs.getNString("userid"));
				 mVo.setPwd(rs.getNString("pwd"));
				 mVo.setEmail(rs.getNString("email"));
				 mVo.setPhone(rs.getNString("phone"));
				 mVo.setGrade(rs.getInt("grade"));
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs);
		}
		
		return mVo;
	}
	
	public int insertMember(MemberVO mVo) {
		int result = -1;
		String sql = "insert into member values(?, ?, ?, ?, ?, ?)";
		try (Connection conn = DBManager.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql); ){
			 pstmt.setNString(1, mVo.getUserid());
			 pstmt.setNString(2, mVo.getName());
			 pstmt.setNString(3, BCrypt.hashpw(mVo.getPwd(), BCrypt.gensalt(10)));
			 pstmt.setNString(4, mVo.getEmail());
			 pstmt.setNString(5, mVo.getPhone());
			 pstmt.setInt(6, mVo.getGrade());
			 result = pstmt.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int checkID(String userid) {
		
		int result = -1;
		String sql = "select userid from member where userid = ?";
		ResultSet rs = null;
		try (Connection conn = DBManager.getConnection(); 
			 PreparedStatement pstmt = conn.prepareStatement(sql); ){
			 pstmt.setNString(1, userid);
			 rs = pstmt.executeQuery();
			 if (rs.next()) {
				result = 1;
			} else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs);
		}
		return result;
	}
	
	public int updateMember(MemberVO mVo) {
		
		int result = -1;
		String sql = "update member set pwd = ?, email = ?,"
					+ "phone = ? where userid = ?";
		try (Connection conn = DBManager.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql); ){
			pstmt.setNString(1, BCrypt.hashpw(mVo.getPwd(), BCrypt.gensalt(10)));
			pstmt.setNString(2, mVo.getEmail());
			pstmt.setNString(3, mVo.getPhone());
			pstmt.setNString(4, mVo.getUserid());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
