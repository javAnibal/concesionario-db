package model;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Coche {
    private static Integer contadorID = 0;

    private final int id;
    private String matricula;
    private String marca;
    private String modelo;
    private Set<Equipamiento> equipamientoList;

    //==================================== SOBRE CARGA CONSTRUCTORES - COCHE ======================================================

    public Coche(String matricula, String marca, String modelo) {

        this.id = ++contadorID; // -> GENERANDO ID AUTOMÁTICO
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.equipamientoList = new HashSet<>();
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
        this.equipamientoList = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }


    //==================================== MÉT-DOS PROPIOS - COCHE ======================================================


    public boolean tieneEquipamientos() {
        return !equipamientoList.isEmpty();
    }

    public void agregarEquipamiento(Equipamiento equipamiento) {
        this.equipamientoList.add(equipamiento);

    }


    /**
     * DEFINO que la clase coche considerará DUPLICADA por el campo matrícula.
     * SE COMPARA por la matrícula y no por su referencia en memoria
     * ES IMPORTANTE -> por su almacenamiento en @Concesionario
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
                ", equipamientoList=" + equipamientoList +
                '}';
    }
}
