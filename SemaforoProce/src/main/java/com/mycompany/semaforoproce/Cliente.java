/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semaforoproce;

/**
 *
 * @author manu_
* Clase que representa a un cliente del concesionario.
 * Cada cliente es un hilo independiente que intenta usar uno de los vehículos.
 */
public class Cliente extends Thread {

    private String nombre;
    private GestorVehiculos gestor;

    /**
     * Constructor del cliente.
     * @param nombre nombre del cliente
     * @param gestor referencia al gestor de vehículos
     */
    public Cliente(String nombre, GestorVehiculos gestor) {
        this.nombre = nombre;
        this.gestor = gestor;
    }

    /**
     * Lógica principal del hilo.
     * El cliente intenta adquirir un vehículo, lo usa durante un tiempo
     * y finalmente lo devuelve.
     */
    @Override
    public void run() {
        try {
            // Intenta adquirir un permiso del semáforo
            gestor.getSemaforo().acquire();

            // Obtiene un vehículo disponible
            int vehiculo = gestor.obtenerVehiculo();

            System.out.println(nombre + " ... probando vehiculo ... " + vehiculo);

            // Simula el tiempo de prueba del vehículo
            Thread.sleep((int) (Math.random() * 3000 + 1000));

            System.out.println(nombre + " ... termino de probar el vehiculo ... " + vehiculo);

            // Devuelve el vehículo
            gestor.devolverVehiculo(vehiculo);

            // Libera el permiso del semáforo
            gestor.getSemaforo().release();

        } catch (InterruptedException e) {
            System.out.println("El cliente " + nombre + " fue interrumpido.");
        }
    }
}

