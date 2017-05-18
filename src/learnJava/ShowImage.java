package learnJava;

//Supriya Shinagde
//2/27/17
//
//A program of one class nested with in another using the image class. we are going to get an image and do something with it

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

public class ShowImage
{
	private DrawingArea canvas;
	private Image image;
	private JLabel label;
	private int xpos,ypos;
	private boolean keyClear;
	private int sizex, sizey;
	private String imageName;
	
	public ShowImage()
	{
		 sizex = 217;
		 sizey = 301;
		 imageName = "calvin.jpg";
		 xpos=220; 
		 ypos = 220;
		 keyClear = false;
	}
	
	public static void main(String[] args)
	{
		ShowImage si = new ShowImage();
		si.run();
	}
	
	public void run()
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLayout(null);			//getContentPane().setLayout(null)
		
		label = new JLabel("Calvin");
		Font font = new Font("Arial", Font.BOLD, 40);
		label.setFont(font);
		frame.add(label);			//frame.getContentPane().add(label)
		
		canvas = new DrawingArea();
		frame.getContentPane().add(canvas);
		
		getMyImage();
		
		label.setBounds(335,0,300,100);
		
		frame.setBackground(Color.GRAY);
		frame.setSize(800,750);
		frame.setLocation(300, 0);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}
	
	public void getMyImage()
	{
		try
		{
			image = ImageIO.read(new File(imageName));
		}
		catch(IOException e)
		{
			System.err.println("\n\n"+imageName+" can't be found.\n\n");
			e.printStackTrace();
		}
	}
	
class DrawingArea extends JPanel implements MouseListener, KeyListener
{
	public DrawingArea()
	{
		setBackground(Color.GRAY);
		setLocation(0,100);
		setSize(800, 650);
		
		addMouseListener(this);
		addKeyListener(this);
	}
	
	public void paintComponent(Graphics g)
	{
		if (keyClear)
		{
			super.paintComponent(g);			//blank
		}
		else
		{
			g.drawImage(image, xpos, ypos, sizex, sizey, this);
			keyClear = false;
		}
		
	}
	public void mousePressed(MouseEvent e)
	{
		requestFocusInWindow();
		xpos = e.getX()-110;
		ypos = e.getY()-150;
		repaint();
	}
	public void mouseClicked(MouseEvent e){};
	public void mouseReleased(MouseEvent e){};
	public void mouseEntered(MouseEvent e){};
	public void mouseExited(MouseEvent e){};
	
	public void keyPressed(KeyEvent e)
	{
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_SPACE||code==KeyEvent.VK_SHIFT)
		{
			keyClear = true;
			repaint();
		}
	}
	public void keyTyped(KeyEvent e){};
	public void keyReleased(KeyEvent e){};
}
}
