package com.minip.product.command;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.minip.mvc2.command.CommandHandler;
import com.minip.mvc2.dao.ProductDAO;


public class ProductDeleteHandler implements CommandHandler {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(request.getMethod().equalsIgnoreCase("GET")) {
			return submitForm(request, response);
		}
		else if (request.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(request, response);
		}
		else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
			
		}
		
	}
	
	
	private String submitForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
				
		Integer code = Integer.valueOf(request.getParameter("code"));
		
		ProductDAO pDao = ProductDAO.getInstance();
		pDao.deleteProduct(code);
		
		response.sendRedirect("/product/list.do");
				
		return null;
		
	}
	
	
	
	
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
			
		return null;
			
		
	}
	

}
