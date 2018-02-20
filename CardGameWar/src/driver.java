import java.util.LinkedList;

public class driver {

	public static void main(String[] args) {
	
		Deck array [] = new Deck[52];
		
		String [] ranks = {"2","3","4","5","6","7","8","9","10","Jack","Queens","King","Ace"};
		
		for(int i=0; i<52; i++) {
			
			array [i] = new Deck(ranks[i%13],(i+2)%12);
			
			}
		
	    LinkedList<Integer> list = new LinkedList<>();

	
	}
}

