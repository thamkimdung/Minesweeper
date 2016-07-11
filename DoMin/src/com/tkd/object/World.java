package com.tkd.object;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;

import com.sun.javafx.iio.ImageLoader;
import com.sun.prism.Graphics;
import com.tkd.gui.ImageLoaderrrr;
import com.tkd.gui.MyFrame;


public class World {
	public static int width=20;
	public static int height=20;
	private Tile[][] tiles;
	
	
	private int AMOUNT_BOMB=20;
	private Random random;
	
	private BufferedImage bomb=ImageLoaderrrr.scale(ImageLoaderrrr.loadImage("image/ro.png"), Tile.getWidth(), Tile.getHeight());
	//normarl la chua an
	private BufferedImage nomarl=ImageLoaderrrr.scale(ImageLoaderrrr.loadImage("image/3077.png"), Tile.getWidth(), Tile.getHeight());
	private BufferedImage flag=ImageLoaderrrr.scale(ImageLoaderrrr.loadImage("image/flag.png"), Tile.getWidth(), Tile.getHeight());
	//press la da an roi
	private BufferedImage press=ImageLoaderrrr.scale(ImageLoaderrrr.loadImage("image/mine.png"), Tile.getWidth(), Tile.getHeight());
	
	
	
	
	
	
	public World() {
		random = new Random();
		
		tiles = new Tile [width] [ height];
		for(int x=0;x<width;x++){
			for(int y=0;y<height;y++){
				tiles[x][y]=new Tile(x, y,nomarl,bomb,press,flag);
				tiles[x][y].setNomarl(nomarl);
			}
		}
		placesBombs();
		
		setNumberofBomb();
		
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public void placeofBomb(){
		int x=random.nextInt((width-1));
		
		int y=random.nextInt((height-1));
		if(!tiles[x][y].isBomb()){
			tiles[x][y].setBomb(true);
		}
		else {
			placeofBomb();
		}
	}
	
	public void placesBombs(){
		for(int i=0;i<AMOUNT_BOMB;i++){
			placeofBomb();
		}
		
	}
	
	//ghi so bomb ben canh moi o
	public void setNumberofBomb(){
		for(int x=0;x<width;x++){
			for(int y=0;y<height;y++){
				//toa do o truoc X
				int mx=x-1;
				// toa do o sau X
				int gx=x+1;
				//toa do o truoc  Y
				int my=y-1;
				//toa do sau Y
				int gy=y+1;
				
				
				int countBomb=0;
				
				//moi o^ se co 8 o^ bao xung quanh, if 8 lan
				if(mx >= 0 && my >= 0 &&tiles[mx][my].isBomb())countBomb++;
				if(gx <width  && gy <height  &&tiles[gx][gy].isBomb())countBomb++;
				if( my >= 0 &&tiles[x][my].isBomb())countBomb++;
				if( gy <height &&tiles[x][gy].isBomb())countBomb++;
				if(mx >= 0  &&tiles[mx][y].isBomb())countBomb++;
				if(gx <width  &&tiles[gx][y].isBomb())countBomb++;
				if(mx >= 0 && gy <height  &&tiles[mx][gy].isBomb())countBomb++;
				if(gx <width && my >= 0 &&tiles[gx][my].isBomb())countBomb++;
				
				
				
				tiles[x][y].setAmountOfNearBomb(countBomb);
				
			}
		}
		
	}
	
	
	public void click(int x,int y){
		int tileX=x/width;
		int tileY=y/height;
		tiles[tileX][tileY].setOpened(true);
	}
	
	public void draw(Graphics2D g) {
		for(int x=0;x<width;x++){
			for(int y=0;y<height;y++){
				tiles[x][y].draw(g);
			}
		}
		// TODO Auto-generated method stub

	}

	public static int getWidth() {
		return width;
	}

	public static int getHeight() {
		return height;
	}

	

}
