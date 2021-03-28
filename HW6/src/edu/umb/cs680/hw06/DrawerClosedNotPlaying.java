package edu.umb.cs680.hw06;

public class DrawerClosedNotPlaying implements State{

    private DrawerClosedNotPlaying() {

    }

    private static DrawerClosedNotPlaying instance = null;

    public static DrawerClosedNotPlaying getInstance(){
        if(instance==null)
            instance = new DrawerClosedNotPlaying();
        return instance;
    }

    public void Open_Close_Button_Pushed() {
        DVD.Open();
        DVD.changeState(DrawerOpen.getInstance());
    }

    public void Play_Button_Pushed() {
        DVD.Play();
        DVD.changeState(DrawerClosedPlaying.getInstance());
    }

    public void Stop_Button_Pushed() {
        DVD.Pause();
        System.out.println("DVD Player Stopped Playing");
    }

}
