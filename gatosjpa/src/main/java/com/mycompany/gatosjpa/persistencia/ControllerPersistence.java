
package com.mycompany.gatosjpa.persistencia;

import com.mycompany.gatosjpa.logica.Gato;
import com.mycompany.gatosjpa.persistencia.GatoJpaController;
import com.mycompany.gatosjpa.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControllerPersistence {
    GatoJpaController GatoJpa= new GatoJpaController();

    public void createCat(Gato cat) {
        GatoJpa.create(cat);
    }

    public void destroyCat(int id) {
        try {
            GatoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editCat(Gato cat) {
        try {
            GatoJpa.edit(cat);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Gato bringCat(int id) {
        return GatoJpa.findGato(id);
    }

    public ArrayList<Gato> bringCats() {
        List <Gato> list=GatoJpa.findGatoEntities();
        ArrayList <Gato> listCats=new ArrayList<Gato>(list);
        return listCats;
    }
}
