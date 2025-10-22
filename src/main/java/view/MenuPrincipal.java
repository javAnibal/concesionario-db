package view;

import controller.ControllerConcesionario;
import model.Coche;
import model.Equipamiento;
import utils.ConcesionarioException;

import java.util.*;


public class MenuPrincipal {

    private static ControllerConcesionario controller = new ControllerConcesionario();
    private static final Scanner sc = new Scanner(System.in);


    private void listaDeOpciones() {

        List<String> listaDeOpciones = List.of(
                " 1) CARGAR -> desde CSV",
                " 2) INSERTAR -> coche ",
                " 3) ORDENAR -> por matrícula ",
                " 4) BORRAR -> por matrícula ",
                " 5) MODIFICAR -> registro ",
                " 6) EXPORTAR ",
                " 0) SALIR "
        );

        listaDeOpciones.forEach(System.out::println);

        System.out.print("Elija opción: -> ");


    }

    public void mostrarMenu() {


        try {
            while (true) {
                listaDeOpciones();

                int input;
                try {
                    input = Integer.parseInt(sc.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Debe ser un número entre [0-5]");
                    continue;
                }

                if (input < 0 || input > 5) {
                    System.out.println("Entrada fuera de rango [0-5]. Intente de nuevo.");
                    continue;
                }

                switch (input) {
                    case 1 -> {
                        System.out.print("Importar CSV (ej: BBDDejemplo.csv): ");
                        String nombreFichero = sc.nextLine().trim();
                        controller.importarDesdeCSV(nombreFichero);


                    }
                    case 2 -> {
                        Set<Coche> nuevoCoche =  new HashSet<>();
                        nuevoCoche.add(solicitarDatos());
                        controller.insertarEnMemoria(nuevoCoche);
                        controller.mostrarDatosEnMemoria();


                    }
                    case 3 -> {
                        System.out.println("Ordenar por matrícula");


                    }

                    case 4 -> System.out.println("Borrar Registro");
                    case 5 -> System.out.println("Modificar el registro");
                    case 0 -> {
                        System.out.println("Saliendo del programa ...");
                        sc.close();
                        System.exit(0);
                    }
                }

                System.out.println();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //==============================================================================================

    // MÉT-DO -> SOLICITAR DATOS & EQUIPAMIENTO

    //==============================================================================================

    public static Coche solicitarDatos() throws ConcesionarioException {

        try {
            System.out.println("Ingrese la matrícula: ");
            String matricula = sc.nextLine().trim().toUpperCase();
            System.out.println("Ingrese la marca: ");
            String marca = sc.nextLine().trim().toLowerCase();
            System.out.println("Ingrese la modelo: ");
            String modelo = sc.nextLine().trim().toLowerCase();

            Coche coche = new Coche(matricula, marca, modelo);

            solicitarEquipamiento(coche);

            return coche;

        } catch (Exception ex) {
            throw new ConcesionarioException("Error al introducir los datos " + ex.getMessage());

        }


    }

    private static void solicitarEquipamiento(Coche coche) throws ConcesionarioException {

        boolean continuar = true;
        while (continuar) {
            System.out.print("¿Desea ingresar equipamiento? (S/N): ");
            String respuesta = sc.nextLine().trim();

            if (respuesta.equalsIgnoreCase("S")) {

                System.out.println("Ingrese el equipamiento");
                String extra = sc.nextLine().trim().toLowerCase();
                Equipamiento equipamiento = new Equipamiento(extra);
                coche.agregarEquipamiento(equipamiento);
                System.out.println("Se ha agregado el equipamiento del coche");

            } else if (respuesta.equalsIgnoreCase("N")) {
                continuar = false;

            } else {
                System.out.println("Opción incorrecta, ingrese (Y/N)");
            }


        }

    }


}


