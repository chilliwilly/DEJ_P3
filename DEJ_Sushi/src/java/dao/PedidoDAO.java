/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import estructura.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author VSPC
 */
public class PedidoDAO {
    private Connection cnx;

    public PedidoDAO(Connection cnx) {
        this.cnx = cnx;
    }
    
    public ArrayList<Producto> listaProducto()
    {
        ArrayList<Producto> listado = new ArrayList<>();
        
        String sql = "SELECT * FROM PRODUCTO ORDER BY ID_PRODUCTO ASC;";
        try (PreparedStatement stmt = cnx.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                int id_producto = rs.getInt("ID_PRODUCTO");
                String nombre_producto = rs.getString("NOMBRE");
                String descrip_producto = rs.getString("DESCRIPCION");
                int precio_producto = rs.getInt("PRECIO");
                
                Producto p = new Producto(id_producto, nombre_producto, descrip_producto, precio_producto);
                listado.add(p);
            }

            return listado;
            
        } catch (Exception ex) {
            throw new RuntimeException("Error al Buscar Producto", ex);
        }
    }
}
