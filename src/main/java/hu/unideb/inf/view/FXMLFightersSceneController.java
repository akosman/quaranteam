/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.view;

import hu.unideb.inf.model.Model;
import hu.unideb.inf.model.Fighter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author Dani
 */
public class FXMLFightersSceneController implements Initializable {

    private Model model;

    public void setModel(Model model) {
        this.model = model;
    }
     @FXML
    private Label name1Label;

    @FXML
    private Label attack1Label;

    @FXML
    private Label defend1Label;

    @FXML
    private Label colorLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label attackLabel;

    @FXML
    private Label defendLabel;
    
    @FXML
    private Label levelLabel;
    
    @FXML
    private Label level1Label;
    
    @FXML
    private AnchorPane rootPane;
    
      @FXML
    private ChoiceBox<String> yourFighterA;
      
     

    @FXML
    private ChoiceBox<String> yourFighterB;
    
    ObservableList list = FXCollections.observableArrayList();
    ObservableList list2 = FXCollections.observableArrayList();

   

    @FXML
    void handleLoadButtonPushed() {
        
        nameLabel.textProperty().bind(model.getFighter().nameProperty());
        name1Label.textProperty().bind(model.getFighter2().nameProperty());

        attackLabel.setText("" + model.getFighter().getAttack());
        attack1Label.setText("" + model.getFighter2().getAttack());       
        
        defendLabel.setText(""+model.getFighter().getDefend());
        defend1Label.setText(""+model.getFighter2().getDefend());
        
        levelLabel.setText(""+model.getFighter().getLevel());
        level1Label.setText(""+model.getFighter2().getLevel());
    }
   
    @FXML
    void handleSaveToFileButtonPushed() throws IOException {
        try (FileOutputStream fos = new FileOutputStream("fighters.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(model.getFighter());
        }
    }

    @FXML
    void handleLoadFromFileButtonPushed() throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream("fighters.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            Fighter s = (Fighter) ois.readObject();
            model.getFighter().setName(s.getName());
            model.getFighter().setDefend(s.getDefend());
            model.getFighter().setAttack(s.getAttack());
            model.getFighter().setLevel(s.getLevel());
        }
    }
    
    @FXML
    void handleFightButtonPushed() throws IOException {
        
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/FXMLFightingScene.fxml"));
        
        rootPane.getChildren().setAll(pane);
                      
        
        
    }
    
        private void LoadData() {
        list.removeAll(list);
        list2.removeAll(list2);
        String a = "DOM";
        String b = "AKOS";
        list.addAll(a, b);
        list2.addAll(b, a);
        yourFighterA.getItems().addAll(list);
        yourFighterB.getItems().addAll(list2);
    }
        
       

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     LoadData();
    }

}
