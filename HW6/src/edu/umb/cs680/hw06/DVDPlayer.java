package edu.umb.cs680.hw06;

public class DVDPlayer {

    private static DVDPlayer instance = null;
    private static State state;

    private DVDPlayer(State state) {
        this.state = state;
    }

    public static DVDPlayer getInstance(){
        if(instance==null){
            state = DrawerClosedNotPlaying.getInstance();
            instance = new DVDPlayer(state);
        }
        return instance;
    }

    public void changeState(State s){
        state = s;
    }

    public void Open_Close_Button_Pushed(){
        state.Open_Close_Button_Pushed();
    }

    public void Stop_Button_Pushed(){
        state.Stop_Button_Pushed();
    }


    public void Play_Button_Pushed(){
        state.Play_Button_Pushed();
    }

    public void Open(){
        System.out.println("Open...");
    }

    public void Close(){
        System.out.println("Close...");
    }

    public void Play(){
        System.out.println("Playing Media...");
    }

    public void Pause(){
        System.out.println("Pausing Media...");
    }

    public State getState() {
        return state;
    }

    public static void main(String[] args) {
        DVDPlayer DVD = DVDPlayer.getInstance();
        DVD.Open_Close_Button_Pushed();
        DVD.Play_Button_Pushed();
        DVD.Stop_Button_Pushed();
    }

}
