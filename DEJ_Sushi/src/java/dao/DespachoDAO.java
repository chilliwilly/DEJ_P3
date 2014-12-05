/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import estructura.Pedido;
import estructura.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

/**
 *
 * @author VSPC
 */
public class DespachoDAO {
    private Connection cnx;

    public DespachoDAO(Connection cnx) {
        this.cnx = cnx;
    }
    
    public ArrayList<Pedido> getPedidoDespacho()
    {
        ArrayList<Pedido> lspedido = new ArrayList<Pedido>();
        String estado = "DESPACHO";
        String sql = "SELECT ID_PEDIDO, NOMBRE, DIRECCION, TOTAL FROM PEDIDO WHERE ESTADO = ? ORDER BY ID_PEDIDO;";
        try(PreparedStatement stmt = cnx.prepareStatement(sql))
        {
            stmt.setString(1, estado);
            try(ResultSet rs = stmt.executeQuery())
            {
                while(rs.next())
                {
                    Pedido pedido = new Pedido();
                    pedido.setId_pedido(rs.getInt("ID_PEDIDO"));
                    pedido.setNombre(rs.getString("NOMBRE"));
                    pedido.setDireccion(rs.getString("DIRECCION"));
                    pedido.setTotal(rs.getInt("TOTAL"));
                    lspedido.add(pedido);                            
                }
            }
        }
        catch(Exception ex)
        {
            throw new RuntimeException("Error al Borrar Detalle ", ex);
        }
        return lspedido;
    }
}
