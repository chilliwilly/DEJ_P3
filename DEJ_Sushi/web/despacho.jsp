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
        <form method="get" action="<c:url value="/DespachoServlet"/>">
            <div class="row">
                <div class="col-xs-6 col-lg-offset-1 text-left">
                    <table class="table table-striped table-bordered">
                        <tr>
                            <td>
                                Pedido
                            </td>
                            <td>
                                Cliente
                            </td>
                            <td>
                                Direccion
                            </td>
                            <td>
                                Total
                            </td>
                            <td>
                                Accion
                            </td>
                        </tr>
                        <c:choose>
                            <c:when test="${lsdespacho==null}">
                                
                            </c:when>
                            <c:when test="${empty lsdespacho}">
                                <tr>
                                    <td>
                                        NO HAY DESPACHOS PARA VISUALIZAR
                                    </td>
                                </tr>
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="listades" items="${lsdespacho}">
                                    <tr>
                                        <td>
                                            <c:out value="${listades.id_pedido}"/>
                                        </td>
                                        <td>
                                            <c:out value="${listades.nombre}"/>
                                        </td>
                                        <td>
                                            <c:out value="${listades.direccion}"/>
                                        </td>
                                        <td>
                                            <c:out value="${listades.total}"/>
                                        </td>
                                        <td>
                                            <c:url var="confirma" value="/DespachadoServlet">
                                                <c:param name="codped" value="${listades.id_pedido}"/>
                                            </c:url>
                                            <a href="${confirma}">
                                                <button type="button" class="btn btn-default btn-xs">
                                                    <span class="glyphicon glyphicon-check"></span>
                                                </button>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>                                
                    </table>
                </div>
            </div>            
        </form>
    </body>
</html>
