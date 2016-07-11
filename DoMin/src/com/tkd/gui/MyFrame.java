package com.tkd.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;



import com.tkd.object.World;

public class MyFrame extends JFrame implements MouseInputListener {
	
	public static final int WIDTH_FRAME = 425;
	public static final int HEIGHT_FRAME = 430;
	
	
	private World world;
	private Screen screen;

	public MyFrame() {
		
		
		addMouseListener(this);
		screen = new Screen();
		add(screen);
		world = new World();
		
		setTitle("Do Min");
		setSize(WIDTH_FRAME, HEIGHT_FRAME);
		
		
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// TODO Auto-generated constructor stub
	}
	public class Screen extends JPanel{
		@Override
		public void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			Graphics2D graphics2d=(Graphics2D)g;
			g.setFont(new Font("Time New Roman", Font.BOLD, 15));
			
			world.draw( graphics2d);		}
	}
	
	
	
	public static int getWidthFrame() {
		return WIDTH_FRAME;
	}

	public static int getHeightFrame() {
		return HEIGHT_FRAME;
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		world.click(e.getX(), e.getY());
		screen.repaint();
	}


	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	

}
