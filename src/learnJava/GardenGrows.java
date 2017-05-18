package learnJava;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class GardenGrows {
	//private boolean key, key2, keyClear, mouseClick;

	public GardenGrows() {
		//key = false;
		//key2 = false;
		JFrame frame = new JFrame("GardenGrows");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		Garden canvas = new Garden();
		frame.getContentPane().add(canvas);
		
		frame.setVisible(true);
		frame.setSize(1200, 1200);
		frame.setLocation(200, 0);
		frame.setResizable(true);
		frame.setBackground(Color.GRAY);
		
	}

	public static void main(String[] args) {
		GardenGrows gg = new GardenGrows();
	}
	
	class Garden extends JPanel implements MouseListener, KeyListener{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private boolean key, key2, keyClear, mouseClick;

		// default constructor
		public Garden() {
			setBackground(Color.gray);
			addMouseListener(this);  //add key and mouse listener
	        addKeyListener(this);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(Color.PINK);
			g.fillRect(50, 50, 1000, 500);
			
			if (key) {
				g.setColor(Color.GREEN);
				g.fillRect(50,50,1000,500);
			}
				
			Color lavender = new Color(150,100,230);
			if(key2) {
				g.setColor(lavender);
				
				for (int y = 180; y<= 500; y=y+200){
					for(int x = 120; x<=1050;x= x+200){
						g.fillOval(x, y, 50, 50);
					}
				}
			}
			
			if(keyClear) {
				g.setColor(Color.PINK);
				g.fillRect(50, 50, 1000, 500);
			}
		}
		
		//Garden p = new Garden();
		public void mouseClicked(MouseEvent e) {
			
		}
		public void mouseReleased(MouseEvent e) {
			//requestFocus();// TODO Auto-generated method stub
		}
		
		public void mouseEntered(MouseEvent e ){
			//requestFocus();// TODO Auto-generated method stub
		}
		
		public void mouseExited(MouseEvent e){
			//requestFocus();// TODO Auto-generated method stub
			
		}
		
		public void mousePressed(MouseEvent e) {
			int posX = e.getX();
			int posY = e.getY();
			if(posX>=0 && posX<= 1050 && posY >=0&& posY<=550){
				requestFocusInWindow();
				mouseClick = true;
				repaint();
				System.out.println("mousePressed: Left click of mouse is pressed");
			}
		}
		
		public void keyPressed(KeyEvent e) {
			int code1 = e.getKeyCode(); 
			if(mouseClick && key){
				if (code1 == KeyEvent.VK_UP){
					key2 = true;
					repaint();
					System.out.println("keyPressed: Up Arrow is pressed");
				}
			}
		}
		
		public void keyTyped(KeyEvent e){
			if (e.getKeyChar() == '%' && mouseClick == true) 
            {
                key = true;
                repaint();
                System.out.println("keyTyped: % key is pressed");
            }
		}
		
		public void keyReleased(KeyEvent e) {
			int code1 = e.getKeyCode();
			if(code1 == KeyEvent.VK_ENTER){
				keyClear = true;
				repaint();
				key = false;
				key2 = false;
				mouseClick = false;
				keyClear = false;
				System.out.println("keyReleased: keyClear key is pressed");
			}
		}	
	}
}