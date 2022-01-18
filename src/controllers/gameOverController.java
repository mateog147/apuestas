
package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class gameOverController {

    @FXML
    private Button jugarBtn;

    @FXML
    void playAgain(MouseEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/main.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene =new Scene(root);
            stage.setTitle("Apuestas");
            stage.setScene(scene);
            stage.show();
            Stage thisStage = (Stage) this.jugarBtn.getScene().getWindow();
            thisStage.close();
        } catch (Exception e) {
            System.out.println("erro al abrir de nuevo");
        }
        
    }

}

