package com.minip.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.minip.mvc2.command.CommandHandler;
import com.minip.mvc2.dao.MemberDAO;
import com.minip.mvc2.dto.MemberVO;

public class LoginHandler implements CommandHandler {

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
		HttpSession session = request.getSession();
		if (session.getAttribute("loginUser") != null) { // 로그인 여부 확인
			url = "/view/main.jsp";	// 로그인이 되어있는 상태라면 메인페이지로 이동		
		}
		return url;
	}
	
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		
		String url = "/view/member/loginForm.jsp";
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.userCheck(userid, pwd);
		
		if(result == 1) {
			MemberVO mVo = mDao.getMember(userid);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mVo);
			request.setAttribute("message", "로그인 되었습니다.");
			url = "/view/main.jsp";
		}else if (result == 0) {
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		}else if (result == -1) {
			request.setAttribute("message", "존재하지 않는 회원입니다.");
		}
				
		return url;
		
	}

}
