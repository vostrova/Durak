import java.util.Random;

/**
 * @author A.Vostrova
 * 
 */

public class Durak {

	// Attributes
	Player player1;
	Player player2;
	Deck deck;

	// Constructor
	public Durak() {
		player1 = new Player();
		player2 = new Player();
		deck = new Deck();
	}

	// deals cards to the player
	private void dealCards(Player player) {
		while (player.getNumOfCards() < 6 && !deck.isEmpty()) {
			Card card = deck.deleteCard();
			player.addCard(card);
		}
	}

	// randomly determines trump suit
	private String determineTrumpSuit() {
		String[] suits = { "diamonds", "clubs", "hearts", "spades" };
		Random r = new Random();
		int randomNumber = r.nextInt(suits.length);
		return suits[randomNumber];
	}

	public void playDurak() {
		// deal cards to the players
		dealCards(player1);
		dealCards(player2);
		// determination of trump suit
		String trump = determineTrumpSuit();
		System.out.println("Trump suit is " + trump);
		int roundCount = 1;
		boolean gameOver = false;
		while (!gameOver) {
			System.out.println("Round № " + roundCount);
			// Player attacks
			Card cardPlayed = player1.attack(trump);
			System.out.println("Player 1: " + cardPlayed.toString());
			// Player defends
			Card cardOfDefence = player2.defend(cardPlayed, trump);
			// player can't defend
			if (cardOfDefence == null) {
				System.out.println("Player 2: " + "-");
				player2.addCard(cardPlayed);
				dealCards(player2);
				dealCards(player1);
			} else {
				System.out.println("Player 2: " + cardOfDefence.toString());
				dealCards(player2);
				dealCards(player1);
				Player playerCur = player2;
				player2 = player1;
				player1 = playerCur;
			}
			roundCount++;
			// You have no cards? Congratulations. You won. Game over.
			if (deck.isEmpty() && player1.getNumOfCards() == 0 && player2.getNumOfCards() != 0) {
				System.out.println("Player 2 is Durak.");
				gameOver = true;
			}
			if (deck.isEmpty() && player2.getNumOfCards() == 0 && player1.getNumOfCards() != 0) {
				System.out.println("Player 1 is Durak.");
				gameOver = true;
			}
			
			//Both of you have no cards? No one is Durak. Game over.
			if (deck.isEmpty() && player2.getNumOfCards() == 0 && player1.getNumOfCards() == 0) {
				System.out.println("No one is Durak.");
				gameOver = true;
			}
		}

	}

}
