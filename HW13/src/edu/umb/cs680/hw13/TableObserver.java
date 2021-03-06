package edu.umb.cs680.hw13;

import java.util.Observable;
import java.util.Observer;

public class TableObserver implements Observer{

    private String ticker;
    private double quote;

    public void update(Observable o, Object o1) {

        if(o instanceof StockQuoteObservable) {
            ticker = ((StockEvent)o1).getTicker();
            quote = ((StockEvent) o1).getQuote();
        }

        else if(o instanceof DJIAQuoteObservable) {
            quote = ((DJIAEvent) o1).getDija();
        }
    }
}