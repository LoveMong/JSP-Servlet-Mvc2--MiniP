package com.minip.member.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.minip.mvc2.command.CommandHandler;


public class LogOutHandler implements CommandHandler {

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
		
		return "/view/member/loginForm.jsp"; 
	
	}
	
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		return "/view/member/loginForm.jsp";
		
	}

}
