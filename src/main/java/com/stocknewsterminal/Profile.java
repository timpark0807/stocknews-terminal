package com.stocknewsterminal;

public class Profile {

    String symbol;
    String companyName;
    Float latestPrice;
    Float high;
    Float low;

    public String getSymbol(){
        return symbol;
    }

    public void setSymbol(String symbol){
        this.symbol = symbol;
    }

    public String getCompanyName(){
        return companyName;
    }

    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

    public Float getLatestPrice(){
        return latestPrice;
    }

    public void setLatestPrice(Float latestPrice){
        this.latestPrice = latestPrice;
    }

    public Float getHigh(){
        return high;
    }

    public void setHigh(Float high){
        this.high = high;
    }

    public Float getLow(){
        return low;
    }

    public void setLow(Float low){
        this.low = low;
    }
}
