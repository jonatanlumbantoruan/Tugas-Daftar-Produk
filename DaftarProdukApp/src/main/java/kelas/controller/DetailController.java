package kelas.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import kelas.Navigator;
import kelas.model.Produk;

public class DetailController {
    @FXML private Label lblKode, lblNama, lblKategori, lblHarga;

    public void setProduk(Produk p) {
        lblKode.setText(p.getKode());
        lblNama.setText(p.getNama());
        lblKategori.setText(p.getKategori());
        lblHarga.setText(String.valueOf(p.getHarga()));
    }

    @FXML
    private void onKembali() throws Exception {
        Navigator.loadFXML("daftar");
    }
}