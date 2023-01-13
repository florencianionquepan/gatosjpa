
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
    
    //Ficha Veterinaria
    
    public void createFile(Ficha file){
        controlPersis.createFile(file); 
    }
    
    public void destroyFile(int id){
        controlPersis.destroyFile(id);
    }
    
    public void editFile(Ficha file){
        controlPersis.editFile(file);
    }
    
    public Ficha bringFile(int id){
        return controlPersis.bringFile(id);
    }
    
    public ArrayList<Ficha> bringFiles(){
        return controlPersis.bringFiles();
    }
}
