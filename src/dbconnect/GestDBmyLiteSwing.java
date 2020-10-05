/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnect;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author france
 */
public class GestDBmyLiteSwing extends GestDBmyLite{
    
    public GestDBmyLiteSwing(String nomeDB, String userDB, String passDB) {
        super(nomeDB, userDB, passDB);
    }
    
    public GestDBmyLiteSwing(String nomeDB) {
        super(nomeDB);
    }
    
    /**
     * il metodo serve per fornire le etichette alle tabelle
     * @param n
     * @return array di stringhe 
     * @throws SQLException 
     */
    public String[] etichette(int n) throws SQLException{
        String [] mat=new String[n];
        for(int i=1;i<=mat.length;i++)
            mat[i-1]=super.getRsmd().getColumnLabel(i);
        return mat;
    }
    /**
     * il metodo riceve una tabella di swing la rielabora e la restituisce 
     * carica di elementi presi dal db
     * @param model 
     * @return tabella swing
     * @throws SQLException 
     */
    public DefaultTableModel tabella(DefaultTableModel model) throws SQLException{
        int cMax = super.getRsmd().getColumnCount();
        model.setColumnCount(cMax); //visualizzazione risultato in tabella
        model.setColumnIdentifiers(etichette(cMax));
        int riga;Object valore; //dichiarazione variabile per righe ed oggetti tabella 
        while(super.getRs().next()) { 
            riga = model.getRowCount();
            for(int c=1; c<=cMax; c++) {
                model.setRowCount(riga + 1); //nuova riga
                valore = super.getRs().getObject(c);
                model.setValueAt(valore, riga, c-1);
            }
        }
        return model;
    }
    
  
     /** 
     * @return Arraylist with the table's name
     * @throws SQLException
     */
    public ArrayList<String> getTablesMetadata() throws SQLException {
        String table[] = { "TABLE" };
        ArrayList<String> tables = new ArrayList<>();
        // receive the Type of the object in a String array.
        super.setRs(super.getDbmd().getTables(null, null, null, table));
        while (super.getRs().next()) {
            tables.add(super.getRs().getString("TABLE_NAME"));
        }
        return tables;
    }
    
    public String getRsStr() throws SQLException{
        String tmp="";
        while(super.getRs().next()) { 
                tmp+=super.getRs().getString(1)+",";
            }
        return tmp;
    }
}
