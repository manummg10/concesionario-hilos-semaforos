/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semaforoproce;

/**
 *
 * @author manu_
 */
public class Concesionario {

    public static void main(String[] args) {
        //Crear un gestor con 4 vehiculos disponibles
        GestorVehiculos gestor = new GestorVehiculos(4);
        //Crear los 9 clientes
        Cliente[] clientes = new Cliente [9];
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Cliente("Cliente_" + (i + 1), gestor);
            clientes[i] .start();
        }
    }
}
