package com.minip.member.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.minip.mvc2.command.CommandHandler;
import com.minip.mvc2.dao.MemberDAO;
import com.minip.mvc2.dto.MemberVO;




public class EditMemberHandler implements CommandHandler {

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
		
		String userid = request.getParameter("userid");
		MemberDAO mDao = MemberDAO.getInstance();
		MemberVO mVo = mDao.getMember(userid);
		request.setAttribute("userInfo", mVo);
		
		return "/view/member/editMemberForm.jsp"; 
	
	}
	
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		MemberVO mVo = new MemberVO();
		mVo.setUserid(userid);
		mVo.setPwd(pwd);
		mVo.setEmail(email);
		mVo.setPhone(phone);
		
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.updateMember(mVo);
		request.setAttribute("message", "회원 정보를 수정했습니다. 다시 로그인해주세요.");
		
		
		return "/view/member/loginForm.jsp";
		
	}

}
