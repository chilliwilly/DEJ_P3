package presentacion;

import estructura.Pedido;
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
import negocio.SushiService;

@WebServlet(name = "DespachoServlet", urlPatterns = {"/DespachoServlet"})
public class DespachoServlet extends HttpServlet {

    @Resource(name = "jdbc/curso")
    private DataSource ds;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection cnx = ds.getConnection()){   
            SushiService ss = new SushiService(cnx);
            ArrayList<Pedido> ls = ss.getListaDespacho();
            request.setAttribute("lsdespacho", ls);
            request.getRequestDispatcher("/despacho.jsp").forward(request, response);
        } catch (Exception ex) {
            throw new RuntimeException("Error Get", ex);
        }
    }
}
