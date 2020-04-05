package com.stocknewsterminal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONStringBuilder {

        private String ticker;

        public JSONStringBuilder(String ticker) {
            this.ticker = ticker;
        }

        public String getJsonStringNews() throws Exception {
            String newsUrl = "https://cloud.iexapis.com/stable/stock/%s/news?last=10&token=ENTERTOKENHERE";
            HttpURLConnection con = getHttpURLConnection(newsUrl);
            String jsonString = getJSONString(con);
            return jsonString;
        }

        public String getJsonStringProfile() throws Exception {
            String apiUrl = "https://cloud.iexapis.com/stable/stock/%s/quote?token=ENTERTOKENHERE";
            HttpURLConnection con = getHttpURLConnection(apiUrl);
            String jsonString = getJSONString(con);
            return jsonString;
        }

        private HttpURLConnection getHttpURLConnection(String request_url) throws Exception {
            URL url = new URL(String.format(request_url, ticker));
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            return con;
        }

        private String getJSONString(HttpURLConnection con) throws Exception {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        }

    }

