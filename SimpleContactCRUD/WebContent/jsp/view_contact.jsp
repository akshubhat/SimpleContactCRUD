<%@page import="com.travis.contact.model.Contact"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/popup.css"> 
    <script src="js/jquery.js"></script>
    <script src="js/popup.js"></script>
    <title>View Contact</title>
  </head>
  <body>
    <section class="wrapper">
      <header>
        <h1>View Contact</h1>
        <hr>
      </header>
      <section class="content">
        <% Contact contact = (Contact) request.getAttribute("contact"); %>
        <p class="error-message">Failed to update. Fields cannot leave blank.</p>
        <form class="contact-form" method="post" action="">
          <input type="hidden" name="contact-id" value="<% out.print(contact.getContactId()); %>">         
          <table>
            <tr>
              <th><label for="firstname">First name:</label></th>
              <td><input type="text" id="firstname" name="firstname" class="input-field" value="<% out.print(contact.getFirstName()); %>" autocomplete="off"></td>
            </tr>
            <tr>
              <th><label for="lastname">Last name:</label></th>
              <td><input type="text" id="lastname" name="lastname" class="input-field" value="<% out.print(contact.getLastName()); %>" autocomplete="off"></td>
            </tr>
            <tr>
              <th><label for="email">Email:</label></th>
              <td><input type="email" id="email" name="email" class="input-field" value="<% out.print(contact.getEmail()); %>" autocomplete="off"></td>
            </tr>
            <tr>
              <th><label for="address">Address:</label></th>
              <td><input type="text" id="address" name="address" class="input-field" value="<% out.print(contact.getAddress()); %>" autocomplete="off"></td>
            </tr>
          </table>
        </form>
        <div class="button-container""><a href="" class="buttons update-button">Update</a><a href="" class="buttons delete-button">Delete</a></div>
      </section>
    </section>
  </body>
</html>