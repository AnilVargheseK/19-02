package com.service.table;

import com.service.notisfo.TradeInquiryService;
import com.util.notisfo.Util;
import java.io.IOException;
import java.sql.SQLException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import samptable.Notis2;

public class TradeResJson {

    public static String getTradeRes() throws IOException, SQLException, Exception {

        TradeInquiryService tis=new TradeInquiryService();
        String json=tis.getAllTradeData(Util.getinstance().getNonce1());

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);
        System.out.println(jsonNode.toString());

//        JsonNode tradesInquiry = jsonData.get("tradesInquiry");
//        System.out.println(tradesInquiry);
        JsonNode status = jsonNode.path("status");
        System.out.println(status.getTextValue());
        String status1 = status.asText();
        System.out.println(status1);
//////////

//        List<String> items = Arrays.asList(status1.split("\\s*,\\s*"));
//        System.out.println("items  : " + items.toString());
////////////////////
        System.out.println("-----------------");

        JsonNode drNode = jsonNode.path("data");
//        Iterator<JsonNode> itr = drNode.getElements();
//        System.out.println("\n data :");
        JsonNode get = drNode.get("tradesInquiry");
        String tradesInquiry = get.asText();

        return tradesInquiry;
    }

    public static void main(String[] args) throws IOException, SQLException {
        //TradeResJson t = new TradeResJson();
//       t.getTradeRes();
//        Database db = new  Database();
//         db.create(null);

        Notis2 n = new Notis2();
        n.start();

    }
}
