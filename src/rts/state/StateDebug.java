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
		
	}
	
	public void tick()
	{
		if(Game.mouse.mouseActionPressed==true)
		{
			//State.setStateChange("Title");
			Game.mouse.mouseActionPressed = false;
			
			// Temp
			System.exit(0);
		}
		/*if(Keyboard.getKeyPressed()=="Escape")
		{
			// Quit
			System.exit(0);
		}*/
	}
	
	public void render(Graphics g)
	{
		renderBackground(g);
		renderOptions(g);
		
		// Temp
		g.fillOval(Game.mouse.mouseCoordsX,Game.mouse.mouseCoordsY,15,15);
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
}