package blackjack;
//Main method class for Blackjack
import java.util.Scanner;

public class GameRunner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deck theDeck = new Deck(1, true);//deal one deck
		
		System.out.println("What is your name? ");
		String s;
		s = sc.next();
		System.out.println("How many rounds would you like to play?");
		int rounds = sc.nextInt();
		int wins = 0;
		
		
		//player's object
		Players me = new Players(s);
		Players dealer = new Players("Dealer");
		//while loop to restart game
		//boolean playerCont = true;
		while (rounds > 0 ) {
			
		me.emptyHand();
		dealer.emptyHand();
		
		//add two cards to human and dealer player
		me.addCard(theDeck.dealNextCard());
		dealer.addCard(theDeck.dealNextCard());
		me.addCard(theDeck.dealNextCard());
		dealer.addCard(theDeck.dealNextCard());
		
		//print hands
		System.out.println("Cards are dealt...\n");
		System.out.println(s + "'s hand: ");
		me.printHand(true);
		System.out.println("Dealer's hand: ");
		dealer.printHand(false);
		System.out.println("\n");
		
		//determine when player is finished hitting
		boolean meDone = false;
		boolean dealerDone = false;
		String answer;
		
		while(!meDone || !dealerDone) {
			//player's turn
			if(!meDone) {
				System.out.print("Hit or Stay? (Enter H or S): ");
				answer = sc.next();//reads user input
				System.out.println();
				//if player hits
				if(answer.compareToIgnoreCase("H") == 0) {
					//add next card in deck and store if player is busted
					meDone = !me.addCard(theDeck.dealNextCard());
					System.out.println(s + "'s hand: ");
					me.printHand(true);
				} else {
					meDone = true;
				}
			}
			//dealer's turn
			if(!dealerDone) {
				if(dealer.getHandSum() < 17) {
					System.out.println("The Dealer hits\n");
					dealerDone = !dealer.addCard(theDeck.dealNextCard());
					dealer.printHand(false);
				} else {
					System.out.println("The Dealer stays\n");
					dealerDone = true;
				}
			}
			System.out.println();
		}
		
		//close scanner
		//sc.close();
		//print final hands
		System.out.println(s + "'s hand: ");
		me.printHand(true);
		System.out.println("Dealer's hand: ");
		dealer.printHand(true);
		
		//calc the sum of both players; print the sum & determine winner
		int mySum = me.getHandSum();
		System.out.println("Total sum of " + s + "'s hand: " + me.getHandSum());
		int dealerSum = dealer.getHandSum();
		System.out.println("Total sum of " + "Dealer's hand: " + dealer.getHandSum());
		if(mySum > dealerSum && mySum <= 21) {
			System.out.println("You win!");
			wins++;
		} else if(dealerSum > mySum && dealerSum <= 21) {
			System.out.println("Dealer wins!");
		} else if(mySum > 21 && dealerSum <= 21) {
			System.out.println("Dealer wins!");
		} else if(dealerSum > 21 && mySum <= 21) {
			System.out.println("You win!");
			wins++;
		} else if(mySum > 21 && dealerSum > 21) {
			System.out.println("Both players bust!");
		}
		else  {
			System.out.println("It's a draw!");
		}
	
		//System.out.print("Would you like to play again? (Enter Y or N)");
		
		/*String playerInput;
		
		playerInput = sc.next();
		if(playerInput.equals("y")) {
			playerCont = true;
		}
		else if (playerInput.equals("n")) {
			playerCont = false;
		}
		else {
			System.exit(0);
		}*/
		rounds--;
	  }
		sc.close();
		System.out.println("You won " + wins + " rounds!");
	}

}
