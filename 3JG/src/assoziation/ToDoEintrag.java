package assoziation;

import java.io.Serializable;

public class ToDoEintrag implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9110135094946493541L;
	private String text;

	public ToDoEintrag(String text) {
		this.text = text;
	}
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
