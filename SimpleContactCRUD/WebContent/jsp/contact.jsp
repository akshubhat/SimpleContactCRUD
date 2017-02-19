<%@page import="com.travis.contact.model.Contact"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/contact.css"> 
    <title>Simple Contact CRUD</title>
  </head>
  <body>
    <section id="main-content">
      <header><h1>Simple Contact CRUD</h1></header>
        <table border="1">
          <tr><th>First name</th><th>Last name</th><th>Email</th><th>Address</th><th colspan="2">Action</th></tr>
          <%
          @SuppressWarnings("unchecked")
          List<Contact> contacts = (List<Contact>)request.getAttribute("contacts");
          for(Contact contact : contacts) {
          %>
          <tr>
            <td><% out.println(contact.getFirstName()); %></td>
            <td><% out.println(contact.getLastName()); %></td>
            <td><% out.println(contact.getEmail()); %></td>
            <td><% out.println(contact.getAddress()); %></td>
            <td><a href="">Edit</a></td>
            <td><a href="">Delete</a></td>
          </tr>
          <%
          }
          %>
         </table>
    </section>
  </body>
</html>