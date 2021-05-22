package edu.umb.cs680.hw13;

import java.util.Observable;

public class DJIAQuoteObservable extends Observable {

    float quote;
    void changeQuote(float x) {
        this.quote = x;
        setChanged();
        notifyObservers(new DJIAEvent(x));
    }

}
