package htw.berlin.demo.webtech.persistance;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "rechnung")
public class RechnungEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid")
    private long rid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "frist", nullable = false)
    private Date frist;

    @Column(name = "kontonummer", nullable = false)
    private String kontonummer;

    @Column(name = "preis", nullable = false)
    private int preis;

    public RechnungEntity(String name, Date frist, String kontonummer, int preis) {
        this.name = name;
        this.frist = frist;
        this.kontonummer = kontonummer;
    }

    protected RechnungEntity() {}

    public long getRid() {
        return rid;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Date getFrist() { return frist; }

    public void setFrist(Date frist) { this.frist = frist; }

    public String getKontonummer() { return kontonummer; }

    public void setKontonummer(String kontonummer) { this.kontonummer = kontonummer; }

    public int getPreis() { return preis; }

    public void setPreis(int preis) { this.preis = preis; }
}
