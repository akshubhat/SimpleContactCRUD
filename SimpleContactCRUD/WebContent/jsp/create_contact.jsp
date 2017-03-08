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
    <title>Create New Contact</title>
  </head>
  <body>
    <section class="wrapper">
      <header>
        <h1>Create New Contact</h1>
        <hr>
      </header>
      <section class="content">
        <p class="error-message">Failed to update. Fields cannot leave blank.</p>
        <form class="contact-form" method="post" action="CreateContactServlet">        
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
        <div class="button-container"><a href="" class="buttons create-button">Create</a><a href="" class="buttons cancel-button">Cancel</a></div>
      </section>
    </section>
  </body>
</html>