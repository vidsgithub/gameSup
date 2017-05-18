package learnJava;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import java.awt.event.MouseListener;
//import java.awt.event.MouseEvent;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

//import javax.annotation.processing.FilerException;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
public class WhirligigTest2
{	
	public static void main( String[] args )
	{
		WhirligigTest2 pills = new WhirligigTest2();
		pills.runIt();
	}
	
	public WhirligigTest2()
	{
	}
	
	public void runIt()
	{
		JFrame frame1 = new JFrame("WhirligigTest2");
		frame1.setSize( 600, 700);				
		frame1.setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);	
		frame1.setLocation(400,50);
		frame1.setResizable(true);
		Whirligig3Panel panel3 = new Whirligig3Panel();
		frame1.getContentPane().add(panel3);
		frame1.setVisible(true);
		
		}
	}
	
	class Whirligig3Panel extends JPanel //implements  ActionListener, KeyListener, MouseListener
	{
		private JRbuttonPanel jp;
		private TeethPanel tp;
		private String imageName[];
		private BufferedImage images [];
		private int selected;
		private String TOOTH_NONE = "tooth-none.GIF";
		private String TOOTH_NONE_2 = "tooth-none-2.jpg";
		private String TOOTH_DECAY = "tooth-decay.jpg";
		private String TOOTH_DECAY_2 = "tooth-decay-2.jpg";
		private String TOOTH_SENSITIVITY = "tooth-sensitivity.jpg";
		private String TOOTH_WHITENING = "tooth-whitening.jpg";
		private String TOOTH_YELLOW_WHITENING = "yellow-whiteteeth.jpg";
		private String blurb, blurb2;
		
		//private boolean pressed;
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			repaint();
		}
		
		public Whirligig3Panel() 
		{
			
			// create an array of strings for easy access
			imageName = new String [] { TOOTH_NONE, 
									TOOTH_NONE_2, 
									TOOTH_DECAY, 
									TOOTH_DECAY_2, 
									TOOTH_SENSITIVITY, 
									TOOTH_WHITENING, 
									TOOTH_YELLOW_WHITENING };
			images = new BufferedImage [7];
			
			blurb = "";
			blurb2= "";
			//Panels
			jp = new JRbuttonPanel ();
			
			tp = new TeethPanel();
			
			add(tp);
			
			add(jp);
			
			setLayout(new GridLayout(1,2));
			
		}
		
		
		class JRbuttonPanel extends JPanel 
		{
			private JRadioButton rbAntiDecay, rbDesensitizing, rbNone, rbWhitening;
			private JRadioButton choices [];
			private ButtonGroup buttons;
			
			ChoicesHandler handle;
			
			public JRbuttonPanel ()
			{
				JLabel label = new JLabel("Different Types of Toothpastes");
				Font font = new Font("Arial", Font.BOLD, 24);
				label.setFont(font);
				label.setBounds(10,8,200, 50);
				add(label);
				
				selected = 0;
				
				GridLayout grid = new GridLayout(5,1);
				
				setLayout(grid);
//				
				rbAntiDecay = new JRadioButton("Anti-Decay");
				
			
				rbWhitening = new JRadioButton("Whitening");
				
				rbDesensitizing = new JRadioButton("Desensitizing");
			
				rbNone = new JRadioButton("None");
				
				handle = new ChoicesHandler();
			
				choices = new JRadioButton[] { rbAntiDecay, rbWhitening, rbDesensitizing, rbNone };
				
				buttons = new ButtonGroup();
				
				for(int x = 0; x < 4; x++)
				{
					buttons.add(choices[x]);
					choices[x].addActionListener(handle);
					add(choices[x]);
					if(selected == 0){
						rbNone.setSelected(true);
					}
				}
				// Initialize first RadioButton
			}
			
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				repaint();
			}
			
			class ChoicesHandler implements ActionListener
			{
				
				public void actionPerformed(ActionEvent e)
				{
						if (rbAntiDecay.isSelected()) {
							System.out.println("anti");
							selected = 2;
							blurb = "This toothpaste contains sodium flouride" ;
							blurb2 = "which makes the teeth more resistent to decay.";
							
						}
						else if (rbWhitening.isSelected()) {
							System.out.println("Whitening");
							selected = 5;
							blurb = "This toothpaste lightens the teeth by";
							blurb2= " taking the surface layer of stains out.";
						}
						else if(rbDesensitizing.isSelected()) {
							System.out.println("Desen");
							selected =4;
							blurb = "Desensitizing toothpastes contains potassium";
							blurb2 = " nitrate which decreases tooth sensitivity";
						}
						else if(rbNone.isSelected()) {
							System.out.println("none");	
							selected = 0;
							blurb = "The result is unclean teeth that is "
							blurb2 = "susceptible to bacteria and other disease";
							
						}
				}
			}
		}
		
		class TeethPanel extends JPanel {
			
			public TeethPanel()  {
			
				getMyImage();
			}
			
			public void paintComponent(Graphics g){
				super.paintComponent(g);
	
				if(!(selected == 4)){
				g.drawImage(images[selected], 50, 50, 200, 200, this);
				g.drawImage(images[selected+1],50, 355, 200, 200, this );
				g.drawString(blurb, 50, 600);
				g.drawString(blurb2, 50, 605);
				//repaint();
				
				}
				else if(selected == 4){
					g.drawImage(images[selected], 70, 50, 200, 200, this);
					g.drawString(blurb, 50, 600);
					g.drawString(blurb2, 50, 605);
					
					//repaint();
				}
			}
			
			public void getMyImage()
			{	
				for(int i = 0; i<=6; i++){
					try
					{
						File file = new File("/Users/vshingad/Documents/workspace/learnJava/src/resources/"+imageName[i]);
						BufferedImage image = ImageIO.read(file);
						
						System.out.print(imageName[i]);
						images[i] = image;
					}
					catch(IOException e)
					{
						System.err.println("\n\n"+imageName[i]+" can't be found.\n\n");						
						e.printStackTrace();
					}
				}

			}
		}
	}



