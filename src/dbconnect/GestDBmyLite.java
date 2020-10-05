/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnect;

import java.sql.*;

public class GestDBmyLite{
    private String nomeDB;
    private String urlDB;  //contiene la stringa di connessione al DB
    private String driver; //contiene il driver del DB
    private String userDB; // se DB MySQL contiene username per accedere al db
    private String passDB; // se DB MySQL contiene password per accedere al db
    private Connection conn;
    private Statement stm;
    private DatabaseMetaData dbmd;
    private ResultSet rs;
    private ResultSetMetaData rsmd;
    
    /**
     * Costruttore permette di caricare il driver per DB MySQL
     * e creare la stringa di connessione al DB 
     * @param nomeDB nome del DB
     * @param userDB username del DB MySQL di default root
     * @param passDB username del DB MySQL di default ""
     */
    public GestDBmyLite(String nomeDB, String userDB, String passDB){
        this.nomeDB=nomeDB;
        this.passDB=passDB;
        driver="com.mysql.cj.jdbc.Driver";
        urlDB="jdbc:mysql:///"+nomeDB;
        try {  //carico il driver
            Class.forName(driver); 
        }
        catch(ClassNotFoundException e) {
          System.out.println("Driver non trovato!");
          System.exit(1);
        }        
    }
    /**
     * Costruttore permette di caricare il driver per DB SQLite
     * e creare la stringa di connessione al DB 
     * @param nomeDB nome del DB
     */
     public GestDBmyLite(String nomeDB){
        this.nomeDB=nomeDB;
        driver="org.sqlite.JDBC";
        urlDB="jdbc:sqlite::resource:"+nomeDB;
        try {  //carico il driver
            Class.forName(driver); 
        }
        catch(ClassNotFoundException e) {
          System.out.println("Driver non trovato!");
          System.exit(1);
        }        
    }
     
     /**metodo per il controllo del DB usato MySQL o SQLite
      * 
      */
     public void ctrlDB(){
        try {  //apre la connessione verso il database
            if (getUrlDB().contains("mysql"))
               setConn(DriverManager.getConnection(getUrlDB(),"root",""));
            else
               setConn(DriverManager.getConnection(getUrlDB()));
            //System.out.println("url:-> "+urlDB);
        }
        catch (SQLException e) {
            System.out.println("Errore nella connessione"+e);
            System.exit(1);
        }
     }

    /**
     * @return the dbmd
     */
    public DatabaseMetaData getDbmd() {
        return dbmd;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Statement getStm() {
        return stm;
    }

    public ResultSet getRs() {
        return rs;
    }

    /**
     * @param rs the rs to set
     */
    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public ResultSetMetaData getRsmd() {
        return rsmd;
    }
    /**
     * metodo per informazioni sui metadati
     */
    public void metadati() {
     ctrlDB();
        try {
            dbmd = conn.getMetaData();
        } catch (SQLException e) {
            System.err.println("There was an error getting the metadata: "
                    + e.getMessage());
        }
    }

    /**
     * inizializzazione connessione, statement e resultset
     * @param query 
     */
    public void dirQuery(String query){  
        ctrlDB();
        //creazione statement mediante una query sql e ricevo il risultato nel resultset
       try { 
            stm=conn.createStatement();
            setRs(stm.executeQuery(query));
            rsmd=rs.getMetaData();
        }
        catch (SQLException e) {
            System.out.println("Errore nella query");
            System.exit(1);
        }
    }
    /**
     * inizializzazione connessione, statement 
     * @param query 
     */  
    public void dirExec(String query){    
        ctrlDB();
        try { //eseguo una query di inserimento o modifica o cancellazione al database
           stm=conn.createStatement();
           stm.executeUpdate(query);
           stm.close();
        }
        catch (SQLException e) {
            System.out.println("Errore nella query");
            System.exit(1);
        }
    }
    /**
     * chiude connessione al DB
     * @throws SQLException 
     */ 
    public void closeConn() throws SQLException{
        if(conn!=null)
            conn.close();
    }
    /**
     * chiude resultset
     * @throws SQLException 
     */
    public void closeRs() throws SQLException{
        rs.close();
    }   

    /**
     * @return the urlDB
     */
    public String getUrlDB() {
        return urlDB;
    }
}
