package edu.umb.cs680.hw05;

public class StandBy implements State{

    private static StandBy standBy;
    private static Escalator escalator;

    private StandBy(){
        escalator = Escalator.getInstance();
    }

    public static StandBy getInstance() {
        if(standBy == null){
            standBy = new StandBy();
        }
        return standBy;
    }

    @Override
    public void startButtonPushed() {
        escalator.moveSteps();
    }

    @Override
    public void stopButtonPushed() {
        escalator.disableSensor();
        escalator.stopSteps();
        escalator.changeState(Stopped.getInstance());
    }

    @Override
    public void motionDetected() {
        escalator.moveSteps();
        escalator.changeState(Operating.getInstance());
    }

    @Override
    public void motionNotDetected() {
        System.out.println("Do nothing");
    }

    public static void main(String[] args) {

    }
}
