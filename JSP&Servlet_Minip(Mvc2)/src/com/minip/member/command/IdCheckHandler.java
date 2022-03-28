package com.minip.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minip.mvc2.command.CommandHandler;
import com.minip.mvc2.dao.MemberDAO;

public class IdCheckHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url;
		
		if (request.getMethod().equalsIgnoreCase("GET")) {
			
			String userid = request.getParameter("userid");
			MemberDAO mDao = MemberDAO.getInstance();
			int result = mDao.checkID(userid);
			request.setAttribute("userid", userid);
			request.setAttribute("result", result);
			url = "/view/member/idCheck.jsp";
			return url;		
			
		}else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
			
	}

}
