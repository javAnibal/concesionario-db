package controller;

import model.Coche;
import model.Concesionario;
import services.GestorCSV;
import services.GestorXML;
import utils.ConcesionarioException;

import java.util.HashSet;
import java.util.Set;

public class ControllerConcesionario {

    private Concesionario concesionario;
    private GestorXML gestorXML;
    private GestorCSV gestorCSV;

    public ControllerConcesionario() {
        this.concesionario = new Concesionario();
        this.gestorXML = new GestorXML();
        this.gestorCSV = new GestorCSV();
    }

    public void mostrarDatosEnMemoria() {

        for (Coche coche : concesionario.getRegistroDeCoches()) {
            System.out.println(coche);
        }

    }


    public void importarDesdeCSV(String nombreFichero) {

        boolean flag = true;
        Set<Coche> importeTemporalCSV = new HashSet<>();

        try {


                importeTemporalCSV = gestorCSV.importarCSV(nombreFichero);



            insertarEnMemoria(importeTemporalCSV);
            mostrarDatosEnMemoria();


        } catch (ConcesionarioException ex) {
            System.err.println("Error al insertar el fichero");
        }
    }

    public void insertarEnMemoria(Set<Coche> coches) {

        for (Coche coche : coches) {
            concesionario.agregarNuevoRegistro(coche);

        }
        System.out.println(" " + coches.size() + " coches agregados al concesionario en memoria.");

    }


}


