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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dani
 */
public class FXMLFightingSceneController implements Initializable {

    private Model model;
    Fighter winner;

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
    private Label updateMessage;

    @FXML
    private ProgressBar progressbar;

    @FXML
    private Button startButton;

    @FXML
    private Button closeButton;

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

        winner = Fight(You, Opponent);

        updateMessage.setText("");

    }

    public Fighter Fight(Fighter Fighter1, Fighter Fighter2) {

        Fighter you = Fighter1;
        Fighter opponent = Fighter2;

        if (you.getAttack() > opponent.getDefend()) {
            return you;
        } else if (you.getAttack() < opponent.getDefend()) {
            return opponent;
        } else {
            return opponent;
        }

    }

    @FXML
    void handleStartButtonPushed() {
        updateMessage.setText("Fighting...");
        //startButton.setDisable(true);
        
        progressbar.setProgress(0);
        Task startProgressBar = ProgressBarTask();

        progressbar.progressProperty().unbind();
        progressbar.progressProperty().bind(startProgressBar.progressProperty());

        startProgressBar.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, //
                new EventHandler<WorkerStateEvent>() {

            @Override
            public void handle(WorkerStateEvent t) {
                updateMessage.setText("Winner: " + winner.getName());
            }
        });
        new Thread(startProgressBar).start();

    }

    //starting fake progress bar
    Task ProgressBarTask() {
        return new Task() {
            protected Object call() throws Exception {
                for (int i = 0; i < 70; i++) {
                    Thread.sleep(70);
                    //updateMessage("70 milliseconds");
                    updateProgress(i + 1, 70);
                    //System.out.println(progressbar.getProgress());
                }
                return true;
            }
        };
    }

    @FXML
    void handleCloseButtonPushed(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
