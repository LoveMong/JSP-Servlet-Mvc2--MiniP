package com.minip.product.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.minip.mvc2.command.CommandHandler;
import com.minip.mvc2.dao.ProductDAO;
import com.minip.mvc2.dto.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProductRegisterHandler implements CommandHandler {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(request.getMethod().equalsIgnoreCase("GET")) {
			return "/view/product/productRegister.jsp";
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
		
		// ServletContext : 웹 애플리케이션 내에 있는 모든 서블릿 그리고 JSP 간에 정보를 공유 및 서블릿 컨테이너에 대한 정보를 추출할 수 있게 하는 기술
		// getServletContext : 현재 웹 어플리케이션에 할당된 ServletContext 객체의 주솟값을 추출
		ServletContext context = request.getServletContext();
		
		String path = context.getRealPath("upload");
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String description = multi.getParameter("description");
		String pictureUrl = multi.getParameter("pictureUrl");
		
		ProductVO pVo = new ProductVO();
		pVo.setName(name);
		pVo.setPrice(price);
		pVo.setDescription(description);
		pVo.setPictureUrl(pictureUrl);
		
		ProductDAO pDao = ProductDAO.getInstance();
		pDao.insertProduct(pVo);
		
		response.sendRedirect("list.do");		
		
		return null;
		
	}
	

}
