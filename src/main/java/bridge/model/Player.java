package bridge.model;

import java.util.ArrayList;

public class Player {
    private Footprint footprint;
    private int currentPlayerLocation;
    private int retryTime=0;
    private boolean isSuccess = false;

    public Player(Footprint footprint, int currentLocation) {
        this.footprint = footprint;
        this.currentPlayerLocation = currentLocation;
    }

    public void intializeData() {
        footprint = new Footprint(new ArrayList<>());
        currentPlayerLocation =0;
    }

    public Footprint getFootprint() {
        return footprint;
    }

    public void moveForword() {
        currentPlayerLocation +=1;
    }

    public int getLocation() {
        return currentPlayerLocation;
    }

    public void initializeTryTime() {
        retryTime = 1;
    }

    public void retryTimeUp() {
        retryTime +=1;
    }

    public int getRetryTime() {
        return retryTime;
    }

    public void success() {
        isSuccess = true;
    }

    public String getIsSuccess() {
        if(isSuccess){
            return "성공";
        }
            return "실패";
    }
}
