package edu.umb.cs680.hw06;

public class DrawerOpen implements State{

    private DrawerOpen(){

    }

    private static DrawerOpen instance = null;

    public static DrawerOpen getInstance(){
        if(instance==null)
            instance = new DrawerOpen();
        return instance;
    }

    public void Open_Close_Button_Pushed() {
        DVD.Close();
        DVD.changeState(DrawerClosedNotPlaying.getInstance());
    }

    public void Stop_Button_Pushed() {
        DVD.Pause();
        System.out.println("Playing Stopped");
    }

    public void Play_Button_Pushed() {
        DVD.Close();
        DVD.Play();
        DVD.changeState(DrawerClosedPlaying.getInstance());
    }

}
