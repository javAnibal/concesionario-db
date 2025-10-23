package controller;

import model.Coche;
import model.Concesionario;
import services.GestorCSV;
import services.GestorXML;
import utils.ConcesionarioException;
import view.ViewConcesionario;

import java.util.HashSet;
import java.util.Set;

public class ControllerConcesionario {

    private Concesionario concesionario;
    private GestorXML gestorXML;
    private GestorCSV gestorCSV;
    private ViewConcesionario viewConcesionario;


    public ControllerConcesionario() {
        this.concesionario = new Concesionario();
        this.gestorXML = new GestorXML();
        this.gestorCSV = new GestorCSV();
        this.viewConcesionario = new ViewConcesionario();
    }


    public void mostrarDatosEnMemoria() {

        for (Coche coche : concesionario.getRegistroDeCoches()) {
            System.out.println(coche);
        }

    }


    public void importarDesdeCSV(String nombreFichero) {

        Set<Coche> contenedorTemporalCSV = new HashSet<>();

        try {
            contenedorTemporalCSV = gestorCSV.leerCSV(nombreFichero);
            insertarEnMemoria(contenedorTemporalCSV);
           // mostrarDatosEnMemoria();


        } catch (ConcesionarioException ex) {
            System.err.println("Error al insertar el fichero" + ex.getMessage());
        }
    }

    public void insertarEnMemoria(Set<Coche> coches)throws ConcesionarioException {

        for (Coche coche : coches) {
            concesionario.agregarNuevoRegistro(coche);

        }
        System.out.println(" " + coches.size() + " coches agregados al concesionario en memoria.");
        viewConcesionario.mostrarTodosLosRegistros(concesionario.getRegistroDeCoches());

    }





}


