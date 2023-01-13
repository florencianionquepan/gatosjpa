
package com.mycompany.gatosjpa.logica;

import com.mycompany.gatosjpa.persistencia.ControllerPersistence;


public class Controller {
    ControllerPersistence controlPersis= new ControllerPersistence();
    
    public void createCat(Gato cat){
        controlPersis.createCat(cat); 
    }
}
