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
            //ArrayList<Producto> lprod = ss.getListaProdCocina();
            ArrayList<Producto> lsProducto = new ArrayList<Producto>();
            ArrayList<PedidoProducto> lsPedProd = new ArrayList<PedidoProducto>();

            for(Pedido ped : ls)
            {
//                for(Producto producto : lprod)
//                {
//                    if(producto.getId_pedido() == ped.getId_pedido())
//                    {
//                        Producto prod = new Producto();
//                        prod.setNombre_producto(producto.getNombre_producto());
//                        prod.setDescrip_producto(producto.getDescrip_producto());
//                        lsProducto.add(prod);
//                    }
//                }
                lsProducto = ss.getPedidoDetalle(ped.getId_pedido());
                PedidoProducto pp = new PedidoProducto(ped, lsProducto);
                lsPedProd.add(pp);
            }

            request.setAttribute("lista", lsPedProd);
            
            request.getRequestDispatcher("/preparacion.jsp").forward(request, response);
        } catch (Exception ex) {
            throw new RuntimeException("Error Get", ex);
        }
    }
}
