package kelas.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kelas.model.Produk;

public class DataProduk {
    private static final ObservableList<Produk> data = FXCollections.observableArrayList();

    public static ObservableList<Produk> getData() {
        return data;
    }

    public static void tambahProduk(Produk p) {
        data.add(p);
    }
}