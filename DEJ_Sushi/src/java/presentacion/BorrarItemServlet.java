package presentacion;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import negocio.SushiService;

@WebServlet(name = "BorrarItemServlet", urlPatterns = {"/BorrarItemServlet"})
public class BorrarItemServlet extends HttpServlet {

    @Resource(name = "jdbc/curso")
    private DataSource ds;

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        processRequest(request, response);
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException 
    {
        try (Connection cnx = ds.getConnection()){   
            SushiService ss = new SushiService(cnx);
            
            int cpedi = Integer.parseInt(request.getParameter("codPedi"));
            int cprod = Integer.parseInt(request.getParameter("codProd"));
            
            ss.borrarItemPedido(cpedi, cprod);            
            
            String url = request.getContextPath()+"/ConfirmarServlet";
            response.sendRedirect(url);
        } catch (Exception ex) {
            throw new RuntimeException("Error Post", ex);
        }
    }
}
