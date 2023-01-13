
package com.mycompany.gatosjpa.persistencia;

import com.mycompany.gatosjpa.logica.Gato;
import com.mycompany.gatosjpa.persistencia.GatoJpaController;


public class ControllerPersistence {
    GatoJpaController GatoJpa= new GatoJpaController();

    public void createCat(Gato cat) {
        GatoJpa.create(cat);
    }
}
