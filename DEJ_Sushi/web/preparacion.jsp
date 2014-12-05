<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <title>Preparacion Sushi</title>
    </head>
    <body>
        <%@include file="WEB-INF/menu.jspf" %>
        <h1>Pedidos Para Preparar</h1>
        <form action="<c:url value="/CocinaServlet"/>" method="post">
            <c:forEach var="pedido" items="${listap}">
                <fieldset>
                    <legend>
                        Pedido &nbsp; <c:out value="${pedido.id_pedido}"/>
                    </legend>
                    <table>
                        <tr>
                            <td>
                                Debe ir el listado del pedido 
                            </td>
                        </tr>
                        <!--<c:forEach var="producto" items="${listaprod}">
                            <c:if test="${producto.id_pedido == pedido.id_pedido}">
                                <tr>
                                    <td>
                                        <c:out value="${producto.nombre}"/>
                                    </td>
                                    <td>
                                        <c:out value="${producto.descripcion}"/>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>-->                       
                    </table>
                    <br>
                    <input type="button" value="Despachar"/>
                </fieldset>
                    <br>
            </c:forEach>            
        </form>
    </body>
</html>
