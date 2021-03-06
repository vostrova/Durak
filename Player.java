import java.util.ArrayList;

/**
 * @author A.Vostrova
 * 
 */


public class Player {
	// Attributes
	ArrayList<Card> cards;
	String name;


	// Constructor
	public Player(String name) {
		cards = new ArrayList<Card>();
		this.name=name;
	}

	//adds card to player's cards
	public void addCard(Card card) {
		cards.add(card);
	}

	//returns number of player's cards
	public int getNumOfCards() {
		return cards.size();
	}
	
	//returns player's name
	public String getName() {
			return name;
		}
	
	

	//returns the index of the smallest card of the ArrayList of cards
	public int getTheSmallest(ArrayList<Card> cardArray) {
		int i = 0;
		int minValue = 15;
		int minInd = -1;
		for (Card card : cardArray) {
			if (card.getValue() < minValue) {
				minValue = card.getValue();
				minInd = i;
			}
			i++;
		}
		
		return minInd;

	}

	// returns the index of the given card in the player's cards
	public int findInCards(Card card) {
		int i = 0;
		for (Card c : cards) {
			if (card == c) {
				return i;
			}
			i++;
		}
		return i;
	}

	// returns the card that player attacks with
	public Card attack(String trump) {
		ArrayList<Card> trumpCards = new ArrayList<Card>();
		ArrayList<Card> nonTrumpCards = new ArrayList<Card>();
		for (Card card : cards) {
			if (card.getSuit().equals(trump)) {
				trumpCards.add(card);
			} else {
				nonTrumpCards.add(card);
			}
		}
		if (nonTrumpCards.size() == 0) {
			Card trumpCard = trumpCards.get(getTheSmallest(trumpCards));
			int index = findInCards(trumpCard);
			cards.remove(index);
			return trumpCard;
		}
		Card nonTrumpCard = nonTrumpCards.get(getTheSmallest(nonTrumpCards));
		int index = findInCards(nonTrumpCard);
		cards.remove(index);
		return nonTrumpCard;
	}
	
	public ArrayList<Card> getPossibleCards(Card attackCard, String trump){
		ArrayList<Card> possibleCards = new ArrayList<Card>();
		for (Card card : cards) {
			if (card.getValue() > attackCard.getValue() && card.getSuit().equals(attackCard.getSuit())) {
				possibleCards.add(card);
			}
			if (card.getSuit().equals(trump)) {
				possibleCards.add(card);
			}
		}
		return possibleCards;
		
	}

	// returns card that player defends with
	public Card defend(Card attackCard, String trump) {
		ArrayList<Card> allPossibleCards = getPossibleCards(attackCard, trump);
		ArrayList<Card> possibleCards = new ArrayList<Card>();
		ArrayList<Card> trumpCards = new ArrayList<Card>();
		
		for(Card card: allPossibleCards) {
			if(card.getSuit().equals(trump)) {
				trumpCards.add(card);
			} else {
				possibleCards.add(card);
			}
		}

		if (possibleCards.size() != 0) {
			Card possibleCard = possibleCards.get(getTheSmallest(possibleCards));
			int index = findInCards(possibleCard);
			cards.remove(index);
			return possibleCards.get(getTheSmallest(possibleCards));
		} else {
			if (!attackCard.getSuit().equals(trump) && trumpCards.size()!=0) {
				Card trumpCard = trumpCards.get(getTheSmallest(trumpCards));
				int index = findInCards(trumpCard);
				cards.remove(index);
				return trumpCards.get(getTheSmallest(trumpCards));
			}
		}

		return null;

	}

}
