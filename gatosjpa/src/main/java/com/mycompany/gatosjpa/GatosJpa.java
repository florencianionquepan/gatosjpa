/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.gatosjpa;

import com.mycompany.gatosjpa.persistencia.exceptions.ControllerPersistence;

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
        ControllerPersistence controlPersis=new ControllerPersistence();
    }
    
}
