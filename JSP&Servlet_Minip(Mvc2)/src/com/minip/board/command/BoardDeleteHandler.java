package com.minip.board.command;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.minip.mvc2.command.CommandHandler;
import com.minip.mvc2.dao.BoardDAO;
import com.minip.mvc2.dao.ProductDAO;
import com.minip.mvc2.dto.BoardVO;
import com.minip.mvc2.dto.Paging;
import com.minip.mvc2.dto.ProductVO;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class BoardDeleteHandler implements CommandHandler {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(request.getMethod().equalsIgnoreCase("GET")) {
			
			return processForm(request, response);
			
		}else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			
			return null;
		}
		
	}
	
	private String processForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String num = request.getParameter("num");
		
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.deleteBoard(num);
		
		response.sendRedirect("/board/list.do");
		
		
		return null;
		
	
		
	}
	

}
