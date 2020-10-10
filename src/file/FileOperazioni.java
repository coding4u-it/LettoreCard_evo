package file;
import java.io.*;
import java.util.*;
public class FileOperazioni {
    private String nomeFile;
    
    public FileOperazioni(String nomeFile){
        this.nomeFile=System.getProperty("user.dir")+System.getProperty("file.separator")+nomeFile;
    }
       
    public String scrittura(String testo,boolean ap){
        String tmp="scrittura eseguita con successo!";
        PrintWriter outputStream=null;
        try {
            outputStream= new PrintWriter(new FileOutputStream(nomeFile,ap));
        } 
        catch (FileNotFoundException e){
            tmp="file di testo non trovato";
        }
        outputStream.println(testo);
        outputStream.close();
        return tmp;
    }
    
    public String lettura(){
        String tmp="File Aperto!\n";
        Scanner inputStream=null;
        try {
            inputStream=new Scanner (new File(nomeFile));
        }
        catch (FileNotFoundException e){
            return tmp="File di lettura non trovato";
        }
        while(inputStream.hasNextLine()){
            String riga=inputStream.nextLine();
            tmp+=riga+"\n";
        }
        inputStream.close();
        return tmp;
    }

    public String getNomeFile() {
        return nomeFile;
    }  
}
