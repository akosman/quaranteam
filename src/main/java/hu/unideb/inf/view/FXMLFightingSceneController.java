/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.view;

import hu.unideb.inf.MainApp;
import hu.unideb.inf.model.Fighter;
import hu.unideb.inf.model.Model;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Dani
 */
public class FXMLFightingSceneController implements Initializable {
    
    private Model model;

    public void setModelFighting(Model model) {
        this.model = model;
    }
    
    private Fighter youselect;
    
    private Fighter opponentselect;
    
    @FXML
     private AnchorPane FightPane;
    
    @FXML
     private Label yourfightername;
     
    @FXML
     private Label opponentname;
    
    // Informacioatadas az initData fuggvennyel, a ket harcos infoit kapjuk meg
    
    public void initData(Fighter You, Fighter Opponent) {
    
        youselect = You;
        opponentselect = Opponent;
        
        yourfightername.textProperty().bind(You.nameProperty());
        opponentname.textProperty().bind(Opponent.nameProperty());
        
    }
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
