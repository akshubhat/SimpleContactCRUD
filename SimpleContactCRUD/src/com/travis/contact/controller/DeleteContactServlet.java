package com.travis.contact.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.travis.contact.dao.ContactDaoImpl;


public class DeleteContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int contactId = Integer.parseInt(request.getParameter("contact-id"));
		boolean isSuccess = false;
		String message = "";
		
		ContactDaoImpl dao = new ContactDaoImpl();
		if(dao.deteleContact(contactId)) {
			isSuccess = true;
			message = "Contact has been deleted.";
		} else {
			message = "Error Occurred. Update Failed";
		}
		
		request.setAttribute("status", isSuccess);
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("jsp/status.jsp");
		rd.forward(request, response);
	}

}
