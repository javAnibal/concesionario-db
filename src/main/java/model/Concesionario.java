package model;

import java.util.HashSet;

import java.util.Set;


public class Concesionario {

    private  Set<Coche> registroDeCoches = new HashSet<>();


    public void agregarNuevoRegistro(Coche coche) {

        this.registroDeCoches.add(coche);
    }

    public void mostrarRegistros() {

        for(Coche coche: registroDeCoches ){

            System.out.println(coche);
        }
    }



}
