package edu.umb.cs680.hw13;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class StockQuoteObservable extends Observable{

    Map<String, Float> map = new HashMap<String, Float>();

    void changeQuote(String s,float x) {
        map.put(s, x);
        notifyObservers(new StockEvent(s,x));
        setChanged();
    }

}
