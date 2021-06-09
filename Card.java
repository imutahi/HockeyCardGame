public class Card 
{
	String value;
	String suit;
	
	//This constructor created to preserve original constructor ability
	//This is required when making an alternate constructor
	Card()
	{
		;
	}

	//This constructor created for convenience	
	Card(String v, String s)
	{
		suit = s;
		value = v;      
	}
	
	public String getSuit() 
	{
		return suit;
	}
	public void setSuit(String suit) 
	{
		this.suit = suit;
	}
	public String getValue() 
	{
		return value;
	}
	public void setValue(String value) 
	{
		this.value = value;
	}
	
	public String getCardImage()
	{
		String returnValue = value + " of " + suit;
		return returnValue;
	}

	public char[] cardDisplay() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
