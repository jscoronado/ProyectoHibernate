package com.proyectohibernate.bean;
// Generated 21-ene-2015 17:12:22 by Hibernate Tools 4.3.1



/**
 * Nombres generated by hbm2java
 */
public class Nombres  implements java.io.Serializable {


     private Integer id = 0;
     private String nombre;
     private String apellido;

    public Nombres() {
    }

    public Nombres(String nombre, String apellido) {
       this.nombre = nombre;
       this.apellido = apellido;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }




}


