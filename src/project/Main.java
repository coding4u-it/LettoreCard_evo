
package project;

import dbconnect.GestDBmyLiteSwing;
import file.FileOperazioni;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.smartcardio.CardException;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lettoreCard.Anagrafica;
import lettoreCard.Carta;
import lettoreCard.CnsProva;


/*
 * Copyright 2020 france.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class Main extends javax.swing.JFrame {
    Carta cd;
    Anagrafica objAnagrafica;
    GestDBmyLiteSwing objDB=new GestDBmyLiteSwing("include/comuni");
    CnsProva objCns;
    DefaultTableModel model;
    FileOperazioni objFile;
    
    public Main() {
        this.objCns = new CnsProva();
        initComponents();
        model = (DefaultTableModel) tblView.getModel();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbgScelta = new javax.swing.ButtonGroup();
        tbpMain = new javax.swing.JTabbedPane();
        pnlCns = new javax.swing.JPanel();
        btnLeggi = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        lblLettura = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaStampa = new javax.swing.JTextArea();
        lblNome = new javax.swing.JLabel();
        lblCf = new javax.swing.JLabel();
        lblSex = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCF = new javax.swing.JTextField();
        txtSex = new javax.swing.JTextField();
        lblCognome = new javax.swing.JLabel();
        txtCognome = new javax.swing.JTextField();
        lblData = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        lblComNascita = new javax.swing.JLabel();
        txtCatComNascita = new javax.swing.JTextField();
        lblComResid = new javax.swing.JLabel();
        txtCatComResid = new javax.swing.JTextField();
        btnExit = new javax.swing.JButton();
        btnCreaCsv = new javax.swing.JButton();
        btnCatToNome = new javax.swing.JButton();
        txtComNascita = new javax.swing.JTextField();
        txtComResidenza = new javax.swing.JTextField();
        cbxApdu = new javax.swing.JComboBox<>();
        lblDataRil = new javax.swing.JLabel();
        lblDataSca = new javax.swing.JLabel();
        pnlComuni = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblView = new javax.swing.JTable();
        rbtComune = new javax.swing.JRadioButton();
        rbtCodice = new javax.swing.JRadioButton();
        txtInsert = new javax.swing.JTextField();
        btnCerca = new javax.swing.JButton();
        btnConnectDB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnLeggi.setText("Leggi");
        btnLeggi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeggiActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        lblLettura.setText("Lettura carta");

        txaStampa.setColumns(20);
        txaStampa.setRows(5);
        jScrollPane1.setViewportView(txaStampa);

        lblNome.setText("Nome:");

        lblCf.setText("CF:");

        lblSex.setText("Sesso:");

        lblCognome.setText("Cognome:");

        lblData.setText("Data Nascita");

        lblComNascita.setText("Comune Nascita");

        lblComResid.setText("Comune Residenza");

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnCreaCsv.setText("Crea CSV");
        btnCreaCsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreaCsvActionPerformed(evt);
            }
        });

        btnCatToNome.setText("CodCat-->nome");
        btnCatToNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatToNomeActionPerformed(evt);
            }
        });

        cbxApdu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00A40800041100110200", "00A40000021102" }));
        cbxApdu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxApduActionPerformed(evt);
            }
        });

        lblDataRil.setText("Data Rilascio:");

        lblDataSca.setText("Data Scadenza:");

        javax.swing.GroupLayout pnlCnsLayout = new javax.swing.GroupLayout(pnlCns);
        pnlCns.setLayout(pnlCnsLayout);
        pnlCnsLayout.setHorizontalGroup(
            pnlCnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCnsLayout.createSequentialGroup()
                .addGroup(pnlCnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCnsLayout.createSequentialGroup()
                        .addComponent(btnLeggi, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxApdu, 0, 1, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCatToNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCreaCsv, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCnsLayout.createSequentialGroup()
                        .addGroup(pnlCnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCnsLayout.createSequentialGroup()
                                    .addGroup(pnlCnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblNome)
                                        .addComponent(lblCf))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(pnlCnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                                        .addComponent(txtCF))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(pnlCnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblData)
                                        .addComponent(lblCognome))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(pnlCnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(pnlCnsLayout.createSequentialGroup()
                                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblSex)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtSex, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtCognome)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCnsLayout.createSequentialGroup()
                                    .addComponent(lblLettura, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlCnsLayout.createSequentialGroup()
                                .addGroup(pnlCnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblDataRil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblComNascita, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblComResid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblDataSca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(23, 23, 23)
                                .addGroup(pnlCnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCatComNascita, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                    .addComponent(txtCatComResid))
                                .addGap(18, 18, 18)
                                .addGroup(pnlCnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtComNascita, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtComResidenza, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlCnsLayout.setVerticalGroup(
            pnlCnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCnsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLeggi)
                    .addComponent(btnReset)
                    .addComponent(btnExit)
                    .addComponent(btnCreaCsv)
                    .addComponent(btnCatToNome)
                    .addComponent(cbxApdu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLettura)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCognome)
                    .addComponent(txtCognome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCatComNascita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblComNascita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtComNascita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtComResidenza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblComResid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCatComResid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblDataRil)
                .addGap(18, 18, 18)
                .addComponent(lblDataSca)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        tbpMain.addTab("CNS Card", pnlCns);

        tblView.setAutoCreateRowSorter(true);
        tblView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblView.setShowGrid(true);
        jScrollPane2.setViewportView(tblView);

        rbgScelta.add(rbtComune);
        rbtComune.setText("Denominazione");

        rbgScelta.add(rbtCodice);
        rbtCodice.setText("CodCatasto");

        txtInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInsertActionPerformed(evt);
            }
        });

        btnCerca.setText("Cerca");
        btnCerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCercaActionPerformed(evt);
            }
        });

        btnConnectDB.setText("Vedi Tutti");
        btnConnectDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectDBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlComuniLayout = new javax.swing.GroupLayout(pnlComuni);
        pnlComuni.setLayout(pnlComuniLayout);
        pnlComuniLayout.setHorizontalGroup(
            pnlComuniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlComuniLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlComuniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(pnlComuniLayout.createSequentialGroup()
                        .addComponent(btnConnectDB, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                        .addComponent(rbtComune)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtCodice)
                        .addGap(18, 18, 18)
                        .addComponent(txtInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCerca, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlComuniLayout.setVerticalGroup(
            pnlComuniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlComuniLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlComuniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtComune)
                    .addComponent(rbtCodice)
                    .addComponent(txtInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerca)
                    .addComponent(btnConnectDB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                .addContainerGap())
        );

        tbpMain.addTab("Comuni", pnlComuni);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tbpMain, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbpMain, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLeggiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeggiActionPerformed
        cd = new Carta();            
        try {
            objCns.leggi();
        } catch (CardException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(cd.iniCardReader()){
                String tmp="",cb=cbxApdu.getSelectedItem().toString();
            try {
                tmp = cd.leggi(cb,"00B0000000");
            } catch (CardException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
                if(!tmp.equals("NO")){
                    objAnagrafica=new Anagrafica(tmp.split(","));
                    txtNome.setText(objAnagrafica.getNome());
                    txtCognome.setText(objAnagrafica.getCognome());
                    txtCF.setText(objAnagrafica.getCf());
                    txtData.setText(objAnagrafica.getDatanascita());
                    txtSex.setText(objAnagrafica.getSesso());
                    txtCatComNascita.setText(objAnagrafica.getComNasc());
                    txtCatComResid.setText(objAnagrafica.getComRes());
                    lblDataRil.setText(lblDataRil.getText()+" "+objAnagrafica.getDataRil());
                    lblDataSca.setText(lblDataSca.getText()+" "+objAnagrafica.getDataSca());
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Inserisci la scheda! e premi ok");
                    btnReset.doClick();
                }      
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Collega il lettore di schede! e premi ok");
            btnReset.doClick();
        }
        txaStampa.setText(cd.inizializzaDriver()+"\n"+cd.getPath()+"\n"+cd.getErr());
    }//GEN-LAST:event_btnLeggiActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        this.dispose();
        Main main = new Main();
        main.setVisible(true);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnConnectDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectDBActionPerformed
        model.setRowCount(0);
        objDB.dirQuery("SELECT * FROM elenco");
        try {
            objDB.tabella(model);
            objDB.closeRs();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConnectDBActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        try {
            objDB.closeConn();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void txtInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInsertActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInsertActionPerformed

    private void btnCercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCercaActionPerformed
        model.setRowCount(0);
        String tmp="";
        for(Enumeration grb =rbgScelta.getElements();grb.hasMoreElements();){
            AbstractButton srb = (AbstractButton) grb.nextElement();
            if (srb.isSelected()) 
                tmp=srb.getText();
        }
        objDB.dirQuery("SELECT * FROM elenco WHERE "+tmp+"='"+txtInsert.getText()+"'");
        try {
            objDB.tabella(model);
            objDB.closeRs();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCercaActionPerformed

    private void btnCreaCsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreaCsvActionPerformed
        objFile=new FileOperazioni("esporta.csv");
        String dati=lblDataRil.getText()+";"+lblDataSca.getText()+";"+txtCognome.getText()+";"+txtNome.getText()+";"+txtCF.getText()+";"+txtData.getText()+";"+txtSex.getText()+";"+txtComNascita.getText()+";"+txtComResidenza.getText();
        objFile.scrittura(dati,false);
        txaStampa.append(objFile.getNomeFile());
    }//GEN-LAST:event_btnCreaCsvActionPerformed

    private void btnCatToNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatToNomeActionPerformed
        String tmp=txtCatComNascita.getText();
        String tmp2[];
        if (!tmp.equals(txtCatComResid.getText())){
            objDB.dirQuery("Select Denominazione from elenco where CodCatasto='"+tmp+"' or CodCatasto='"+txtCatComResid.getText()+"'");
        try {
            tmp2=objDB.getRsStr().split(",");
            txtComNascita.setText(tmp2[0]);
            txtComResidenza.setText(tmp2[1]);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else{
            objDB.dirQuery("Select Denominazione from elenco where CodCatasto='"+tmp+"'");
        try {
            txtComNascita.setText(objDB.getRs().getString(1));
            txtComResidenza.setText(objDB.getRs().getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
 
    }//GEN-LAST:event_btnCatToNomeActionPerformed

    private void cbxApduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxApduActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxApduActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCatToNome;
    private javax.swing.JButton btnCerca;
    private javax.swing.JButton btnConnectDB;
    private javax.swing.JButton btnCreaCsv;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLeggi;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cbxApdu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCf;
    private javax.swing.JLabel lblCognome;
    private javax.swing.JLabel lblComNascita;
    private javax.swing.JLabel lblComResid;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDataRil;
    private javax.swing.JLabel lblDataSca;
    private javax.swing.JLabel lblLettura;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSex;
    private javax.swing.JPanel pnlCns;
    private javax.swing.JPanel pnlComuni;
    private javax.swing.ButtonGroup rbgScelta;
    private javax.swing.JRadioButton rbtCodice;
    private javax.swing.JRadioButton rbtComune;
    private javax.swing.JTable tblView;
    private javax.swing.JTabbedPane tbpMain;
    private javax.swing.JTextArea txaStampa;
    private javax.swing.JTextField txtCF;
    private javax.swing.JTextField txtCatComNascita;
    private javax.swing.JTextField txtCatComResid;
    private javax.swing.JTextField txtCognome;
    private javax.swing.JTextField txtComNascita;
    private javax.swing.JTextField txtComResidenza;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtInsert;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSex;
    // End of variables declaration//GEN-END:variables
}
