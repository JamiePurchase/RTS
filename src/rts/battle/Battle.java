package rts.battle;

public class Battle
{
	// Tiles
	public boolean[] tileSolid = new boolean[43];
	
	// Units
	public BattleUnit[] unit = new BattleUnit[100];
	public int unitCount = 0;
	
	// Buildings
	public BattleBuilding[] building = new BattleBuilding[100];
	public int buildingCount = 0;

	public Battle()
	{
		
	}
	
	public void buildingAdd(String type, int army, int posX, int posY)
	{
		buildingCount+=1;
		building[buildingCount] = new BattleBuilding(type, army, posX, posY);
	}
	
	public void unitAdd(String type, int army, int posX, int posY)
	{
		unitCount+=1;
		unit[unitCount] = new BattleUnit(type, army, posX, posY);
	}
}