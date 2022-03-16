package gameplay;
//таблица данных
//

import java.util.ArrayList;

public class Gameplay {
    private ArrayList<Step> stepArrayList = new ArrayList<>();


    public void addStep(int indexI,int indexJ,int playerID) {
        this.stepArrayList.add(new Step(indexI,indexJ,playerID));
    }

    public ArrayList<Step> getStepArrayList() {
        return stepArrayList;
    }
}
