package rts.battle;

public class Battle
{
	// Tick
	public static int tickClock = 0;
	public static boolean tickPause = false;
	
	// State
	public static boolean menuMainActive = false;
	public static int menuMainPos;
	public static int menuMainMax;
	
	// Selection
	public static boolean selectionActive = false;
	public static String selectionType;
	public static int selectionID = 0;
	public static boolean selectionMulti = false;
	public static int[] selectionArray = new int[50];
	
	// Armies
	public static BattleArmy[] army = new BattleArmy[3];
	
	// Units
	public static BattleUnit[] unit = new BattleUnit[100];
	public static int unitCount = 0;
	
	// Buildings
	public static BattleBuilding[] building = new BattleBuilding[100];
	public static int buildingCount = 0;

	// Tiles
	public static boolean[] tileSolid = new boolean[43];

	public Battle()
	{
	}
	
	public static void buildingAdd(String type, int army, int posX, int posY)
	{
		buildingCount+=1;
		building[buildingCount] = new BattleBuilding(type, army, posX, posY);
	}
	
	public static void unitAdd(String type, int army, int posX, int posY)
	{
		unitCount+=1;
		unit[unitCount] = new BattleUnit(type, army, posX, posY);
	}
}