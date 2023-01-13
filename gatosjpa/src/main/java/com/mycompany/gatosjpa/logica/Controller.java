
package com.mycompany.gatosjpa.logica;

import com.mycompany.gatosjpa.persistencia.ControllerPersistence;
import java.util.ArrayList;


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
    
    public Gato bringCat(int id){
        return controlPersis.bringCat(id);
    }
    
    public ArrayList<Gato> bringCats(){
        return controlPersis.bringCats();
    }
}
