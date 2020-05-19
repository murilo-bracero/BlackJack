package Models;

import java.util.ArrayList;

public class Player {
	
	private ArrayList<Card> hand = new ArrayList<Card>();
	private String name;
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Card> getHand(){
		return hand;
	}
	
	public String showHand() {
		String str = "\n";
		for(Card card : hand) {
			str += card.toString() + "\n";
		}
		
		return str;
	}
	
	public int getHandSize() {
		return hand.size();
	}
	
	public int getHandSum() {
		int sum = 0;
		
		for(Card card : hand) {
			sum += card.getCardValue();
		}
		return sum;
	}
	
	public void pickCard(Card card) {
		hand.add(card);
	}
	
	public boolean think(Card card) {
		if((this.getHandSum() + card.getCardValue()) >= 21) {
			return false;
		}
		
		return true;
	}

}
