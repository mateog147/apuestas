package models;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Round {
    //Atributos
    ArrayList<Player> players = new ArrayList<Player>();

    public static HashMap<Integer, String> horses = new HashMap<Integer, String>();



    //constructor
    public ArrayList<Player> getPlayers() {
        return players;
    }




    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }




    public Round() {
        for(int i=0;i<4;i++){
            this.players.add(new Player());
        }
        horses.put(1, "Mostufa");
        horses.put(2, "Omicron");
        horses.put(3, "Paracron");
        horses.put(4, "Trueno");
    }


    

    //metodos de clase
    public String bet(){
        int numberOfWins = 0;
        double price =0;
        int random = (int)  Math.floor(Math.random()*(4)+1);
        String winerHorse = horses.get(random);
        for (int i=0;i<4;i++) {
            if(winerHorse.equals(players.get(i).getHorse())){
                numberOfWins +=1;
            }
            price+=players.get(i).getBet();
        }
        if( numberOfWins>1){
            price = price / numberOfWins;
        }

        for (int i=0;i<4;i++) {
            if(winerHorse.equals(players.get(i).getHorse())){
                players.get(i).setFounds(players.get(i).getFounds()+(int)price+players.get(i).getBet());;
            }
            players.get(i).setBet(0, "null");
        }

        System.out.println("premio " + price);
        return (winerHorse);
    }

    public void gameOver(){
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/gameOverView.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene =new Scene(root);
            stage.setTitle("GAME OVER");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("Error al abrir");
        }
    }
    
}
