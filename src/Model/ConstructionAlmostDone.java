package Model;

import java.awt.*;
import java.util.Random;

public class ConstructionAlmostDone {
    private String id;
    private int[] location;
    private Road roadAttachedTo;
    private int waitingTime = 3;
    private String status;

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int[] getLocation() {
        return location;
    }

    public void setLocation(int[] location) {
        this.location = location;
    }

    public Road getRoadAttachedTo() {
        return roadAttachedTo;
    }

    public void setRoadAttachedTo(Road roadAttachedTo) {
        this.roadAttachedTo = roadAttachedTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ConstructionAlmostDone(String id , Road roadAttachedTo){
        this.id = "construction_" + id;
        this.roadAttachedTo = roadAttachedTo;
        status = "done";
        location = new int[]{(roadAttachedTo.getEndLocation()[0] - roadAttachedTo.getStartLocation()[0]) /2,
                (roadAttachedTo.getEndLocation()[1] - roadAttachedTo.getStartLocation()[1]) /2};
        this.roadAttachedTo.getConstructionAlmostDoneList().add(this);
    }

    public void initializeConstructions(){
        if(waitingTime == 0){
            if(status.equals("done")){
                setStatus("processing");
            }
            else{
                setStatus("done");
            }
            waitingTime = 3;
        }
        waitingTime --;
    }

    public void printStatus(){
        System.out.printf("%s on %s at position (%s, %s) will be %s in %s %n ", this.getId(), this.getRoadAttachedTo().getId(),
                this.location[0], this.location[1], this.getStatus(), this.getWaitingTime() );
    }
    public void draw(Graphics g, int scale){
        if(roadAttachedTo.getOrientation() == Road.Orientation.HORIZONTAL){
            if(status.equals("done") ){
                g.setColor(Color.MAGENTA);
            }
            else {
            g.setColor(Color.RED);
            }
            int[] startLocation = getRoadAttachedTo().getStartLocation();
            int x = (getLocation()[0] + startLocation[0]) * scale;
            int y = startLocation[1] * scale;
            int height = (getRoadAttachedTo().getWidth() / 2) * scale;
            g.fillRect(x, y, scale, height);
        }
        else{
            if(status.equals("done")){
                g.setColor(Color.MAGENTA);
            }
            else {
                g.setColor(Color.RED);
            }
            int[] startLocation = getRoadAttachedTo().getStartLocation();
            int x = (startLocation[0] + (getRoadAttachedTo().getWidth() / 2)) * scale;
            int y = (getLocation()[0] + startLocation[1]) * scale;
            int width = (getRoadAttachedTo().getWidth() / 2) * scale;
            g.fillRect(x, y, width, scale);
        }

    }
}
