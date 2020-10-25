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

/**
 *
 * @author france
 */
public class Anagrafica {

    private String dataRil;
    private String dataSca;
    private String nome;
    private String cognome;
    private String datanascita;
    private String cf;
    private String sesso;
    private String errore;
    private String comNasc;
    private String comRes;

    public Anagrafica(){}
     
    public Anagrafica(String[]info){
        //this.id=id;
        this.dataRil=info[1];
        this.dataSca=info[2];
        this.cognome=info[3]; 
        this.nome=info[4]; 
        this.datanascita=info[5];
        this.sesso=info[6];
        this.cf=info[7];
        this.comNasc=info[8]; 
        this.comRes=info[9];
    }
    
    public String getDataRil() {
        return dataRil;
    }

    public void setDataRil(String dataRil) {
        this.dataRil = dataRil;
    }

    public String getDataSca() {
        return dataSca;
    }
    
    public void setDataSca(String dataSca) {
        this.dataSca = dataSca;
    }
    public String getComNasc() {
        return comNasc;
    }

    public void setComNasc(String comNasc) {
        this.comNasc = comNasc;
    }
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @return the datanascita
     */
    public String getDatanascita() {
        return datanascita;
    }

    /**
     * @return the sesso
     */
    public String getSesso() {
        return sesso;
    }

    /**
     * @return the cf
     */
    public String getCf() {
        return cf;
    }
   public String getErrore(){
       return errore;
   }

    /**
     * @return the comune
     */
    public String getComRes() {
        return comRes;
    }

    /**
     * @param comRes the comune to set
     */
    public void setComune(String comRes) {
        this.comRes = comRes;
    }
    
}
