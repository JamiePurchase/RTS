package rts.state;

import java.awt.Color;
import java.awt.Graphics;

import rts.Game;
import rts.display.Drawing;
import rts.graphics.Assets;

public class StateDebug extends State
{
	
	public StateDebug()
	{
		Game.mouse.nexusClear();
		Game.mouse.nexusAdd("", 100, 100, 150, 50);
		Game.mouse.nexusAdd("", 100, 100, 150, 50);
	}
	
	public void render(Graphics g)
	{
		renderBackground(g);
		renderOptions(g);
		
		// Temp
		g.setColor(Color.BLUE);
		g.fillOval(Game.mouse.mouseCoordsX,Game.mouse.mouseCoordsY,15,15);
		g.drawString("Coords: ("+ Game.mouse.mouseCoordsX + " , " + Game.mouse.mouseCoordsY + ")", 1000, 75);
	}
	
	public void renderBackground(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1366, 768);
		/*g.setColor(Color.WHITE);
		g.drawRect(100,100,1066,468);*/
	}
	
	public void renderOptions(Graphics g)
	{
		Drawing.drawMenuItem(g, "Start",100,100,0);
		Drawing.drawMenuItem(g, "Quit",100,300,0);
	}
	
	public void tick()
	{
		if(Game.mouse.mouseActionPressedL==true)
		{
			int click = Game.mouse.nexusCheck();
			if(click==1)
			{
				//State.setStateChange("Title");
				Game.mouse.mouseActionDone();
			}
			if(click==2)
			{
				System.exit(0);
			}
		}
	}
}