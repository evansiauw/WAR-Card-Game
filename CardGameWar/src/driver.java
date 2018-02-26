import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;
import java.math.*;

public class driver {

    public static void main(String[] args) {
    
        Deck array [] = new Deck[52];
        LinkedList <Deck> player1 = new LinkedList <>();
        LinkedList <Deck> player2 = new LinkedList <>();
        
        String [] ranks = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
        
        for(int i=0; i<52; i++) {
            array [i] = new Deck(ranks[i%13],(i%13)+2); 
        }   
        
        shuffling(array);
        playGame(array, player1, player2);
        
    }
    
    private static void playGame(Deck array [], LinkedList <Deck> player1, LinkedList <Deck> player2) {
        
        LinkedList <Deck> temp = new LinkedList <>();
    
        for(int i=0; i<26; i++) {
            player1.add(array[i]);
        }
        
        for(int j=26; j<52; j++) {
            player2.add(array[j]);
        }
        
        System.out.println("Begin game:");
        System.out.println("Number of Cards in Player 1's Deck: "+player1.size());
        System.out.println("Number of Cards in Player 2's Deck: "+player2.size());
        printingCards(player1,player2);
        
        while (player1.size() > 0 && player2.size() > 0) {
            
            if(player1.getFirst().getValue() > player2.getFirst().getValue()) {
                player1.add(player1.removeFirst());
                player1.add(player2.removeFirst()); 
                System.out.println("Player 1 wins this round\n");
            }
            
            else if (player1.getFirst().getValue() < player2.getFirst().getValue()) {
                player2.add(player2.removeFirst());
                player2.add(player1.removeFirst());
                System.out.println("Player 2 wins this round\n");
            }
            
            else {
            		if (player1.size() >= 5 && player2.size() >= 5){
            		    System.out.println("We have a standard war\n");
            		    standardWar(player1, player2, temp); 
            		}
            		else {
            			System.out.println("We have a modified war\n");
            			ModifiedWar(player1, player2, temp);
            		}
            }
            System.out.println("Number of Cards in Player 1's Deck: "+player1.size());
            System.out.println("Number of Cards in Player 2's Deck: "+player2.size());
            
            printingCards(player1, player2); 
            
        }
        if (player1.size() > player2.size()) System.out.println("Player 1 Wins the Game!");
        else System.out.println("Player 2 Wins the Game!");
    }
    
    private static void ModifiedWar(LinkedList <Deck> player1, LinkedList <Deck> player2, LinkedList <Deck> temp){
    	if (player1.size() != 1 && player2.size() != 1){
    		//remove cards that caused the war and put them in temp list
            temp.add(player1.removeFirst());
            temp.add(player2.removeFirst());
        
            int num = Math.min(player1.size(), player2.size()); 
    		
            //the player with less cards deals whatever they got
    		for(int i = 0; i < num-1; i++) {
    			temp.add(player1.removeFirst());
    			temp.add(player2.removeFirst());
    		}
    		
    		//the player with more cards does a regular war
    		/*for(int i = 0; i < 4; i++) {
                if (player1.size() > player2.size()) temp.add(player1.removeFirst());
                else temp.add(player2.removeFirst());
            }*/
    		
    		if(player1.getFirst().getValue() > player2.getFirst().getValue()) {
                temp.add(player1.getFirst());
                player1.removeFirst();
                temp.add(player2.getFirst());
                player2.removeFirst();
                player1.addAll(temp);
                temp.clear();
                System.out.println("Player 1 wins this round\n");
            }
            
            else if(player1.getFirst().getValue() < player2.getFirst().getValue()) {
                temp.add(player2.getFirst());
                player2.removeFirst();
                temp.add(player1.getFirst());
                player1.removeFirst();
                player2.addAll(temp);
                temp.clear();
                System.out.println("Player 2 wins this round\n");
            }
    		
        }    
    	else{
                if (player1.size() > player2.size()) {
                    temp.add(player1.removeFirst());
                }
                else {
                    temp.add(player2.removeFirst());
                }
            
            
            /*if(player1.getFirst().getValue() > player2.getFirst().getValue()) {
                temp.add(player1.getFirst());
                player1.removeFirst();
                temp.add(player2.getFirst());
                player2.removeFirst();
                player1.addAll(temp);
                temp.clear();
            }
            
            else if(player1.getFirst().getValue() < player2.getFirst().getValue()) {
                temp.add(player2.getFirst());
                player2.removeFirst();
                temp.add(player1.getFirst());
                player1.removeFirst();
                player2.addAll(temp);
                temp.clear();
            }*/
    	}
    	
    		
    }
    
    private static void standardWar(LinkedList <Deck> player1, LinkedList <Deck> player2, LinkedList <Deck> temp){
            temp.add(player1.getFirst());
            player1.removeFirst();
            temp.add(player2.getFirst());
            player2.removeFirst();
            temp.add(player1.getFirst());
            player1.removeFirst();
            temp.add(player2.getFirst());
            player2.removeFirst();
            temp.add(player1.getFirst());
            player1.removeFirst();
            temp.add(player2.getFirst());
            player2.removeFirst();
            
            if(player1.getFirst().getValue() > player2.getFirst().getValue()) {
                temp.add(player1.getFirst());
                player1.removeFirst();
                temp.add(player2.getFirst());
                player2.removeFirst();
                player1.addAll(temp);
                temp.clear();
                System.out.println("Player 1 wins this round");
            }
            
            else if(player1.getFirst().getValue() < player2.getFirst().getValue()) {
                temp.add(player2.getFirst());
                player2.removeFirst();
                temp.add(player1.getFirst());
                player1.removeFirst();
                player2.addAll(temp);
                temp.clear();
                System.out.println("Player 2 wins this round");
            }
        
    }
    
    private static void printingCards(LinkedList <Deck> player1, LinkedList <Deck> player2)
    {
        ListIterator<Deck> listIterator3 = player1.listIterator();
        System.out.println("Player 1's hand:");
        while (listIterator3.hasNext()) {
            System.out.print(listIterator3.next() + " ");
        }
        System.out.println();
        System.out.println("Player 2's hand:");
        ListIterator<Deck> listIterator4 = player2.listIterator();
        while (listIterator4.hasNext()) {
            System.out.print(listIterator4.next() + " ");
        }
        
        System.out.println("\n");
    }
    
    
    private static void shuffling(Deck array []) {
        
        System.out.println("Before Shuffling");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
        
        int arrayLength = array.length;
        for (int i = 0; i < arrayLength; i++) {
            int r = i + (int) (Math.random() * (arrayLength-i));   // between i and n-1
            swap(array, i, r);
        }
        
        System.out.println("After Shuffling");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("\n");
    }

    
    private static void swap(Deck[] array, int i, int r) {
        Deck swap = array[i];
        array[i] = array[r];
        array[r] = swap;
    }
    
}

