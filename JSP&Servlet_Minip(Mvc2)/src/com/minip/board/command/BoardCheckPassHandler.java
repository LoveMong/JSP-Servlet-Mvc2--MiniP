package com.minip.board.command;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.minip.mvc2.command.CommandHandler;
import com.minip.mvc2.dao.BoardDAO;
import com.minip.mvc2.dao.ProductDAO;
import com.minip.mvc2.dto.BoardVO;
import com.minip.mvc2.dto.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardCheckPassHandler implements CommandHandler {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(request.getMethod().equalsIgnoreCase("GET")) {
			return "/view/board/boardCheckPass.jsp";
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

		String url = null;
		String num = request.getParameter("num");
		String pass = request.getParameter("pass");
		
		System.out.println("num : "+ num);
		System.out.println("pass : "+ pass);
		
		BoardDAO bDao = BoardDAO.getInstance();
		BoardVO bVo = bDao.selectOneBoardByNum(num);
		
		if (bVo.getPass().equals(pass)) {
			url = "/view/board/boardCheckSuccess.jsp";
		} else {
			url = "/view/board/boardCheckPass.jsp";
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
		}
		
		return url;
		
	}
	

}
