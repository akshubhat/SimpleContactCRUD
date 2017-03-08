<%@page import="com.travis.contact.model.Contact"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/contact.css"> 
    <script src="js/jquery.js"></script>
    <script src="js/contact.js"></script>
    <title>Simple Contact CRUD</title>
  </head>
  <body>
    <section class="wrapper">
      <header>
        <h1>Simple Contact CRUD</h1>
        <hr>
      </header>
      <nav><a href="CreateContactServlet" class="create-button">New Contact</a></nav>
      <% 
      @SuppressWarnings("unchecked")
      List<Contact> contacts = (List<Contact>)request.getAttribute("contacts");
      if(contacts.size() > 0) {
      %>
        <div class="table-content">
          <table border="1">
              <tr>
                <th>First name</th>
                <th>Last name</th>
                <th>Email</th>
                <th>Address</th>
                <th>Action</th>
               </tr>
            <% for(Contact contact : contacts) { %>
            <tr>
              <td><% out.print(contact.getFirstName()); %></td>
              <td><% out.print(contact.getLastName()); %></td>
              <td><% out.print(contact.getEmail()); %></td>
              <td><% out.print(contact.getAddress()); %></td>
              <td class="action-cols"><a href="ViewContactServlet?contactId=<% out.print(contact.getContactId()); %>" class="view-button">View</a></td>
            </tr>
            <%
            }
            %>
          </table>
        </div>
    <% } else { %>
        <p>No contact found!</p>
    <% } %>
    </section>
  </body>
</html>