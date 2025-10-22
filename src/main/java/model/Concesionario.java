package model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;


import java.util.HashSet;

import java.util.Set;

@XmlRootElement

public class Concesionario {

    public Concesionario() {
    }

    @XmlElementWrapper(name = "listado-coches")
    @XmlElement(name = "coche")
    private Set<Coche> registroDeCoches = new HashSet<>();

    public Set<Coche> getRegistroDeCoches() {
        return registroDeCoches;
    }

    public void agregarNuevoRegistro(Coche coche) {

        registroDeCoches.add(coche);
    }

    public void mostrarRegistros() {

        for(Coche coche: registroDeCoches ){

            System.out.println(coche);
        }
    }



}
