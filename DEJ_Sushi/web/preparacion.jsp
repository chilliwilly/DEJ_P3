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
                <div class="panel panel-primary col-lg-offset-2" style="width: 900px;">
                    <div class="panel-heading">
                      <h3 class="panel-title">Pedido Nro &nbsp; <c:out value="${listaPedido.pedido.id_pedido}"/></h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-xs-7 col-lg-offset-3 text-center">
                                <table class="table table-striped table-bordered">
                                    <c:forEach var="listaProducto" items="${listaPedido.productos}">
                                        <tr>
                                            <th>
                                                <c:out value="${listaProducto.nombre_producto}"/>
                                            </th>
                                            <th>
                                                <c:out value="${listaProducto.descrip_producto}"/>
                                            </th>
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
                            </div>
                        </div>
                    </div>
                </div>                
                <br><br>
            </c:forEach>
        </form>
    </body>
</html>
