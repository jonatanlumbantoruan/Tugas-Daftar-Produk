package kelas.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.Produk;

public class FormController {
    @FXML private TextField txtKode, txtNama, txtHarga;
    @FXML private ComboBox<String> cbKategori;

    @FXML
    public void initialize() {
        cbKategori.getItems().addAll("Makanan", "Minuman");
        cbKategori.getSelectionModel().selectFirst();
    }

    @FXML
    private void onSimpan() {
        try {
            String kode = txtKode.getText();
            String nama = txtNama.getText();
            String kategori = cbKategori.getValue();
            double harga = Double.parseDouble(txtHarga.getText());

            if (nama.trim().isEmpty()) {
                showAlert("Nama produk tidak boleh kosong!");
                return;
            }
            if (harga <= 0) {
                showAlert("Harga harus lebih dari 0!");
                return;
            }

            DataProduk.tambahProduk(new Produk(kode, nama, kategori, harga));
            Navigator.loadFXML("daftar");
        } catch (NumberFormatException e) {
            showAlert("Harga harus berupa angka yang valid!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onBatal() throws Exception {
        Navigator.loadFXML("daftar");
    }

    private void showAlert(String msg) {
        new Alert(Alert.AlertType.ERROR, msg).show();
    }
}