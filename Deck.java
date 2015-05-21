package blackjack;

//Deck class for 52 cards
import java.util.Random;

public class Deck {
	
	private Card[] cards;//array of cards in deck; top card is the first index
	//private ArrayList<Card> cards;
	//private LinkedList<Card> cards;
	
	private int numCards;//numbers of cards currently in deck
	
	//overloading deck constructor 
	public Deck() {
		//calls other constructor; defining one deck without shuffling
		this(1, false);
	}
	//number of individual decks; shuffle of cards
	public Deck(int numDecks, boolean shuffle) {
		this.numCards = numDecks * 52;
		this.cards = new Card[this.numCards];//new array of type Card
		
		int c = 0;//card index
	
		//for each index
		for(int d = 0; d < numDecks; d++) {
			//for each suit
			for(int s = 0; s < 4; s++) {
				//for each number
				for(int n = 1; n <= 13; n++) {
					//add a new card to deck
					this.cards[c] = new Card(Suit.values()[s], n);
					c++;//increment card index
				}
			}
		}
	//shuffle deck if necessary
		if(shuffle) {
			this.shuffle();
		}
	
	}
	//method for shuffle; shuffle deck randomly swapping pairs of cards
	private void shuffle() {
		Random r = new Random();//random generator
		Card temp;//temp card placeholder when swapping
		int j;
		for(int i = 0; i < this.numCards; i++) {
			//get random card j to swap i's value with
			j = r.nextInt(this.numCards);
			
			//do swap
			temp = this.cards[i];
			this.cards[i] = this.cards[j];
			this.cards[j] = temp;
		}
		
	}
	//Deal next card at top of deck
	public Card dealNextCard() {
		Card top = this.cards[0];//get the top card
		
		//shift all the subsequent cards to the left by one index
		for(int c = 1; c < this.numCards; c++) {
			this.cards[c-1] = this.cards[c];
		}
		this.cards[this.numCards -1] = null;//empty card to the left
		this.numCards--;//decrement number of card in deck
		
		return top;
	}
	//print top cards in deck
	public void printDeck(int numToPrint) {
		for(int c = 0; c < numToPrint; c++) {
		System.out.printf("% 3d/%d %s\n", c + 1, this.numCards, this.cards[c].toString() );
		}
		System.out.printf("\t[%d others]\n", this.numCards - numToPrint);
	}
}
