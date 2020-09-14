import java.util.ArrayList;

/**
 * @author A.Vostrova
 * 
 */

public class Deck {

	// attributes
	ArrayList<Card> deck;
	String[] suits = { "diamonds", "clubs", "hearts", "spades" };

//constructor
	public Deck() {
		deck = new ArrayList<Card>();
		int count = 0;
		for (String suit : suits) {
			for (int i = 6; i < 15; i++) {
				Card card = new Card(suit, i);
				deck.add(card);
				count++;
			}
		}
	}

	// deletes card from the deck
	public Card deleteCard() {
		Card cardToDelete = deck.get(deck.size() - 1);
		deck.remove(deck.size() - 1);
		return cardToDelete;
	}

//returns the number of cards in the deck
	public int getNumOfCards() {
		return deck.size();
	}

//returns true if the deck is empty
	public boolean isEmpty() {
		if (deck.size() != 0) {
			return false;
		}
		return true;
	}

}
