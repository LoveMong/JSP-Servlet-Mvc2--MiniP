package com.minip.product.command;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.minip.mvc2.command.CommandHandler;
import com.minip.mvc2.dao.ProductDAO;
import com.minip.mvc2.dto.Paging;
import com.minip.mvc2.dto.ProductVO;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class ProductListHandler implements CommandHandler {
	
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
		
		String url = "/view/product/productList.jsp";
		int page = 1;
		int pageTotal = 0;
		String table = "product";
		System.out.println("table Name:" + table);
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		ProductDAO pDao = ProductDAO.getInstance();
		pageTotal = pDao.sqlRow();
		
		Paging paging = new Paging();
		paging.setPage(page);
		paging.setTotalCount(pageTotal);
		
		System.out.println("pagetotal : " + pageTotal);
		List<ProductVO> productList = pDao.selectAllProducts(page);
		request.setAttribute("productList", productList);
		request.setAttribute("paging", paging);
		return url;
		
	}
	

}
