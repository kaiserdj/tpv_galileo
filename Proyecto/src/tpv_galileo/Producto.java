/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpv_galileo;

/**
 *
 * @author gonfe
 */
public class Producto {
    //https://www.tudespensa.com/carniceria/#search:%5B%22%22%2C%5B%5D%2C%7B%22orden%22%3A%221%22%7D%2C30%5D
    //https://www.remove.bg/
    
    private int Id;
    private String Nombre;
    private int Cantidad;
    private double Unidad;
    private double Precio;
    private int Iva;
    private String IdBD;
    private String Imagen;

    public Producto(String[] producto) {
        Id = Integer.parseInt(producto[0]);
        Nombre = producto[1];
        Cantidad = 1;
        Unidad = Float.parseFloat(producto[2]);
        Imagen = producto[6];
    }
    
    public Producto(String[] producto, int cantidad){
        Id = Integer.parseInt(producto[0]);
        Nombre = producto[2];
        Cantidad = cantidad;
        Unidad = Float.parseFloat(producto[3]);
        Precio = Cantidad * Unidad;
        Iva = Integer.parseInt(producto[4]);
        IdBD = producto[5];
        Imagen = null;
    }

    public int getId() {
        return Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public double getUnidad() {
        return Unidad;
    }

    public double getPrecio() {
        return Precio;
    }

    public int getIva() {
        return Iva;
    }

    public String getIdBD() {
        return IdBD;
    }

    public String getImagen() {
        return Imagen;
    }
    
    
}
