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

public class BoardListHandler implements CommandHandler {
	
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
		
		String url = "/view/board/boardList.jsp";
		int page = 1;
		int pageTotal = 0;
		
		if(request.getParameter("page") != null) {
			
			page = Integer.parseInt(request.getParameter("page"));
			
		}
		
		BoardDAO pDao = BoardDAO.getInstance();
		pageTotal = pDao.sqlRow();
		
		Paging paging = new Paging();
		paging.setPage(page);
		paging.setTotalCount(pageTotal);
				
		List<BoardVO> boardList = pDao.selectAllBoards(page);
		request.setAttribute("boardList", boardList);
		request.setAttribute("paging", paging);
		return url;
		
	}
	

}
