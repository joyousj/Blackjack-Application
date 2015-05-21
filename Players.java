package blackjack;

//Class for human and dealer players
public class Players {

	private String name;
	private Card[] hand = new Card[10];//Card array name hand - cards in player's current hand
	private int numCards;//number of cards in player's current hand
	
	public Players(String aName) {
		this.name = aName;
		
		//set a player's hand to empty
		this.emptyHand();
	}
	//reset the player's hand to have no cards
	public void emptyHand() {
		for(int c = 0; c < 10; c++) {
			this.hand[c] = null;
		}
		this.numCards = 0;
	}
	//add card to player's hand; card to add whether sum of new hand is below or equal to 21
	public boolean addCard(Card aCard) {
		//print error if hand has max number (10) of cards
		if(this.numCards == 10) {
			System.err.printf("%s's hand already has 10 cards; " + "cannot add another card\n", this.name);
			System.exit(1);
		}
		//add new card in next slot and increment number of cards counter
		this.hand[this.numCards] = aCard;
		this.numCards++;
		
		return (this.getHandSum() <= 21);
	}

	
	//method-get sum of cards in player's hand
	public int getHandSum() {
		int handSum = 0;
		int cardNum;
		int numAces =0;
		
		//calc each card's contribution to hand sum
		for(int c =0; c < this.numCards; c++) {
			cardNum = this.hand[c].getNumber();//get number for current card
			
			if(cardNum == 1) {//Ace value(rank)
				numAces++;
				handSum += 11;
			} else if (cardNum > 10) {//face card
				handSum += 10;
			} else {
				handSum += cardNum;
			}
		}
		//if aces and sum is greater than 21, set some/all to value(rank) of 1 instead
		while (handSum > 21 && numAces > 0) {
			handSum -= 10;
			handSum--;
		}
		return handSum;
	}
	//print cards in player's hand
	public void printHand(boolean showFirstCard) {
		for(int c = 0; c < this.numCards; c++) {
			if(c == 0 && !showFirstCard) {
				System.out.println(" [hidden]");
			} else {
				System.out.printf(" %s\n", this.hand[c].toString());
			}
		}
	}
	
	
}
