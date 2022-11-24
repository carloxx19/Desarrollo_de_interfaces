package com.mycompany.vendercafe;

import cafe.Cafe;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController implements Initializable {

    //variables
    int total = 0;

    //declaraciones
    //botones
    @FXML
    private Button btnRealizarPedido;

    @FXML
    private Button eliminar;

    @FXML
    private Button btnRecargar;

    //togglegroup de cafe y los 3 radio button
    @FXML
    private ToggleGroup cafe;

    @FXML
    private RadioButton cafeLatte;

    @FXML
    private RadioButton capuccino;

    @FXML
    private RadioButton cortado;

    @FXML
    private ComboBox<String> comboTamanio;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtIngresarSaldo;

    @FXML
    private TextField txtSaldoTotal;

    //table view y sus columnas
    @FXML
    private TableView areaPedidos;

    @FXML
    private TableColumn nombreCafe;

    @FXML
    private TableColumn precioCafe;

    @FXML
    private TableColumn tamanioCafe;

    @FXML
    private TableColumn cantidadcafe;

    @FXML
    private TableColumn totalCafe;

    //observablelist
    @FXML
    ObservableList<Cafe> lista;

    //metodos
    //metodo para ingresar el dinero del usuario
    @FXML
    public void agregarDinero(ActionEvent event) {

        if (event.getSource().equals(btnRecargar)) {

            String validar = txtIngresarSaldo.getText();

            if (validar.matches("[0-9]*")) {
                int cantidad_de_saldo_a_ingresar = Integer.parseInt(txtIngresarSaldo.getText());
                total = total + cantidad_de_saldo_a_ingresar;

                txtSaldoTotal.setText(total + "");
            } else {
                dialogoError("solo ingrese numeros por favor.");
            }
        }
    }

    //combo box tamanios del cafe
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        comboTamanio.getItems().addAll("grande", "mediano", "pequeño");
        lista = FXCollections.observableArrayList();
        this.nombreCafe.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.tamanioCafe.setCellValueFactory(new PropertyValueFactory("tamanio"));
        this.cantidadcafe.setCellValueFactory(new PropertyValueFactory("cantidad"));
        this.precioCafe.setCellValueFactory(new PropertyValueFactory("valor"));
        this.totalCafe.setCellValueFactory(new PropertyValueFactory("total"));
    }

    //pedido del cafe
    @FXML
    public void realizar_pedido(ActionEvent event) {
        dar_valores_a_cafe();
    }

    @FXML
    public void dar_valores_a_cafe() {
        Cafe caf = new Cafe();

        //asignamos a nombre de cafe el valor del radio button
        if (capuccino.isSelected()) {
            caf.setNombre("capuccino");
        } else if (cafeLatte.isSelected()) {
            caf.setNombre("cafe Latte");
        } else if (cortado.isSelected()) {
            caf.setNombre("cortado");
        }

        //asignamos al tamanio del cafe el valor seleccionado en el comboBox
        caf.tamanio = comboTamanio.getValue();

        //en base a la seleccion del combo box le damos un valor por tamanio
        if (caf.tamanio == "pequeño") {
            caf.valor = 1;
        } else if (caf.tamanio == "mediano") {
            caf.valor = 2;
        } else {
            caf.valor = 3;
        }

        //obtenemos la cantidad de cafes comprados en base a la cantidad escrita en txtCantidad
        String validar = txtCantidad.getText();
        if (validar.matches("[0-9]*")) {
            caf.cantidad = Integer.parseInt(txtCantidad.getText());
        } else {
            dialogoError("Ingrese un caracter numerico, por favor.");
        }

        caf.cantidad = Integer.parseInt(txtCantidad.getText());

        //sacamos el precio total multiplicando el valor por la cantidad
        caf.total = caf.getCantidad() * caf.getValor();

        if (caf.total > total) {
            aviso_saldo_inferior("saldo insuficiente, por favor introduzca saldo.");
        } else {
            total = total - caf.total;
            txtSaldoTotal.setText(total + "");
            this.lista.add(caf);
            areaPedidos.setItems(lista);
        }
    }

    @FXML
    public void aviso_saldo_inferior(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Diálogo de aviso...");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    public void dialogoError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}