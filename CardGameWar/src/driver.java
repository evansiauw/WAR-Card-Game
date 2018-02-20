public class driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//
		
		/// hellllooooooooooooooooooo
		
		deck newDeck= new deck();
		

	}



	public class card implements Comparable<card>{
		
		public int rank;
		private String nameCard;
		
		card(){
			
		}
		
		public void setRank(int n) {
			this.rank=n;
			//this.nameCard= (String)n;
			
			
		} 
		
		
		
		
		@Override
		public int compareTo(card o) {
			if (this.rank< o.rank) {return -1;}
			else if(this.rank>o.rank) {return 1;}
			else {return 0;}
		}
		
		
	}// end of class card
	
	
	
	
	public class deck{
		
	card [] deck= new card [52];
		
		deck () {
			
		}
	}


}// end of driver
