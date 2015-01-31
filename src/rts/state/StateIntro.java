package rts.state;

import java.awt.Color;
import java.awt.Graphics;

import rts.Game;
import rts.display.Drawing;

public class StateIntro extends State
{
	private int tickCount = 0;
	private int tickFrame = 1;

	public StateIntro()
	{
		
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1366, 768);
		if(tickFrame>1)
		{
			Drawing.drawStringShadow(g, "Intro", 400, 300, 1, Color.WHITE);
		}
	}
	
	public void tick()
	{
		tickClick();
		tickTime();
	}
	
	public void tickClick()
	{
		if(Game.mouse.mouseActionPressedL==true)
		{
			Game.mouse.mouseActionDone();
			Game.setStateChange(new StateTitle());
		}
	}
	
	public void tickTime()
	{
		tickCount+=1;
		if(tickCount>=60)
		{
			tickFrame+=1;
			tickCount=0;
			if(tickFrame>10)
			{
				State.setStateChange("Title");
			}
		}
	}

}