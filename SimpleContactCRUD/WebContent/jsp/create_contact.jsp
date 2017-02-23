<%@page import="com.travis.contact.model.Contact"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/popup.css"> 
    <script src="js/jquery.js"></script>
    <script src="js/contact.js"></script>
    <title>Create New Contact</title>
  </head>
  <body>
    <section id="wrapper">
      <header>
        <h1>Create New Contact</h1>
        <hr>
      </header>
      <section id="content">
        <p id="error-message">Failed to update. Fields cannot leave blank.</p>
        <form id="contact-form" method="post" action="">        
          <table>
            <tr>
              <th><label for="firstname">First name:</label></th>
              <td><input type="text" id="firstname" name="firstname" class="input-field" value="" autocomplete="off"></td>
            </tr>
            <tr>
              <th><label for="lastname">Last name:</label></th>
              <td><input type="text" id="lastname" name="lastname" class="input-field" value="" autocomplete="off"></td>
            </tr>
            <tr>
              <th><label for="email">Email:</label></th>
              <td><input type="email" id="email" name="email" class="input-field" value="" autocomplete="off"></td>
            </tr>
            <tr>
              <th><label for="address">Address:</label></th>
              <td><input type="text" id="address" name="address" class="input-field" value="" autocomplete="off"></td>
            </tr>
          </table>
        </form>
        <div id="button-container"><a href="" id="create-button" class="button">Create</a><a href="" id="cancel-button" class="button">Cancel</a></div>
      </section>
    </section>
  </body>
</html>