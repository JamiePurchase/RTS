package rts.state;
import rts.Game;
import rts.battle.Battle;
import rts.battle.BattleArmy;
import rts.display.Drawing;
import rts.display.ImageLoader;
import rts.graphics.Assets;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class StateTitle extends State
{
	public BufferedImage imgLogo;
	
	public StateTitle()
	{
		initImages();
		initNexus();
	}
	
	public void initImages()
	{
		// Temp
		//"C:/Eclipse/Workspace/RTS/res/interface/titleLogo.png"
		
		//imgLogo = ImageLoader.loadImage("/interface/titleLogo.png");
	}
	
	public void initNexus()
	{
		Game.mouse.nexusClear();
		Game.mouse.nexusAdd("ButtonStart",800, 500, 200, 50);
		Game.mouse.nexusAdd("ButtonQuit",800, 600, 200, 50);
	}
	
	public void render(Graphics g)
	{
		renderBackground(g);
		renderOptions(g);
	}
	
	public void renderBackground(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1366, 768);
		g.drawImage(Drawing.getImage("interface/titleLogo.png"),  0, 0, null);
	}
	
	public void renderOptions(Graphics g)
	{
		Drawing.drawMenuItem(g, "Start",800,500,0);
		Drawing.drawMenuItem(g, "Quit",800,600,0);
	}
	
	public void tick()
	{
		if(Game.mouse.mouseActionPressedL==true)
		{
			String ref = Game.mouse.nexusCheckRef();
			if(ref=="ButtonStart")
			{
				Game.mouse.mouseActionDone();
				
				// Battle
				Game.setStateChange(new StateBattle());
				Game.battle = new Battle();
				
				// Temp - Player
				Battle.army[1] = new BattleArmy("Player","Nation1");
				Battle.army[1].resourceWood = 475;
				Battle.army[1].resourceFood = 500;
				Battle.army[1].resourceGold = 425;
				Battle.army[1].resourceStone = 150;
				Battle.army[1].favourNow = 15;
				Battle.army[1].favourMax = 75;
				Battle.unitAdd("Temp", 1, 6, 9);
				Battle.unit[1].name = "Explorer";
				Battle.unit[1].posD = "S";
				Battle.unit[1].width = 1;
				Battle.unit[1].height = 1;
				Battle.unit[1].gfxTileset = "unit/explorer1";
				Battle.unit[1].gfxPortrait = "portrait/tempMitsunaga2";
				Battle.unit[1].healthNow = 100;
				Battle.unit[1].healthMax = 100;
				Battle.unit[1].action = "Idle";
				Battle.unitAdd("Temp", 1, 12, 11);
				Battle.unit[2].name = "Explorer";
				Battle.unit[2].posD = "S";
				Battle.unit[2].width = 1;
				Battle.unit[2].height = 1;
				Battle.unit[2].gfxTileset = "unit/explorer2";
				Battle.unit[2].gfxPortrait = "portrait/temp";
				Battle.unit[2].healthNow = 100;
				Battle.unit[2].healthMax = 100;
				Battle.unit[2].action = "Idle";
				Battle.buildingAdd("TownCenter",1,4,4);
				Battle.building[1].name = "Town Center";
				Battle.building[1].width = 4;
				Battle.building[1].height = 4;
				Battle.building[1].gfxImage = "building/TownCenter1";
				Battle.building[1].commandLabel[1] = "Train";
				Battle.building[1].commandLabel[2] = " ";
				Battle.building[1].commandLabel[3] = " ";
				Battle.building[1].commandRef[1][1] = "Settler";
				Battle.building[1].commandIcon[1][1] = "temp";
				
				// Temp - Computer
				Battle.army[2] = new BattleArmy("Computer","Nation2");
			}
			if(ref=="ButtonQuit")
			{
				System.exit(0);
			}
		}
	}
}