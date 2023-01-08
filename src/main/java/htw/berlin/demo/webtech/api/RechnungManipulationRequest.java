package htw.berlin.demo.webtech.api;

import java.util.Calendar;
import java.util.Date;

public class RechnungManipulationRequest {
    private String name;
    private Date frist;
    private String kontonummer;
    private int preis;

    public RechnungManipulationRequest(String name, Date frist, String kontonummer, int preis) {
        this.name = name;
        this.frist = frist;
        this.kontonummer = kontonummer;
        this.preis = preis;
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

    public void setFrist(Date frist) {
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

    public void extension() {
        preis = preis + 10;
        return changeFrist(frist);
    }

    public Date changeFrist() {
        Calendar c = Calendar.getInstance();
        c.setTime(frist);
        c.add(Calendar.DATE, 14);
        return frist = c.getTime();
    }
}
