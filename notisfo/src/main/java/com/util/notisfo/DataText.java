package com.util.notisfo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DataText {

    public static void readData(String[] arrData) throws IOException {

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String strDate = formatter.format(date);

        File file = new File("F:\\Notis\\TexttradeFO" + strDate + ".txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

        for (String ar : arrData) {

            List<String> items = Arrays.asList(ar.split("\\s*,\\s*"));
            System.out.println("arrayitems  : " + items.toString());

            String seqNo = items.get(0);
            String mkt = items.get(1);
            String trdNo = items.get(2);
            String trdTm = items.get(3);
            long longtime = Long.valueOf(trdTm);;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
            Date time = new Date(longtime);
            String tradeTime = dateFormat.format(time);

            String tkn = items.get(4);
            String trdQty = items.get(5);
            String trdPrc = items.get(6);
            String bsFlg = items.get(7);
            String ordNo = items.get(8);
            String brnCd = items.get(9);
            String usrId = items.get(10);
            String proCli = items.get(11);
            String cliActNo = items.get(12);
            String cpCd = items.get(13);
            String remarks = items.get(14);
            String actTyp = items.get(15);
            String TCd = items.get(16);
            String ordTm = items.get(17);
            int time1 = Integer.parseInt(ordTm);
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
            Date resultdate = new Date(time1);
            String orderTime = sdf.format(resultdate);

            String booktype = items.get(18);
            String oppTmCd = items.get(19);
            String ctclId = items.get(20);
            String status = items.get(21);
            String TmCd = items.get(22);
            String sym = items.get(23);
            String ser = items.get(24);
            String inst = items.get(25);
            String expDt = items.get(26);
            String strPrc = items.get(27);
            String optType = items.get(28);

            bw.write(alignUtil.alignData(seqNo, 1, 8) + ",");
            bw.write(alignUtil.alignData(mkt, 1, 1) + ",");
            bw.write(alignUtil.alignData(trdNo, 1, 8) + ",");
            bw.write(alignUtil.alignData(tradeTime, 1, 8) + ",");
            bw.write(alignUtil.alignData(tkn, 1, 4) + ",");
            bw.write(alignUtil.alignData(trdQty, 1, 4) + ",");
            bw.write(alignUtil.alignData(trdPrc, 1, 4) + ",");
            bw.write(alignUtil.alignData(bsFlg, 1, 1) + ",");
            bw.write(alignUtil.alignData(ordNo, 1, 8) + ",");
            bw.write(alignUtil.alignData(brnCd, 1, 4) + ",");
            bw.write(alignUtil.alignData(usrId, 1, 5) + ",");
            bw.write(alignUtil.alignData(proCli, 1, 2) + ",");
            bw.write(alignUtil.alignData(cliActNo, 1, 20) + ",");
            bw.write(alignUtil.alignData(cpCd, 1, 12) + ",");
            bw.write(alignUtil.alignData(remarks, 1, 25) + ",");
            bw.write(alignUtil.alignData(actTyp, 1, 2) + ",");
            bw.write(alignUtil.alignData(TCd, 1, 2) + ",");
            bw.write(alignUtil.alignData(orderTime, 1, 8) + ",");
            bw.write(alignUtil.alignData(booktype, 1, 2) + ",");
            bw.write(alignUtil.alignData(oppTmCd, 1, 1) + ",");
            bw.write(alignUtil.alignData(ctclId, 1, 8) + ",");
            bw.write(alignUtil.alignData(status, 1, 1) + ",");
            bw.write(alignUtil.alignData(TmCd, 1, 5) + ",");
            bw.write(alignUtil.alignData(sym, 1, 10) + ",");
            bw.write(alignUtil.alignData(ser, 1, 2) + ",");
            bw.write(alignUtil.alignData(inst, 1, 6) + ",");
            bw.write(alignUtil.alignData(expDt, 1, 4) + ",");
            bw.write(alignUtil.alignData(strPrc, 1, 4) + ",");
            bw.write(alignUtil.alignData(optType, 1, 2) + ",");

            bw.write(System.getProperty("line.separator"));

        }
        bw.close();
    }

}
