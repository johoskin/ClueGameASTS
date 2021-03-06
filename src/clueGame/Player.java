package clueGame;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Player {
	private String playerName;
	private int row;
	private int column;
	private Color color;
	protected ArrayList<Card> myCards = new ArrayList<Card>();
	protected ArrayList<Card> seenCards = new ArrayList<Card>();
	protected ArrayList<Card> unSeenCards = new ArrayList<Card>();
	
	
	public ArrayList<Card> getUnSeenCards() {
		return unSeenCards;
	}

	public void setUnSeenCards(ArrayList<Card> unSeenCards) {
		this.unSeenCards = unSeenCards;
	}

	public ArrayList<Card> getSeenCards() {
		return seenCards;
	}

	public void setSeenCards(ArrayList<Card> seenCards) {
		this.seenCards = seenCards;
	}

	public Player(){
		
	}
	
	public Player(String playerName, int row, int column, Color color){
		this.playerName = playerName;
		this.row = row;
		this.column = column;
		this.color = color;
	}
	
	public ArrayList<Card> getMyCards() {
		return myCards;
	}

	public Card disproveSuggestion(Solution suggestion) {
		ArrayList<Card> matching = new ArrayList<Card>();
		for(int i = 0; i < myCards.size(); i++){
			
			if(getMyCards().get(i).getCardType() == CardType.PERSON){
				if(myCards.get(i).getCardName().equals(suggestion.person)){
					matching.add(getMyCards().get(i));
				}
			}
			
			if(myCards.get(i).getCardType() == CardType.WEAPON){
				if(myCards.get(i).getCardName().equals(suggestion.weapon)){
					matching.add(getMyCards().get(i));
				}
			}
			
			if(getMyCards().get(i).getCardType() == CardType.ROOM){
				if(getMyCards().get(i).getCardName().equals(suggestion.room)){
					matching.add(getMyCards().get(i));
				}
			}
			
		}
		
		if(matching.size() == 0){
			return null;
		}
		
		if(matching.size() == 1){
			return matching.get(0);
		}
		Random randomGen = new Random();
		int randomInt = randomGen.nextInt(matching.size());
		return matching.get(randomInt);
	}


	public void setMyCards(ArrayList<Card> myCards) {
		this.myCards = myCards;
	}

	public String getPlayerName() {
		return playerName;
	}


	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}


	public int getRow() {
		return row;
	}


	public void setRow(int row) {
		this.row = row;
	}


	public int getColumn() {
		return column;
	}


	public void setColumn(int column) {
		this.column = column;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}
}
