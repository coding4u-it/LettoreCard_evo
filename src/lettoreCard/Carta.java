
package lettoreCard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.smartcardio.Card;
import javax.smartcardio.CardChannel;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;
import javax.smartcardio.TerminalFactory;

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

public class Carta {
   
    private String err; 
    private String path;
    private final String PROTOCOL="T=1";
    private CardTerminal terminal;
    private Card card;
    private CardChannel channel;
    private int a=64;//64
    private ResponseAPDU answer;
    
    public Carta(){}

    public String getErr()  {    return err;    }//errori

    public String getPath() {   return path;    }//nome porta usb
    
    /**
     * metodo per inizializzazione della scheda CNS
     * @return 
     */
    public String inizializzaDriver(){
        String cheOS = System.getProperty("os.name").toLowerCase();
        String tmp=""; 
        if(cheOS.equalsIgnoreCase("linux"))
            try {
                String comm[] = { "find", "/usr", "/lib", "-name", "libpcsclite.so.1" };
                String line;
                Process p = Runtime.getRuntime().exec(comm);
                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                while ((line = reader.readLine()) != null && !line.equals(""))
                    if (line.contains("libpcsclite.so.1")) {
                        System.setProperty("sun.security.smartcardio.library",line);
                        break;
                    }
                tmp="driver ok";
                p.waitFor();
            } catch (IOException | InterruptedException e) {
                tmp="driver non trovato";
                Logger.getLogger(Carta.class.getName()).log(Level.SEVERE, null, e);
            }    
        return tmp;
    }
    
    /**
     * metodo di controllo se il lettore di schede è collegato
     * @return 
     */
    public boolean iniCardReader(){
        boolean sw=true;
        TerminalFactory factory= TerminalFactory.getDefault();
        try {
            terminal = factory.terminals().list().get(0);
            } catch (CardException ex) {
                sw=false;
                Logger.getLogger(Carta.class.getName()).log(Level.SEVERE, null, ex);
            }
        return sw;
    }
    
    /**
     * metodo per la lettura della scheda CNS e l'invio dei comandi
     * @param selezione
     * @param lettura
     * @return 
     * @throws javax.smartcardio.CardException 
     */
    public String leggi(String selezione, String lettura) throws CardException {
        String tmp;
        if(terminal.isCardPresent()){
            card = terminal.connect(PROTOCOL);
            channel = card.getBasicChannel();
            path="card: " + card+"\n"+channel+" "+card.getATR();
            //comando per la selezione dei dati personali {00A40800041100110200}, comando per la lettura {00B0000000};
            err = richiedi(hexToByte(selezione),false);
            tmp = richiedi(hexToByte(lettura),true);
            card.disconnect(false);
        }else{
            tmp="NO";
        }
    return tmp;
    }
    
    /**
     * metodo per la conversione da array di byte a Stringa esadecimale
     * @param bytes
     * @return 
     */
    public String bytesToHex (byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte ab : bytes) 
            sb.append(String.format("%02x", ab));
        //System.out.println("bytes->hex: "+sb.toString());
        return sb.toString();
    }
    
    /**
     * metodo per la conversione da stringa ad array di byte
     * @param s
     * @return 
     */
    public byte[] hexToByte(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2)
            data[i/2] = (byte)((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i+1),16));
        //System.out.println("hex.>bytes: "+data);
        return data;
    }
    
    /**
     * metodo che estrae il carattere esadecimale da convertire
     * @return 
     */
    public String carattere(){
        String tmp= ""+bytesToHex(answer.getBytes()).charAt(a)+""+bytesToHex(answer.getBytes()).charAt(a+1);
        //System.out.println("char:"+ tmp);
      return tmp;
    }
    
    /**
     * metodo che estrae il numero di lunghezza della stringa sucessiva
     * @param cf
     * @return 
     */
    public int numero(String cf){
        String num=(char)Integer.parseInt(cf, 16)+"";
        num+=(char)Integer.parseInt(carattere(), 16); 
        //System.out.println("numero: "+Integer.parseInt(num,16));
        return Integer.parseInt(num,16);
    }
    
    /**
     * metodo che consente di estrarre o l'esito della trasmissione o i dati personali
     * @param dati
     * @param scelta
     * @return
     * @throws CardException 
     */
    public String richiedi(byte[] dati,boolean scelta) throws CardException {
        // comando response per eventuali errori e dati richiesti
        answer = channel.transmit(new CommandAPDU(dati));
        String tmp;
        boolean isTrue=true;
        if(scelta){
            tmp="";
            String num="";//variabile che consente di determinare la lunghezza delle stringhe
            int off=0,conta=0, off1=0;//variabili che consentono 63
            while(isTrue && a<(255*4)){
                String cf =carattere();
                if (answer.getSW1()==0x90 && answer.getSW2()==0x00){
                    a+=2;
                    if(off==0 && conta<11){
                        off=numero(cf);
                        off1+=off;
                        a+=2;
                        conta++;
                        if (off1!=0){
                            tmp+=",";
                            off1=0;}
                    }
                    else{
                        tmp+= (char)Integer.parseInt(cf, 16);
                        off--;
                    }
                }
                if (conta==11 && off==0){
                    isTrue=false;
                    tmp+=",";
                }
            }
        }
        else
            tmp=""+answer;
        System.out.println("dati:  "+tmp);
        return tmp;
    }
}
