package com.tkd.object;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import com.sun.prism.Graphics;
import com.tkd.gui.MyFrame;

public class Tile {
	private int x;
	private int y;
	public static int width=MyFrame.getWidthFrame()/World.getWidth();
	public static int height=MyFrame.getHeightFrame()/World.getHeight();
	
	
	private boolean bomb;
	private boolean opened;
	private BufferedImage openedImage;
	private BufferedImage bombImage;
	private BufferedImage flag;
	
	
	//so luong bom o gan o
	private int amountOfNearBomb;
	
	
	private BufferedImage nomarl;
	public Tile(int x, int y,BufferedImage normal, BufferedImage bomb,BufferedImage openImage,BufferedImage flag) {
		super();
		this.x = x;
		this.y = y;
		this.nomarl=normal;
		this.bombImage=bomb;
		
		this.openedImage=openImage;
		this.flag=flag;
	
		
	}
	
	
	
	



	public void setOpened(boolean opened) {
		this.opened = opened;
	}







	public void setNomarl(BufferedImage nomarl) {
		this.nomarl = nomarl;
	}
	public boolean isOpened() {
		return opened;
		
	}
	



	public void setOpenedImage(BufferedImage openedImage) {
		this.openedImage = openedImage;
	}







	public void draw(Graphics2D g) {
		
		if(!opened){
			g.drawImage(nomarl, x*width, y*height,null);
		}
		else {
			if(bomb){
				g.drawImage(bombImage, x*width, y*height,null);
			}
			else {
				g.drawImage(openedImage, x*width, y*height,null);
				if(amountOfNearBomb>0){
					g.setColor(Color.white);
					g.drawString(""+amountOfNearBomb, x*width+8, y*height+height-5);
				}
			}
		}

	}
	
	public void setImage(BufferedImage nomarl) {
		this.nomarl = nomarl;
	}

	public static int getWidth() {
		return width;
	}

	public static int getHeight() {
		return height;
	}

	
	public void setBomb(boolean bomb) {
		this.bomb = bomb;
	}

	
	public boolean isBomb(){
		return bomb;
	}
	
	
	public void setAmountOfNearBomb(int amountOfNearBomb) {
		this.amountOfNearBomb = amountOfNearBomb;
	}
	
	
	

}
