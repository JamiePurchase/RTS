package rts.state;
import rts.Game;
import rts.display.Drawing;
import rts.display.ImageLoader;
import rts.graphics.Assets;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class StateTitle extends State
{
	public BufferedImage imgLogo;
	
	public StateTitle()
	{
		//initImages();
		initNexus();
	}
	
	public void initImages()
	{
		imgLogo = ImageLoader.loadImage("/interface/titleLogo.png");
	}
	
	public void initNexus()
	{
		Game.mouse.nexusClear();
		Game.mouse.nexusAdd("ButtonStart",100, 100, 150, 50);
		Game.mouse.nexusAdd("ButtonQuit",100, 300, 150, 50);
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
		//g.drawImage(imgLogo,  0, 0, null);
	}
	
	public void renderOptions(Graphics g)
	{
		Drawing.drawMenuItem(g, "Start",100,100,0);
		Drawing.drawMenuItem(g, "Quit",100,300,0);
	}
	
	public void tick()
	{
		if(Game.mouse.mouseActionPressed==true)
		{
			String ref = Game.mouse.nexusCheckRef();
			if(ref=="ButtonStart")
			{
				//State.setStateChange("Title");
				Game.mouse.mouseActionPressed = false;
			}
			if(ref=="ButtonQuit")
			{
				System.exit(0);
			}
		}
	}
}