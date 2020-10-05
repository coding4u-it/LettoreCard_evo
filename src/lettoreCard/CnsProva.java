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
package lettoreCard;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.smartcardio.Card;
import javax.smartcardio.CardChannel;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;
import javax.smartcardio.TerminalFactory;
/**
 *
 * @author france
 */
public class CnsProva  {
   
    String err,term; 
    String path;
    String str="";
    String protocol="T=1";
    CardTerminal  terminal;
    Card card;
    CardChannel channel;
    //68,69
   int a=0,b=1;
    char car[] ;
    
    public CnsProva(){}

    public String getErr()  {    return err;    }//errori

    public String getTerm() {   return term;    }//letture

    public String getName() {   return str;    }//letture

    public String getPath() {   return path;    }//nome porta usb
    
      
public void leggi() throws CardException, NoSuchAlgorithmException {
   try {
            String comm[] = { "find", "/usr", "/lib", "-name",
                    "libpcsclite.so.1" };
            String line;
            Process p = Runtime.getRuntime().exec(comm);
           
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));

            while ((line = reader.readLine()) != null && !line.equals("")) {
                if (line.contains("libpcsclite.so.1")) {
                System.setProperty("sun.security.smartcardio.library",line);
                    break;
                }
            }
           
            p.waitFor();

        } catch (Exception e) {

            e.printStackTrace();
        }
     TerminalFactory factory= TerminalFactory.getDefault();
     
       List<CardTerminal> terms = factory.terminals().list();
       CardTerminal terminal = terms.get(0);
     
      if(terms!=null){
         
        term= ""+terminal;
        if(terminal.isCardPresent()==true){
            card = terminal.connect(protocol);
            channel = card.getBasicChannel();
            term="card: " + card+"\n"+channel+" "+card.getATR()+"\n";
        }else{
            err="Carta non inserita";
            System.err.close(); 
        }
       byte[] dati = {(byte) 0x00, (byte) 0xA4, (byte) 0x00, (byte) 0x00, (byte) 0x02, (byte) 0x3f, (byte) 0x00};
        byte[] dati2={(byte) 0x00, (byte) 0xA4, (byte) 0x00, (byte) 0x00,(byte) 0x02, (byte) 0x11, (byte) 0x00};
        byte[] dati3={(byte) 0x00, (byte) 0xA4, (byte) 0x00, (byte) 0x00, (byte) 0x02,(byte) 0x11, (byte) 0x02};
        byte[] read = {(byte) 0x00,(byte) 0xB0,(byte) 0x00,(byte) 0x00,(byte) 0x00};
            
            ResponseAPDU r = channel.transmit(new CommandAPDU(dati));
            err+=""+r;
            ResponseAPDU r1 = channel.transmit(new CommandAPDU(dati2));
            err+=""+r1;
            ResponseAPDU r2 = channel.transmit(new CommandAPDU(dati3));
            err+=""+r2;
        ResponseAPDU t = channel.transmit(new CommandAPDU(read));
        
        car = new char[128];//numero coppie byte da leggere
            System.out.println();
            for (int i=0;i<car.length;i++){
           
            String cd = ""+bytesToHex(t.getBytes()).charAt(a);
            String ce = ""+bytesToHex(t.getBytes()).charAt(b);
            
            String cf =cd+ce;
            if (t.getSW1() == 0x90 && t.getSW2() == 0x00){
            int dec = Integer.parseInt(cf, 16);
            car[i]= (char)dec;
            
             a=a+2; b=b+2;
            str+=car[i];
            }
            }
          System.out.println("str- "+str); 
         card.disconnect(false); 
    }else{
        term="nessun terminale  ";         
    }
       System.out.println(); 
}
     public String bytesToHex (byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (int i=0; i< bytes.length; i++) {
            sb.append(String.format("%02x", bytes[i]));
        }
        return sb.toString();
    }
}

