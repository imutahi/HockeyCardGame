import java.util.Scanner;

public class Human extends Player
{
	Scanner in = new Scanner(System.in);
	Deck d = new Deck();
	Card c = new Card();
	boolean cardMatch = true;
	
	public String takeTurn(String lcp)
	{
		printIntro(lcp);
		displayHand();
		
		int n = getCardToPlay();
		
		String cardPlayed = h.getCard(n-1).getCardImage();
		System.out.println("\nYou play card: " + cardPlayed + "\n\n");
		
		h.markCardPlayed(n-1);
		
		
		return cardPlayed;
		
	}
	
	public void printIntro(String lcp)
	{
		System.out.println("Player 1, It is your turn!");
		System.out.println("\nThe last card played was " + lcp);
	}
	
	public void displayHand()
	{
		System.out.println("\nYour hand:");
		System.out.println("Card 1               Card 2           Card 3            Card 4         Card 5");
		for(int x = 0; x<5; x++)
		{
			if (!h.hasBeenPlayed(x))
				System.out.print(h.getCard(x).getCardImage() + "     ");
			else
				System.out.print("played          ");
		}
		System.out.println();

	}
	
	public int getCardToPlay()
	{
		boolean cardPlayed = true;
		int n = 0;
		while(cardPlayed)
		{
			n = 0;
			while(n < 1 || n > 5)
			{
				
				System.out.print("Which card number would you like to play? ");
				n = in.nextInt();
			}
			if(!h.hasBeenPlayed(n-1))
				cardPlayed = false;
		}
		return n;
	}
}

