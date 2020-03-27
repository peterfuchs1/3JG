package praxis1;
	
public class Rechnungen {

  private Operation[] liste;

  public Rechnungen() {
    liste = new Operation[10];
  }

  public void setRechnung(
    Operation bo, int index) {
    liste[index] = bo;
  }

  public double summe() {
    double s = 0;
    for(int i = 0; i < liste.length; 
      i++) {
      if(liste[i] != null) {
        s+=liste[i].ergebnis();
      }
    }
    return s;
  }
  public String auflisten() {
	    String s = "";
	    for(int i = 0; i < liste.length; 
	      i++) {
	      if(liste[i] != null) {
	        s+=liste[i].rechnenText();
	      }
	    }
	    return s;
	  }
}

