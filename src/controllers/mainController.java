package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Round;

public class mainController {

    Round game;

    @FXML
    private TextField betPlayer1;

    @FXML
    private TextField betPlayer2;

    @FXML
    private TextField betPlayer3;

    @FXML
    private TextField betPlayer4;

    @FXML
    private Button continueBtn;

    @FXML
    private ImageView finImg;

    @FXML
    private ImageView horseImg;

    @FXML
    private ChoiceBox<String> horsePlayer1;

    @FXML
    private ChoiceBox<String> horsePlayer2;

    @FXML
    private ChoiceBox<String> horsePlayer3;

    @FXML
    private ChoiceBox<String> horsePlayer4;

    @FXML
    private Label moneyPlayer1;

    @FXML
    private Label moneyPlayer2;

    @FXML
    private Label moneyPlayer3;

    @FXML
    private Label moneyPlayer4;

    @FXML
    private Button playBtn;

    @FXML
    private ProgressBar progress;

    @FXML
    private Label winHorseLbl;

    @FXML
    private Label winLbl;

    @FXML
    void continueGame(MouseEvent event) {
        int counter=0;
        setScreen();
        horseImg.setVisible(false);
        finImg.setVisible(false);
        progress.setProgress(0);
        winHorseLbl.setVisible(false);
        winLbl.setVisible(false);
        continueBtn.setVisible(false);

        if(this.game.getPlayers().get(0).getFounds()<=0){
            counter+=1;
            betPlayer1.setText("0");
            betPlayer1.setDisable(true);
            horsePlayer1.setValue("Eliminado");
            horsePlayer1.setDisable(true);
        }
        if(this.game.getPlayers().get(1).getFounds()<=0){
            counter+=1;
            betPlayer2.setText("0");
            betPlayer2.setDisable(true);
            horsePlayer2.setValue("Eliminado");
            horsePlayer2.setDisable(true);
        }
        if(this.game.getPlayers().get(2).getFounds()<=0){
            counter+=1;
            betPlayer3.setText("0");
            betPlayer3.setDisable(true);
            horsePlayer3.setValue("Eliminado");
            horsePlayer3.setDisable(true);
        }
        if(this.game.getPlayers().get(3).getFounds()<=0){
            counter+=1;
            betPlayer4.setText("0");
            betPlayer4.setDisable(true);
            horsePlayer4.setValue("Eliminado");
            horsePlayer4.setDisable(true);
        }

        if(counter==4){
            gameOver();
        }

    }

    @FXML
    void play(MouseEvent event) {
        this.game.getPlayers().get(0).setBet(Integer.parseInt(betPlayer1.getText()), horsePlayer1.getValue());
        this.game.getPlayers().get(1).setBet(Integer.parseInt(betPlayer2.getText()), horsePlayer2.getValue());
        this.game.getPlayers().get(2).setBet(Integer.parseInt(betPlayer3.getText()), horsePlayer3.getValue());
        this.game.getPlayers().get(3).setBet(Integer.parseInt(betPlayer4.getText()), horsePlayer4.getValue());
        race();
    }

    @FXML
    void initialize(){
        ObservableList<String> horses = FXCollections.observableArrayList("Mostufa","Omicron","Paracron","Trueno");
        horsePlayer1.setItems(horses) ;
        horsePlayer2.setItems(horses) ;
        horsePlayer3.setItems(horses) ;
        horsePlayer4.setItems(horses) ;

        this.game = new Round();
        setScreen();
    }

    void setScreen(){
        moneyPlayer2.setText (String.valueOf(this.game.getPlayers().get(1).getFounds()));
        moneyPlayer3.setText (String.valueOf(this.game.getPlayers().get(2).getFounds()));
        moneyPlayer1.setText (String.valueOf(this.game.getPlayers().get(0).getFounds()));
        moneyPlayer4.setText (String.valueOf(this.game.getPlayers().get(3).getFounds()));
    }

    void race() {
        
        horseImg.setVisible(true);
        finImg.setVisible(true);
        progress.setProgress(100);
        winHorseLbl.setVisible(true);
        winLbl.setVisible(true);
        continueBtn.setVisible(true);
        winHorseLbl.setText(this.game.bet());
    }

    void gameOver(){
        game.gameOver();
        Stage thisStage = (Stage) this.winLbl.getScene().getWindow();
        thisStage.close();
    }

}

