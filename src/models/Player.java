package models;

public class Player {
    //Atributos
    private int founds;
    private int bet;
    private String horse;
    
    //Constructores
    public Player(int founds) {
        this.founds = founds;
    }

    public Player() {
        this.founds= 20000;
    }

    //Setters y getters
    public int getFounds() {
        return founds;
    }

    public void setFounds(int founds) {
        this.founds = founds;
    }

    public int getBet() {
        return bet;
    }


    public String getHorse() {
        return horse;
    }

    public void setHorse(String horse) {
        this.horse = horse;
    }
    //metodos de la clase
    public void setBet(int bet, String horse){
        if(bet<=this.founds){
            this.bet=bet;
        }else{
            this.bet=this.founds;
        }
        this.founds-=this.bet;
        this.horse = horse;
    }

    
}
