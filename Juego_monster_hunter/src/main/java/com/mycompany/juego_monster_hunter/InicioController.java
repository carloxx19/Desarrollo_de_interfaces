package com.mycompany.juego_monster_hunter;

import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class InicioController{
    
    @FXML
    private Button btn_jugar;

    @FXML
    private AnchorPane fondo_inicio;
    
    @FXML
    public static ObservableList<Personaje> lista;

     @FXML
    private void cambiar_ventana_personaje() throws IOException {
  
        App.setRoot("primary");
    }
}