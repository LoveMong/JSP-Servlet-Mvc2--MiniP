package com.minip.board.command;

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

public class BoardViewHandler implements CommandHandler {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(request.getMethod().equalsIgnoreCase("GET")) {
			
			return processForm(request, response);
			
		}else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			
			return null;
		}
		
	}
	
	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		
		String url = "/view/board/boardView.jsp";
		String num = request.getParameter("num");
		
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.updateReadCount(num);
		
		BoardVO bVo = bDao.selectOneBoardByNum(num);
		request.setAttribute("board", bVo);
		
		return url;
		
	}
	

}
