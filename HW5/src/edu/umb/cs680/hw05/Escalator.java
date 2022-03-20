package edu.umb.cs680.hw05;

public class Escalator {
    private static State state;
    private static Escalator escalator;

    private Escalator(){}

    public static Escalator getInstance() {
        if(escalator == null){
            escalator = new Escalator();
            state = Stopped.getInstance();
        }
        return escalator;
    }

    public State getState(){
        return state;
    }

    public void changeState(State newState){
        Escalator.state = newState;
    }

    public void startButtonPushed(){
        state.startButtonPushed();
    }

    public void stopButtonPushed(){
        state.stopButtonPushed();
    }

    public void motionDetected(){
        state.motionDetected();
    }
    public void motionNotDetected(){
        state.motionNotDetected();
    }

    public void moveSteps(){
        System.out.println("Steps moved");
    }

    public void stopSteps(){
        System.out.println("Steps stopped");
    }

    public void enableSensor(){
        System.out.println("Steps enabled");
    }

    public void disableSensor(){
        System.out.println("Steps disabled");
    }

    public static void main(String[] args) {

    }
}
