/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semaforoproce;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * 
 *
 * @author manu_
 *
 * Clase que gestiona los vehículos del concesionario y controla el acceso a ellos.
 * Contiene un semáforo que permite que solo 4 clientes utilicen un vehículo a la vez.
 */
public class GestorVehiculos {

    /** Semáforo que limita el número de clientes que pueden usar vehículos simultáneamente */
    private Semaphore semaforo;

    /** Lista de vehículos disponibles (representados como números) */
    private List<Integer> vehiculosDisponibles;

    /**
     * Constructor del gestor de vehículos.
     * @param numeroVehiculos cantidad de vehículos disponibles
     */
    public GestorVehiculos(int numeroVehiculos) {
        this.semaforo = new Semaphore(numeroVehiculos, true);
        this.vehiculosDisponibles = new ArrayList<>();

        for (int i = 1; i <= numeroVehiculos; i++) {
            vehiculosDisponibles.add(i);
        }
    }

    /**
     * Asigna un vehículo disponible a un cliente.
     * Este método está sincronizado para evitar condiciones de carrera.
     * @return número del vehículo asignado
     */
    public synchronized int obtenerVehiculo() {
        return vehiculosDisponibles.remove(0);
    }

    /**
     * Devuelve un vehículo al listado de disponibles.
     * @param vehiculo número del vehículo a devolver
     */
    public synchronized void devolverVehiculo(int vehiculo) {
        vehiculosDisponibles.add(vehiculo);
    }

    /**
     * Devuelve el semáforo que controla el acceso a los vehículos.
     * @return semáforo
     */
    public Semaphore getSemaforo() {
        return semaforo;
    }
}

