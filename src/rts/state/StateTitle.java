package rts.state;

import java.awt.Color;
import java.awt.Graphics;

import rts.display.Drawing;
import rts.graphics.Assets;
import rts.input.Keyboard;

public class StateTitle extends State
{
	private int menuPos = 1;
	private int menuMax = 5;
	private int cursorAnimTick = 0;
	private int cursorAnimMove = 0;
	
	public StateTitle()
	{
		
	}
	
	public void tick()
	{
		// Cursor
		cursorAnimTick+=1;
		if(cursorAnimTick==15){cursorAnimMove = 2;}
		if(cursorAnimTick==30){cursorAnimMove = 3;}
		if(cursorAnimTick==45){cursorAnimMove = 4;}
		if(cursorAnimTick==60){cursorAnimMove = 5;}
		if(cursorAnimTick==75){cursorAnimMove = 4;}
		if(cursorAnimTick==90){cursorAnimMove = 3;}
		if(cursorAnimTick==105){cursorAnimMove = 2;}
		if(cursorAnimTick==120)
		{
			cursorAnimMove = 1;
			cursorAnimTick = 0;
		}
		
		// Key Events
		if(Keyboard.getKeyPressed()=="Space" || Keyboard.getKeyPressed()=="Enter")
		{
			Keyboard.setKeyDone();
			if(menuPos==1)
			{
				// Character Selection
				State.setStateChange("Character");
				Keyboard.setKeyDone();
			}
			if(menuPos==2)
			{
				// Load Game
				//State.setStateChange("Load");
				//Keyboard.setKeyDone();
			}
			if(menuPos==3)
			{
				// Basic Instructions
				State.setStateChange("Tutorial");
				Keyboard.setKeyDone();
			}
			if(menuPos==4)
			{
				// Game Options
				State.setStateChange("Options");
				Keyboard.setKeyDone();
			}
			if(menuPos==5)
			{
				// Project Information
				State.setStateChange("About");
				Keyboard.setKeyDone();
			}
		}
		if(Keyboard.getKeyPressed()=="Escape")
		{
			// Quit
			System.exit(0);
		}
		if(Keyboard.getKeyPressed()=="Up" && menuPos>1)
		{
			menuPos-=1;
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Down" && menuPos<menuMax)
		{
			menuPos+=1;
			Keyboard.setKeyDone();
		}
	}
	
	public void render(Graphics g)
	{
		renderBackground(g);
		renderOptions(g);
	}
	
	public void renderBackground(Graphics g)
	{
		g.drawImage(Assets.uiTitleBkg,  0, 0, null);
	}
	
	public void renderOptions(Graphics g)
	{		
		Drawing.drawStringShadow(g, "New Game", 250, 350, 1, Color.GRAY);
		Drawing.drawStringShadow(g, "Continue", 250, 400, 1, Color.GRAY);
		Drawing.drawStringShadow(g, "Tutorial", 250, 450, 1, Color.GRAY);
		Drawing.drawStringShadow(g, "Options", 250, 500, 1, Color.GRAY);
		Drawing.drawStringShadow(g, "About", 250, 550, 1, Color.GRAY);
		
		int cursorX = 215 + cursorAnimMove;
		int cursorY = menuPos * 50 + 300;
		
		// Temp (the continue option is currently disabled)
		if(menuPos==2){cursorX=217;}
		
		Drawing.drawStringShadow(g, ">", cursorX, cursorY, 1, Color.GRAY);
		
		/*if(menuPos==1){g.drawImage(Assets.uiTitleOpt1a,  200, 275, null);}
		else{g.drawImage(Assets.uiTitleOpt1,  200, 275, null);}
		if(menuPos==2){g.drawImage(Assets.uiTitleOpt5a,  400, 275, null);}
		else{g.drawImage(Assets.uiTitleOpt5,  400, 275, null);}
		if(menuPos==3){g.drawImage(Assets.uiTitleOpt2a,  200, 350, null);}
		else{g.drawImage(Assets.uiTitleOpt2,  200, 350, null);}
		if(menuPos==4){g.drawImage(Assets.uiTitleOpt3a,  400, 350, null);}
		else{g.drawImage(Assets.uiTitleOpt3,  400, 350, null);}
		if(menuPos==5){g.drawImage(Assets.uiTitleOpt4a,  300, 425, null);}
		else{g.drawImage(Assets.uiTitleOpt4,  300, 425, null);}*/
	}
}