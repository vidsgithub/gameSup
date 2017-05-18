package learnJava;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;





public class Whirligig {

	public Whirligig() {
		JFrame framew = new JFrame("Whirligig");
		framew.setSize( 1200, 1000);				
		framew.setDefaultCloseOperation(framew.EXIT_ON_CLOSE);	
		framew.setLocation(10,10);
		framew.setResizable(true);
		WhirligigPanelWhole panel = new WhirligigPanelWhole();
		framew.getContentPane().add(panel);
		
		framew.setVisible(true);
		
	}

	public static void main(String[] args) {
		Whirligig w = new Whirligig();

	}
	class WhirligigPanelWhole extends JPanel
	{
		public WhirligigPanelWhole(){
		GridLayout grid = new GridLayout(3,2);
		setLayout(grid );
		
		
		//create plain panel with title
		
		WhiligigPanel1 panel1 = new WhiligigPanel1();
		
		//2nd panel toothpaste
		
		Whirligig3Panel panel2 = new Whirligig3Panel();
		
		//3rd panel days without flossing
		
		WhirligigPanel2 panel3 = new WhirligigPanel2();
		
		//4thPanel sugar on teeth 
		
		MyWhirligigPanel panel4 = new MyWhirligigPanel();
		
		//5th panel brushtime
		
		BrushTeethPanel panel5 = new BrushTeethPanel();
		
		//6th panel foods
		
		CheckBoxPanel panel6 = new CheckBoxPanel();
		
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
		add(panel5);
		add(panel6);
	
		}
		
		//panels
		class WhiligigPanel1 extends JPanel{
			public WhiligigPanel1(){
				JLabel label = new JLabel("Dental Health");
				Font font = new Font("Arial", Font.BOLD, 30);
				label.setFont(font);
				label.setBounds(10,8,200, 50);
				add(label);
			}
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				repaint();
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
			imageName = new String [] { //TOOTH_NONE, 
									TOOTH_NONE_2, 
									//TOOTH_DECAY, 
									TOOTH_DECAY_2, 
									TOOTH_SENSITIVITY, 
									//TOOTH_WHITENING, 
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
							selected = 1;
							blurb = "This toothpaste contains sodium flouride" ;
							blurb2 = "which makes the teeth more resistent to decay.";
							
						}
						else if (rbWhitening.isSelected()) {
							System.out.println("Whitening");
							selected = 3;
							blurb = "This toothpaste lightens the teeth by";
							blurb2= " taking the surface layer of stains out.";
						}
						else if(rbDesensitizing.isSelected()) {
							System.out.println("Desen");
							selected =2;
							blurb = "Desensitizing toothpastes contains potassium";
							blurb2 = " nitrate which decreases tooth sensitivity";
						}
						else if(rbNone.isSelected()) {
							System.out.println("none");	
							selected = 0;
							blurb = "The result is unclean teeth that is ";
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
	
				if(selected>-1){
				g.drawImage(images[selected], 50, 50, 150, 150, this);
				g.drawString(blurb, 50, 220);
				g.drawString(blurb2, 50, 230);
				//repaint();
				
				}
					
					
				}
			}
			
			public void getMyImage()
			{	
				for(int i = 0; i<=3; i++){
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
		
		class WhirligigPanel2 extends JPanel
	    {
	        private DrawPanel2 drawP;
	        private PressPanel2 pressP;
	        private boolean pressed;    // used to tell is button pressed
	        int c1 = 255;//Colours for the teeth
	        int c2 = 255;
	        int c3 = 255;
	 
	 
	        public WhirligigPanel2()//Create layout
	        {
	            pressed = false;
	            setLayout(new GridLayout(2,1));
	            drawP = new DrawPanel2();
	            add(drawP);
	            pressP = new PressPanel2();
	            add(pressP);
	        }
	 
	    public class PressPanel2 extends JPanel
	    {
	            //private JButton button1;
	        private JSlider slider1;//Create JSlider
	 
	        public PressPanel2()
	        {
	            setLayout(new FlowLayout());//Flow Layout
	            slider1 = new JSlider();
	 
	            Slider1Handler2 s1Handler2 = new Slider1Handler2();//Action handler
	            slider1.addChangeListener(s1Handler2);
	            add(slider1);
	        }
	 
	        class Slider1Handler2 implements ChangeListener//Listens for change in JSlider's pos
	        {
	            public void stateChanged(ChangeEvent e)
	            {
	                int sValue = slider1.getValue();//colour value 1
	                if(sValue <14)
	                {
	                    pressed = true;
	                    c1 = 255;
	                    c2 = 255;
	                    c3 = 255;
	                }
	                else if(sValue >= 14 && sValue <28)//colour value 2
	                {
	                    pressed = true;
	                    c1 = 255;
	                    c2 = 255;
	                    c3 = 165;
	                }
	                else if(sValue >= 28 && sValue <42)//colour value 3
	                {
	                    pressed = true;
	                    c1 = 255;
	                    c2 = 255;
	                    c3 = 65;
	                }
	                else if(sValue >= 42 && sValue <56)//colour value 4
	                {
	                    pressed = true;
	                    c1 = 180;
	                    c2 = 180;
	                    c3 = 0;
	                }
	                else if(sValue >= 56 && sValue <70)//colour value 5
	                {
	                    pressed = true;
	                    c1 = 100;
	                    c2 = 70;
	                    c3 = 0;
	                }
	                else if(sValue >= 70 && sValue <84)//colour value 6
	                {
	                    pressed = true;
	                    c1 = 30;
	                    c2 = 60;
	                    c3 = 0;
	                }
	                else if(sValue >= 84)//colour value 7
	                {
	                    pressed = true;
	                    c1 = 0;
	                    c2 = 0;
	                    c3 = 0;
	                }
	                drawP.repaint();//repaint the teeth
	            }
	        }
	    }
	 
	    public class DrawPanel2 extends JPanel
	    {
	 
	        public DrawPanel2()
	        {
	        }
	 
	        public void paintComponent(Graphics g)    // paint component
	        {
	            setBackground(Color.CYAN);
	 
	            super.paintComponent (g);    // draw background
	            Font font = new Font ("Serif", Font.BOLD, 20);
	            g.setFont( font );
	 
	            if (pressed)
	            {
	                g.drawString("Days Without Flossing",65,30);//create informative text
	                g.drawString("0 Days",15,135);
	                g.drawString("7 Days",275,135);
	                pressed = false;
	 
	                Color teeth = new Color(c1,c2,c3);//set teeth colour
	                //Draw Teeth
	                int xcord = 130;
	                int ycord = 0;
	                g.setColor(Color.RED);
	                g.fillArc(xcord,ycord,90,85,0,-180);
	                g.setColor(teeth);
	                g.fillArc(xcord+5,ycord+10,80,70,0,-180);
	                g.setColor(Color.BLACK);
	                g.drawArc(xcord,ycord+25,90,40,0,-180);
	                g.drawLine(xcord+22,ycord+45,xcord+22,ycord+75);
	                g.drawLine(xcord+45,ycord+45,xcord+45,ycord+80);
	                g.drawLine(xcord+68,ycord+45,xcord+68,ycord+75);
	                g.setColor(Color.RED);
	                g.fillArc(xcord,ycord+35,90,15,0,-180);
	            }
	        }
	    }
	}
	
		class MyWhirligigPanel extends JPanel
		{
		    private int rgb = 255;
		    private boolean pressed;    // used to tell is button1 pressed
		    private JButton button1, button2, button3, button4;
		    private DrawPanel drawP;
		    private PressPanel pressP;
		    
		    public MyWhirligigPanel()
		    {        
		        pressed = false;
		        pressP = new PressPanel();
		        add(pressP);
		        drawP = new DrawPanel();
		        add(drawP);
		        setLayout(new GridLayout(1,2));
		    }
		public class PressPanel extends JPanel
		{
		    public PressPanel()
		    {
		        setLayout(null);
		    
		        button1 = new JButton("0 grams");
		        button1.setLocation(30, 100);
		        button1.setSize(new Dimension(100, 30));
		        ButtonHandler bHandler = new ButtonHandler();
		        button1.addActionListener(bHandler);
		        add(button1);
		        
		        button2 = new JButton("5 grams");
		        button2.setLocation(30, 145);
		        button2.setSize(new Dimension(100, 30));
		        //ButtonHandler bHandler = new ButtonHandler();
		        button2.addActionListener(bHandler);
		        add(button2);
		        
		        button3 = new JButton("20 grams");
		        button3.setLocation(30, 190);
		        button3.setSize(new Dimension(100, 30));
		        //ButtonHandler bHandler = new ButtonHandler();
		        button3.addActionListener(bHandler);
		        add(button3);
		        
		        button4 = new JButton("50 grams");
		        button4.setLocation(30, 235);
		        button4.setSize(new Dimension(100, 30));
		        //ButtonHandler bHandler = new ButtonHandler();
		        button4.addActionListener(bHandler);
		        add(button4);
		    }
		    public void paintComponent(Graphics g)
		    {
		        super.paintComponent(g);
		        Font font = new Font ("Arial", Font.PLAIN, 18);
		        g.setFont(font);
		        g.drawString("Choose an amount", 12, 25);
		        g.drawString("and see the effect", 25, 50);
		    }
		class ButtonHandler implements ActionListener
		{    
		    private String buttonPressed;
		    
		    public void actionPerformed(ActionEvent evt)
		    {
		        if(button1.getText().equals("0 grams"))
		        {
		            button1.setText("reset");
		            button2.setText("reset");
		            button3.setText("reset");
		            button4.setText("reset");
		        }
		        else if(button2.getText().equals("5 grams"))
		        {
		            button1.setText("reset");
		            button2.setText("reset");
		            button3.setText("reset");
		            button4.setText("reset");
		        }
		        else if(button3.getText().equals("20 grams"))
		        {
		            button1.setText("reset");
		            button2.setText("reset");
		            button3.setText("reset");
		            button4.setText("reset");
		        }
		        else if(button4.getText().equals("50 grams"))
		        {
		            button1.setText("reset");
		            button2.setText("reset");
		            button3.setText("reset");
		            button4.setText("reset");
		        }
		        else if(button1.getText().equals("reset") || button2.getText().equals("reset") || button3.getText().equals("reset") || button4.getText().equals("reset"))
		        {
		            button1.setText("0 grams");
		            button2.setText("5 grams");
		            button3.setText("20 grams");
		            button4.setText("50 grams");
		        }
		         if(evt.getSource().equals(button1))
		        {
		            rgb = 255;
		        }
		        else if(evt.getSource().equals(button2))
		        {
		            rgb = 200;
		        }
		        else if(evt.getSource().equals(button3))
		        {
		            rgb = 100;
		        }
		        else if(evt.getSource().equals(button4))
		        {
		            rgb = 1;
		        }
		        drawP.repaint();
		    }
		}
		}
		public class DrawPanel extends JPanel
		{
		    private int x;
		    private int y;
		    
		    public void paintComponent(Graphics g)
		    {
		        super.paintComponent (g);    // draw background    
		        Font font1 = new Font ("Arial", Font.PLAIN, 18);
		        g.setFont(font1);
		        setLayout(null);
		        g.drawString("of sugar and see", 1, 25);
		        g.drawString("it has on teeth.", 1, 50);        
		        if(pressed)
		        {
		            g.drawString("It Works.", 10, 150);
		            pressed = false;
		        }
		        
		        int xCord = 18;
		        int yCord = 100;
		        g.setColor(Color.RED);
		        g.fillArc(xCord, yCord, 90, 85, 0, -180);
		        g.setColor(new Color(rgb, rgb, rgb));
		        g.fillArc(xCord +5, yCord +10, 80, 70, 0, -180);
		        g.setColor(Color.BLACK);
		        g.drawArc(xCord, yCord +25, 90, 40, 0, -180);
		        g.drawLine(xCord +22, yCord +45, xCord +22, yCord +75);
		        g.drawLine(xCord +45, yCord +45, xCord +45, yCord +80);
		        g.drawLine(xCord +68, yCord +45, xCord +68, yCord +75);
		        g.setColor(Color.RED);
		        g.fillArc(xCord, yCord +35, 90, 15, 0, -180);
		    }
		}
	
	
	
	}
		
		class BrushTeethPanel extends JPanel implements AdjustmentListener
		{
			Color teethColor;
			int teethRGB;
			JScrollBar jsb;
			
			public BrushTeethPanel()
			{
				setSize(350, 300);
				setLocation(100, 100);
				setLayout(null);
				
				teethRGB = 255;
				teethColor = new Color(teethRGB, teethRGB, teethRGB);
				
				jsb = new JScrollBar(JScrollBar.HORIZONTAL, 0, 10, 0, 50);
				jsb.setBounds(20, 5, 350, 300);
				jsb.setSize(350, 20);
				jsb.addAdjustmentListener(this);
				add(jsb);
				
				JLabel text1 = new JLabel("What happens when you don't brush your teeth? Move the scroll");
				text1.setBounds(20, 100, 400, 60);
				add(text1);
				
				JLabel text2 = new JLabel("bar to see how your teeth change in color as time passes.");
				text2.setBounds(20, 120, 400, 60);
				add(text2);
			}
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				teethColor = new Color(teethRGB, teethRGB, teethRGB);
				
				for (int c = 20; c <= 320; c+=50)
				{
					g.setColor(teethColor);
					g.fillRect(c, 30, 40, 40);
					
					g.setColor(Color.BLACK);
					g.drawRect(c, 30, 40, 40);
				}
			}
			public void adjustmentValueChanged(AdjustmentEvent e)
			{
				int value = jsb.getValue();
				teethRGB = 255-value*6;
				repaint();
			}
		}	
		
		class CheckBoxPanel extends JPanel implements ActionListener
		{
			JCheckBox c1, c2, c3, c4, c5;
			JLabel scoreLabel;
			String scoreString;
			
			public CheckBoxPanel()
			{
				setSize(350, 300);
				setLocation(100, 500);
				setLayout(new GridLayout(7, 1, 10, 10));
				
				scoreString = "Perfect!";
				
				add(new JLabel("    Which of the following do you eat/drink on a daily basis?"));
				
				c1 = new JCheckBox("Hard Candy");
				c1.addActionListener(this);
				add(c1);
				
				c2 = new JCheckBox("Soda");
				c2.addActionListener(this);
				add(c2);
				
				c3 = new JCheckBox("Coffee");
				c3.addActionListener(this);
				add(c3);
				
				c4 = new JCheckBox("Sour Candy");
				c4.addActionListener(this);
				add(c4);
				
				c5 = new JCheckBox("Juice / Sports Drinks");
				c5.addActionListener(this);
				add(c5);
				
				
				scoreLabel = new JLabel("    Score: " + scoreString);
				add(scoreLabel);
			}

			public void actionPerformed(ActionEvent e)
			{
				int score = 0;
				
				if (c1.isSelected())
					score++;
				if (c2.isSelected())
					score++;
				if (c3.isSelected())
					score++;
				if (c4.isSelected())
					score++;
				if (c5.isSelected())
					score++;
				
				if (score == 0)
					scoreString = "Perfect!";
				else if (score == 1 || score == 2)
					scoreString = "Good";
				else if (score == 3 || score == 4)
					scoreString = "Warning! Your teeth are at risk!";
				else
					scoreString = "Visit a dentist ASAP!";
				
				//System.out.println(scoreString);
				scoreLabel.setText("    Score: " + scoreString);
					
				repaint();
			}
		}
	
	
	
}
