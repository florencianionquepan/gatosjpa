
package com.mycompany.gatosjpa.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ficha implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    private boolean desparasitacion;
    private boolean tripleFelina;
    private boolean antirrabica;

    public Ficha() {
    }

    public Ficha(int id, boolean desparasitacion, boolean tripleFelina, boolean antirrabica) {
        this.id = id;
        this.desparasitacion = desparasitacion;
        this.tripleFelina = tripleFelina;
        this.antirrabica = antirrabica;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDesparasitacion() {
        return desparasitacion;
    }

    public void setDesparasitacion(boolean desparasitacion) {
        this.desparasitacion = desparasitacion;
    }

    public boolean isTripleFelina() {
        return tripleFelina;
    }

    public void setTripleFelina(boolean tripleFelina) {
        this.tripleFelina = tripleFelina;
    }

    public boolean isAntirrabica() {
        return antirrabica;
    }

    public void setAntirrabica(boolean antirrabica) {
        this.antirrabica = antirrabica;
    }

    @Override
    public String toString() {
        return "Ficha{" + "id=" + id + ", desparasitacion=" + desparasitacion + ", tripleFelina=" + tripleFelina + ", antirrabica=" + antirrabica + '}';
    }
    
    
}
