import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends Player {
	
	

	public HumanPlayer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	// returns the cards that player attacks with
	public Card attack(String trump) {
		int num = 1;
		for (Card card : cards) {
			System.out.println(num + ". " + card.toString());
			num += 1;
		}
		System.out.println("Which card do you want to attack with (enter a number)?");
		Scanner scan = new Scanner(System.in);
		int cardNum = scan.nextInt();
		Card curCard=cards.get(cardNum-1);
		cards.remove(cardNum-1);
		return curCard;

	}

	// returns card that player defends with
	public Card defend(Card attackCard, String trump) {
		ArrayList<Card> possibleCards = getPossibleCards(attackCard, trump);
		int num = 1;
		if(possibleCards.size()==0) {
			return null;
		}
		for (Card card : possibleCards) {
			System.out.println(num + ". " + card.toString());
			num += 1;
		}
		System.out.println("Which card do you want to defend with (enter a number)?");
		Scanner scan = new Scanner(System.in);
		int cardNum = scan.nextInt();
		if(cardNum!=-1) {
			Card curCard=possibleCards.get(cardNum-1);
			int index=findInCards(curCard);
			cards.remove(index);
			return curCard;

		}
		return null;
		
	}

}
