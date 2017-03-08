<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Success</title>
    <style>
    @import url('https://fonts.googleapis.com/css?family=Ubuntu');
    body { font-family:"Ubuntu", Sans-serif; text-align:center; }
    p { padding: 5px; margin: 0; }
    p.success-message, p.error-message  { font-size:10pt; font-weight:bold; }
    p.success-message { color:#10BA3A; }
    p.error-message { color:#FF2222; }
    p.close-message { font-size:9pt; } 
    p.close-button a { color:#FFFFFF; background-color:#4784F5; border-radius:5px; font-size:10pt; padding:5px 10px; text-decoration:none; }
    p.close-button a:hover { background-color:#0E5CED; }
    </style>
  </head>
  <body>
    <%  
    boolean isSuccess = (boolean) request.getAttribute("status");
    String message = (String) request.getAttribute("message"); 
    %>
    <% if(isSuccess) { %>
        <p class="success-message"><% out.print(message); %></p>
    <% } else { %>
        <p class="error-message"><% out.print(message); %></p>
    <% } %>
    <p class="close-message">Window will be closed in <span id="second">2</span> second.</p>
    <p class="close-button"><a href="" onclick="window.opener.location.reload(true);window.close();">Close</a></p>
    <script>
    var second = 2;
    var counter = setInterval(function() {
    	second--;
    	document.getElementById("second").textContent = second;
    	if(second <= 0) {
    		clearInterval(counter);
    		window.opener.location.reload(true);
    		window.close();
    	}
    }, 1000);
    </script>
  </body>
</html>