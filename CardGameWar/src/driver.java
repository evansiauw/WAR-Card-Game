import java.util.LinkedList;

public class driver {

	public static void main(String[] args) {
	
		Deck array [] = new Deck[52];
		
		String [] ranks = {"2","3","4","5","6","7","8","9","10","Jack","Queens","King","Ace"};
		
		for(int i=0; i<52; i++) {
			
			array [i] = new Deck(ranks[i%13],(i+2)%12);
			
			}
		
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
		
	    LinkedList<Integer> list = new LinkedList<>();

	
	}

    private static void swap(Deck[] a, int i, int r) {
        Deck swap = a[i];
        a[i] = a[r];
        a[r] = swap;
    }
    
}

