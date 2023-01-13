
package com.mycompany.gatosjpa.persistencia;

import com.mycompany.gatosjpa.logica.Ficha;
import com.mycompany.gatosjpa.logica.Gato;
import com.mycompany.gatosjpa.persistencia.GatoJpaController;
import com.mycompany.gatosjpa.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControllerPersistence {
    GatoJpaController gatoJpa= new GatoJpaController();
    FichaJpaController fichaJpa=new FichaJpaController();

    public void createCat(Gato cat) {
        gatoJpa.create(cat);
    }

    public void destroyCat(int id) {
        try {
            gatoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editCat(Gato cat) {
        try {
            gatoJpa.edit(cat);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Gato bringCat(int id) {
        return gatoJpa.findGato(id);
    }

    public ArrayList<Gato> bringCats() {
        List <Gato> list=gatoJpa.findGatoEntities();
        ArrayList <Gato> listCats=new ArrayList<Gato>(list);
        return listCats;
    }
    
    //FICHA VETERINARIA

    public void createFile(Ficha file) {
        fichaJpa.create(file);
    }

    public void destroyFile(int id) {
        try {
            fichaJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editFile(Ficha file) {
        try {
            fichaJpa.edit(file);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Ficha bringFile(int id) {
        return fichaJpa.findFicha(id);
    }

    public ArrayList<Ficha> bringFiles() {
       List <Ficha> list=fichaJpa.findFichaEntities();
        ArrayList <Ficha> listFichas=new ArrayList<Ficha>(list);
        return listFichas;
    }
}