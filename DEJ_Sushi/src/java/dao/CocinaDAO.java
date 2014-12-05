package dao;

import estructura.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class CocinaDAO {
    private Connection cnx;

    public CocinaDAO(Connection cnx) {
        this.cnx = cnx;
    }
    
    public ArrayList<Pedido> listaPedidoCocina()
    {
        ArrayList<Pedido> ls = new ArrayList<Pedido>();
        String estado = "PREPARACION";
        String sql = "SELECT * FROM PEDIDO WHERE ESTADO = ? ORDER BY ID_PEDIDO;";
        try(PreparedStatement stmt = cnx.prepareStatement(sql))
        {
            stmt.setString(1, estado);
            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next())
                {
                    Pedido p = new Pedido();
                    p.setId_pedido(rs.getInt("ID_PEDIDO"));
                    ls.add(p);
                }
            }
        }
        catch(Exception ex)
        {
            throw new RuntimeException("Error al Select ", ex);
        }
        return ls;
    }
    
    public ArrayList<Producto> listaProductoCocina()
    {
        ArrayList<Producto> lprod = new ArrayList<Producto>();
        String estado = "PREPARACION";
        String sql = "SELECT ID_PEDIDO, PRODUCTO.NOMBRE, DESCRIPCION FROM PRODUCTO "
                   + "JOIN PEDIDO_DETALLE USING (ID_PRODUCTO) "
                   + "JOIN PEDIDO USING (ID_PEDIDO) "
                   + "WHERE PEDIDO.ESTADO = ? ORDER BY ID_PEDIDO;";
        try(PreparedStatement stmt = cnx.prepareStatement(sql))
        {
            stmt.setString(1, estado);
            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next())
                {
                    Producto p = new Producto();
                    p.setId_pedido(rs.getInt("ID_PEDIDO"));
                    p.setNombre_producto(rs.getString("NOMBRE"));
                    p.setDescrip_producto(rs.getString("DESCRIPCION"));
                    lprod.add(p);
                }
            }
        }
        catch(Exception ex)
        {
            throw new RuntimeException("Error al Select ", ex);
        }
        return lprod;
    }
    
    public void updateEstadoADespacho(int codPedido)
    {
        String estado = "DESPACHO";
        String sql = "UPDATE PEDIDO SET ESTADO = ? WHERE ID_PEDIDO = ?;";
        try(PreparedStatement stmt = cnx.prepareStatement(sql))
        {
            stmt.setString(1, estado);
            stmt.setInt(2, codPedido);
            stmt.executeUpdate();
        }
        catch(Exception ex)
        {
            throw new RuntimeException("Error al Update ", ex);
        }
    }
}
