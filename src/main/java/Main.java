import model.Coche;
import model.Concesionario;
import model.Equipamiento;
import services.GestorCSV;
import services.GestorXML;
import utils.ConcesionarioException;
import view.MenuPrincipal;


public class Main {


    private static MenuPrincipal menuPrincipal = new MenuPrincipal();

    public static void main(String[] args) {


        menuPrincipal.mostrarMenu();




    }
}


/*
*
*
*
* PRUEBAS DE TEST-  PARA COMPROBAR QUE FUNCIONABAN LOS METODOS
*
*
*
*
*
*
* try {
            //INSTANCIAS DE CLASES
            Concesionario concesionario = new Concesionario();
            GestorXML xml = new GestorXML();
            GestorCSV csv = new GestorCSV(concesionario);

            //Objetos
            Coche coche = new Coche("8910JCY", "nissan", "pulsar");
            Coche coche2 = new Coche("8310JCY", "nissan", "pulsar");
            //OBJETOS EQUIPAMIENTO
            Equipamiento eq = new Equipamiento("Aire acondicionario PRO");


            // METODOS
            concesionario.agregarNuevoRegistro(coche);
            concesionario.agregarNuevoRegistro(coche2);
            coche2.agregarEquipamiento(eq);
            xml.crearXML(concesionario);
            concesionario.mostrarRegistros();

            csv.insertarCSV("BBDDejemplo.csv");

            System.out.println("Nuevos regsitrpos");
            concesionario.mostrarRegistros();


        } catch (ConcesionarioException e) {
            System.err.println(e);
            e.printStackTrace();
        }



*
* */
