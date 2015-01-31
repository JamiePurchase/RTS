package rts.display;

import java.awt.image.BufferedImage;

public class Tileset
{
	
	public Tileset()
	{
	}
	
	public static BufferedImage[] getTileset(String file, int width, int height)
	{
		int tileTotal = width * height;
		Spritesheet sheet = new Spritesheet(ImageLoader.loadImage(file));
		BufferedImage[] tileset = new BufferedImage[tileTotal];
		int posX = 1;
		int posY = 1;
		for(int tile=0;tile<tileTotal;tile+=1)
		{
			int cropX = 32 * posX - 32;
			int cropY = 32 * posY - 32;
			tileset[tile] = sheet.crop(cropX, cropY, 32, 32);
			posX+=1;
			if(posX>width)
			{
				posX=1;
				posY+=1;
			}
		}
		return tileset;
	}
}