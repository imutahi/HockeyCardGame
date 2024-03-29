
public class Hand 
{
	Card[] myCards = new Card[5];
	int acceptCardsIndex = 0;
	int nextCardIndex = 0;
	
	public void handDisplay()
	{
		for(int x = 0; x < 5; x++)
		{
			if(myCards[x] != null)
				System.out.println(myCards[x].getCardImage());
		}
	}
	
	public Card getNextCard()
	{
		Card nextCard = null;
		nextCard = myCards[nextCardIndex];
		nextCardIndex ++;
		if (nextCardIndex > 4) nextCardIndex = 0;
		return nextCard;
	}
	
	public void markCardPlayed(int x)
	{
		myCards[x].setSuit("played");
		myCards[x].setValue("played");
	}
	
	public boolean hasBeenPlayed(int x)
	{
		if(myCards[x].getSuit().equals("played"))
			return true;
		else
			return false;
	}
	
	public Card getCard(int x)
	{
		return myCards[x];
	}
	
	public void acceptCard(Card c)
	{
		if(acceptCardsIndex > 4) acceptCardsIndex = 0;
		myCards[acceptCardsIndex] = c;
		acceptCardsIndex++;
	}
	
}
