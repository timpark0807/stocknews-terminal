package com.stocknewsterminal;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class Stock {

    private News[] news;
    private Profile profile;
    private String jsonStringNews;
    private String jsonStringInfo;

    public Stock(String ticker) throws Exception {
        JSONStringBuilder jsonStringBuilder = new JSONStringBuilder(ticker);
        String jsonStringNews = jsonStringBuilder.getJsonStringNews();
        String jsonStringProfile = jsonStringBuilder.getJsonStringProfile();
        this.profile = buildProfile(jsonStringProfile);

//        Gson gson = new Gson();
//        News[] news = gson.fromJson(jsonStringNews, News[].class);
        this.news = buildNews(jsonStringNews);
        for (News i : news) {
            System.out.println(i.getHeadline());
            System.out.println(i.getUrl());
        }

    }

    private Profile buildProfile(String jsonString){
        Gson gson = new Gson();
        Profile profile = gson.fromJson(jsonString, Profile.class);
        return profile;
    }

    public News[] buildNews(String jsonString){
        Gson gson = new Gson();
        News[] news = gson.fromJson(jsonString, News[].class);
        return news;
    }

    public String getPriceLatest(){
        return Float.toString(profile.getLatestPrice());
    }

    public String getPriceHigh(){
        return Float.toString(profile.getHigh());
    }

    public String getPriceLow(){
        return Float.toString(profile.getLow());
    }

    public String getSymbol(){
        return profile.getSymbol();
    }

    public News[] getNews(){
        return news;
    }

    public String getCompanyName() {
        return profile.getCompanyName();
    }

}
