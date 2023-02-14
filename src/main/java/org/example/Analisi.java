package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Analisi {
    String nome;
    String cognome;
    String codiceFiscale;
    String sesso;
    int eta;
    Date dataOraPrelievo;
    String luogoPrelievo;
    ArrayList<Esame> esami;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public Date getDataOraPrelievo() {
        return dataOraPrelievo;
    }

    public void setDataOraPrelievo(Date dataOraPrelievo) {
        this.dataOraPrelievo = dataOraPrelievo;
    }

    public String getLuogoPrelievo() {
        return luogoPrelievo;
    }

    public void setLuogoPrelievo(String luogoPrelievo) {
        this.luogoPrelievo = luogoPrelievo;
    }

    public ArrayList<Esame> getEsami() {
        return esami;
    }

    public void setEsami(ArrayList<Esame> esami) {
        this.esami = esami;
    }
}
