import model.Coche;
import model.Concesionario;

public class Main {

    public static void main(String[] args) {

        Concesionario concesionario = new Concesionario();



        Coche coche = new Coche( "8910JCY", "nissan", "pulsar");

        concesionario.agregarNuevoRegistro(coche);

        concesionario.mostrarRegistros();



    }
}
