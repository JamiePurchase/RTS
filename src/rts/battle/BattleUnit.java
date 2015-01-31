package rts.battle;

import java.awt.image.BufferedImage;

import rts.display.Drawing;
import rts.display.Spritesheet;

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
	public static String gfxTileset;
	public static String gfxPortrait;
	
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
	
	public static BufferedImage getImage(String direction, int frame)
	{
		// Spritesheet
		String image = gfxTileset + ".png";
		Spritesheet sheet = new Spritesheet(Drawing.getImage(image));
		
		// Individual Image
		if(direction=="N" && frame==1){return sheet.crop(32, 96, 32, 32);}
		if(direction=="N" && frame==2){return sheet.crop(0, 96, 32, 32);}
		if(direction=="N" && frame==3){return sheet.crop(64, 96, 32, 32);}
		if(direction=="E" && frame==1){return sheet.crop(32, 64, 32, 32);}
		if(direction=="E" && frame==2){return sheet.crop(0, 64, 32, 32);}
		if(direction=="E" && frame==3){return sheet.crop(64, 64, 32, 32);}
		if(direction=="S" && frame==1){return sheet.crop(32, 0, 32, 32);}
		if(direction=="S" && frame==2){return sheet.crop(0, 0, 32, 32);}
		if(direction=="S" && frame==3){return sheet.crop(64, 0, 32, 32);}
		if(direction=="W" && frame==1){return sheet.crop(32, 32, 32, 32);}
		if(direction=="W" && frame==2){return sheet.crop(0, 32, 32, 32);}
		if(direction=="W" && frame==3){return sheet.crop(64, 32, 32, 32);}
		return sheet.crop(32, 0, 32, 32);
	}
	
	public static String getPortrait()
	{
		return gfxPortrait + ".png";
	}
}