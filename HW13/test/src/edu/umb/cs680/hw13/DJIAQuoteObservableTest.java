package edu.umb.cs680.hw13;

import org.junit.jupiter.api.Test;


class DJIAQuoteObservableTest {

    PiechartObserver PiechartObserver = new PiechartObserver();
    TableObserver TableObserver = new TableObserver();
    ThreeDObserver THREEDObserver = new ThreeDObserver();

    @Test
    void verificationdijaquote() {

        DJIAQuoteObservable djiaObserver = new DJIAQuoteObservable();
        djiaObserver.addObserver(PiechartObserver);
        djiaObserver.addObserver(TableObserver);
        djiaObserver.addObserver(THREEDObserver);

        djiaObserver.changeQuote(50);
        djiaObserver.changeQuote(60);
    }
}