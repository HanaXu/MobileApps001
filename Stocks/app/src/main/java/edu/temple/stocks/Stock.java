package edu.temple.stocks;

class Stock {
    private String symbol;
    private String name;
    private String price;

    Stock(String symbol, String name, String price) {
        this.symbol = symbol;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "Symbol: " + symbol + " Name: " +name + " Price: " + price;
    }
}
