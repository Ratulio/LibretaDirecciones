package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.Persona;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import static javafx.scene.input.DataFormat.URL;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import view.VistaPersonaController;

/**
 *
 * @author dam
 */
public class LibretaDurecciones extends Application {
    
     private ObservableList datosPersona = FXCollections.observableArrayList();
     private Stage escenarioPrincipal;
     private BorderPane layoutPrincipal;
     private AnchorPane vistaPersona;
     
     
     public LibretaDurecciones(){
         datosPersona.add(new Persona("Pablo", "Perez Estevan"));
         datosPersona.add(new Persona("Pablo", "Prieto Gutierrez"));
         datosPersona.add(new Persona("Alex", "Daniel Tomsa"));
         datosPersona.add(new Persona("Daniel", "Zamarreño Avendaño"));
         datosPersona.add(new Persona("Mauricio", "Sanchez Moreno"));
         
     }
     
     public ObservableList getDatosPersona(){
         return datosPersona;
     }
    
    @Override
    public void start(Stage escenarioPrincipal) {
    this.escenarioPrincipal = escenarioPrincipal;
        
        //Establezco el título
        this.escenarioPrincipal.setTitle("Libreta de direcciones");
        
        //Inicializo el layout principal
        initLayoutPrincipal();
        
        //Muestro la vista persona
        muestraVistaPersona();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void initLayoutPrincipal() {
         //Cargo el layout principal a partir de la vista VistaPrincipal.fxml
        FXMLLoader loader = new FXMLLoader();
        URL location = LibretaDurecciones.class.getResource("../View/VistaPrincipal.fxml");
        loader.setLocation(location);
        try {
            layoutPrincipal = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(LibretaDurecciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Cargo y muestro la escena que contiene ese layout principal
        Scene escena = new Scene(layoutPrincipal);
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
    }

     public void muestraVistaPersona(){
        
        //Cargo la vista persona a partir de VistaPersona.fxml
        FXMLLoader loader = new FXMLLoader();
        URL location = LibretaDurecciones.class.getResource("../View/VistaPersona.fxml");
        loader.setLocation(location);
        try {
            vistaPersona = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(LibretaDurecciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Añado la vista al centro del layoutPrincipal
        layoutPrincipal.setCenter(vistaPersona);
        
        VistaPersonaController controller = loader.getController();
        controller.setLibretaDirecciones(this);
               
    }
    
    //Invoco el método getPrimaryStage para que devuelva mi escenario principal
    public Stage getPrimaryStage() {
        return escenarioPrincipal;
    }

    
   
    
}
