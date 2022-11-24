package com.mycompany.mavenproject7;

public class datos_bebidas {
    String nombre_bebida;
    String id_bebida;
    String imagen;

    public String getNombre_bebida() {
        return nombre_bebida;
    }

    public void setNombre_bebida(String nombre_bebida) {
        this.nombre_bebida = nombre_bebida;
    }

    public String getId_bebida() {
        return id_bebida;
    }

    public void setId_bebida(String id_bebida) {
        this.id_bebida = id_bebida;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public datos_bebidas(String id_bebida,String nombre_bebida,String imagen) {
        this.nombre_bebida = nombre_bebida;
        this.id_bebida = id_bebida;
        this.imagen = imagen;
    }
    
     @Override
    public String toString() {
        return getId_bebida();
    }   
}