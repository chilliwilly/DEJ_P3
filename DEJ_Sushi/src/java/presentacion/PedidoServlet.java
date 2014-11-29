package presentacion;

import negocio.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(name = "PedidoServlet", urlPatterns = {"/PedidoServlet"})
public class PedidoServlet extends HttpServlet {    

    @Resource(name = "jdbc/curso")
    private DataSource ds;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try (Connection cnx = ds.getConnection()){   
            SushiService ss = new SushiService(cnx);            
            
            request.setAttribute("lista",ss.getProducto());
            request.getRequestDispatcher("/pedido.jsp").forward(request, response);
            
        } catch (Exception ex) {
            throw new RuntimeException("Error Get", ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //hacer pedido
        
        request.getRequestDispatcher("/pedido.jsp").forward(request, response);
    }
}
