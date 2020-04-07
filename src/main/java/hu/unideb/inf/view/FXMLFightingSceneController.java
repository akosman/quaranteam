/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.view;

import hu.unideb.inf.MainApp;
import hu.unideb.inf.model.Model;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Dani
 */
public class FXMLFightingSceneController implements Initializable {
    
     @FXML
     private AnchorPane FightPane;
     
     // itt toltom vissza a FightersScene.fxml-t, de meg nem vittem at a modellt is
    
     @FXML
    void handleBackButtonPushed() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/FXMLFightersScene.fxml"));
      
        FightPane.getChildren().setAll(pane);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
