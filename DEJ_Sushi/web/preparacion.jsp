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
        <form action="<c:url value="/CocinaServlet"/>" method="get">
            <c:forEach var="listaPedido" items="${lista}">
                <input type="hidden" name="codPedido" value="<c:out value="${listaPedido.pedido.id_pedido}"/>"/>
                <fieldset>
                <legend>
                    Pedido &nbsp; <c:out value="${listaPedido.pedido.id_pedido}"/>
                </legend>
                <table>
                    <c:forEach var="listaProducto" items="${listaPedido.productos}">
                        <tr>
                            <td>
                                <c:out value="${listaProducto.nombre_producto}"/>
                            </td>
                            <td>&nbsp;</td>
                            <td>
                                <c:out value="${listaProducto.descrip_producto}"/>
                            </td>
                        </tr>
                    </c:forEach>                    
                </table>
                <br>
                    <c:url var="despachar" value="/CocinadoServlet">
                        <c:param name="codped" value="${listaPedido.pedido.id_pedido}"/>
                    </c:url>
                    <a href="${despachar}">
                        <button type="button" class="btn btn-primary btn-lg">
                            <span class="glyphicon glyphicon-ok"></span>
                        </button>
                    </a> 
                <br><br>
            </c:forEach>            
        </form>
    </body>
</html>
