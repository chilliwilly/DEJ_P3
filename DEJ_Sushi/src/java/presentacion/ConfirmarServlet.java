/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import estructura.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.stream.IntStream;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import negocio.SushiService;

@WebServlet(name = "ConfirmarServlet", urlPatterns = {"/ConfirmarServlet"})
public class ConfirmarServlet extends HttpServlet {

    @Resource(name = "jdbc/curso")
    private DataSource ds;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //int cod_pedido = Integer.parseInt(request.getAttribute("cod_ped").toString());
        try (Connection cnx = ds.getConnection()){   
            SushiService ss = new SushiService(cnx);           
            int cod_pedido = ss.getUltimoId();
            Pedido p = ss.getPedido(cod_pedido);
            ArrayList<Producto> prod = ss.getPedidoDetalle(cod_pedido);
            
            request.setAttribute("itemPedido", p);
            request.setAttribute("itemDetPedido", prod);
            
            request.getRequestDispatcher("/confirmar.jsp").forward(request, response);
        } catch (Exception ex) {
            throw new RuntimeException("Error Post", ex);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection cnx = ds.getConnection()){   
            SushiService ss = new SushiService(cnx); 
            int codPedido = Integer.parseInt(request.getParameter("codPed"));
            
            ss.confirmarPedido(codPedido);            

            String url = request.getContextPath()+"/ConfirmarServlet";
            response.sendRedirect(url);
        } catch (Exception ex) {
            throw new RuntimeException("Error Post", ex);
        }
    }
}
