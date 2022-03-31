package com.minip.board.command;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.minip.mvc2.command.CommandHandler;
import com.minip.mvc2.dao.BoardDAO;
import com.minip.mvc2.dto.BoardVO;


public class BoardRegisterHandler implements CommandHandler {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(request.getMethod().equalsIgnoreCase("GET")) {
			return "/view/board/boardRegister.jsp";
		}
		else if (request.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(request, response);
		}
		else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
			
		}
		
	}
	
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws IOException {

		BoardVO bVo = new BoardVO();
		bVo.setName(request.getParameter("name"));
		bVo.setPass(request.getParameter("pass"));
		bVo.setEmail(request.getParameter("email"));
		bVo.setTitle(request.getParameter("title"));
		bVo.setContent(request.getParameter("content"));
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.insertBoard(bVo);
		response.sendRedirect("list.do");		
		return null;
		
	}
	

}
