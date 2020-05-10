/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.view;

import hu.unideb.inf.model.Fighter;
import hu.unideb.inf.model.Model;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author gM
 */


public class FXMLhomeSceneController implements Initializable {
    private Model model;
    
    private Fighter fighter;

    public void setModel(Model model) {
        this.model = model;
    }

    @FXML
    private AnchorPane managePane;
    @FXML
    private AnchorPane playPane;
    
    @FXML
    private AnchorPane addFighterPane;
    
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
    private Slider attackSlider;

    @FXML
    private Slider defenseSlider;

    @FXML
    private ChoiceBox<String> yourFighterA;
     
    @FXML
    private ChoiceBox<String> yourFighterB;
    
    @FXML
    private ChoiceBox<String> ChooseFighter;
    
    @FXML
    private TextField FighterNameTextField;

    
    @FXML
    private Label choiceerror;
    
    // listak a ChoiceBoxokhoz
    
    ObservableList list = FXCollections.observableArrayList();
    ObservableList list2 = FXCollections.observableArrayList();
    
    //MENÜKEZELÉS ==== MENÜKEZELÉS ==== MENÜKEZELÉS ==== MENÜKEZELÉS ==== MENÜKEZELÉS
    @FXML
    void handlePlayButtonPushed() {
        //adott pane engedélyezése
        playPane.setVisible(true);
        playPane.setDisable(false);
        //Többi eltűntetése
        managePane.setVisible(false);
        managePane.setDisable(true);
        addFighterPane.setVisible(false);
        addFighterPane.setDisable(true);
    }
    @FXML
    void handleManageButtonPushed() {
        //adott pane engedélyezése
        managePane.setVisible(true);
        managePane.setDisable(false);
        //Többi eltűntetése
        playPane.setVisible(false);
        playPane.setDisable(true);
        addFighterPane.setVisible(false);
        addFighterPane.setDisable(true);
        
    }
    
    @FXML
    void handleAddFighterButtonPushed() {
        //adott pane engedélyezése
        addFighterPane.setVisible(true);
        addFighterPane.setDisable(false);
        
        managePane.setVisible(false);
        managePane.setDisable(true);
        playPane.setVisible(false);
        playPane.setDisable(true);
    }
    
     @FXML
    void handleHomeButtonPushed() {
        playPane.setVisible(false);
        playPane.setDisable(true);
        managePane.setVisible(false);
        managePane.setDisable(true);
        addFighterPane.setVisible(false);
        addFighterPane.setDisable(true);
    }
    //MENÜKEZELÉS ==== MENÜKEZELÉS ==== MENÜKEZELÉS ==== MENÜKEZELÉS ==== MENÜKEZELÉS
    
   // Itt a LOAD gomb megnezi hogy kit szeretnel betolteni es azt rakja a Labelekre
    @FXML
    void handleLoadButtonPushed() {
        
        
        for (int i=0; i<model.getList().size(); i++){
            if (ChooseFighter.getValue().equals(model.getList().get(i).getName())) {
                 nameLabel.textProperty().bind(model.getList().get(i).nameProperty());
                 attackLabel.setText("" + model.getList().get(i).getAttack());
                 defendLabel.setText("" + model.getList().get(i).getDefend());
                 levelLabel.setText("" + model.getList().get(i).getLevel2());
            }
            
        }
             
     /*   if (Fighter.getValue().equals("DOM")){
        nameLabel.textProperty().bind(model.getList().get(0).nameProperty());

        attackLabel.setText("" + model.getFighter().getAttack());

        defendLabel.setText(""+model.getFighter().getDefend());

        levelLabel.setText(""+model.getFighter().getLevel2());
        }
        else {
        
        nameLabel.textProperty().bind(model.getFighter2().nameProperty());

        attackLabel.setText("" + model.getFighter2().getAttack());

        defendLabel.setText(""+model.getFighter2().getDefend());

        levelLabel.setText(""+model.getFighter2().getLevel2());
        
        }
        */
     
    }
   
    
     
    @FXML
    void handleSaveToFileButtonPushed() throws IOException {
       /* try (FileOutputStream fos = new FileOutputStream("fighterss.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(model.getList().get(0));
        }
        
        
        
        */
       
        try {
         FileOutputStream fileOut =
         new FileOutputStream("fighters.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(model.getList());
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved in fighters.ser");
      } catch (IOException i) {
         i.printStackTrace();
      }
   
    }
        
       
       
    @FXML
    void handleLoadFromFileButtonPushed() throws IOException, ClassNotFoundException {
       
        /*
        try (FileInputStream fis = new FileInputStream("fighterss.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            Fighter s = (Fighter) ois.readObject();
           model.getList().get(0).setName(s.getName());
            model.getList().get(0).setDefend(s.getDefend());
            model.getList().get(0).setAttack(s.getAttack());
            model.getList().get(0).setLevel(s.getLevel());
        }
        
        */
        
        List<Fighter> e = new ArrayList<>();
        
        try {
         FileInputStream fileIn = new FileInputStream("fighters.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         e = (List<Fighter>) in.readObject();
         in.close();
         fileIn.close();
      } catch (IOException i) {
         i.printStackTrace();
         return;
      } catch (ClassNotFoundException c) {
         System.out.println("Employee class not found");
         c.printStackTrace();
         return;
      }
        
        list.clear();
        list2.clear();
        
        model.setList(e);
        
        for (int i = 0; i < e.size(); i++) {
                
                list.add(e.get(i).getName());
                list2.add(e.get(i).getName());
            }
        
       Refresh();
        
    }
    
    // Itt toltom be a FightingScene.fxml-t a Choose Fighter AnchorPane-rol
    // UI: nem mukodik meg rendesen a visszagomb sajnos,szoval meg buggos,es a Modell cuccokat sem tolti be
    
    @FXML
    void handleFightButtonPushed() throws IOException {
        
  
       
       
       // itt dol el a choiceboxbol hogy ki lesz a te harcosod es ki az ellenfel
       // es annak az adatait dobjuk at a Fighting scenere
       
        for (int i = 0; i < model.getList().size(); i++) {
            
            for (int k = 0; k < model.getList().size(); k++) {
                
                if (yourFighterA.getValue().equals(model.getList().get(i).getName()) && yourFighterB.getValue().equals(model.getList().get(k).getName())) {
                    
                    if (model.getList().get(i).getName().equals(model.getList().get(k).getName())) {
                        
                        choiceerror.setVisible(true);
                        break;
                        
                    }
                    
                    else {
                    
           FXMLLoader loader = new FXMLLoader(FXMLhomeSceneController.class.getResource("/fxml/FXMLFightingScene.fxml"));
           Scene scene = new Scene(loader.load());
           Stage stage = new Stage(StageStyle.DECORATED);
           stage.setTitle("Fight");
           stage.getIcons().add(new Image("/fxml/battle.png"));
           stage.setScene(scene);
       
           FXMLFightingSceneController controller = loader.getController();
           
           controller.initData(model.getList().get(i), model.getList().get(k));
           
            stage.show(); 
           
            choiceerror.setVisible(false);
                        }
                    }
            
                }
       
       
            
        }
           
      
           
       
            
                               
        
    }
    
    // uj jatekos hozzaadasa eseten frissitem a choiceboxokat
    
        void Refresh(){
      
        
        yourFighterA.getItems().clear();
        yourFighterB.getItems().clear();
        ChooseFighter.getItems().clear();
            
        yourFighterA.getItems().addAll(list);
        yourFighterA.setValue("DOM");
        yourFighterB.getItems().addAll(list2);
        yourFighterB.setValue("AKOS");
        ChooseFighter.getItems().addAll(list);
        ChooseFighter.setValue("DOM");
        
    }
    
        // Uj jatekos hozaadasa attributumokkal
        
    @FXML
    void handleAddButtonPushed() {
        double max = 50;
        double attack = 0;
        double defense = 0;
        
        attack = attackSlider.getValue();
        defense = defenseSlider.getValue();
        
        max = max - attack - defense;
        
        String v = FighterNameTextField.getText();
        
        for (int i=0; i<model.getList().size();i++) {
            if (v.equals(model.getList().get(i).getName()) || v.equals("")){
                
            Alert wrongname = new Alert(Alert.AlertType.ERROR);
            wrongname.setTitle("Wrong name");
            wrongname.setContentText("Name is already in use!");
            wrongname.setHeaderText(null);
            wrongname.showAndWait();
            break;
            
            }
            
            else {
                
                if(max == 0) {
                
                List<Fighter> temp = new ArrayList<>();
                temp.add(new Fighter(v, (int)attack, (int)defense, 1));
                temp.addAll(model.getList());
                model.setList(temp);
                list.add(v);
                list2.add(v);
                Refresh();
                break;
                } else {
                    Alert wrongattributes = new Alert(Alert.AlertType.ERROR);
                    wrongattributes.setTitle("Wront Attributes");
                    wrongattributes.setContentText("You have to use all of your attributes points, which is 50!");
                    wrongattributes.setHeaderText(null);
                    wrongattributes.showAndWait();
                   break;
                }
            }
        }

    }
    
        // Betolto fuggveny a ChoiceBoxokhoz
    
        private void LoadData() {
        list.removeAll(list);
        list2.removeAll(list2);
        
            
       
       
        String a = "DOM";
        String b = "AKOS";
        String c = "DANI";
        list.addAll(a, b, c);
        list2.addAll(b, c, a);
        yourFighterA.getItems().clear();
        yourFighterB.getItems().clear();
        ChooseFighter.getItems().clear();
        yourFighterA.getItems().addAll(list);
        yourFighterB.getItems().addAll(list2);
        ChooseFighter.getItems().addAll(list);
        ChooseFighter.setValue("DOM");
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
