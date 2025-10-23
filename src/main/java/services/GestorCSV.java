package services;

import model.Coche;
import model.Equipamiento;
import utils.ConcesionarioException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;


/**
 * @GestorCSV -> Clase lógica donde implemento la lectura de un fichero, necesita un
 * @param -> de tipo String -> que se concatena con una ruta estática.
 * Cabe indicar que este mét-do buscará el fichero en la -> RAÍZ DEL PROYECTO <-
 * CONTIENE -> @leerCSV {Leer un fichero CSV}
 * @return -> devuelve un SET sin duplicados - {Lógica implementada en la clase base @Coche}
 * @registroTemporal -> actual como contenedor temporal para almacenar lo que se lea desde el fichero indicado.
 */
public class GestorCSV {

    //Ruta por defecto
    private static final Path rutaBaseOrigen = Path.of(System.getProperty("user.dir"));

    public Set<Coche> leerCSV(String ficheroCSV) throws ConcesionarioException {

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
                    System.out.println("Se omite el encabezado");
                    continue;
                }

                String[] datos = linea.split(";");
                String matricula = datos[0];
                String marca = datos[1];
                String modelo = datos[2];

                // CREAMOS EL OBJETO CON LOS 3 PRIMEROS CAMPOS
                Coche coche = new Coche(matricula, marca, modelo);

                // SI LA LÍNEA ES MAYOR QUE 3 Y NO ESTÁ VACÍA
                // LLAMAMOS -> agregar equipamiento y creamos una nueva instancia
                if (datos.length > 3 && !datos[3].isEmpty()) {
                    String[] listaExtras = datos[3].split("\\|");
                    for (String extra : listaExtras) {
                        coche.agregarEquipamiento(new Equipamiento(extra.trim()));
                    }
                }
                System.out.println("Registros nuevos = " + ++contador);

                // UTILIZAMOS EL SET -> QUE MEDIANTE LA IMPLEMENTACIÓN DEL MÉT-DO EQUALS Y HAS-CODE -> EN LA CLASE @Coche
                // DINÁMICAMENTE SE COMPARA POR MATRÍCULA Y SI CONSIDERA == DISTINTA == SI ES IGUAL == EVITANDO DUPLICADOS
                registroTemporal.add(coche);

            }

        } catch (
                IOException ex) {
            throw new ConcesionarioException("Error al leer el fichero " + ficheroCSV);
        }

        return registroTemporal;
    }


}
