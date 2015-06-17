package contdb.entities;

import java.util.Date;

/**
 *
 * @author thotic
 */
public class Cont {
    
    // Attribute
    private int conr;
    private int ctnr;
    private String stao;
    private Date edat;
    
    // Konstruktoren
    public Cont() {
    }

    public Cont(int conr) {
        this.conr = conr;
    }
    

    public Cont(int conr, int ctnr, String stao, Date edat) {
        this.conr = conr;
        this.ctnr = ctnr;
        this.stao = stao;
        this.edat = edat;
    }
    
    
    // Getter und Setter
    public int getConr() {
        return conr;
    }

    public void setConr(int conr) {
        this.conr = conr;
    }

    public int getCtnr() {
        return ctnr;
    }

    public void setCtnr(int ctnr) {
        this.ctnr = ctnr;
    }

    public String getStao() {
        return stao;
    }

    public void setStao(String stao) {
        this.stao = stao;
    }

    public Date getEdat() {
        return edat;
    }

    public void setEdat(Date edat) {
        this.edat = edat;
    }
    
}

