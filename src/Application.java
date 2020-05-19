import Models.Board;
import Models.Card;
import Models.Dealer;
import Models.Player;

public class Application {
    
    public static void presentation(String title){
        print("*******************");
        print("| "+title+" |");
        print("*******************");
    }
    
    public static void showTieText(Player player, Board board) {
    	print("Jogo acabou");
		print("Quantidade de cartas na mão: " + player.getHandSize());
		print("Soma Total: " + player.getHandSum());
		print("Cartas na mão: " + player.showHand());
		print("Cartas na mesa: \n" 
			+ board.getFaceDownCard().toString() + "\n"
			+ board.getFaceUpCard().toString()
		);
    }
    
    public static void showWinText(Player player) {
    	print(player.getName() + "É O VENCEDOR!");
		print("Quantidade de cartas na mão: " + player.getHandSize());
		print("Soma Total: " + player.getHandSum());
		print("Cartas na mão: " + player.showHand());
    }
    
    //abstraction
    public static void print(Object generic) {
    	System.out.println(generic.toString());
    }
    
    public static void main(String[] args) {
    	//initialize the dealer
    	Dealer dealer = new Dealer();
    	
    	//initialize 2 players
    	Player ia1 = new Player("Alfred");
    	
    	//initialize new Board
    	Board board = new Board();
    	
    	dealer.setFaceUpCard(board);
    	print("Mesa: Virada para cima - " + board.getFaceUpCard().toString());
    	
    	dealer.setFaceDownCard(board);
    	
    	//give two cards for each player
    	for(int i = 1; i <= 2; i++) {
    		Card card = dealer.getRandomCard();
    		ia1.pickCard(card);
    		print("Player" + String.valueOf(i) + ": " + card.toString());
    	}
    		
    	
    	boolean endGame = false;
    	
    	while(!endGame) {
    		if(!ia1.think(board.getFaceUpCard())) {
    			
    			if(ia1.getHandSum() == 21) showWinText(ia1);
    			else showTieText(ia1, board);
    			endGame = true;
    			break;
    		}
    		
    		// card in hand player + faceUpCard is lower than 21
    		ia1.pickCard(board.getFaceUpCard());
    		
    		if(!ia1.think(dealer.getFaceDownCardFromBoard(board))) {
    			if(ia1.getHandSum() == 21) showWinText(ia1);
    			else showTieText(ia1, board);
    			endGame = true;
    			break;
    		}
    		
    		ia1.pickCard(dealer.getFaceDownCardFromBoard(board));
    		
    		// picking cards until endGame
    		while(endGame == false) {
    			Card card = dealer.getRandomCard(); 
    			
    			if(!ia1.think(card)) {
    				if(ia1.getHandSum() == 21) showWinText(ia1);
    				else showTieText(ia1, board);
    				endGame = true;
    				break;
    			}
    			
    			ia1.pickCard(card);
    		}
    		
    	}
    	
    }
    
}
