import java.util.LinkedList;
import java.util.Random;

public class driver {

	public static void main(String[] args) {
	
		Deck array [] = new Deck[52];
		LinkedList <Deck> player1 = new LinkedList <>();
		LinkedList <Deck> player2 = new LinkedList <>();
		
		
		String [] ranks = {"2","3","4","5","6","7","8","9","10","Jack","Queens","King","Ace"};
		
		for(int i=0; i<52; i++) {
			array [i] = new Deck(ranks[i%13],(i+2)%12); 
		}	
		
		shuffling(array);
		playGame(array, player1, player2);
		
	}
	
	private static void playGame(Deck array [], LinkedList <Deck> player1, LinkedList <Deck> player2) {
		
		int cardCounter1 = 26;
		int cardCounter2 = 26;
	
		for(int i=0; i<26; i++) {
			player1.add(i, array[i]);
			System.out.println(player1.size());
		}
		
		for(int j=26; j<52; j++) {
			player2.add(j%26, array[j]);
			System.out.println(player2.size());
		}
		
		while (cardCounter1 >= 3 && cardCounter2 >= 3) {
			
		}
		
		
		
		
	}
	
	
	private static void shuffling(Deck array []) {
		
        System.out.println("Before Swapping");
		for (int i = 0; i < array.length; i++) {
		    System.out.print(array[i] + ", ");
		}
		System.out.println();
		
		int arrayLength = array.length;
        for (int i = 0; i < arrayLength; i++) {
            int r = i + (int) (Math.random() * (arrayLength-i));   // between i and n-1
            swap(array, i, r);
        }
        
        System.out.println("After Swapping");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
	}

    private static void swap(Deck[] a, int i, int r) {
        Deck swap = a[i];
        a[i] = a[r];
        a[r] = swap;
    }
    
}

