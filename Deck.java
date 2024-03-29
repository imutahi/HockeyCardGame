
public class Deck 
{
	Card[] cards = new Card[52];
	Hand[] hands = new Hand[10];
	
	//The following attributes created to facilitate createHands()
	//and getNextHand()
	int nextCardLocation = 0;
	int nextHandLocation = 0;

	//The default constructor is overridden to make sure Deck is in
	//a usable form for Game.
	Deck()
	{
		fillDeck();
		shuffle();
		createHands();
	}
	
	void fillDeck()
	{
		//Deck of 52 Cards 
		cards[0] = new Card("Ace","Hearts");
		cards[1] = new Card("2","Hearts");
		cards[2] = new Card("3","Hearts");
		cards[3] = new Card("4","Hearts");
		cards[4] = new Card("5","Hearts");
		cards[5] = new Card("6","Hearts");
		cards[6] = new Card("7","Hearts");
		cards[7] = new Card("8","Hearts");
		cards[8] = new Card("9","Hearts");
		cards[9] = new Card("10","Hearts");
		cards[10] = new Card("Jack","Hearts");
		cards[11] = new Card("Queen","Hearts");
		cards[12] = new Card("King","Hearts");
		
		cards[13] = new Card("Ace","Diamonds");
		cards[14] = new Card("2","Diamonds");
		cards[15] = new Card("3","Diamonds");
		cards[16] = new Card("4","Diamonds");
		cards[17] = new Card("5","Diamonds");
		cards[18] = new Card("6","Diamonds");
		cards[19] = new Card("7","Diamonds");
		cards[20] = new Card("8","Diamonds");
		cards[21] = new Card("9","Diamonds");
		cards[22] = new Card("10","Diamonds");
		cards[23] = new Card("Jack","Diamonds");
		cards[24] = new Card("Queen","Diamonds");
		cards[25] = new Card("King","Diamonds");
		
		cards[26] = new Card("Ace","Clubs");
		cards[27] = new Card("2","Clubs");
		cards[28] = new Card("3","Clubs");
		cards[29] = new Card("4","Clubs");
		cards[30] = new Card("5","Clubs");
		cards[31] = new Card("6","Clubs");
		cards[32] = new Card("7","Clubs");
		cards[33] = new Card("8","Clubs");
		cards[34] = new Card("9","Clubs");
		cards[35] = new Card("10","Clubs");
		cards[36] = new Card("Jack","Clubs");
		cards[37] = new Card("Queen","Clubs");
		cards[38] = new Card("King","Clubs");
		
		cards[39] = new Card("Ace","Spades");
		cards[40] = new Card("2","Spades");
		cards[41] = new Card("3","Spades");
		cards[42] = new Card("4","Spades");
		cards[43] = new Card("5","Spades");
		cards[44] = new Card("6","Spades");
		cards[45] = new Card("7","Spades");
		cards[46] = new Card("8","Spades");
		cards[47] = new Card("9","Spades");
		cards[48] = new Card("10","Spades");
		cards[49] = new Card("Jack","Spades");
		cards[50] = new Card("Queen","Spades");
		cards[51] = new Card("King","Spades");
	}
	
	void shuffle()
	{
		Card hold = null;
		for(int x = 0; x < 52; x++)
		{
			int r = (int)(Math.random() * 52);
			hold = cards[x];
			cards[x] = cards[r];
			cards[r] = hold;
		}
	}
	
	public void displayDeck()
	{
		System.out.println("Cards in the deck:");
		for(int x = 0; x < 52; x ++)
		{
			System.out.println(cards[x].getCardImage());
		}
	}
	
	public void createHands()
	{
		
		for(int x = 0; x < 10; x++)
		{
			Hand h = new Hand();
			for(int y = 0; y < 5; y++)
			{
				h.acceptCard(cards[nextCardLocation]);
				nextCardLocation ++;
				if (nextCardLocation > 51) nextCardLocation = 0;
			}
			hands[x] = h;
			
		}
	}
	
	public Hand getNextHand()
	{
		Hand h = hands[nextHandLocation];
		nextHandLocation ++;
		if (nextHandLocation > 9) nextHandLocation = 0;
		return h;
		
	}
}


