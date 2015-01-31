package rts.battle;

import java.awt.image.BufferedImage;

public class BattleUnit
{
	// Details
	public String name;
	public String type;
	public int army;
	
	// Location
	public int posX;
	public int posY;
	public String posD;
	
	// Graphics
	public int width;
	public int height;
	public String gfxTileset;
	public String gfxPortrait;
	
	// Stats
	public int healthNow;
	public int healthMax;
	
	// Action
	public String action;
	public int actionTargetPosX;
	public int actionTargetPosY;
	
	// Shortcut
	//public boolean shortcutActive = false;
	//public String shortcutKey;
	
	public BattleUnit(String unit, int assign, int x, int y)
	{
		name = "";
		type = unit;
		army = assign;
		posX = x;
		posY = y;
		//gfxTileset
		//gfxPortrait
		healthNow = 0;
		healthMax = 0;
		action = "Idle";
	}
}