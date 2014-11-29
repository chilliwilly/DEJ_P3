/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

/**
 *
 * @author VSPC
 */
public class Producto {
    private int id_producto;
    private String nombre_producto;
    private String descrip_producto;
    private int precio_producto;

    public Producto() {
    }

    public Producto(int id_producto, String nombre_producto, String descrip_producto, int precio_producto) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.descrip_producto = descrip_producto;
        this.precio_producto = precio_producto;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescrip_producto() {
        return descrip_producto;
    }

    public void setDescrip_producto(String descrip_producto) {
        this.descrip_producto = descrip_producto;
    }

    public int getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(int precio_producto) {
        this.precio_producto = precio_producto;
    }
}
