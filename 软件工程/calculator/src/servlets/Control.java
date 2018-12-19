package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Computer;

public class Control extends HttpServlet {
	private double num1;
	private double num2;
	private String oper;
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException,ServletException{
				double num1=Double.parseDouble(request.getParameter("num1"));
				double num2=Double.parseDouble(request.getParameter("num2"));
				String oper=request.getParameter("oper");
				Computer c=new Computer();
				double result=c.calculate(num1,num2,oper);
				request.setAttribute("result", result);
				String forward="/one.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(forward);
				//Íê³ÉÌø×ª
					rd.forward(request, response);
					
				}
			public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException,ServletException{
			doGet(request,response);
			}

}
