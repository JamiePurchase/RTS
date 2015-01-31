package rts.state;

import java.awt.Color;
import java.awt.Graphics;

import rts.Game;
import rts.battle.Battle;
import rts.display.Drawing;
import rts.graphics.Assets;

public class StateBattle extends State
{
	
	public StateBattle()
	{
		
	}
	
	public void render(Graphics g)
	{
		renderBackground(g);
		renderFrame(g);
		renderTiles(g);
		renderBuildings(g);
		renderUnits(g);
		renderInterface(g);
		if(Game.battle.menuMainActive==true){renderMenuMain(g);}
	}
	
	public void renderBackground(Graphics g)
	{
		g.setColor(Drawing.getColorRGB(152,213,115));
		g.fillRect(0,0,1366,768);
		g.drawImage(Drawing.getImage("background/grass.png"),  0, 0, null);
	}
	
	public void renderBuildings(Graphics g)
	{
		for(int x=1;x<=Game.battle.buildingCount;x+=1)
		{
			int posX = (32 * Game.battle.building[x].posX) - 20;
			int posY = (32 * Game.battle.building[x].posY) + 19;
			
			// If the building is selected, draw the highlight/cursor image beneath
			
			g.drawImage(Drawing.getImage(Game.battle.building[x].gfxImage), posX, posY, null);
		}
	}
	
	public void renderFrame(Graphics g)
	{
		// Fill
		g.setColor(Drawing.getColorRGB(185,122,87));
		g.fillRect(0, 0, 1366, 50);
		g.fillRect(0, 0, 11, 768);
		g.fillRect(1355, 0, 11, 768);
		g.fillRect(0, 626, 1366, 142);
		
		// Border
		g.setColor(Drawing.getColorRGB(110,68,46));
		g.setColor(Color.WHITE);
		g.drawRect(10,49,1346,578);
		g.drawRect(11,50,1344,576);
	}
	
	public void renderInterface(Graphics g)
	{
		renderInterfaceResources(g);
		renderInterfaceSelection(g);
	}
	
	public void renderInterfaceResources(Graphics g)
	{
		g.setFont(Assets.fontStandard);
		g.setColor(Color.BLACK);
		g.drawString("WOOD", 150, 35);
		String wood = "" + Battle.army[1].resourceWood;
		g.drawString(wood, 250, 35);
		g.drawString("FOOD", 350, 35);
		String food = "" + Battle.army[1].resourceFood;
		g.drawString(food, 450, 35);
		g.drawString("GOLD", 550, 35);
		String gold = "" + Battle.army[1].resourceGold;
		g.drawString(gold, 650, 35);
		g.drawString("STONE", 750, 35);
		String stone = "" + Battle.army[1].resourceStone;
		g.drawString(stone, 850, 35);
	}
	
	public void renderInterfaceSelection(Graphics g)
	{
		String selectTitle = "";
		String selectText1 = "Nothing selected";
		if(Game.battle.selectionActive==true)
		{
			if(Game.battle.selectionType=="Building")
			{
				selectTitle = Game.battle.building[Game.battle.selectionID].name;
				selectText1 = "You selected the town center";
			}
		}
		g.setFont(Assets.fontStandardBold);
		g.setColor(Color.BLACK);
		g.drawString(selectTitle, 500, 660);
		g.setFont(Assets.fontStandard);
		g.drawString(selectText1, 500, 710);
	}
	
	public void renderMenuMain(Graphics g)
	{
		
	}
	
	public void renderTiles(Graphics g)
	{
		
	}
	
	public void renderUnits(Graphics g)
	{
		// If the unit is selected, draw the highlight/cursor image beneath
	}
	
	public void tick()
	{
		if(Game.battle.tickPause==false){tickAdvance();}
		
		// Debug
		/*if(Game.mouse.mouseActionPressed==true)
		{
			String debug = "Mouse click at " + Game.mouse.mouseCoordsX +", " + Game.mouse.mouseCoordsY; 
			System.out.println(debug);
		}*/
		
		if(Game.mouse.mouseActionPressed==true){tickClick();}
	}
	
	public void tickAdvance()
	{
		tickAdvanceBuildings();
		tickAdvanceUnits();
	}
	
	public void tickAdvanceBuildings()
	{
		
	}
	
	public void tickAdvanceUnits()
	{
		
	}
	
	public void tickClick()
	{
		String clickZone = tickClickZone(Game.mouse.mouseCoordsX,Game.mouse.mouseCoordsY);
		
		/*String debug = "Click was in the " + clickZone + " zone";
		System.out.println(debug);*/
		
		// Whereabouts should this be placed?
		if(Game.battle.menuMainActive==true){tickClickMenuMain();}
		
		if(clickZone=="Board"){tickClickBoard();}
		if(clickZone=="InterfaceMap"){tickClickInterfaceMap();}
		if(clickZone=="InterfaceResources"){tickClickInterfaceResources();}
		if(clickZone=="InterfaceSelection" && Game.battle.selectionActive==true){tickClickBoard();}
		Game.mouse.mouseActionPressed = false;
	}
	
	public void tickClickBoard()
	{
		tickClickBoardBuildings();
		tickClickBoardUnits();
	}
	
	public void tickClickBoardBuildings()
	{
		for(int x=1;x<=Game.battle.buildingCount;x+=1)
		{
			// Debug
			//boolean debugFind = false; 
			
			int posX1 = (32 * Game.battle.building[x].posX) - 20;
			int posY1 = (32 * Game.battle.building[x].posY) + 19;
			int posX2 = (32 * Game.battle.building[x].width) + posX1;
			int posY2 = (32 * Game.battle.building[x].height) + posY1;
			if(Game.mouse.mouseCoordsX>=posX1 && Game.mouse.mouseCoordsX<=posX2 && Game.mouse.mouseCoordsY>=posY1 && Game.mouse.mouseCoordsY<= posY2)
			{
				Game.battle.selectionActive = true;
				Game.battle.selectionType = "Building";
				Game.battle.selectionID = x;
				
				// Debug
				//debugFind = true;
			}
			
			// Debug
			/*String debug1 = "Checking building #" + x + ": " + posX1 + ", " + posY1 + " to " + posX2 + ", " + posY2;
			String debug2 = "Did not find a building at this position";
			if(debugFind==true){debug2 = "This is a building";}
			System.out.println(debug1);
			System.out.println(debug2);*/
		}
	}
	
	public void tickClickBoardUnits()
	{
		
	}
	
	public void tickClickInterfaceMap()
	{
		
	}
	
	public void tickClickInterfaceResources()
	{
		
	}
	
	public void tickClickInterfaceSelection()
	{
		
	}
	
	public void tickClickMenuMain()
	{
		
	}
	
	public String tickClickZone(int x, int y)
	{
		if(y>=0 && y<=50)
		{
			if(x>=0 && x<=1275){return "InterfaceResources";}
			//if(x>=1276 && x<=1366){return "Interface
		}
		if(y>=51 && y<=626){return "Board";}
		if(y>=627 && y<=768)
		{
			if(x>=0 && x<=1166){return "InterfaceSelection";}
			if(x>=1167 && x<=1366){return "InterfaceMap";}
		}
		return "None";
	}
	
}