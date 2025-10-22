package services;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import model.Coche;
import model.Concesionario;
import model.Equipamiento;
import utils.ConcesionarioException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;


public class GestorXML {

    private static final Path rutaBase = Path.of(System.getProperty("user.dir"), "concesionario.xml");

    public void crearXML(Concesionario concesionario) throws ConcesionarioException {


        try(OutputStream os = Files.newOutputStream(rutaBase)){

            JAXBContext context = JAXBContext.newInstance(Concesionario.class, Coche.class, Equipamiento.class);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(concesionario, os);


        } catch (IOException | JAXBException e) {
            e.printStackTrace();
            throw new ConcesionarioException("El fichero xml no se ha creado");
        }





    }

}
