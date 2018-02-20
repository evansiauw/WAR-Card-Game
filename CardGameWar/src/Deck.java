import java.util.LinkedList;

public class Deck {
	
	private String cardName;
	private int cardValue;
	
	public Cards(String cardRank, int cardValue) {
		
		cardName = cardRank;
		this.cardValue = cardValue;
	}
	
	public String getName () { return cardName; }
	public int getValue () { return cardValue; }
	
	public void setName (String Name) { cardName = Name; }
	public void setValue (int Value) { cardValue = Value; }
	
	public String toString() {
		return cardName;
	}
	
}
