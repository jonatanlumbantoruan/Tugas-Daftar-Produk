package kelas.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.Produk;

public class DaftarController {
    @FXML private TableView<Produk> tabelProduk;
    @FXML private TableColumn<Produk, String> colKode, colNama, colKategori;
    @FXML private TableColumn<Produk, Double> colHarga;
    @FXML private TextField txtCari;

    @FXML
    public void initialize() {
        colKode.setCellValueFactory(new PropertyValueFactory<>("kode"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colKategori.setCellValueFactory(new PropertyValueFactory<>("kategori"));
        colHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));
        tabelProduk.setItems(DataProduk.getData());
    }

    @FXML
    private void onTambah() throws Exception {
        Navigator.loadFXML("form");
    }

    @FXML
    private void onDetail() throws Exception {
        Produk selected = tabelProduk.getSelectionModel().getSelectedItem();
        if (selected != null) {
            javafx.fxml.FXMLLoader loader = Navigator.loadFXML("detail");
            DetailController controller = loader.getController();
            controller.setProduk(selected);
        } else {
            Alert a = new Alert(Alert.AlertType.WARNING, "Pilih produk terlebih dahulu!");
            a.show();
        }
    }

    @FXML
    private void onCari() {
        String keyword = txtCari.getText().toLowerCase();
        ObservableList<Produk> filtered = FXCollections.observableArrayList();
        for (Produk p : DataProduk.getData()) {
            if (p.getNama().toLowerCase().contains(keyword)) {
                filtered.add(p);
            }
        }
        tabelProduk.setItems(filtered);
    }
}