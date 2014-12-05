<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <title>Pedido Sushi</title>
    </head>
    <body>
        <%@include file="WEB-INF/menu.jspf" %>
        <script src="http://code.jquery.com/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <h1>Pedido Sushi</h1>
        <form action="<c:url value="/PedidoServlet"/>" method="post">
            <div class="container" style="margin-top:30px">
                <div class="mainbox col-md-4 col-md-offset-4 col-sm-8 col-sm-offset-2">
                    <div class="panel panel-info modal-content">
                        <div class="panel-heading"><h3 class="panel-title"><strong>Datos Cliente</strong></h3></div>
                        <div class="panel-body">
                            <div class="controls">
                                <div class="form-group">
                                    <label id="nombre">Nombre&nbsp;&nbsp;&nbsp;</label>
                                    <input type="text" name="txtNombre" required="true" placeholder="Ingrese Nombre"/>
                                </div>
                                <div class="form-group">
                                    <label id="direccion">Direccion</label>
                                    <input type="text" name="txtDireccion" required="true" placeholder="Ingrese Direccion"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="container modal-content">
            <div class="page-header"><h1>Seleccion de Rolls</h1></div>        
            <div class="row">
                <div class="col-xs-8 col-lg-offset-2 text-center">
                    <table class="table table-striped table-bordered">
                        <c:forEach var="productos" items="${lista}">
                            <tr>
                                <th>
                                    <input type="checkbox" name="chkProd" value="<c:out value="${productos.id_producto}"/>"/>
                                </th>
                                <th>
                                    <c:out value="${productos.nombre_producto}"/>
                                </th>
                                <th>
                                    <c:out value="${productos.descrip_producto}"/>
                                </th>
                                <th>
                                    <c:out value="${productos.precio_producto}"/>
                                </th>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>            
            <input type="submit" value="Cotizar" class="btn btn-primary btn-lg"/>
        </form>
    </body>
</html>
