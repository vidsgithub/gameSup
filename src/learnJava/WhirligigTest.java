package learnJava;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Font;

import javax.swing.JFrame;	
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
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

import javax.annotation.processing.FilerException;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
public class WhirligigTest
{	
	public static void main( String[] args )
	{
		WhirligigTest pills = new WhirligigTest();
		pills.runIt();
	}
	
	public WhirligigTest()
	{
	}
	
	public void runIt()
	{
		JFrame frame = new JFrame("WhirligigTest");
		frame.setSize( 400, 300);				
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setLocation(40,50);
		frame.setResizable(true);
		
		Whirligig3Panel panel3;
		try {
			panel3 = new Whirligig3Panel();
			frame.getContentPane().add( panel3 );	
			frame.setVisible(true);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	class Whirligig3Panel extends JPanel //implements  ActionListener, KeyListener, MouseListener
	{
		private JRbuttonPanel jp;
		private TeethPanel tp;
		private String images[];
		private Image img [];
		private final String TOOTH_NONE = "tooth-none.GIF";
		private final String TOOTH_NONE_2 = "tooth-none-2.jpg";
		private final String TOOTH_DECAY = "tooth-decay.jpg";
		private final String TOOTH_DECAY_2 = "tooth-decay-2.jpg";
		private final String TOOTH_SENSITIVITY = "tooth-sensitivity.jpg";
		private final String TOOTH_WHITENING = "tooth-whitening.jpg";
		private final String TOOTH_YELLOW_WHITENING = "yello-whiteteeth.jpg";
		
		private boolean pressed;
		
		public Whirligig3Panel() throws IOException
		{
			//Panels
			jp = new JRbuttonPanel ();
			
			tp = new TeethPanel();
			
			GridLayout grid = new GridLayout(1,2);
			setLayout(grid );
			
			add(jp);
			
			add(tp);
			
			// create an array of strings for easy access
			images = new String [] { TOOTH_NONE, 
									TOOTH_NONE_2, 
									TOOTH_DECAY, 
									TOOTH_DECAY_2, 
									TOOTH_SENSITIVITY, 
									TOOTH_WHITENING, 
									TOOTH_YELLOW_WHITENING };
			// read images and put it in array
			for (int i=0; i < 6; i++) {
				try{
					img[i] = ImageIO.read(new File("resources/"+images[i]));
				}
				catch(IOException e){
					System.err.print(e);
				}	
			}
			
			//set the image panel with initial image
			tp.setImage(img[jp.getCurrentRBSelected()]);
		}
		
		class JRbuttonPanel extends JPanel 
		{
			private JRadioButton rbAntiDecay, rbDesensitizing, rbNone, rbWhitening;
			private JRadioButton choices [];
			private ButtonGroup buttons;
			public int currentRBSelected;
			ChoicesHandler handle;
			
			/**
			 * @return the currentRBSelected
			 */
			public int getCurrentRBSelected() {
				return this.handle.SelectedRB;
			}

			/**
			 * @param currentRBSelected the currentRBSelected to set
			 */
			public void setCurrentRBSelected(int currentRBSelected) {
				this.handle.SelectedRB = currentRBSelected;
			}

			public JRbuttonPanel ()
			{
				GridLayout grid = new GridLayout(4,1);
				
				setLayout(grid);
				
				rbAntiDecay = new JRadioButton("Anit-Decay");
				
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
				}
				// Initialize first RadioButton
				handle.setSelectedRB(0);
			}
			
			class ChoicesHandler implements ActionListener
			{
				private int SelectedRB;
				
				/**
				 * @return the selectedRB
				 */
				public int getSelectedRB() {
					return SelectedRB;
				}
				
				/**
				 * @param selectedRB the selectedRB to set
				 */
				public void setSelectedRB(int selectedRB) {
					SelectedRB = selectedRB;
				}
				
				public void actionPerformed(ActionEvent e)
				{
					for(int i = 0; i < 4; i++) {
						this.SelectedRB = i;
						
						if (choices[i] == rbAntiDecay) {
							System.out.println("anti");
						}
						else if (choices[i] == rbWhitening) {
							System.out.println("Whitening");
						}
						else if(choices[i] == rbDesensitizing) {
							System.out.println("Desen");
						}
						else if(choices[i] == rbNone) {
							System.out.println("none");	
						}
					}
				}
			}
		}
		
		class TeethPanel extends JPanel {
			private Image currentImage;
			public TeethPanel() throws IOException {
				GridLayout grid = new GridLayout(1,1);
				
				setLayout(grid);
				
				
			}
			
			// Convince methods
			void setImage(Image ImageToSet) {
				this.currentImage = ImageToSet;
				this.repaint();
			}
		}
	}
}

			
		
