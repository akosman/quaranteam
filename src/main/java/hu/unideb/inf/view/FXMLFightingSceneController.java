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
import javafx.scene.control.ProgressBar;
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
    
    @FXML
     private Label youlvl;
    
    @FXML
     private Label opponentlvl;
    
    @FXML
     private Label youattack;
    
    @FXML
     private Label opponentattack;
    
    @FXML
     private Label youdefend;
    
    @FXML
     private Label opponentdefend;
    
    @FXML
    private Label winner;
    
    @FXML
    private ProgressBar progressbar;
    
    
    // Informacioatadas az initData fuggvennyel, a ket harcos infoit kapjuk meg
    
    public void initData(Fighter You, Fighter Opponent) {
    
        youselect = You;
        opponentselect = Opponent;
        
        yourfightername.textProperty().bind(You.nameProperty());
        opponentname.textProperty().bind(Opponent.nameProperty());
        
        youlvl.setText("Lvl:" + You.getLevel());
        opponentlvl.setText("Lvl:" + Opponent.getLevel());

        youattack.setText("" + You.getAttack());
        opponentattack.setText("" + Opponent.getAttack());
        
        youdefend.setText("" + You.getDefend());
        opponentdefend.setText("" + Opponent.getDefend());
        
        
        
        winner.textProperty().bind(Fight(You, Opponent).nameProperty());
       
    }
    
    
    
     public Fighter Fight(Fighter Fighter1, Fighter Fighter2) {
        
        Fighter you = Fighter1;
        Fighter opponent = Fighter2;
        
        if (you.getAttack() > opponent.getDefend()) {
            return you;
        } else if(you.getAttack() < opponent.getDefend()) {
            return opponent;
        } else {
            return opponent;
        }
        
        
    }
   
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
