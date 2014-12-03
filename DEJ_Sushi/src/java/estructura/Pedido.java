/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import java.util.*;

/**
 *
 * @author VSPC
 */
public class Pedido {
    private String nombre;
    private String direccion;
    private ArrayList<Integer> lsprod;

    public Pedido() {
    }

    public Pedido(String nombre, String direccion, ArrayList<Integer> lsprod) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.lsprod = lsprod;
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
}
