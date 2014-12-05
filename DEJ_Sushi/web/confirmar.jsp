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
        <script src="http://code.jquery.com/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <h1>Confirmar Pedido Sushi</h1>
        <form action="<c:url value="/ConfirmarServlet"/>" method="post">
            <input type="hidden" name="codPed" value="<c:out value="${itemPedido.id_pedido}"/>"/>
            <fieldset>
                <legend>
                    Datos Cliente
                </legend>
                <table>
                    <tr>
                        <td>Nombre</td>
                        <td>:</td>
                        <td><c:out value="${itemPedido.nombre}"/></td>
                    </tr>
                    <tr><td colspan="3">&nbsp;</td></tr>
                    <tr>
                        <td>Dirección</td>
                        <td>:</td>
                        <td><c:out value="${itemPedido.direccion}"/></td>
                    </tr>
                </table>
            </fieldset>
            <br>
            <fieldset>
                <c:out value="${mensaje}"/>
                <legend>
                    Selección de Rolls
                </legend>
                <div class="row">
                    <div class="col-xs-6 col-lg-offset-1 text-left">
                        <table class="table table-striped table-bordered">
                            <c:forEach var="productos" items="${itemDetPedido}">
                                <tr>
                                    <td hidden="true">
                                        <input type="hidden" name="codProd" value="<c:out value="${productos.id_producto}"/>"/>
                                    </td>
                                    <td>
                                        <c:out value="${productos.nombre_producto}"/>
                                    </td>
                                    <td>
                                        <c:out value="${productos.descrip_producto}"/>
                                    </td>
                                    <td>
                                        <c:out value="${productos.precio_producto}"/>
                                    </td>
                                    <td>
                                        <c:url var="borraItemPedido" value="/ConfirmarServlet">
                                            <c:param name="codProd" value="${productos.id_producto}"/>
                                        </c:url>
                                        <a href="${borraItemPedido}">
                                            <button type="button" class="btn btn-default btn-xs">
                                                <span class="glyphicon glyphicon-remove"></span>
                                            </button>
                                        </a>
                                    </td> 
                                </tr>
                            </c:forEach>   
                                <tr>
                                    <td colspan="3" style="text-align: right;">
                                        TOTAL
                                    </td>
                                    <td>
                                        <c:out value="${itemPedido.total}"/>
                                    </td>
                                </tr>
                        </table>
                    </div>
                </div>
            </fieldset>
                <input type="submit" value="Confirmar" class="btn btn-primary btn-lg"/>
        </form>
    </body>
</html>
