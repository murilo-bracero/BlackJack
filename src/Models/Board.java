package Models;

public class Board {
	
	private Card faceUpCard;
	private Card faceDownCard;
	
	public boolean setFaceUpCard(Card card) {
		if(faceUpCard != null) return false;
		
		faceUpCard = card;
		return true;
	}
	
	public boolean setFaceDownCard(Card card) {
		if(faceDownCard != null) return false;
		
		faceDownCard = card;
		return true;
	}
	
	public Card getFaceUpCard() {
		return faceUpCard;
	}
	
	public Card getFaceDownCard() {
		return faceDownCard;
	}
}
