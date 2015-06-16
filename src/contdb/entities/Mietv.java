package contdb.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author thotic
 */
public class Mietv {
    
    // Attribute
    private int mietnr;
    private int knr;
    private Date mietdat;
    private BigDecimal gespreis;
    private Date rdat;
    private BigDecimal mwst;
    private BigDecimal bruttopreis;
    private List<ContPos> contPosListe;
    
    // Konstruktoren
    public Mietv() {
        contPosListe = new LinkedList<>();
    }

    public Mietv(int mietnr, int knr, Date mietdat, List<ContPos> contPosListe) {
        this.mietnr = mietnr;
        this.knr = knr;
        this.mietdat = mietdat;
        this.contPosListe = contPosListe;
    }

    
    public Mietv(int mietnr, int knr, Date mietdat, BigDecimal gespreis,
            Date rdat, BigDecimal mwst, BigDecimal bruttopreis,List<ContPos> contPosListe) {
        this.mietnr = mietnr;
        this.knr = knr;
        this.mietdat = mietdat;
        this.gespreis = gespreis;
        this.rdat = rdat;
        this.mwst = mwst;
        this.bruttopreis = bruttopreis;
        this.contPosListe = contPosListe;
    }
    
    
    // Getter und Setter
    public int getMietnr() {
        return mietnr;
    }

    public void setMietnr(int mietnr) {
        this.mietnr = mietnr;
    }

    public int getKnr() {
        return knr;
    }

    public void setKnr(int knr) {
        this.knr = knr;
    }

    public Date getMietdat() {
        return mietdat;
    }

    public void setMietdat(Date mietdat) {
        this.mietdat = mietdat;
    }

    public BigDecimal getGespreis() {
        return gespreis;
    }

    public void setGespreis(BigDecimal gespreis) {
        this.gespreis = gespreis;
    }

    public Date getRdat() {
        return rdat;
    }

    public void setRdat(Date rdat) {
        this.rdat = rdat;
    }

    public BigDecimal getMwst() {
        return mwst;
    }

    public void setMwst(BigDecimal mwst) {
        this.mwst = mwst;
    }

    public BigDecimal getBruttopreis() {
        return bruttopreis;
    }

    public void setBruttopreis(BigDecimal bruttopreis) {
        this.bruttopreis = bruttopreis;
    }

    public List<ContPos> getContPosListe() {
        return contPosListe;
    }

    public void setContPosListe(List<ContPos> contPosListe) {
        this.contPosListe = contPosListe;
    }
    
    
}
