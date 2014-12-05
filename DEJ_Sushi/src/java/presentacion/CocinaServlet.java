package presentacion;

import estructura.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.*;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import negocio.SushiService;

@WebServlet(name = "CocinaServlet", urlPatterns = {"/CocinaServlet"})
public class CocinaServlet extends HttpServlet {

    @Resource(name = "jdbc/curso")
    private DataSource ds;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection cnx = ds.getConnection()){   
            SushiService ss = new SushiService(cnx);
            ArrayList<Pedido> ls = ss.getListaPedidoCocina();
            ArrayList<Producto> lprod = ss.getListaProdCocina();
            request.setAttribute("listap", ls);
            request.setAttribute("listaprod", lprod);
            request.getRequestDispatcher("/preparacion.jsp").forward(request, response);
        } catch (Exception ex) {
            throw new RuntimeException("Error Get", ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/preparacion.jsp").forward(request, response);
    }
}
