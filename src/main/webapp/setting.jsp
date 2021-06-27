<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; ISO-8859-1" language="java"%>
<html>
<title>Setting page</title>
<body>
<h2>
    This is where the content of the setting page is.
</h2>
<h3>
    Time now is:  <%
        Date date = new Date();
        out.println(date);

    %>
</h3>
</body>
</html>
