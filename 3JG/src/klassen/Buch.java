package klassen;
public abstract class Buch {

     public void setAutor(Autor a) { }

     public String getZusammenfassung() { return null; }

     private String getAbsolutePath(String relPath) { return null; }

     private void speichern(String pfad) { }

     abstract void generateCopy();

}