package hu.unideb.inf;

import hu.unideb.inf.model.Model;
import hu.unideb.inf.view.FXMLhomeSceneController;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
         FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLhomeScene.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Fighting Game");
        stage.getIcons().add(new Image("/fxml/sword.png"));
        stage.setScene(scene);
        
        ((FXMLhomeSceneController)loader.getController()).setModel(new Model());
        stage.setResizable(false);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
