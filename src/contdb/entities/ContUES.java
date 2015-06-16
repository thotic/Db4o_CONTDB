package contdb.entities;

import java.util.Date;

/**
 *
 * @author thotic
 */
public class ContUES extends Cont {
    
    // Attribute
    private String zhafen;
    
    // Konstruktoren
    public ContUES() {
    }

    public ContUES(int conr, int ctnr, String stao, Date edat, String zhafen) {
        super(conr, ctnr, stao, edat);
        this.zhafen = zhafen;
    }
    
    
    // Getter und Setter
    public String getZhafen() {
        return zhafen;
    }

    public void setZhafen(String zhafen) {
        this.zhafen = zhafen;
    }
    
}
