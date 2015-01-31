package rts.state;
import rts.Game;
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
		if(Game.mouse.mouseActionPressed==true)
		{
			String ref = Game.mouse.nexusCheckRef();
			if(ref=="ButtonStart")
			{
				Game.setStateChange(new StateBattle());
				Game.mouse.mouseActionPressed = false;
			}
			if(ref=="ButtonQuit")
			{
				System.exit(0);
			}
		}
	}
}