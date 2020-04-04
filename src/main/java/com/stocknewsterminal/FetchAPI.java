package com.stocknewsterminal;


import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class FetchAPI {

    static String api_url = "https://cloud.iexapis.com/stable/stock/%s/quote?token=pk_9c9d7383c24748a8adaa5d85544c5fa9";
    static JSONObject jsonResponse;

    public FetchAPI(String ticker) throws Exception {
        // Set URL and GET
        URL url = new URL(String.format(api_url, ticker));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        jsonResponse = getJSON(con);
    }

    private JSONObject getJSON(HttpURLConnection con) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return new JSONObject(response.toString());
    }

    public static String fetchCompany() {
        return jsonResponse.getString("companyName");
    }

    public static float fetchPrice() {
        return jsonResponse.getFloat("latestPrice");
    }

    public static float fetchHigh() {
        return jsonResponse.getFloat("high");
    }

    public static float fetchLow() {
        return jsonResponse.getFloat("low");
    }

//    public static void main(String[] args) throws Exception {
//        URL url = new URL(api_url);
//        HttpURLConnection con = (HttpURLConnection) url.openConnection();
//        con.setRequestMethod("GET");
//
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(con.getInputStream()));
//        String inputLine;
//        StringBuffer response = new StringBuffer();
//        while ((inputLine = in.readLine()) != null) {
//            response.append(inputLine);
//        }
//        in.close();
//        //print in String
//        System.out.println(response);
//        //Read JSON response and print
//        JSONObject myResponse = new JSONObject(response.toString().trim());
//        System.out.println("statusCode- "+myResponse.getString("datetime"));
//    }
}
