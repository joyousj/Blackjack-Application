package blackjack;
//Card Class for Blackjack
public class Card {

	private Suit suit;//one of four valid suits
	private int number;//number of card; Ace is 1, Jack-King is 11-13
	
	//Card constructor; create instance of a Card
	public Card(Suit aSuit, int aNumber) {
		this.suit = aSuit;//suit of a card
		
		//Check to make sure number is valid
		if(aNumber >= 1 && aNumber <= 13) {
			
			this.number = aNumber;//the number of a card
			
		} else {
			System.err.println(number + " is not a valid Card number");
			System.exit(1);//exit with status 1
		}
	
	}

	//Return the number of the card
	public int getNumber() {
		return number;
	}

	//Overload toString() method-custom toString() method
	public String toString() {
		
		String numStr = "Error";
		
		switch(this.number) {
		
		case 2:
			numStr = "2";
			break;
			
		case 3:
			numStr = "3";
			break;
			
		case 4:
			numStr = "4";
			break;
			
		case 5:
			numStr = "5";
			break;
			
		case 6:
			numStr = "6";
			break;
			
		case 7:
			numStr = "7";
			break;
			
		case 8:
			numStr = "8";
			break;
			
		case 9:
			numStr = "9";
			break;
			
		case 10:
			numStr = "10";
			break;
			
		case 11:
			numStr = "J";
			break;
			
		case 12:
			numStr = "Q";
			break;
			
		case 13:
			numStr = "K";
			break;
			
		case 1:
			numStr = "A";
			break;
		}
		return numStr + suit.toString();
	}
	
	
}
