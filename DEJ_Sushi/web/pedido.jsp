<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="WEB-INF/menu.jspf" %>
        <h1>Pedido Sushi</h1>
        <form action="<c:url value="/PedidoServlet"/>" method="post">
            <fieldset>
                <legend>
                    Datos Cliente
                </legend>
                <table>
                    <tr>
                        <td>Nombre</td>
                        <td>:</td>
                        <td><input type="text" name="txtNombre" required="true"/></td>
                    </tr>
                    <tr><td colspan="3">&nbsp;</td></tr>
                    <tr>
                        <td>Dirección</td>
                        <td>:</td>
                        <td><input type="text" name="txtNombre" required="true"/></td>
                    </tr>
                </table>
            </fieldset>  
            <br>
            <fieldset>
                <legend>
                    Selección de Rolls
                </legend>
                <div class="row">
                    <div class="col-xs-6 col-lg-offset-1 text-left">
                        <table class="table table-striped table-bordered">
                            <c:forEach var="productos" items="${lista}">
                                <tr>
                                    <td>
                                        <input type="checkbox" value="<c:out value="${productos.id_producto}"/>"/>
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
                                </tr>
                            </c:forEach>                    
                        </table>
                    </div>
                </div>
            </fieldset>
            <input type="submit" value="Cotizar" class="btn btn-primary btn-lg"/>
        </form>
    </body>
</html>
