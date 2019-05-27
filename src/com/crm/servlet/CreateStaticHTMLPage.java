package com.crm.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CreateStaticHTMLPage {

	/*ServletContext 是一个域对象,可以读取全局配置参数,搜索当前工程目录下面的资源文件,获取当前工程名字
	 * 
	 */
	public void create(HttpServletRequest request, HttpServletResponse response,
            ServletContext servletContext, String fileName, String fileFullPath, String jspPath)  throws ServletException, IOException {
		// TODO Auto-generated method stub
		  response.setContentType("text/html;charset=utf-8");// 设置HTML结果流编码(即HTML文件编码)
	        RequestDispatcher rd = servletContext.getRequestDispatcher(jspPath);// 得到JSP资源
	       
	        //ByteArrayInputStream把字节数组中的字节以流的形式读出,实现了对同一个字节数组的操作.
	        // 用于从ServletOutputStream中接收资源
	        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	        
	        // 用于从HttpServletResponse中接收资源
	        //ServletOutputStream可以捕获内存缓冲区的数据，转换成字节数组。
	        
	        // 写入指定的字节b到此字节输出流中,从指定数组的下标off开始写入len个字节到该输出流中
	        final ServletOutputStream servletOuputStream = new ServletOutputStream() {
	            public void write(byte[] b, int off, int len) {
	                byteArrayOutputStream.write(b, off, len);
	            }

	            public void write(int b) {
	                byteArrayOutputStream.write(b);
	            }

				@Override
				public boolean isReady() {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public void setWriteListener(WriteListener arg0) {
					// TODO Auto-generated method stub
					
				}

	        };
	        
	        // 把转换字节流转换成字符流
	        final PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(byteArrayOutputStream));
	        
	        // 用于从response获取结果流资源(重写了两个方法)
	        HttpServletResponse httpServletResponse = new HttpServletResponseWrapper(response) {
	            public ServletOutputStream getOutputStream() {
	                return servletOuputStream;
	            }

	            public PrintWriter getWriter() {
	                return printWriter;
	            }
	        };
	        rd.include(request, httpServletResponse);// 发送结果流
	        printWriter.flush();// 刷新缓冲区，把缓冲区的数据输出
	        FileOutputStream fileOutputStream = new FileOutputStream(fileFullPath);
	        byteArrayOutputStream.writeTo(fileOutputStream);// 把byteArrayOuputStream中的资源全部写入到fileOuputStream中
	        fileOutputStream.close();// 关闭输出流，并释放相关资源
	        response.sendRedirect(fileName);// 发送指定文件流到客户端
		
		
		
		
	}

}
