
package com.mycompany.gatosjpa.logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Gato implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    private String nombre;
    private ArrayList<String> srcFoto;
    private String sexo;
    private String descripcion;
    private String raza;
    private String color;
    private boolean adoptado;
    
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    
    @OneToOne
    private Ficha fichaVet;
    
    @ManyToOne
    private Voluntario volunt;

    @OneToMany(mappedBy="gato")
    private ArrayList<Solicitante> ListaSolic;
    public Gato() {
    }

    public Gato(int id, String nombre, ArrayList<String> srcFoto, String sexo, String descripcion, String raza, String color, boolean adoptado, Date fechaNac, Ficha fichaVet, Voluntario volunt) {
        this.id = id;
        this.nombre = nombre;
        this.srcFoto = srcFoto;
        this.sexo = sexo;
        this.descripcion = descripcion;
        this.raza = raza;
        this.color = color;
        this.adoptado = adoptado;
        this.fechaNac = fechaNac;
        this.fichaVet = fichaVet;
        this.volunt = volunt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getSrcFoto() {
        return srcFoto;
    }

    public void setSrcFoto(ArrayList<String> srcFoto) {
        this.srcFoto = srcFoto;
    }
    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isAdoptado() {
        return adoptado;
    }

    public void setAdoptado(boolean adoptado) {
        this.adoptado = adoptado;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Ficha getFichaVet() {
        return fichaVet;
    }

    public void setFichaVet(Ficha fichaVet) {
        this.fichaVet = fichaVet;
    }

    public Voluntario getVolunt() {
        return volunt;
    }

    public void setVolunt(Voluntario volunt) {
        this.volunt = volunt;
    }

    public ArrayList<Solicitante> getListaSolic() {
        return ListaSolic;
    }

    public void setListaSolic(ArrayList<Solicitante> listaSolic) {
        ListaSolic = listaSolic;
    }

    @Override
    public String toString() {
        return "Gato{" + "id=" + id + ", nombre=" + nombre 
                + ", srcFoto=" + srcFoto + ", sexo=" + sexo 
                + ", descripcion=" + descripcion + ", raza=" + raza 
                + ", color=" + color + ", adoptado=" + adoptado 
                + ", fechaNac=" + fechaNac + '}';
    }
    
    
    
    
}
