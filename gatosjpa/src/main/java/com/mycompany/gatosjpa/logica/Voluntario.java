
package com.mycompany.gatosjpa.logica;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import javax.persistence.*;

@Entity
@DiscriminatorValue("VOL")
public class Voluntario extends Persona{
    private LocalDate fechaIngreso;
    @OneToMany (mappedBy="volunt")
    private LinkedList<Gato> listaGatos;

    public Voluntario(String dni, String nombre, String apellido, String telefono,
                        LocalDate fechaIngreso, LinkedList<Gato> gatos) {
        super(dni, nombre, apellido, telefono);
        this.fechaIngreso = fechaIngreso;
        this.listaGatos = gatos;
    }

    public Voluntario() {
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
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
