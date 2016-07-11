package com.tkd.gui;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.sun.prism.Graphics;

public class ImageLoaderrrr{
	public static BufferedImage loadImage(String path){
		try {
			return ImageIO.read(ImageLoaderrrr.class.getClassLoader().getResourceAsStream(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static BufferedImage scale(BufferedImage source, int width, int height){
		BufferedImage scale = new BufferedImage(width, height, source.getType());
		Graphics2D g = (Graphics2D) scale.getGraphics();
		
		g.drawImage(source, 0, 0, width,height,null);
		g.dispose();
		return scale;
		
	}
	
}