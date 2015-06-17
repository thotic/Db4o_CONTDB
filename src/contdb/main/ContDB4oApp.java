package contdb.main;

import contdb.connect.DB4oEmb;
import contdb.entities.Cont;
import contdb.entities.ContPos;
import contdb.entities.ContUES;
import contdb.gui.Menue;
import java.util.Date;
import java.util.List;

/**
 *
 * @author thotic
 */
public class ContDB4oApp {
    
    // main
    public static void main(String args[]) {
     
        // DB Instanz (fuer Schemaname und Connection)
        DB4oEmb db4o = new DB4oEmb(); 
        
        // Menue aufrufen /////////////////////// 
        Menue menue = new Menue(db4o);
        menue.setVisible(true);
        
        // Connection schliessen
        menue.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                db4o.closeConnection();
                System.exit(0);
            }
        });
        
          
        // Kontroll Menue ///////////////////////////
        try {
            // Lesen ContPos
            List<Object> contPosListe = db4o.read(new ContPos());
            System.out.println("ContPos: ");
            for(Object o : contPosListe) {
                ContPos cp = (ContPos) o;
                System.out.println(cp.getConr()+" "+cp.getWoab()+" "+cp.getWobis());
            }
            // Lesen Cont
            List<Object> contListe = db4o.read(new Cont());
            System.out.println("Cont: ");
            for(Object o : contListe) {
                ContUES cu;
                Cont c;
                try{
                    cu = (ContUES) o;
                    System.out.println(cu.getConr()+" "+cu.getCtnr()+" "+
                            cu.getStao()+" "+cu.getEdat()+" "+cu.getZhafen() );
                } catch (ClassCastException e) {
                    c = (Cont) o;
                    System.out.println(c.getConr()+" "+c.getCtnr()+" "+
                            c.getStao()+" "+c.getEdat()+" kein UES"); 
                }                
            }
        } finally {
            // Connection schliessen
            //db4o.closeConnection();
        }
        
        

    }
    
}
