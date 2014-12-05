package estructura;

import java.io.Serializable;
import java.util.*;

public class Pedido implements Serializable{
    private int id_pedido;
    private String nombre;
    private String direccion;
    private int total;
    private ArrayList<Integer> lsprod;

    public Pedido() {
    }

    public Pedido(String nombre, String direccion, ArrayList<Integer> lsprod) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.lsprod = lsprod;
    }

    public Pedido(int id_pedido, String nombre, String direccion, int total) {
        this.id_pedido = id_pedido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.total = total;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Integer> getLsprod() {
        return lsprod;
    }

    public void setLsprod(ArrayList<Integer> lsprod) {
        this.lsprod = lsprod;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
