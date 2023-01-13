
package com.mycompany.gatosjpa.persistencia;

import com.mycompany.gatosjpa.logica.Gato;
import com.mycompany.gatosjpa.persistencia.GatoJpaController;
import com.mycompany.gatosjpa.persistencia.exceptions.NonexistentEntityException;
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
}
