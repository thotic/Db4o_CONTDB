package contdb.connect;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.ExtObjectContainer;
import com.db4o.ext.StoredClass;
import com.db4o.ext.StoredField;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thotic
 */
public class DB4oEmb {
    
    /** ObjectContainer fuer db4o */
    private ObjectContainer db = null;
    /** erweiterter ObjectContainer fuer db4o */
    private ExtObjectContainer dbExt = null;
    /** Array-Liste fuer die Metadaten */
    ArrayList<String> metadata = null;
    
    /**
    * Dieser Konstruktor initialisiert die Array-Liste f�r die Metadaten und
    * ruft die entsprechende Methode connect() auf.
    *
    * @param path
    *            Pfad zur Datenbank-Datei
    */
    public DB4oEmb() {

      // Arrays-Liste fuer die Metadaten initialisieren
      metadata = new ArrayList<>();

      // Connect-Methode aufrufen
      connect();

    }
    
    /**
    * Diese Methode stellt eine Verbindung zu einer db4o-Datenbank her und ruft
    * dann die Methode metadata() auf.
    *
    * @param ip
    *            IP-Adresse des db4o-Servers
    * @param port
    *            Port des db4o-Servers
    * @param user
    *            Benutzername zur Datenbankverbindung
    * @param password
    *            Passwort zur Datenbankverbindung
    */
    private void connect() {
        try {
            // Datenbankverbindung herstellen (CS-Modus)
            db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "DBCONT2");
            // erweiterten ObjectContainer erzeugen
            dbExt = db.ext();
            // Metadata-Methode aufrufen
            metadata();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Metadaten der Datenbank werden anbegfragt
    public void metadata() {
        StoredClass[] sclass;
        StoredField[] sf;
        metadata.clear();

        // erweiterten ObjectContainer erzeugen
        //dbExt = db.ext();
        // gespeicherten Klassen auslesen
        sclass = dbExt.storedClasses();

        // alle relevanten Klassen in die Array-Liste kopieren
        for (int i = 0; i < sclass.length; i++) {

            if (!sclass[i].getName().contains("com.db4o")) {
                metadata.add("$$$");
                metadata.add(sclass[i].getName());
                sf = sclass[i].getStoredFields();

                for (int j = 0; j < sf.length; j++) {
                    metadata.add(sf[j].getName());
                    metadata.add(sf[j].getStoredType().toString());
                }
            }
        }
    }
    
    // Objekt einfuegen
    public boolean insert(Object o) {         

        // Ueberprueft ob Objekt schon vorhanden
        ObjectSet result = db.queryByExample(o);
        if ((result.size() == 0)) {     // wenn Objekt nicht vorhanden
            db.store(o);              // Objekt in Datenbank sichern
            db.commit();
            return true;
        }

        return false;
    }
    
    // Objekt suchen
    public Object find(Object o) {
        
        Object found;
        // Ueberprueft ob Objekt existiert
        ObjectSet result = db.queryByExample(o);
        if ((result.size()) == 0) {     // wenn Objekt nicht vorhanden
            found = null;
        }
        else {
            found = result.next();    
        }
        return found;
    }
    
    // Objekt updaten
    public boolean update(Object o) {    // noch nicht implementiert
        return false;
    }
    
    // Objekt loeschen
    public boolean delete(Object o) {   

        // Ueberprueft ob Objekt vorhanden
        ObjectSet result = db.queryByExample(o);
        for (Object found : result) {      // wenn gleiche Objekt(e) gefunden
            db.delete(found);              // Objekt(e) loeschen
        }
        db.commit();
        return true;
    }
    
    // Lesen von Objekten
    public List<Object> read(Object o) {   

        // holt alle Objekte aus DB, die von der Klasse von o sind
        // ist o z.B. ein Objekt der Klasse Sensor, dann werden alle
        // Objekte der Klasse Sensor aus der DB ausgelesen
        List<Object> result = (List<Object>) db.query(o.getClass());
        return result;
    }
    
    // Diese Methode schliesst die Datenbankverbindung
    public void closeConnection() {

        if (db != null) {
            db.close();
        }

        if (dbExt != null) {
            dbExt.close();
        }
    }
    
    // Getter und Setter
    public ArrayList<String> getMetadata() {
        return metadata;
    }
    
}
