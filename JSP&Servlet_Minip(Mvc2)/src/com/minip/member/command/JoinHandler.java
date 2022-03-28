package com.minip.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.minip.mvc2.command.CommandHandler;
import com.minip.mvc2.dao.MemberDAO;
import com.minip.mvc2.dto.MemberVO;

public class JoinHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(request.getMethod().equalsIgnoreCase("GET")) {
			return processForm(request, response);
		}
		else if (request.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(request, response);
		}
		else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
			
		}
	}
	
	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		
		String url = "/view/member/loginForm.jsp";

		return url;
	
	}
	
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		
//		request.setCharacterEncoding("UTF-8");
		String url = "/view/member/loginForm.jsp";
		
		String userid = request.getParameter("userid");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("pwd");
		
		MemberVO mVo = new MemberVO();
		mVo.setUserid(userid);
		mVo.setName(name);
		mVo.setEmail(email);
		mVo.setPhone(phone);
		mVo.setPwd(pwd);
		mVo.setGrade(0);
		
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.insertMember(mVo);
		HttpSession session = request.getSession();
		if(result == 1) {
			session.setAttribute("userid", mVo.getUserid());
			request.setAttribute("message", "회원 가입에 성공했습니다.");	
		} else {
			request.setAttribute("message", "회원 가입에 실패했습니다.");
		}
		
		return url;
		
	}

}
