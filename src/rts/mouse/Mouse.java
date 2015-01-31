package rts.mouse;
import rts.mouse.Nexus;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import rts.Game;

public class Mouse extends MouseAdapter
{
	// Location
	public int mouseCoordsX;
	public int mouseCoordsY;
	public boolean mouseOnScreen;
	
	// Actions
	public boolean mouseActionPressed = false;
	
	// Nexus
	public Nexus[] mouseNexus = new Nexus[10];
	public int mouseNexusCount = 0;

	@Override
	public void mousePressed (MouseEvent e)
	{
		mouseCoordsX = e.getX();
		mouseCoordsY = e.getY();
		mouseActionPressed = true;
	}

	@Override
	public void mouseReleased (MouseEvent e)
	{
		
	}

	public void mouseEntered (MouseEvent e)
	{
		mouseOnScreen = true;
	}
	
	public void mouseExited (MouseEvent e)
	{
		mouseOnScreen = false;
	}
	
	public void nexusAdd(String ref, int posX, int posY, int width, int height)
	{
		mouseNexusCount+=1;
		mouseNexus[mouseNexusCount] = new Nexus(ref, posX, posY, width, height);
	}
	
	public int nexusCheck()
	{
		return nexusCheck(mouseCoordsX,mouseCoordsY);
	}
	
	public int nexusCheck(int posX, int posY)
	{
		for(int x=1;x<=mouseNexusCount;x+=1)
		{
			if(posX>=mouseNexus[x].posX1 && posX<=mouseNexus[x].posX2 && posY>=mouseNexus[x].posY1 && posY<=mouseNexus[x].posY2)
			{
				return x;
			}
		}
		return 0;
	}
	
	public String nexusCheckRef()
	{
		return nexusCheckRef(mouseCoordsX,mouseCoordsY);
	}
	
	public String nexusCheckRef(int posX, int posY)
	{
		for(int x=1;x<=mouseNexusCount;x+=1)
		{
			if(posX>=mouseNexus[x].posX1 && posX<=mouseNexus[x].posX2 && posY>=mouseNexus[x].posY1 && posY<=mouseNexus[x].posY2)
			{
				return mouseNexus[x].reference;
			}
		}
		return "";
	}
	
	public void nexusClear()
	{
		mouseNexus = new Nexus[10];
		mouseNexusCount = 0;
	}
}