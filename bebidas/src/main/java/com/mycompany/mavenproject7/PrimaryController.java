package com.mycompany.mavenproject7;

import java.io.*;
import javafx.scene.control.ComboBox;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.json.JSONArray;
import org.json.JSONObject;

public class PrimaryController implements Initializable {

    //CONTENIDO FXML CON ID
    @FXML
    public TextField introducir_busqueda;
    @FXML
    public ComboBox<Categoria> categorias;
    //Contenidos tableView
    @FXML
    public TableView tabla_contenido;
    @FXML
    public TableColumn idCombo;
    @FXML
    public TableColumn nombreCombo;
    @FXML
    public ImageView imagen_bebida;

    //OBSERVABLE LISTS
    public ObservableList<Categoria> listaCategorias;
    public ObservableList<datos_bebidas> listaBebidas;

    private ArrayList<datos_bebidas> arl = new ArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            instancias();
            jsonCategorias();
            asociarElementos();
        } catch (IOException ex) {
            System.out.println("error en initialize");
        }
    }

    //METODOS 
    //INICIALIZA Observable list
    public void instancias() {
        listaCategorias = FXCollections.observableArrayList();
        listaBebidas = FXCollections.observableArrayList();

        this.idCombo.setCellValueFactory(new PropertyValueFactory("id_bebida"));
        this.nombreCombo.setCellValueFactory(new PropertyValueFactory("nombre_bebida"));
    }

    //AGREGA contenido a la comboBox
    public void asociarElementos() {
        categorias.setItems(listaCategorias);
        tabla_contenido.setItems(listaBebidas);
    }

    //CREA EL FICHERO QUE PARA PODER ALMACENAR EL JSON
    protected String extraer_fichero(String url) throws IOException {
        String fichero = "";
        InputStream inputStream;
        inputStream = new URL(url).openStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String linea;
        while ((linea = bufferedReader.readLine()) != null) {
            fichero += linea;
        }
        return fichero;
    }

    private void jsonCategorias() throws IOException {
        String fichero = extraer_fichero("https://www.thecocktaildb.com/api/json/v1/1/list.php?c=list");
        JSONObject jsonObject = new JSONObject(fichero);
        JSONArray jsonArray = jsonObject.getJSONArray("drinks");

        for (int x = 0; x < jsonArray.length(); x++) {
            JSONObject categorias = jsonArray.getJSONObject(x);
            String nombre_categoria = categorias.getString("strCategory");
            listaCategorias.add(new Categoria(nombre_categoria));
        }
    }

    @FXML
    protected void mostrar_contenido_categoria(ActionEvent event) throws IOException {
        limpiar_tableView();

        String ver = categorias.getValue().nombre;

        String fichero = extraer_fichero("https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=" + ver);
        JSONObject jsonObject = new JSONObject(fichero);
        JSONArray jsonArray = jsonObject.getJSONArray("drinks");

        for (int x = 0; x < jsonArray.length(); x++) {
            JSONObject categorias_contenido = jsonArray.getJSONObject(x);
            String nombre_bebida = categorias_contenido.getString("strDrink");
            String id_bebida = categorias_contenido.getString("idDrink");
            String id_imagen = categorias_contenido.getString("strDrinkThumb");
            arl.add(new datos_bebidas(id_bebida, nombre_bebida, id_imagen));
            listaBebidas.add(arl.get(x));
        }
    }

    public void limpiar_tableView() {
        for (int i = 0; i < tabla_contenido.getItems().size(); i++) {
            tabla_contenido.getItems().clear();
        }
        arl.clear();
        imagen_bebida.setImage(null);
    }

    public void mostar_imagen(MouseEvent event) throws IOException {
        int index = tabla_contenido.getSelectionModel().getSelectedIndex();
        String url = arl.get(index).imagen;

        imagen_bebida.setImage(new Image(url));
    }

    public void buscar_nombre(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.ENTER) {
            limpiar_tableView();

            String palabra = introducir_busqueda.getText();

            String fichero = extraer_fichero("https://www.thecocktaildb.com/api/json/v1/1/search.php?s=" + palabra);
            JSONObject jsonObject = new JSONObject(fichero);
            JSONArray jsonArray = jsonObject.getJSONArray("drinks");

            for (int x = 0; x < jsonArray.length(); x++) {
                JSONObject categorias_contenido = jsonArray.getJSONObject(x);
                String nombre_bebida = categorias_contenido.getString("strDrink");
                String id_bebida = categorias_contenido.getString("idDrink");
                String id_imagen = categorias_contenido.getString("strDrinkThumb");
                arl.add(new datos_bebidas(id_bebida, nombre_bebida, id_imagen));
                listaBebidas.add(arl.get(x));
            }
        }
    }
}
