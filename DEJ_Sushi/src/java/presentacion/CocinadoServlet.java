package presentacion;

import estructura.*;
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

@WebServlet(name = "CocinadoServlet", urlPatterns = {"/CocinadoServlet"})
public class CocinadoServlet extends HttpServlet {

    @Resource(name = "jdbc/curso")
    private DataSource ds;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cod_ped = Integer.parseInt(request.getParameter("codped"));
        
        try (Connection cnx = ds.getConnection()){   
            SushiService ss = new SushiService(cnx);            
            
            ss.modEstadoPedidoDesp(cod_ped);
            
            Thread.sleep(2000);
            String url = request.getContextPath()+"/CocinaServlet";
            response.sendRedirect(url);
        } catch (Exception ex) {
            throw new RuntimeException("Error Get", ex);
        }
    }
}
