package com.crm.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.controller.StuController;
import com.crm.entity.Fenye;
import com.crm.servlet.CreateStaticHTMLPage;

/**
 * Servlet implementation class Stu
 */
public class Stu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Stu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		 if (request.getParameter("id") != null) {
	            String fileName =request.getParameter("id") + ".html";
	            System.out.println(fileName);
	           
	            String filePath = getServletContext().getRealPath("/") + fileName;
	            
	            File chapterFile = new File(filePath);
	            System.out.println(chapterFile);
	            if (chapterFile.exists()) {
	                System.out.println("html页面存在，直接跳转");
	                response.sendRedirect(fileName);
	                return;
	            }
	            
	            
//	            System.out.println("新生成html页面");
	            //TODO 这里可调用service查询页面上需要的数据，然后封装到request里面
//	            StuMapperService stuMapperService=new StuMapperService() 
	          
	            
	            
	            request.setAttribute("time", new java.util.Date());
	            request.setAttribute("id", request.getParameter("id"));
	            new CreateStaticHTMLPage().create(request, response, getServletContext(), fileName, filePath,
	                    "/Stu.jsp");
//	        }
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
