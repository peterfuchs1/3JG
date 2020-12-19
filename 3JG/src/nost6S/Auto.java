package nost6S;

public class Auto {

	private int leistung;
	private String type;

	public Auto(String type, int leistung) {
		this.leistung=leistung;
		this.type=type;
	}

	public void setLeistung(int leistung) {this.leistung=leistung; }

	public int getLeistung() { 	return this.leistung; 	}

	public void setType(String type) { this.type=type; 	}

	public String getType() { return this.type; 	}

}
