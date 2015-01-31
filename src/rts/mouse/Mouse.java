package rts.mouse;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import rts.Game;

public class Mouse extends MouseAdapter
{
	public int mouseCoordsX;
	public int mouseCoordsY;
	public boolean mouseOnScreen;
	public boolean mouseActionPressed = false;

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
}