package rts.battle;

import java.awt.image.BufferedImage;

public class BattleBuilding
{
	// Details
	public String name;
	public String type;
	public int army;
	
	// Location
	public int posX;
	public int posY;
	public int width;
	public int height;
	
	// Graphics
	public static String gfxImage;
	public static String gfxPortrait;
	
	// Stats
	public int healthNow;
	public int healthMax;
	
	// Action
	public String action;
	public int actionTrainNow;
	public int actionTrainMax;
	public BattleUnit actionTrainUnit;
	
	// Commands
	public String[] commandLabel = new String[4];
	public String[][] commandRef = new String[7][4];
	public String[][] commandIcon = new String[7][4];
	
	// Shortcut
	//public boolean shortcutActive = false;
	//public String shortcutKey;
	
	public BattleBuilding(String building, int assign, int x, int y)
	{
		name = "";
		type = building;
		army = assign;
		posX = x;
		posY = y;
		width = 0;
		height = 0;
		//gfxImage
		//gfxPortrait
		healthNow = 0;
		healthMax = 0;
		action = "Idle";
	}
	
	public static String getImage(String type)
	{
		return gfxImage + type + ".png";
	}
	
	public static String getPortrait()
	{
		return gfxPortrait + ".png";
	}
}