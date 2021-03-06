package rts.state;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import rts.Game;
import rts.battle.Battle;
import rts.display.Drawing;
import rts.graphics.Assets;

public class StateBattle extends State
{
	
	public StateBattle()
	{
		Game.mouse.nexusAdd("BorderT", 0, 0, 1366, 10);
		Game.mouse.nexusAdd("BorderL", 0, 50, 10, 704);
		Game.mouse.nexusAdd("BorderR", 1356, 50, 10, 704);
		Game.mouse.nexusAdd("BorderB", 0, 758, 1366, 10);
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
			String stance = "I";
			if(Game.battle.selectionActive==true && Game.battle.selectionType=="Building" && Game.battle.selectionID==x){stance = "S";}
			int posX = (32 * Game.battle.building[x].posX) - 20;
			int posY = (32 * Game.battle.building[x].posY) + 19;
			g.drawImage(Drawing.getImage(Game.battle.building[x].getImage(stance)), posX, posY, null);
		}
	}
	
	public void renderFrame(Graphics g)
	{
		// Fill
		/*g.setColor(Drawing.getColorRGB(185,122,87));
		g.fillRect(0, 0, 1366, 50);
		g.fillRect(0, 0, 11, 768);
		g.fillRect(1355, 0, 11, 768);
		g.fillRect(0, 626, 1366, 142);
		
		// Border
		g.setColor(Drawing.getColorRGB(110,68,46));
		g.setColor(Color.WHITE);
		g.drawRect(10,49,1346,578);
		g.drawRect(11,50,1344,576);*/
		
		g.drawImage(Drawing.getImage("interface/battleFrame1.png"), 0, 0, null);
		g.drawImage(Drawing.getImage("interface/battleFrame2.png"), 0, 50, null);
		g.drawImage(Drawing.getImage("interface/battleFrame2.png"), 1355, 50, null);
		g.drawImage(Drawing.getImage("interface/battleFrame6.png"), 660, 754, null);
	}
	
	public void renderInterface(Graphics g)
	{
		renderInterfaceMap(g);
		renderInterfaceMenu(g);
		renderInterfaceResources(g);
		if(Game.battle.selectionActive==true){renderInterfaceSelection(g);}
	}
	
	public void renderInterfaceMap(Graphics g)
	{
		g.drawImage(Drawing.getImage("interface/battleFrame3.png"), 0, 498, null);
		g.setColor(Color.BLUE);
		g.drawOval(30, 510, 250, 250);
	}
	
	public void renderInterfaceMenu(Graphics g)
	{
		
	}
	
	public void renderInterfaceResources(Graphics g)
	{
		g.drawImage(Drawing.getImage("interface/battleFrame4.png"), 360, 562, null);
		g.drawImage(Drawing.getImage("interface/battleFlag1.png"), 360, 564, null);
		String favour = "" + Battle.army[1].favourNow;
		String wood = "" + Battle.army[1].resourceWood;
		String food = "" + Battle.army[1].resourceFood;
		String gold = "" + Battle.army[1].resourceGold;
		String stone = "" + Battle.army[1].resourceStone;
		String population = "" + Battle.army[1].populationNow + "/" + Battle.army[1].populationMax;
		g.setFont(Assets.fontStandard);
		g.setColor(Color.BLACK);
		g.drawString(wood, 380, 695);
		g.drawString(food, 530,695);
		g.drawString(gold, 380,725);
		g.drawString(stone, 530, 725);
		g.drawString(favour, 380, 755);
		g.drawString(population, 530, 755);
	}
	
	public void renderInterfaceSelection(Graphics g)
	{
		// Frame
		g.drawImage(Drawing.getImage("interface/battleFrame5.png"), 660, 562, null);
		renderInterfaceSelectionCommands(g);
		renderInterfaceSelectionDetails(g);
	}
	
	public void renderInterfaceSelectionCommands(Graphics g)
	{
		// Temp
		
		/*g.setColor(Color.DARK_GRAY);
		g.fillRect(915,602,115,50);
		g.fillRect(915,657,115,50);
		g.fillRect(915,712,115,50);*/
		g.drawImage(Drawing.getImage("interface/battleCommandLabel.png"), 915, 602, null);
		g.drawImage(Drawing.getImage("interface/battleCommandLabel.png"), 915, 657, null);
		g.drawImage(Drawing.getImage("interface/battleCommandLabel.png"), 915, 712, null);
		
		String label1 = " ";
		String label2 = " ";
		String label3 = " ";
		if(Game.battle.selectionType=="Building")
		{
			label1 = Game.battle.building[Game.battle.selectionID].commandLabel[1];
			label2 = Game.battle.building[Game.battle.selectionID].commandLabel[2];
			label3 = Game.battle.building[Game.battle.selectionID].commandLabel[3];
		}
		if(Game.battle.selectionType=="Unit")
		{
			/*label1 = Game.battle.unit[Game.battle.selectionID].commandLabel[1];
			label2 = Game.battle.unit[Game.battle.selectionID].commandLabel[2];
			label3 = Game.battle.unit[Game.battle.selectionID].commandLabel[3];*/
		}
		g.setFont(Assets.fontStandard);
		g.setColor(Color.WHITE);
		g.drawString(label1, 925, 635);
		g.drawString(label2, 925, 690);
		g.drawString(label3, 925, 745);
		for(int x=1;x<=6;x+=1)
		{
			for(int y=1;y<=3;y+=1)
			{
				int posX = (55 * x) + 980;
				int posY = (55 * y) + 547;
				g.drawImage(Drawing.getImage("interface/battleCommandBack.png"), posX, posY, null);
				
				// Note: there needs to be an array of commands to display
				String icon = "icon/temp.png";
				if(x==1){g.drawImage(Drawing.getImage(icon), posX, posY, null);}
			}
		}
	}
	
	public void renderInterfaceSelectionDetails(Graphics g)
	{
		// Data
		String selectTitle = "";
		BufferedImage portrait = Drawing.getImage("portrait/temp.png");
		if(Game.battle.selectionType=="Building")
		{
			selectTitle = Game.battle.building[Game.battle.selectionID].name;
			//portrait = Drawing.getImage(Game.battle.building[Game.battle.selectionID].getPortrait());
		}
		if(Game.battle.selectionType=="Unit")
		{
			selectTitle = Game.battle.unit[Game.battle.selectionID].name;
			portrait = Drawing.getImage(Game.battle.unit[Game.battle.selectionID].getPortrait());
		}
		
		// Name
		g.setFont(Assets.fontStandardBold);
		g.setColor(Color.BLACK);
		g.drawString(selectTitle, 710, 588);
		
		// Portrait
		g.drawImage(Drawing.getImage("portrait/bkg.png"), 660, 597, null);
		g.drawImage(portrait, 710, 597, null);
		
		// Health Bar
		g.setColor(Color.GREEN);
		g.fillRect(660,749,250,17);
	}
	
	public void renderMenuMain(Graphics g)
	{
		
	}
	
	public void renderTiles(Graphics g)
	{
		
	}
	
	public void renderUnits(Graphics g)
	{
		for(int x=1;x<=Game.battle.unitCount;x+=1)
		{
			// Note: for now, we are only returning the first frame
			BufferedImage image = Game.battle.unit[x].getImage(Game.battle.unit[x].posD,1);
			int posX = (32 * Game.battle.unit[x].posX) - 20;
			int posY = (32 * Game.battle.unit[x].posY) + 19;
			g.drawImage(image, posX, posY, null);
		}
	}
	
	public void tick()
	{
		if(Game.battle.tickPause==false){tickAdvance();}	
		tickBorderScroll();
		if(Game.mouse.mouseActionPressedL==true){tickClick();}
		if(Game.mouse.mouseActionPressedR==true){tickClickRight();}
	}
	
	public void tickAdvance()
	{
		tickAdvanceBuildings();
		tickAdvanceUnits();
	}
	
	public void tickAdvanceBuildings()
	{
		for(int x=1;x<=Game.battle.buildingCount;x+=1)
		{
			if(Game.battle.building[x].action=="Train")
			{
				Game.battle.building[x].actionTrainNow+=1;
				if(Game.battle.building[x].actionTrainNow==Game.battle.building[x].actionTrainMax)
				{
					//Game.battle.addUnit()
					Game.battle.building[x].action = "Idle";
					Game.battle.building[x].actionTrainNow = 0;
					Game.battle.building[x].actionTrainMax = 0;
				}
			}
		}
	}
	
	public void tickAdvanceUnits()
	{
		
	}
	
	public void tickBorderScroll()
	{
		String ref = Game.mouse.nexusCheckRef();
		if(ref=="BorderT"){System.out.println("BorderT");}
		if(ref=="BorderL"){System.out.println("BorderL");}
		if(ref=="BorderR"){System.out.println("BorderR");}
		if(ref=="BorderB"){System.out.println("BorderB");}
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
		Game.mouse.mouseActionDone();
	}
	
	public void tickClickBoard()
	{
		Game.battle.selectionActive = false;
		Game.battle.selectionType = "None";
		Game.battle.selectionID = 0;
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
			String debug2 = "Did not click on this building";
			if(debugFind==true){debug2 = "Selected building #" + x;}
			System.out.println(debug1);
			System.out.println(debug2);*/
		}
	}
	
	public void tickClickBoardUnits()
	{
		for(int x=1;x<=Game.battle.unitCount;x+=1)
		{
			// Debug
			boolean debugFind = false;
			
			int posX1 = (32 * Game.battle.unit[x].posX) - 20;
			int posY1 = (32 * Game.battle.unit[x].posY) + 19;
			int posX2 = (32 * Game.battle.unit[x].width) + posX1;
			int posY2 = (32 * Game.battle.unit[x].height) + posY1;
			if(Game.mouse.mouseCoordsX>=posX1 && Game.mouse.mouseCoordsX<=posX2 && Game.mouse.mouseCoordsY>=posY1 && Game.mouse.mouseCoordsY<= posY2)
			{
				Game.battle.selectionActive = true;
				Game.battle.selectionType = "Unit";
				Game.battle.selectionID = x;
				
				// Debug
				debugFind = true;
			}
			
			// Debug
			String debug1 = "Checking unit #" + x + ": " + posX1 + ", " + posY1 + " to " + posX2 + ", " + posY2;
			String debug2 = "Did not click on this unit";
			if(debugFind==true){debug2 = "Selected unit #" + x;}
			System.out.println(debug1);
			System.out.println(debug2);
		}
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
	
	public void tickClickRight()
	{
		if(Game.battle.selectionActive==true && tickClickZone(Game.mouse.mouseCoordsX,Game.mouse.mouseCoordsY)=="Board")
		{
			if(Game.battle.selectionType=="Building" && Game.battle.building[Game.battle.selectionID].army ==1)
			{
				tickClickRightBuilding(Game.battle.selectionID);
			}
			if(Game.battle.selectionType=="Unit" && Game.battle.unit[Game.battle.selectionID].army ==1)
			{
				tickClickRightUnit(Game.battle.selectionID);
			}
		}
		Game.mouse.mouseActionDone();
	}
	
	public void tickClickRightBuilding(int id)
	{
		// Set rally point? Can this building attack?
		String debug = "Building #" + id + " requesting relocation of rally point";
		System.out.println(debug);
	}
	
	public void tickClickRightUnit(int id)
	{
		// Did we click on an enemy or an open space?
		String debug = "Unit #" + id + " issued orders";
		System.out.println(debug);
	}
	
	public String tickClickZone(int x, int y)
	{
		if(x>=0 && x<1366 && y>=0 && y<50){return "InterfacePanel";}
		if(x>=0 && x<1366 && y>=50 && y<626){return "Board";}
		if(x>=0 && x<360 && y>=498 && y<768){return "InterfaceMap";}
		if(x>=360 && x<660 && y>=627 && y<768){return "InterfaceResources";}
		if(x>=660 && x<1366 && y>=627 && y<768){return "InterfaceSelection";}
		return "None";
	}
	
}