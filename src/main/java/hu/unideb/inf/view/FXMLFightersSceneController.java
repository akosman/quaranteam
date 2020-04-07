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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


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
    private Label colorLabel;
    
    @FXML
    private Button loadbutton;

    @FXML
    private Label nameLabel;

    @FXML
    private Label attackLabel;

    @FXML
    private Label defendLabel;
    
    @FXML
    private Label levelLabel;

    @FXML
    private AnchorPane rootPane;
    
    @FXML
    private ChoiceBox<String> yourFighterA;
     
    @FXML
    private ChoiceBox<String> yourFighterB;
    
    @FXML
    private ChoiceBox<String> Fighter;
    
    // listak a ChoiceBoxokhoz
    
    ObservableList list = FXCollections.observableArrayList();
    ObservableList list2 = FXCollections.observableArrayList();
    
  
   // Itt a LOAD gomb megnezi hogy kit szeretnel betolteni es azt rakja a Labelekre
    
    @FXML
    void handleLoadButtonPushed() {
        
        if (Fighter.getValue().equals("DOM")){
        nameLabel.textProperty().bind(model.getFighter().nameProperty());

        attackLabel.setText("" + model.getFighter().getAttack());

        defendLabel.setText(""+model.getFighter().getDefend());

        levelLabel.setText(""+model.getFighter().getLevel());
        }
        else {
        
        nameLabel.textProperty().bind(model.getFighter2().nameProperty());

        attackLabel.setText("" + model.getFighter2().getAttack());

        defendLabel.setText(""+model.getFighter2().getDefend());

        levelLabel.setText(""+model.getFighter2().getLevel());
        
        }
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
    
    // Itt toltom be a FightingScene.fxml-t a Choose Fighter AnchorPane-rol
    // UI: nem mukodik meg rendesen a visszagomb sajnos,szoval meg buggos,es a Modell cuccokat sem tolti be
    
    @FXML
    void handleFightButtonPushed() throws IOException {
        
  
       FXMLLoader loader = new FXMLLoader(FXMLFightersSceneController.class.getResource("/fxml/FXMLFightingScene.fxml"));
       Scene scene = new Scene(loader.load());
       Stage stage = new Stage(StageStyle.DECORATED);
       stage.setTitle("Fight");
       stage.getIcons().add(new Image("/fxml/battle.png"));
       stage.setScene(scene);
       
       FXMLFightingSceneController controller = loader.getController();
       
       // itt dol el a choiceboxbol hogy ki lesz a te harcosod es ki az ellenfel
       // es annak az adatait dobjuk at a Fighting scenere
       
       if (yourFighterA.getValue().equals("DOM") && yourFighterB.getValue().equals("AKOS")){
           
           controller.initData(model.getFighter(), model.getFighter2());
           
       } else {
           controller.initData(model.getFighter2(), model.getFighter());
       }
            
       stage.show();                          
        
    }
        // Betolto fuggveny a ChoiceBoxokhoz
    
        private void LoadData() {
        list.removeAll(list);
        list2.removeAll(list2);
        String a = "DOM";
        String b = "AKOS";
        list.addAll(a, b);
        list2.addAll(b, a);
        yourFighterA.getItems().addAll(list);
        yourFighterB.getItems().addAll(list2);
        Fighter.getItems().addAll(list);
        Fighter.setValue("DOM");
        yourFighterA.setValue("DOM");
        yourFighterB.setValue("AKOS");
    }
        
       

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         LoadData();
    }

}
