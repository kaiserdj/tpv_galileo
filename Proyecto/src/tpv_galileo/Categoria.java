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
public class Categoria {

    private int Id;
    private String Nombre;
    private String Imagen;
    
    public Categoria(String[] categoria) {
        Id = Integer.parseInt(categoria[0]);
        Nombre = categoria[1];
        Imagen = categoria[2];
    }

    public int getId() {
        return Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getImagen() {
        return Imagen;
    }
    
    
    
    
}
