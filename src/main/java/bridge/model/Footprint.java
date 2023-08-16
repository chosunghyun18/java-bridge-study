package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Footprint {
    private ArrayList<String> footprint;

    public Footprint(ArrayList<String> footprint) {
        this.footprint = footprint;
    }

    private void makeNewFootprint(boolean isCorrect) {
        if (isCorrect) {
            footprint.add("O");
        }
        if (!isCorrect){
            footprint.add("X");
        }
    }

    public List<String> getFootprint() {
        return footprint;
    }
}
