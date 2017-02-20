package com.travis.contact.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.travis.contact.dao.ContactDaoImpl;
import com.travis.contact.model.Contact;


public class ViewContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int contactId = Integer.parseInt(request.getParameter("contactId"));
		ContactDaoImpl dao = new ContactDaoImpl();
		Contact contact = dao.getContactById(contactId);
		
		request.setAttribute("contact", contact);
		RequestDispatcher rd = request.getRequestDispatcher("jsp/view_contact.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int contactId = Integer.parseInt(request.getParameter("contact-id"));
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		Contact contact = new Contact();
		contact.setContactId(contactId);
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setEmail(email);
		contact.setAddress(address);
		
		ContactDaoImpl dao = new ContactDaoImpl();
		dao.updateContact(contact);
		
		request.setAttribute("success-message", new String("Update Successful!"));
		RequestDispatcher rd = request.getRequestDispatcher("jsp/success.jsp");
		rd.forward(request, response);
	}

}
