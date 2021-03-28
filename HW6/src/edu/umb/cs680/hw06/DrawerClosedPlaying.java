package edu.umb.cs680.hw06;

public class DrawerClosedPlaying implements State{

    private DrawerClosedPlaying() {

    }

    private static DrawerClosedPlaying instance = null;

    public static DrawerClosedPlaying getInstance(){
        if(instance == null)
            instance = new DrawerClosedPlaying();
        return instance;
    }

    public void Open_Close_Button_Pushed() {
        DVD.Pause();
        DVD.Open();
        DVD.changeState(DrawerOpen.getInstance());
    }

    public void Play_Button_Pushed() {
        DVD.Play();
        System.out.println("Playing");
    }

    public void Stop_Button_Pushed() {
        DVD.Pause();
        DVD.changeState(DrawerClosedNotPlaying.getInstance());
    }
}
