package Models;

public class Dealer {
	
	private Deck deck;
	
	public Dealer(){
		deck = new Deck();
		deck.shuffle();	
	}
	
	public void setFaceUpCard(Board board) {
		Card card = deck.getRandomCard();
		board.setFaceUpCard(card);
	}
	
	public void setFaceDownCard(Board board) {
		Card card = deck.getRandomCard();
		board.setFaceDownCard(card);
	}
	
	public Card getRandomCard() {
		return deck.getRandomCard();
	}
	
	public Card getFaceDownCardFromBoard(Board board) {
		return board.getFaceDownCard();
	}
}
