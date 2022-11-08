package org.zerock.w1;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="sampleServlet",urlPatterns="/sample")
public class SampleServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("doGet...."+this);
	}
	
	@Override
	public void destroy() {
		System.out.println("destory...............");
		
	}
	
	@Override
	public void init(ServletConfig config) {
		System.out.println("init(ServletConfig)..............");
	}
}
