package samptable;

import com.service.notisfo.TokenService;
import com.service.notisfo.TradeInquiryService;
import com.service.table.FileReadWrite;
import com.service.table.TradeResJson;
import com.service.table.TradeStructure;
import com.util.notisfo.DataText;
import com.util.notisfo.WriteTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import static java.rmi.Naming.list;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class Notis2 extends javax.swing.JFrame {

    public Notis2() throws IOException, SQLException {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        totalBuyValue = new javax.swing.JTextField();
        totalTradeValue = new javax.swing.JTextField();
        totalTrades = new javax.swing.JTextField();
        totalSellValue = new javax.swing.JTextField();
        Refresh = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Notis - FO");

        totalBuyValue.setEditable(false);
        totalBuyValue.setBackground(new java.awt.Color(255, 255, 255));
        totalBuyValue.setText("0");
        totalBuyValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalBuyValueActionPerformed(evt);
            }
        });

        totalTradeValue.setEditable(false);
        totalTradeValue.setBackground(new java.awt.Color(255, 255, 255));
        totalTradeValue.setText("0");
        totalTradeValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalTradeValueActionPerformed(evt);
            }
        });

        totalTrades.setEditable(false);
        totalTrades.setBackground(new java.awt.Color(255, 255, 255));
        totalTrades.setText("Total Trades");
        totalTrades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalTradesActionPerformed(evt);
            }
        });

        totalSellValue.setEditable(false);
        totalSellValue.setBackground(new java.awt.Color(255, 255, 255));
        totalSellValue.setText("0");
        totalSellValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalSellValueActionPerformed(evt);
            }
        });

        Refresh.setText("Refresh");
        Refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RefreshMouseClicked(evt);
            }
        });
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        jLabel2.setText("Total Buy Value");

        jLabel3.setText("Total Sell Value ");

        jLabel4.setText("Total Trade Value");

        jLabel5.setText("Total Trades");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Current Trade Date", "Seq No", "mkt", "Market Status", "Trade No", "Trade Time", "Token", "Trade Quantity", "Trade Price", "Trade Value", "Buy/Sell", "Order No", "Branch Code", "User Id", "Client Type", "Client account number", "cpCd", "Remarks", "Activity Type", "Transaction Code", "Order Time", "Book Type", "Opposite Broker Id", "CTCL code", "Trade Status", "Member Code", "Symbol", "Series", "Instrument", "Expiry Date", "Strike Price", "Option Type"
            }
        ));
        jTable1.setToolTipText("");
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setAutoscrolls(false);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setEnabled(false);
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalBuyValue, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalSellValue)))
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalTradeValue, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalTrades, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1107, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalBuyValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalTradeValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalSellValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalTrades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void totalBuyValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalBuyValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalBuyValueActionPerformed

    private void totalTradeValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalTradeValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalTradeValueActionPerformed

    private void totalTradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalTradesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalTradesActionPerformed

    private void totalSellValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalSellValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalSellValueActionPerformed

    public void loadTableData(){
        
        
    }
    Timer timer;
    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        // TODO add your handling code here:
        timer = new Timer(30000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Refresh.setEnabled(true);
                timer.stop();
            }
        });
        Refresh.setEnabled(false);
        timer.start();

        
        
//        javax.swing.Timer t = new javax.swing.Timer(5000, new ActionListener() {
//          public void actionPerformed(ActionEvent e) {
             
        try {
            TokenService token = new TokenService();
            token.login();

            String details = TradeResJson.getTradeRes();

            System.out.println("tradesInquiry: " + details);
            String ctrlRec = details.split("\\^")[0];
            System.out.println("Control Rec : " + ctrlRec);
            List<String> ctrl = Arrays.asList(ctrlRec.split("\\s*,\\s*"));
            System.out.println("ctrl  : " + ctrl.toString());
            Object[] array1 = ctrl.toArray();
            
            TradeStructure t = new TradeStructure(ctrl.get(0), ctrl.get(1), ctrl.get(2), ctrl.get(3), ctrl.get(4), ctrl.get(5));

            String dataRec = details.substring(details.indexOf("^") + 1);
            
//            if (dataRec==null){
//                System.out.println(" no datas ");
//            }
//            else{
            
            dataRec.trim();
            System.out.println("Data Records : " + dataRec);
            String[] arrData = dataRec.split("\\^");
            
            
            
            DataText.readData(arrData);
            
            DecimalFormat dfBuyValue = null;
            DecimalFormat dfSellValue = null;
            DecimalFormat dftotTradeValue1 = null;
            double totBuyValue = 0;
            double totSellValue = 0;
            double totTradeValue1 = 0;

            String textTotBuyValue = totalBuyValue.getText();
            totBuyValue = Double.parseDouble(textTotBuyValue);
            String textTotSellValue = totalSellValue.getText();
            totSellValue = Double.parseDouble(textTotSellValue);
            
            for (String a : arrData) {
                System.out.println("Array Trade : " + a);

                List<String> items = Arrays.asList(a.split("\\s*,\\s*"));
                System.out.println("arrayitems  : " + items.toString());
                Object[] array = items.toArray();
                double trdQty = Double.parseDouble(items.get(5));
                double trdPrc = Double.parseDouble(items.get(6)) / 100;
                String tradePrice = Double.toString(trdPrc);
                double trdVal = trdQty * trdPrc;
                String tradeValue = Double.toString(trdVal);

                
//                JtableData.setTableData(array);
                
                TradeStructure ts = new TradeStructure(items.get(0), items.get(1), items.get(2), items.get(3), items.get(4), items.get(5), items.get(6),
                        items.get(7), items.get(8), items.get(9), items.get(10), items.get(11), items.get(12),
                        items.get(13), items.get(14), items.get(15), items.get(16), items.get(17), items.get(18), items.get(19),
                        items.get(20), items.get(21), items.get(22), items.get(23), items.get(24), items.get(25), items.get(26), items.get(27), items.get(28));


//                FileReadWrite fw = new FileReadWrite();
//                fw.seqNumWrite(items.get(0));
//                fw.seqNumWrite(items.toString());

                DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
                tableModel.addRow(new Object[]{t.getCurrTrdDate(), ts.getSeqNo(), ts.getMkt(), t.getMktSts(), ts.getTrdNo(), ts.getTrdTm(), ts.getTkn(), ts.getTrdQty(), tradePrice, tradeValue,
                    ts.getBsFlg(), ts.getOrdNo(), ts.getBrnCd(), ts.getUsrId(), ts.getProCli(), ts.getCliActNo(),
                    ts.getCpCd(), ts.getRemarks(), ts.getActTyp(), ts.getTCd(), ts.getOrdTm(), ts.getBooktype(),
                    ts.getOppTmCd(), ts.getCtclId(), ts.getStatus(), ts.getTmCd(), ts.getSym(), ts.getSer(), ts.getInst(), ts.getExpDt(), ts.getStrPrc(), ts.getOptType()});
                
                
                 FileReadWrite fw = new FileReadWrite();
                fw.seqNumWrite(items.get(0));
                
                double price = Double.parseDouble(items.get(6));
                double buySell = Double.parseDouble(items.get(7));
                if (buySell == 1) {
                    totBuyValue = totBuyValue + trdVal;
                    dfBuyValue = new DecimalFormat("#.##");
                    dfBuyValue.format(totBuyValue);
                } else {
                    totSellValue = totSellValue + trdVal;
                    dfSellValue = new DecimalFormat("#.##");
                    dfSellValue.format(totSellValue);
                }

            }
            totTradeValue1 = totBuyValue + totSellValue;
            dftotTradeValue1 = new DecimalFormat("#.##");
            dftotTradeValue1.format(totTradeValue1);
            String textFieldValue = totalBuyValue.getText();
            totalBuyValue.setText(dfBuyValue.format(totBuyValue));
//            totalSellValue.setText(Double.toString(totSellValue));
            totalSellValue.setText(dfSellValue.format(totSellValue));
            totalTradeValue.setText(dftotTradeValue1.format(totTradeValue1));
            
// }
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Notis2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Notis2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Notis2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

          try {
            WriteTable.setTableData(jTable1);
        } catch (IOException ex) {
            Logger.getLogger(Notis2.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          
          
          
//            }
//       });
//        t.start();

    }//GEN-LAST:event_RefreshActionPerformed

    private void RefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RefreshMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_RefreshMouseClicked

    // public static void main(String args[])
    public void start() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Notis2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Notis2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Notis2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notis2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Notis2().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Notis2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Notis2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Refresh;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField totalBuyValue;
    private javax.swing.JTextField totalSellValue;
    private javax.swing.JTextField totalTradeValue;
    private javax.swing.JTextField totalTrades;
    // End of variables declaration//GEN-END:variables

}
