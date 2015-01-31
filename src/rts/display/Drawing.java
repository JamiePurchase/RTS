package rts.display;
import java.awt.Color;
import java.awt.Graphics;

import rts.graphics.Assets;

public class Drawing
{
	public static void drawStringShadow(Graphics g, String text, int x, int y)
	{
		drawStringShadow(g, text, x, y, 2, Color.BLACK);
	}
		
	public static void drawStringShadow(Graphics g, String text, int x, int y, int shadow, Color color)
	{
		g.setFont(Assets.fontStandard);
		g.setColor(color);
		for(int n=1;n<=shadow;n+=1)
		{
			g.drawString(text, x+n, y+n);
		}
		g.setColor(Color.WHITE);
		g.drawString(text, x, y);
	}
	
	public static void drawFrame(Graphics g, int x, int y, int width, int height)
	{
		// Shadow
		g.setColor(Color.gray);
		g.fillRect(x+5, y+5, width, height);
		
		// Background
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);
		
		// Border
		g.setColor(Color.white);
		g.drawRect(x, y, width, height);
	}
	
	public static void drawMenuItem(Graphics g, String text, int x, int y, int hover)
	{
		// Temp (move to arguments)
		int width = 150;
		int height = 50;
		
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLUE);
		g.drawRect(x, y, width, height);
		g.setFont(Assets.fontButton);
		g.drawString(text, x+15, y+25);
		
		/*g.setFont(Assets.fontStandard);
		if(hover==1){g.setFont(Assets.fontStandardBold);}
		g.setColor(Color.BLACK);
		g.drawString(text, x, y);*/
	}
}