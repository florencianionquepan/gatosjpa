
package com.mycompany.gatosjpa.persistencia;

import com.mycompany.gatosjpa.logica.*;
import com.mycompany.gatosjpa.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControllerPersistence {
    GatoJpaController gatoJpa= new GatoJpaController();
    FichaJpaController fichaJpa=new FichaJpaController();
    PersonaJpaController personJpa=new PersonaJpaController();
    VoluntarioJpaController voluntJpa=new VoluntarioJpaController();
    SolicitanteJpaController solJpa=new SolicitanteJpaController();

    public void createCat(Gato cat) {
        gatoJpa.create(cat);
    }

    public void destroyCat(int id) {
        try {
            gatoJpa.destroy(id);
        } catch (Exception ex) {
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
    
    //------PERSONA------//

    public void createPerson(Persona person) {
        try {
            personJpa.create(person);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void destroyPerson(String dni) {
        try {
            personJpa.destroy(dni);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editPerson(Persona person) {
        try {
            personJpa.edit(person);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Persona bringPerson(String dni) {
        return personJpa.findPersona(dni);
    }

    public ArrayList<Persona> bringPeople() {
        List <Persona> list=personJpa.findPersonaEntities();
        ArrayList <Persona> listPeople=new ArrayList<Persona>(list);
        return listPeople;
    }

    //------VOLUNTARIO------//

    public void createVolunt(Voluntario vol) {
        try {
            voluntJpa.create(vol);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void destroyVolunt(String dni) {
        try {
            voluntJpa.destroy(dni);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editVol(Voluntario vol) {
        try {
            voluntJpa.edit(vol);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Voluntario bringVol(String dni) {
        return voluntJpa.findVoluntario(dni);
    }

    public ArrayList<Voluntario> bringVols() {
        List <Voluntario> list=voluntJpa.findVoluntarioEntities();
        ArrayList <Voluntario> listVols=new ArrayList<Voluntario>(list);
        return listVols;
    }

    public void createSol(Solicitante sol) {
        try {
            solJpa.create(sol);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void destroySol(String dni) {
        try {
            solJpa.destroy(dni);
        } catch (com.mycompany.gatosjpa.exceptions.NonexistentEntityException e) {
            throw new RuntimeException(e);
        }
    }

    public void editSol(Solicitante sol) {
        try {
            solJpa.edit(sol);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Solicitante bringSol(String dni) {
        return solJpa.findSolicitante(dni);
    }

    public ArrayList<Solicitante> bringSols() {
        List <Solicitante> list=solJpa.findSolicitanteEntities();
        ArrayList <Solicitante> listSols=new ArrayList<Solicitante>(list);
        return listSols;
    }
}
