public class Card {

	// attributes
	private String suit;
	private int value;

//constructor
	public Card(String suit, int value) {
		this.suit = suit;
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;

	}

	public void setValue(int value) {
		this.value = value;

	}

	public String toString() {
		if (value == 11) {
			return "Jack of " + suit;
		}
		if (value == 12) {
			return "Queen of " + suit;
		}
		if (value == 13) {
			return "King of " + suit;
		}
		if (value == 14) {
			return "Ace of " + suit;
		}

		return value + " of " + suit;

	}

}
