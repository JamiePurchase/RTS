package rts.graphics;

import java.awt.Font;
import java.awt.image.BufferedImage;

import rts.display.ImageLoader;

public class Assets
{	
	// Fonts
	public static Font fontButton;
	public static Font fontStandard, fontStandardBold, fontStandardUnderline;
	
	// Title
	public static BufferedImage uiTitleBkg;
	
	public static void init()
	{
		initFonts();
		initInterface();
	}
	
	public static void initFonts()
	{
		fontButton = new Font("MV Boli", Font.PLAIN, 36);
		fontStandard = new Font("MV Boli", Font.PLAIN, 26);
		fontStandardBold = new Font("MV Boli", Font.BOLD, 26);
		fontStandardUnderline = new Font("MV Boli", Font.PLAIN, 26);
	}
	
	public static void initInterface()
	{
		initInterfaceTitle();
	}

	public static void initInterfaceTitle()
	{
		uiTitleBkg = ImageLoader.loadImage("/interface/titleBkg.png");
	}

}