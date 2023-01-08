package htw.berlin.demo.webtech.api;

import java.util.Calendar;
import java.util.Date;

public class Rechnung {
    private long rid;
    private String name;
    private Date frist;
    private String kontonummer;
    private int preis;

    public Rechnung(String name, Date frist, String kontonummer, int preis) {
        this.name = name;
        this.frist = frist;
        this.kontonummer = kontonummer;
        this.preis = preis;
    }

    public Rechnung(long rid, String name, Date frist, String kontonummer, int preis) {
    }


    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFrist() {
        return frist;
    }

    public void setFrist() {
        this.frist = frist;
    }

    public String getKontonummer() {
        return kontonummer;
    }

    public void setKontonummer(String kontonummer) {
        this.kontonummer = kontonummer;
    }

    public int getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }


}
