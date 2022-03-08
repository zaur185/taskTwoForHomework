package player;

public class Player {
    private String name;

    private int wins;

    public Player(String name){
        this.name = name;
        this.wins =0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWins(boolean wins) {
        if(wins==true)this.wins+=1;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }
}
