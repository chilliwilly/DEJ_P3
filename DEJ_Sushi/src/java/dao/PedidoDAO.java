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
    
    public void insertPedido(String nom, String dir, int tot)
    {
        //ResultSet rs = null;
        //int cod_pedido = 0;
        String sql = "INSERT INTO PEDIDO VALUES (NULL,?,?,?,?);";
        try(PreparedStatement stmt = cnx.prepareStatement(sql))
        {
            stmt.setString(1, nom);
            stmt.setString(2, dir);
            stmt.setInt(3, tot);
            stmt.setString(4, "COTIZACION");
            stmt.executeUpdate();
            
            //rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");

            //if (rs.next()) {
            //    cod_pedido = rs.getInt(1);
            //}
        }
        catch(Exception ex)
        {
            throw new RuntimeException("Error al Insertar ", ex);
        }
        
        //return cod_pedido;
    }
    
    public int selectLastId()
    {
        ResultSet rs = null;
        int cod_pedido = 0;
        String sql = "SELECT LAST_INSERT_ID()";
        try(PreparedStatement stmt = cnx.prepareStatement(sql))
        {
            rs = stmt.executeQuery();

            if (rs.next()) {
                cod_pedido = rs.getInt(1);
            }
        }
        catch(Exception ex)
        {
            throw new RuntimeException("Error al Recuperar ID ", ex);
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
    
    public void deleteItemPedido(int codPedido, int codProd)
    {
        String sql = "DELETE FROM PEDIDO_DETALLE WHERE ID_PEDIDO = ? AND ID_PRODDUCTO = ?;";
        try(PreparedStatement stmt = cnx.prepareStatement(sql))
        {
            stmt.setInt(1, codPedido);
            stmt.setInt(2, codProd);
            stmt.executeUpdate();
        }
        catch(Exception ex)
        {
            throw new RuntimeException("Error al Borrar Detalle ", ex);
        }
    }
    
    public Pedido selectPedido(int codPedido)
    {        
        Pedido p = null;
        String sql = "SELECT ID_PEDIDO, NOMBRE, DIRECCION, TOTAL FROM PEDIDO WHERE ID_PEDIDO = ?;";
        try(PreparedStatement stmt = cnx.prepareStatement(sql))
        {
            stmt.setInt(1, codPedido);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                p = new Pedido(rs.getInt("ID_PEDIDO"), 
                               rs.getString("NOMBRE"), 
                               rs.getString("DIRECCION"), 
                               rs.getInt("TOTAL"));             
            }
        }
        catch(Exception ex)
        {
            throw new RuntimeException("Error al Borrar Detalle ", ex);
        }
        return p;
    }
    
    public ArrayList<Producto> selectDetallePedido(int codPedido)
    {
        ArrayList<Producto> lsprod = new ArrayList<Producto>();
        String sql = "SELECT ID_PRODUCTO, NOMBRE, DESCRIPCION, PRECIO "
                   + "FROM PRODUCTO JOIN PEDIDO_DETALLE USING (ID_PRODUCTO) "
                   + "WHERE ID_PEDIDO = ? ORDER BY ID_PRODUCTO;";
        try(PreparedStatement stmt = cnx.prepareStatement(sql))
        {
            stmt.setInt(1, codPedido);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Producto prod = new Producto();
                prod.setId_producto(rs.getInt("ID_PRODUCTO"));
                prod.setNombre_producto(rs.getString("NOMBRE"));
                prod.setDescrip_producto(rs.getString("DESCRIPCION"));
                prod.setPrecio_producto(rs.getInt("PRECIO"));
                lsprod.add(prod);                            
            }
        }
        catch(Exception ex)
        {
            throw new RuntimeException("Error al Borrar Detalle ", ex);
        }
        return lsprod;
    }
    
    public void updateEstadoPedido(int cod)
    {
        String sql = "UPDATE PEDIDO SET ESTADO = ? WHERE ID_PEDIDO = ?;";
        try(PreparedStatement stmt = cnx.prepareStatement(sql))
        {
            stmt.setString(1, "PREPARACION");
            stmt.setInt(2, cod);
            stmt.executeUpdate();
        }
        catch(Exception ex)
        {
            throw new RuntimeException("Error al Actualizar Estado ", ex);
        }
    }
}
