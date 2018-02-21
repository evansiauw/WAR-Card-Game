import java.util.LinkedList;
import java.util.ListIterator;
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
		
		LinkedList <Deck> temp = new LinkedList <>();
		int cardCounter1 = 26;
		int cardCounter2 = 26;
	
		for(int i=0; i<26; i++) {
			player1.add(i, array[i]);
		}
		
		for(int j=26; j<52; j++) {
			player2.add(j%26, array[j]);
		}
		
		while (cardCounter1 > 3 && cardCounter2 > 3) {
			
			if(player1.getFirst().getValue() > player2.getFirst().getValue()) {
				cardCounter1++;
				cardCounter2--;
				player1.add(player1.getFirst());
				player1.add(player2.getFirst());
				player1.removeFirst();
				player2.removeFirst();					
			}
			else if (player1.getFirst().getValue() < player2.getFirst().getValue()) {
				cardCounter2++;
				cardCounter2--;
				player2.add(player2.getFirst());
				player2.add(player1.getFirst());
				player1.removeFirst();
				player2.removeFirst();					
			}
			
			else if (player1.getFirst().getValue() == player2.getFirst().getValue()) {
				cardCounter1 -= 2;
				cardCounter2 -= 2;
				temp.add(player1.getFirst());
				temp.add(player1.removeFirst());
				temp.add(player1.getFirst());
				temp.add(player1.removeFirst());
				temp.add(player2.getFirst());
				temp.add(player2.removeFirst());
				temp.add(player2.getFirst());
				temp.add(player2.removeFirst());
				
				if(player1.getFirst().getValue() > player2.getFirst().getValue()) {
					cardCounter1 += 3;
					cardCounter2 -= 3;
					temp.add(player1.getFirst());
					player1.removeFirst();
					temp.add(player2.getFirst());
					player2.removeFirst();
					player1.addAll(temp);
					temp.clear();
				}
				
				if(player1.getFirst().getValue() < player2.getFirst().getValue()) {
					cardCounter2 += 3;
					cardCounter1 -= 3;
					temp.add(player2.getFirst());
					player2.removeFirst();
					temp.add(player1.getFirst());
					player1.removeFirst();
					player2.addAll(temp);
					temp.clear();
				}
					
			}
			
			ListIterator<Deck> listIterator = player1.listIterator();
			while (listIterator.hasNext()) {
				System.out.print(listIterator.next() + " ");
			}
			System.out.println();
			
			ListIterator<Deck> listIterator2 = player2.listIterator();
			while (listIterator2.hasNext()) {
				System.out.print(listIterator2.next() + " ");
			}
			
			System.out.println("\n");
			
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

    private static void swap(Deck[] array, int i, int r) {
        Deck swap = array[i];
        array[i] = array[r];
        array[r] = swap;
    }
    
}

