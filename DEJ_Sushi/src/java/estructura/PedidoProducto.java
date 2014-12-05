package estructura;

import java.util.*;

public class PedidoProducto {
    private Pedido pedido;
    private ArrayList<Producto> productos;

    public PedidoProducto() {
    }

    public PedidoProducto(Pedido pedido, ArrayList<Producto> productos) {
        this.pedido = pedido;
        this.productos = productos;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
}
