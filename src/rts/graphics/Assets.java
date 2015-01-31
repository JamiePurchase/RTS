package rts.graphics;

import java.awt.Font;
import java.awt.image.BufferedImage;

import rts.display.ImageLoader;

public class Assets
{	
	// Fonts
	public static Font fontButton;
	public static Font fontStandard, fontStandardBold;
	
	public static void init()
	{
		initFonts();
	}
	
	public static void initFonts()
	{
		fontButton = new Font("MV Boli", Font.PLAIN, 32);
		fontStandard = new Font("MV Boli", Font.PLAIN, 26);
		fontStandardBold = new Font("MV Boli", Font.BOLD, 26);
	}

}