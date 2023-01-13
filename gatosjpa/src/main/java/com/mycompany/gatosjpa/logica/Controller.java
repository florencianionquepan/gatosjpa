
package com.mycompany.gatosjpa.logica;

import com.mycompany.gatosjpa.persistencia.ControllerPersistence;


public class Controller {
    ControllerPersistence controlPersis= new ControllerPersistence();
    
    public void createCat(Gato cat){
        controlPersis.createCat(cat); 
    }
    
    public void destroyCat(int id){
        controlPersis.destroyCat(id);
    }
    
    public void editCat(Gato cat){
        controlPersis.editCat(cat);
    }
}
