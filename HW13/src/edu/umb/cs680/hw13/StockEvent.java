package edu.umb.cs680.hw13;

public class StockEvent {

    public float quote;
    public String ticker;


    public StockEvent(String s, float x) {
        this.ticker = s;
        this.quote = x;
    }

    public float getQuote() {
        return quote;
    }

    public String getTicker() {
        return ticker;
    }
}
