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
    //Creacion Eliminacion Pedido - Detalle
    public ArrayList<Producto> getProducto()
    {
        PedidoDAO dao = new PedidoDAO(cnx);
        
        return dao.listaProducto();
    }
    
    public int getUltimoId()
    {
        PedidoDAO dao = new PedidoDAO(cnx);
        return dao.selectLastId();
    }
    
    public void guardaPedido(Pedido pedido)    
    {
        PedidoDAO dao = new PedidoDAO(cnx);
        int total = 0;
        
        for(Integer cod_prod: pedido.getLsprod())
        {
            for(Producto p : getProducto())
            {
                if(p.getId_producto() == cod_prod)
                {
                    total = total + p.getPrecio_producto();
                    break;
                }
            }
        }
        
        dao.insertPedido(pedido.getNombre(), pedido.getDireccion(),total);
        
        int cod_ped = dao.selectLastId();
        
        for(Integer cod_prod: pedido.getLsprod())
        {
            dao.insertDetallePedido(cod_ped, cod_prod);
        }
        //return cod_ped;
    }
    
    public Pedido getPedido(int codpedido)
    {
        Pedido p = null;
        PedidoDAO dao = new PedidoDAO(cnx);
        p = dao.selectPedido(codpedido);
        
        return p;
    }
    
    public ArrayList<Producto> getPedidoDetalle(int codpedido)
    {        
        PedidoDAO dao = new PedidoDAO(cnx);        
        ArrayList<Producto> lsp = dao.selectDetallePedido(codpedido);       
        
        return lsp;
    }
    
    public void borrarItemPedido(int codPedido, int codProd)
    {
        PedidoDAO dao = new PedidoDAO(cnx);
        dao.deleteItemPedido(codPedido, codProd);
        dao.updateItemPedidoPrecio(codPedido);
    }
    
    public void confirmarPedido(int cod)
    {
        PedidoDAO dao = new PedidoDAO(cnx);
        dao.updateEstadoPedido(cod);
    }
    
    //Preparar
    public ArrayList<Pedido> getListaPedidoCocina()
    {
        ArrayList<Pedido> ls = new ArrayList<Pedido>();
        CocinaDAO dao = new CocinaDAO(cnx);
        ls = dao.listaPedidoCocina();
        return ls;
    }
    
    public ArrayList<Producto> getListaProdCocina()
    {
        ArrayList<Producto> lprod = new ArrayList<Producto>();
        CocinaDAO dao = new CocinaDAO(cnx);
        lprod = dao.listaProductoCocina();
        return lprod;
    }
    
    //Despacho
    public ArrayList<Pedido> getListaDespacho()
    {
        DespachoDAO dao = new DespachoDAO(cnx);
        ArrayList<Pedido> ls = new ArrayList<Pedido>();
        ls = dao.getPedidoDespacho();
        return ls;
    }
    
    public void modListaDespacho(int cod)
    {
        DespachoDAO dao = new DespachoDAO(cnx);
        dao.updatePedidoDespacho(cod);
    }
}
