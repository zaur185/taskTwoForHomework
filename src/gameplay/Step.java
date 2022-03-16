package gameplay;

public class Step {
    private int idStep;
    private int indexI;
    private int indexJ;
    private int playerID;


    public Step(int idStep, int indexI, int indexJ,int playerID){
        this.idStep = idStep;
        this.indexI = indexI;
        this.indexJ = indexJ;
        this.playerID = playerID;
    }

    public void setIdStep(int idStep) {
        this.idStep = idStep;
    }

    public void setIndexI(int indexI) {
        this.indexI = indexI;
    }

    public void setIndexJ(int indexJ) {
        this.indexJ = indexJ;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }




    public String getIdStep() {
        return Integer.toString(idStep);
    }

    public String getIndexI() {
        return Integer.toString(indexI);
    }



    public String getIndexJ() {
        return Integer.toString(indexJ);
    }

    public String  getPlayerID() {
        return Integer.toString(playerID);
    }
}
