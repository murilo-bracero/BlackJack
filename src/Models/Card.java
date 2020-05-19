package Models;

public class Card {
    private String name;
    private String suit;
    
    Card(String name, String suit){
        this.name = name;
        this.suit = suit;
    }
    
    public String getName(){
        return name;
    }
    
    public String getSuit(){
        return suit;
    }
    
    public String toString(){
        return name + "/" + suit;
    }
    
    public int getCardValue() {
    	try {
    		return Integer.parseInt(name);
    	}catch(Exception e) {
    		if(name == "As") return 1;
    		else return 10;
    	}
    }
}
