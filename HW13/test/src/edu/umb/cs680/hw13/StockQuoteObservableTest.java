package edu.umb.cs680.hw13;

import org.junit.jupiter.api.Test;

class StockQuoteObservableTest {

    @Test
    void verificationdijaquote() {
        PiechartObserver PiechartObserver = new PiechartObserver();
        TableObserver TableObserver = new TableObserver();
        ThreeDObserver THREEDObserver = new ThreeDObserver();

        StockQuoteObservable djiaObserver = new StockQuoteObservable();
        djiaObserver.addObserver(PiechartObserver);
        djiaObserver.addObserver(TableObserver);
        djiaObserver.addObserver(THREEDObserver);
        djiaObserver.changeQuote("Akshay",50);
        djiaObserver.changeQuote("Chinmay",60);
    }
}