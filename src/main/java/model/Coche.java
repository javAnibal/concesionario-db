package model;


import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XmlRootElement

public class Coche {
    private static Integer contadorID = 0;

    @XmlAttribute
    private int id;
    @XmlElement
    private String matricula;
    @XmlElement
    private String marca;
    @XmlElement
    private String modelo;
    @XmlElementWrapper(name = "equipamientos")
    @XmlElement(name = "equipamiento")
    private Set<Equipamiento> equipamiento;

    //==================================== SOBRE CARGA CONSTRUCTORES - COCHE ======================================================


    public Coche() {
    }

    public Coche(String matricula, String marca, String modelo) {

        this.id = ++contadorID; // -> GENERANDO ID AUTOMÁTICO
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.equipamiento = new HashSet<>();
    }

    public Coche(int id, String matricula, String marca, String modelo) {
        this.id = ++contadorID;
        // GENERANDO ID AUTOMÁTICO (id = 5, tomará el siguiente int)
        if (id > contadorID) {
            contadorID = id;
        }

        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.equipamiento = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public static Integer getContadorID() {
        return contadorID;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Set<Equipamiento> getEquipamiento() {
        return equipamiento;
    }

    //==================================== MÉT-DOS PROPIOS - COCHE ======================================================


    public boolean tieneEquipamientos() {
        return !equipamiento.isEmpty();
    }

    public void agregarEquipamiento(Equipamiento equipamiento) {

        this.equipamiento.add(equipamiento);


    }


    /**
     * DEFINO que la clase coche considerará DUPLICADA por el campo matrícula.
     * SE COMPARA por la matrícula y no por su referencia en memoria
     * ES IMPORTANTE -> por su almacenamiento en @Concesionario
     *
     * @Set<Coche> registroDeCoches = new HashSet<>(); (atributo)
     * En la clase concesionario
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Coche coche)) return false;
        return Objects.equals(matricula, coche.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(matricula);
    }

    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", equipamientoList=" + equipamiento +
                '}';
    }
}
