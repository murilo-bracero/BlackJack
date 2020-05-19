package Models;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> cardDeck;

    public ArrayList<Card> getCardDeck() {
        return cardDeck;
    }

    public Deck() {
        cardDeck = new ArrayList<Card>();

        String suit = "", name = "";

        for (int k = 1; k <= 4; k++) {
            switch (k) {
                case 1:
                    suit = "Paus";
                    break;
                case 2:
                    suit = "Copas";
                    break;
                case 3:
                    suit = "Espadas";
                    break;
                case 4:
                    suit = "Ouros";
                    break;
            }
            for (int j = 1; j <= 13; j++) {
                switch (j) {
                    case 1:
                        name = "As";
                        cardDeck.add(new Card(name, suit));
                        break;
                    case 11:
                        name = "Dama";
                        cardDeck.add(new Card(name, suit));
                        break;
                    case 12:
                        name = "Valete";
                        cardDeck.add(new Card(name, suit));
                        break;
                    case 13:
                        name = "Rei";
                        cardDeck.add(new Card(name, suit));
                        break;
                    default:
                        name = String.valueOf(j);
                        cardDeck.add(new Card(name, suit));
                        break;
                }
            }
        }

    }
    
    public void shuffle(){
        Random randomizer = new Random();
        for( int i = cardDeck.size() - 1; i > 0; i--){
            int rndNum = randomizer.nextInt(i + 1);
            Card aux = cardDeck.get(i);
            cardDeck.set(i, cardDeck.get(rndNum));
            cardDeck.set(rndNum, aux);
        }
    }
    
    public Card getRandomCard(){
    	if(cardDeck.size() == 0) return null;
    	
        Random randomizer = new Random();
        int rndNum = randomizer.nextInt(cardDeck.size() - 1);
        return cardDeck.remove(rndNum);
    }
    
    public void printDeck(){
        for(int i = 0; i < cardDeck.size(); i++){
            System.out.println(String.valueOf(i) + " - " 
                + cardDeck.get(i).getName() + " - " 
                + cardDeck.get(i).getSuit());
        }
    }
}
