// This is what regulates the game logic and makes it run.
public class Game 
{
	static String lastCardPlayed = "none";
	static String currentCardPlayed = "none";
	
	
	static Deck d = new Deck();
	static Human player1 = new Human();
	static AI ai = new AI();
	static Card c = new Card();

	public static void main(String[] args) 
	{
		
		startGame();
		play();
		endGame();
	}
	static void play()
	{
		for (int x=0;x<3;x++) //for the three periods in a game
		{
			System.out.println("\n\nYou are in period "+(x+1));
			Deck d = new Deck();
			for(int z=0;z<5;z++)
			{
				System.out.println("\n\nYou are in round "+(z+1)+"\n");
				givePlayerHand(player1,d.getNextHand());
				givePlayerHand(ai,d.getNextHand());
				
				for(int a = 0; a < 5; a++)// for the turn based rounds
				{
					currentCardPlayed = player1.takeTurn(lastCardPlayed);
					//this next line checks if the cards match and then does not include the first card in the game.
					if ((lastCardPlayed != null) && ((currentCardPlayed.charAt(0)== lastCardPlayed.charAt(0))))
					{// game logic for breakaway for player
						if (player1.isBreakaway())
						{
							player1.setScore(player1.getScore()+1);
							player1.setBreakaway(false);
							System.out.println("YOU HAVE SCORED!!!!! Your current score is: "+ player1.getScore()+" and your opponents score is: "+ai.getScore());
						}
						else
						{
							player1.setBreakaway(true);
							System.out.println("You are currently in BREAKAWAY. Your current score is: "+ player1.getScore()+" and your opponents score is: "+ai.getScore());
						}
					}
					else if (currentCardPlayed.charAt(0)=='J')
					{
						player1.setBreakaway(true);
						System.out.println("You are currently in BREAKAWAY. Your current score is: "+ player1.getScore()+" and your opponents score is: "+ai.getScore());
					}
					else
					{
						player1.setBreakaway(false);
						System.out.println("That play did not result in a Goal, Your current score is: "+player1.getScore()+" and your opponents score is: "+ai.getScore());
					}
						
					lastCardPlayed = currentCardPlayed;
					
					currentCardPlayed = ai.takeTurn(lastCardPlayed); //helps AI to recognize when its "its" turn.
					if ((lastCardPlayed != null) && ((currentCardPlayed.charAt(0)==lastCardPlayed.charAt(0))))
					{ // the code for Player breakaway is Very similar for the AI Breakaway
						if (ai.isBreakaway())
						{
							ai.setScore(ai.getScore()+1);
							ai.setBreakaway(false);
							System.out.println("YOUR OPPONENT SCORED!!!! Your opponents score is: "+ ai.getScore()+" Your score is still: "+player1.getScore());
						}
						else
						{
							ai.setBreakaway(true);
							System.out.println("Your opponent is currently in BREAKAWAY. Your Opponent's score is: "+ ai.getScore()+" Your score is still: "+player1.getScore());
						}
					}
					else if (currentCardPlayed.charAt(0)=='J')
					{
						ai.setBreakaway(true);
						System.out.println("Your oppponent is currently in BREAKAWAY. Your Opponent's score is: "+ ai.getScore()+" Your score is: "+player1.getScore());
					}
					else
					{
						ai.setBreakaway(false);
						System.out.println("Your opponent did not score, his current score is still: "+ai.getScore()+" Your score is: "+player1.getScore());
					}
					
					lastCardPlayed = currentCardPlayed;
				}
			}
		}
	}
	
	static void givePlayerHand(Player p,Hand h)
	{
		p.acceptHand(h);
	}
	
	static void startGame()// Start of the game, message dialogs
	{
		givePlayerHand(player1,d.getNextHand());
		givePlayerHand(ai,d.getNextHand());
	System.out.println("****WELCOME TO HOCKEY!!!!!********");
	System.out.println("Player, Are You Ready?");
	System.out.println("Let The Games..BEGIN!!");
	}
	
	static void endGame() // end game logic, messages
	{
		System.out.println("\n\n                   GAME OVER");
		if(player1.getScore()>ai.getScore())
		{
			System.out.println("\n!!!!!!!!!!!!!!!YOU WIN!! CONGRATULATIONS!!!!!!!!!!!");
		}
		else if (player1.getScore()<ai.getScore())
		{
			System.out.println("Opponent Victory!!, Maybe Next Time. ");
		}
		else
		{
			System.out.println("\n Its a Tie.");
		}
	System.out.println("Play Again?");
	}
}


