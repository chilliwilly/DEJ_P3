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
    
    public int insertPedido(String nom, String dir)
    {
        ResultSet rs = null;
        int cod_pedido = 0;
        String sql = "INSERT INTO PEDIDO VALUES (NULL,?,?,?,?);";
        try(PreparedStatement stmt = cnx.prepareStatement(sql))
        {
            stmt.setString(1, nom);
            stmt.setString(2, dir);
            stmt.setInt(3, 0);
            stmt.setString(4, "COTIZACION");
            stmt.executeUpdate();
            
            rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");

            if (rs.next()) {
                cod_pedido = rs.getInt(1);
            }
        }
        catch(Exception ex)
        {
            throw new RuntimeException("Error al Insertar ", ex);
        }
        
        return cod_pedido;
    }
    
    public void insertDetallePedido(int cod_ped, int cod_prod)
    {        
        String sql = "INSERT INTO PEDIDO_DETALLE VALUES (?,?);";
        try(PreparedStatement stmt = cnx.prepareStatement(sql))
        {
            stmt.setInt(1, cod_ped);
            stmt.setInt(2, cod_prod);
            stmt.executeUpdate();
        }
        catch(Exception ex)
        {
            throw new RuntimeException("Error al Insertar Detalle ", ex);
        }
    }
}
