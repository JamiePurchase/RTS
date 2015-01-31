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
	public String gfxImage;
	public String gfxPortrait;
	
	// Stats
	public int healthNow;
	public int healthMax;
	
	// Action
	public String action;
	
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
}