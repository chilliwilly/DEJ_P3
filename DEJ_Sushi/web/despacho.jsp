<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <title>Despachar Sushi</title>
    </head>
    <body>
        <%@include file="WEB-INF/menu.jspf" %>
        <h1>Pedidos para Despachar</h1>
        <form method="post" action="<c:url value="/DespachoServlet"/>">
        </form>
    </body>
</html>
