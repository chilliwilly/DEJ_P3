/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.*;
import estructura.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author VSPC
 */
public class SushiService {
    private Connection cnx;
    
    public SushiService(Connection cnx)
    {
        this.cnx = cnx;
    }
    
    public ArrayList<Producto> getProducto()
    {
        PedidoDAO dao = new PedidoDAO(cnx);
        
        return dao.listaProducto();
    }
}
