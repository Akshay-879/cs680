package edu.umb.cs680.hw06;

public interface State {

    DVDPlayer DVD = DVDPlayer.getInstance();

    void Open_Close_Button_Pushed();
    void Play_Button_Pushed();
    void Stop_Button_Pushed();

}

