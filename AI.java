
public class AI extends Player
{
	static Card c = new Card();
	
	public String takeTurn(String lcp)
	{
		printIntro(lcp);
		
		int n = getCardToPlay(lcp);
		
		
		String cardPlayed = h.getCard(n).getCardImage();
		System.out.println("\nAI plays card: " + cardPlayed + "\n\n");
		
		h.markCardPlayed(n);
		
		return cardPlayed;
		
	}
	
	public void printIntro(String lcp)
	{
		System.out.println("It is the AI's turn!");
		System.out.println("\nThe last card played was " + lcp);
	}
	
	
	public int getCardToPlay(String lcp)
	{
		
		int n = 0;
		if(h.getCard(0).getValue().charAt(0)==lcp.charAt(0))
			n=0;
		else if (h.getCard(1).getValue().charAt(0)==lcp.charAt(0))
			n=1;
		else if (h.getCard(2).getValue().charAt(0)==lcp.charAt(0))
			n=2;
		else if (h.getCard(3).getValue().charAt(0)==lcp.charAt(0))
			n=3;
		else if (h.getCard(4).getValue().charAt(0)==lcp.charAt(0))
			n=4;
		else
		{
			for(int x = 0; x<5; x++)
			{
				if(!h.hasBeenPlayed(x))
					n = x;
			}
		}
		return n;
	}
}