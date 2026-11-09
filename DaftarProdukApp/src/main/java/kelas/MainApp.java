package kelas;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Navigator.setStage(primaryStage);
        primaryStage.setTitle("Aplikasi Pencatatan Produk Toko");
        Navigator.loadFXML("daftar");
    }

    public static void main(String[] args) {
        launch(args);
    }
}