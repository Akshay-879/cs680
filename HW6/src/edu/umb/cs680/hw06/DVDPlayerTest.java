package edu.umb.cs680.hw06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DVDPlayerTest {

    DVDPlayer DVD = DVDPlayer.getInstance();
    @Test

    public void Drawer_Closed_Not_Playing_Test(){

        DVD.Open_Close_Button_Pushed();
        State actual = DVD.getState();
        State expected = DrawerOpen.getInstance();
        assertEquals(expected,actual);

        DVD.changeState(DrawerClosedPlaying.getInstance());
        DVD.Play_Button_Pushed();
        actual = DVD.getState();
        expected = DrawerClosedPlaying.getInstance();
        assertEquals(expected,actual);

        DVD.changeState(DrawerClosedPlaying.getInstance());
        DVD.Stop_Button_Pushed();
        actual = DVD.getState();
        expected = DrawerClosedNotPlaying.getInstance();
        assertEquals(expected,actual);

    }

    @Test
    public void Drawer_Closed_Playing_Test(){

        DVD.changeState(DrawerClosedPlaying.getInstance());
        DVD.Open_Close_Button_Pushed();
        State actual = DVD.getState();
        State expected = DrawerOpen.getInstance();
        assertEquals(expected,actual);

        DVD.changeState(DrawerClosedPlaying.getInstance());
        DVD.Play_Button_Pushed();
        actual = DVD.getState();
        expected = DrawerClosedPlaying.getInstance();
        assertEquals(expected,actual);

        DVD.Stop_Button_Pushed();
        actual = DVD.getState();
        expected = DrawerClosedNotPlaying.getInstance();
        assertEquals(expected,actual);

    }

    @Test
    public void Drawer_Open_Test(){

        DVD.changeState(DrawerOpen.getInstance());
        DVD.Open_Close_Button_Pushed();
        State actual = DVD.getState();
        State expected = DrawerClosedNotPlaying.getInstance();
        assertEquals(expected,actual);

        DVD.changeState(DrawerOpen.getInstance());
        DVD.Play_Button_Pushed();
        actual = DVD.getState();
        expected = DrawerClosedPlaying.getInstance();
        assertEquals(expected,actual);

        DVD.changeState(DrawerOpen.getInstance());
        DVD.Stop_Button_Pushed();
        actual = DVD.getState();
        expected = DrawerOpen.getInstance();
        assertEquals(expected,actual);

    }

}