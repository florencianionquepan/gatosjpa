/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.gatosjpa;

import com.mycompany.gatosjpa.logica.Controller;
import com.mycompany.gatosjpa.logica.Ficha;
import com.mycompany.gatosjpa.logica.Gato;
import com.mycompany.gatosjpa.logica.Persona;
import com.mycompany.gatosjpa.logica.Voluntario;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author florencia
 */
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
        Voluntario volunt=new Voluntario("36192394","Flower","Nonque","4143822",new Date(),listaGatis);
        control.createVol(volunt);
        
        //4)Creo los gatos a cargo. 
        Ficha fichaVet1=new Ficha(1,true,false,false);
        control.createFile(fichaVet1);
        Ficha fichaVet2=new Ficha(2,true,false,false);
        control.createFile(fichaVet2);
        
        Gato catEmma=new Gato(6,"Emma",new ArrayList(),"hembra","Gatita loca","pardo","naranja",false, new Date(),fichaVet1,volunt);
        control.createCat(catEmma);
        Gato catIgor=new Gato(7,"Igor",new ArrayList(),"macho","Gatita loca","pardo","negro",true, new Date(),fichaVet2,volunt);
        control.createCat(catIgor);
        
        listaGatis.add(catEmma);
        listaGatis.add(catIgor);
        //System.out.println("----GATA LOCA----");
        //Gato cat=control.bringCat(1);
        //System.out.println("La gata: "+cat.getNombre()+" posee la ficha "+cat.getFichaVet().toString());
        volunt.setGatos(listaGatis);
        control.editVol(volunt);
        
    }
    
}
