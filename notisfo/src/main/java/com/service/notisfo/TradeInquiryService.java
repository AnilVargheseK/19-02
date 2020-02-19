package com.service.notisfo;

import com.service.table.FileReadWrite;
import com.util.notisfo.PropertiesLoader;
import com.util.notisfo.Util;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import static java.lang.System.getProperty;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Properties;
import javax.net.ssl.HttpsURLConnection;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.json.JSONObject;

public class TradeInquiryService {

    private static final String DATA_FORMAT = "CSV:CSV";
    private static final String VERSION = "1.0";

//     public static String getTradesInquiry(String seqNo){
//        String srchFilter = "ALL";
//        String tradesInquiry=seqNo+","+srchFilter+","+",";
//         
//        return tradesInquiry;
//     }
    public String getAllTradeData(String nonce) throws Exception {

        String authorization = Util.getInqAuthorization();

//        String msgId = Util.getMsgId();
        System.out.println(nonce + "<- nonce");

        String postData = this.AllTradeRequestData();
        System.out.println("post Data  : " + postData);
//        String tradeInquirytHost = "www.devconnect2nse.com";
        String tradeInquirytHost = PropertiesLoader.getProperty("tradeinquiry.host");
        String tradeInquiryEndpoint = PropertiesLoader.getProperty("tradeinquiry.endpoint");
//        String tradeInquiryEndpoint = "/inquiry-fo/trades-inquiry";
        
//        String tradeInquiryEndpoint = "/inquiry-fo/trades-inquiry";
        String urlString = "https://" + tradeInquirytHost + tradeInquiryEndpoint;
        
        System.out.println(urlString);

        URL url = new URL(urlString);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", authorization);
        connection.setRequestProperty("nonce", nonce);
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = postData.getBytes("utf-8");
            os.write(input, 0, input.length);
            os.flush();
            os.close();
        }

        String responseLine = "";
        StringBuilder respone = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
//            StringBuilder respone = new StringBuilder();
            responseLine = null;
            while ((responseLine = br.readLine()) != null) {
//                    System.out.println(responseLine);
                respone.append(responseLine.trim());
            }
            System.out.println("respone  : " + respone.toString());
//                br.close();
        }
        System.out.println("resLine......");
        return respone.toString();
    }

    /////   
    public String AllTradeRequestData() throws Exception {

        
        JSONObject j = new JSONObject();
        JSONObject data = new JSONObject();
        data.put("msgId", Util.getMsgId());
        data.put("dataFormat", DATA_FORMAT);
        data.put("tradesInquiry", "0,ALL,,");   // 0 <- last sequence number
//        data.put("tradesInquiry", FileReadWrite.seqNumRead());   // 0 <- last sequence number
//        data.put("tradesInquiry", seqNumRead();   
        j.put("version", VERSION);
        j.put("data", data);

        System.out.println("trade request data: " + j);

        return j.toString();
    }

}
