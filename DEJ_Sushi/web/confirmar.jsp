<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <title>Confirmar Pedido</title>
    </head>
    <body>
        <%@include file="WEB-INF/menu.jspf" %>
        <h1>Confirmar Pedido Sushi</h1>
        <form action="<c:url value="/ConfirmarServlet"/>" method="get">
        </form>
    </body>
</html>
