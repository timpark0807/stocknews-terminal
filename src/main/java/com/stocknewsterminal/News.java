package com.stocknewsterminal;

public class News {

    String headline;
    String url;
    String source;

    public String getHeadline(){
        return headline;
    }

    public void setHeadline(String headline){
        this.headline = headline;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getSource(){
        return source;
    }

    public String setSource(){
        return source;
    }

    @Override
    public String toString() {
        return String.format(
                "{headline=%s, url=%s, source=%s}",
                headline, url, source);
    }

}
