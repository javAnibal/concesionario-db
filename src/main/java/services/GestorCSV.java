package services;

import model.Coche;
import model.Concesionario;
import model.Equipamiento;
import utils.ConcesionarioException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;


public class GestorCSV {


    private static final Path rutaBaseOrigen = Path.of(System.getProperty("user.dir"));

    public Set<Coche> importarCSV(String ficheroCSV) throws ConcesionarioException {

        if (ficheroCSV.isEmpty() || ficheroCSV.isBlank()) {
            System.err.println("Debe especificar el nombre de un fichero");
            return null;
        }

        Set<Coche> registroTemporal = new HashSet<>();

        Path rutaCompleta = rutaBaseOrigen.resolve(ficheroCSV);

        try (BufferedReader br = new BufferedReader(new FileReader(rutaCompleta.toFile()))) {

            boolean encabezado = true;
            String linea = "";
            int contador = 0;

            while ((linea = br.readLine()) != null) {

                if (encabezado) {
                    encabezado = false;
                    continue;
                }

                String[] datos = linea.split(";");
                String matricula = datos[0];
                String marca = datos[1];
                String modelo = datos[2];

                Coche coche = new Coche(matricula, marca, modelo);


                if (datos.length > 3 && !datos[3].isEmpty()) {
                    String[] listaExtras = datos[3].split("\\|");
                    for (String extra : listaExtras) {
                        coche.agregarEquipamiento(new Equipamiento(extra.trim()));
                    }
                }

                // agregar al concesionario
                registroTemporal.add(coche);


            }

        } catch (
                IOException ex) {
            throw new ConcesionarioException("Error al leer el fichero " + ficheroCSV);
        }

        return registroTemporal;
    }


}
