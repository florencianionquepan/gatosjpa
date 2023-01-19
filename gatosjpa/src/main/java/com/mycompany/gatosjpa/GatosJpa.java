package com.mycompany.gatosjpa;

import com.mycompany.gatosjpa.logica.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class GatosJpa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //De esta forma se van a crear todas las tablas que tenga hasta el momento
        Controller control= new Controller();
        
        /*
        Gato cat;
        cat = new Gato(2,"Ateneo",new ArrayList(),"macho","Gatito sobreviviente","raza","negro",false, new Date());
        control.createCat(cat);
        
        cat.setNombre("igorio");
        control.editCat(cat);
        control.destroyCat(2);
        */
        
        //Gato catBuscado=control.bringCat(3);
        //System.out.println(catBuscado.toString());
        
        /*ArrayList <Gato> listaGatitos=control.bringCats();
        for(int i=0;i<listaGatitos.size();i++){
            System.out.println(listaGatitos.get(i).toString());
        }
        
        */
        //1)CREAR LISTA DE GATOS VACIA
        LinkedList <Gato> listaGatis=new LinkedList<Gato>();
        
        //2)CREAMOS UNA PERSONA Y UN VOLINTARIO
        //Persona Florencia=new Persona("36192394","Flower","Nonque","4143822");
        
        //3)CREO VOLUNTARIO
        Voluntario volunt=new Voluntario("36192394","Flower","Nonque","4143822", LocalDate.of(2022,12,01),listaGatis);
        control.createVol(volunt);

        //4)Creo los gatos a cargo. 
        Ficha fichaVet1=new Ficha(1,true,false,false);
        control.createFile(fichaVet1);
        Ficha fichaVet2=new Ficha(2,true,false,false);
        control.createFile(fichaVet2);

        //A gato ya le agrego la lista de solicitantes en su constructor que siempre estara vacia en un principio
        ArrayList<Solicitante> listaSol=new ArrayList<Solicitante>();
        Gato catEmma=new Gato(1,"Emma",new ArrayList(),"hembra","Gatita loca","pardo","naranja",false,
                                LocalDate.of(2016,8,22),fichaVet1,volunt,listaSol);
        control.createCat(catEmma);
        Gato catIgor=new Gato(2,"Igor",new ArrayList(),
                        "macho","Gatito loco","pardo","negro",
                true, LocalDate.of(2022,8,20),fichaVet2,volunt,listaSol);
        control.createCat(catIgor);

        //CREAR SOLICITANTE
        //Para que en la base de datos el solicitante tenga como atributo un gato, deberia construir el objeto
        //con el gato. No tiene sentido en la realidad ya que primero el solicitante se crea, luego vera si
        //quiere solicitar un gato o no- Elimino del constructor al gato. Luego se agregara editando el objeto
        Solicitante Marcos=new Solicitante("92425108","Marcos","Papaleo","4635800","Santa Fe 200");
        control.createSol(Marcos);
        //Ahora Marcos una vez creado va a solicitar la adopcion de Emma
        listaSol.add(Marcos);
        catEmma.setListaSolic(listaSol);
        control.editCat(catEmma);

        Marcos.setGato(catEmma);
        control.editSol(Marcos);

        listaGatis.add(catEmma);
        listaGatis.add(catIgor);
        //System.out.println("----GATA LOCA----");
        //Gato cat=control.bringCat(1);
        //System.out.println("La gata: "+cat.getNombre()+" posee la ficha "+cat.getFichaVet().toString());
        volunt.setGatos(listaGatis);
        control.editVol(volunt);
        
    }
    
}
