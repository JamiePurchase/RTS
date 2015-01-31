package rts.state;

import java.awt.Color;
import java.awt.Graphics;

import rts.display.Drawing;

public class StateBattle extends State
{
	public StateBattle()
	{
		
	}
	
	public void render(Graphics g)
	{
		renderFrame(g);
		renderTiles(g);
		renderBuildings(g);
		renderUnits(g);
		renderInterface(g);
	}
	
	public void renderBuildings(Graphics g)
	{
		
	}
	
	public void renderFrame(Graphics g)
	{
		g.setColor(Drawing.getColorRGB(185,122,87));
		g.fillRect(0, 0, 1366, 50);
		g.fillRect(0, 0, 11, 768);
		g.fillRect(1355, 0, 11, 768);
		g.fillRect(0, 626, 1366, 142);
		g.setColor(Drawing.getColorRGB(110,68,46));
		g.setColor(Color.WHITE);
		g.drawRect(10,49,1346,578);
		g.drawRect(11,50,1344,576);
	}
	
	public void renderInterface(Graphics g)
	{
		
	}
	
	public void renderTiles(Graphics g)
	{
		
	}
	
	public void renderUnits(Graphics g)
	{
		
	}
	
	public void tick()
	{
		
	}
	
}