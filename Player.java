public abstract class Player
{
	Hand h = null;
	int score = 0;
	boolean breakaway = false;
	// the set and get function of breakaway helps the game identify which player is on breakaway.
	public boolean isBreakaway()  // Setters and Getters 
	{
		return breakaway;
	}
	public void setBreakaway(boolean breakaway)
	{
		this.breakaway = breakaway;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void acceptHand(Hand x)
	{
		h = x;
	}
	
	public abstract String takeTurn(String lcp);

}

