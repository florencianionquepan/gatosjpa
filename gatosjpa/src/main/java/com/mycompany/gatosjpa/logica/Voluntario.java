
package com.mycompany.gatosjpa.logica;

import java.util.Date;
import java.util.LinkedList;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Voluntario extends Persona{
    private Date fechaIngreso;
    @OneToMany
    private LinkedList<Gato> listaGatos;

    public Voluntario(String dni, String nombre, String apellido, String telefono,
                        Date fechaIngreso, LinkedList<Gato> gatos) {
        super(dni, nombre, apellido, telefono);
        this.fechaIngreso = fechaIngreso;
        this.listaGatos = gatos;
    }

    public Voluntario() {
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LinkedList<Gato> getGatos() {
        return listaGatos;
    }

    public void setGatos(LinkedList<Gato> gatos) {
        this.listaGatos = gatos;
    }

    @Override
    public String toString() {
        return "Voluntario{" + "fechaIngreso=" + fechaIngreso + ", gatos=" + listaGatos + '}';
    }
    
    
}
