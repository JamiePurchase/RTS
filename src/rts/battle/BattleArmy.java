package rts.battle;

public class BattleArmy
{
	// Details
	public String control;
	public String nation;
	
	// Resources
	public int resourceWood = 0;
	public int resourceFood = 0;
	public int resourceGold = 0;
	public int resourceStone = 0;
	public int resourceMax = 0;
	
	// Population
	public int populationNow = 0;
	public int populationMax = 0;
	
	// Favour
	public int favourNow = 0;
	public int favourMax = 0;
	
	public BattleArmy(String setControl, String setNation)
	{
		control = setControl;
		nation = setNation;
	}

}