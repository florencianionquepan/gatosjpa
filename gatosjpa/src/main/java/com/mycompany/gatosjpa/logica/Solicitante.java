package com.mycompany.gatosjpa.logica;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("SOLIC")
public class Solicitante extends Persona{
    private String domicilio;

    @ManyToOne
    private Gato gato;

    public Solicitante() {
    }

    public Solicitante(String dni, String nombre, String apellido, String telefono, String domicilio,Gato gato) {
        super(dni, nombre, apellido, telefono);
        this.domicilio = domicilio;
        this.gato=gato;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Gato getGato() {
        return gato;
    }

    public void setGato(Gato gato) {
        this.gato = gato;
    }

    @Override
    public String toString() {
        return "Solicitante{" +
                "domicilio='" + domicilio + '\'' +
                ", gato=" + gato +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
