
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
    
    //-----PERSONA------//
    public void createPerson(Persona person){
        controlPersis.createPerson(person); 
    }
    
    public void destroyPerson(String dni){
        controlPersis.destroyPerson(dni);
    }
    
    public void editPerson(Persona person){
        controlPersis.editPerson(person);
    }
    
    public Persona bringPerson(String dni){
        return controlPersis.bringPerson(dni);
    }
    
    public ArrayList<Persona> bringPeople(){
        return controlPersis.bringPeople();
    }
    
    //-----VOLUNTARIO------//
    
    public void createVol(Voluntario vol){
        controlPersis.createVolunt(vol); 
    }
    
    public void destroyVol(String dni){
        controlPersis.destroyVolunt(dni);
    }
    
    public void editVol(Voluntario vol){
        controlPersis.editVol(vol);
    }
    
    public Voluntario bringVol(String dni){
        return controlPersis.bringVol(dni);
    }
    
    public ArrayList<Voluntario> bringVols(){
        return controlPersis.bringVols();
    }
}
