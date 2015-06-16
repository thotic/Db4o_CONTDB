package contdb.entities;

/**
 *
 * @author thotic
 */
public class ContPos {
    
    // Attribute
    private int conr;
    private int woab;
    private int wobis;
    
    // Konstruktoren
    public ContPos() {
    }

    public ContPos(int conr, int woab, int wobis) {
        this.conr = conr;
        this.woab = woab;
        this.wobis = wobis;
    }
    
    // Getter und Setter
    public int getConr() {
        return conr;
    }

    public void setConr(int conr) {
        this.conr = conr;
    }

    public int getWoab() {
        
        return woab;
    }

    public boolean setWoabWobis(int woab, int wobis) {
        boolean bool = false;
        if( woab>0 && woab<=52 && wobis>0 && wobis<=52 && woab<=wobis) {
            this.woab = woab;
            this.wobis = wobis;
            bool = true;
        }
        else {
            System.err.println("Methode setWoabWobis fehlgeschlagen");
        }
        return bool;
    }

    public int getWobis() {
        return wobis;
    }

    
}
