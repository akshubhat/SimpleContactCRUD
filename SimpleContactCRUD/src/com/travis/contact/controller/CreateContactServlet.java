package com.travis.contact.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.travis.contact.dao.ContactDaoImpl;
import com.travis.contact.model.Contact;


public class CreateContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("jsp/create_contact.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		boolean isSuccess = false;
		String message = "";
		
		Contact contact = new Contact();
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setEmail(email);
		contact.setAddress(address);
		
		ContactDaoImpl dao = new ContactDaoImpl();
		if(dao.insertNewContact(contact)) {
			isSuccess = true;
			message = "Update Successful!";
		} else {
			message = "Error Occurred. Fail to create new contact";
		}
		
		request.setAttribute("status", isSuccess);
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("jsp/status.jsp");
		rd.forward(request, response);
	}

}
