package kelas;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Navigator {
    private static Stage stage;

    public static void setStage(Stage s) {
        stage = s;
    }

    public static FXMLLoader loadFXML(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/kelas/" + fxml + ".fxml"));
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(MainApp.class.getResource("/kelas/styles/app.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
        return loader;
    }
}