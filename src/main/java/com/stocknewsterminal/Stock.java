package com.stocknewsterminal;

import java.util.Map;

public class Stock {

    static String ticker;
    static float price;
    static float high;
    static float low;
    static Map news;
    static String company;

    public Stock(String ticker) throws Exception {
        this.ticker = ticker;
        FetchAPI api = new FetchAPI(ticker);
        this.price = api.fetchPrice();
        this.high = api.fetchHigh();
        this.low = api.fetchLow();
        this.company = api.fetchCompany();
//        this.news = FetchAPI.fetchNews(ticker);
    }

    public String getTicker(){
        return ticker;
    }

    public float getPrice(){
        return price;
    }

    public Map getNews(){
        return news;
    }

    public float getHigh() {
        return high;
    }

    public float getLow() {
        return low;
    }

    public String getCompany() {
        return company;
    }

    public static void main(String[] args) {
    }


}
