package com.minip.mvc2.controller;




import java.io.FileReader;

import java.io.IOException;

import java.util.HashMap;

import java.util.Iterator;

import java.util.Map;

import java.util.Properties;



import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;


import com.minip.mvc2.command.*;




public class ControllerUsingFile extends HttpServlet {

private static final long serialVersionUID = 1L;

	

	// <커맨드, 핸들러인스턴스> 매핑 정보 저장

	private Map<String, CommandHandler> commandHandlerMap = new HashMap<>();

	

	public void init() throws ServletException {

		//설정파일 읽기

		String configFile = getInitParameter("configFile");

		

		//읽어온 매핑 정보를 properties 객체에 저장

		Properties prop = new Properties();

		String configFilePath = getServletContext().getRealPath(configFile);

		try(FileReader fr = new FileReader(configFilePath)) {

			//load. 저장 

			prop.load(fr);

		} catch(IOException e) {

			throw new ServletException(e);

		}

		

		//아래 다섯가지 작업을 반복한다.

		//1. 프로퍼티 이름을 커맨드 이름으로 사용

		//2. 커맨드 이름에 해당하는 핸들러 클래스 이름을 Properties에서 구함

		//3. 핸들러 클래스 이름을 이용해서 Class 객체를 구함

		//4. Class로부터 핸들러 객체를 생성

		//5. commandHandlerMap에 (커맨드, 핸들러 객체) 매핑 정보를 저장한다.

		Iterator keyIter = prop.keySet().iterator();

		while(keyIter.hasNext()) {

			String command = (String) keyIter.next();

			String handlerClassName = prop.getProperty(command);

			try {

				Class<?> handlerClass = Class.forName(handlerClassName);

				CommandHandler handlerInstance = (CommandHandler) handlerClass.newInstance();

				commandHandlerMap.put(command, handlerInstance);

			} catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {

				throw new ServletException(e);

			}

		}

	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		process(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		process(request, response);

	}

	

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//클라이언트가 요청한 명령어를 구한다.

		String command = request.getParameter("cmd");

		

		//commandHandlermap에서 요청을 처리할 핸들러 객체를 구한다.

		CommandHandler handler = commandHandlerMap.get(command);

		

		//명령어에 해당하는 핸들러 객체가 존재하지 않을 경우 NullHandler를 사용한다.

		if(handler == null) {

			handler = new NullHandler();

		}

		

		//구한 핸들러 객체의 process() 메서드를 호출해서 요청을 처리하고, 결과로 보여줄 뷰 페이지 경로를 리턴값으로 전달받는다.

		String viewPage = null;

		try {

			viewPage = handler.process(request, response);

		} catch (Exception e) {

			throw new ServletException(e);

		}

		

		//viewPage가 null이 아닐 경우, 핸들러 인스턴스가 리턴한 뷰페이지로 이동한다.

		if(viewPage != null) {

			RequestDispatcher rd = request.getRequestDispatcher(viewPage);

			rd.forward(request, response);

		}

	}

}

