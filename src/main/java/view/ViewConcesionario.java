package view;

import model.Coche;
import utils.ConcesionarioException;

import java.util.Set;

public class ViewConcesionario {


    public void mostrarTodosLosRegistros(Set<Coche> todosLosRegistros) throws ConcesionarioException {

        if (todosLosRegistros == null || todosLosRegistros.isEmpty()) {
            System.out.println("No existen registros para mostrar.");
            return;
        }

        System.out.println("=== Lista de Coches ===");
        for (Coche coche : todosLosRegistros) {
            System.out.println(String.format(
                    "ID: %d\nMatrícula: %s\nMarca: %s\nModelo: %s\n---------------------",
                    coche.getId(),
                    coche.getMatricula(),
                    coche.getMarca(),
                    coche.getModelo()
            ));
        }
    }


}

