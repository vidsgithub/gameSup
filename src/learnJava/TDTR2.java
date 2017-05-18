package learnJava;

import java.awt.Color;	
import java.awt.Graphics;
import java.awt.Font;

import javax.swing.JFrame;	
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class TDTR2
{
	private JFrame framew;
	private Panels panel;
	public TDTR2()
	{
		framew = new JFrame("The Dangerous Trig Rendezous");
		framew.setSize(1000, 700);				
		framew.setDefaultCloseOperation(framew.EXIT_ON_CLOSE);	
		framew.setLocation(50,10);
		framew.setResizable(true);
		panel = new Panels();
		framew.getContentPane().add(panel);
		
		framew.setVisible(true);
	}
	public static void main(String[]args)
	{
		TDTR2 tdtr = new TDTR2();
	}
	
	class Panels extends JPanel
	{
		private StartPanel sp;
		private DirectionsStory ds;
		private GamePlay gp;
		private RescuePanel rp;
		private MiniLessonPanel mlp;
		private CardLayout cards;
		private int level;
		private int score;
		private int saved;
		public Panels()
		{
			level = 1;
			score= 1;
			saved = 2;
			cards = new CardLayout();
			setLayout(cards);
			setBackground(Color.RED);
			
			mlp = new MiniLessonPanel();
			sp = new StartPanel();	
			ds = new DirectionsStory();
			gp = new GamePlay();
			rp = new RescuePanel();	
			
			add(sp, "StartPanel"); //add S tartPanel
			add(ds, "DirectionsPanel"); //add DirectionsStory Panel
			add(gp, "GamePlayPanel"); //addGameplay Panel
			add(rp, "HomePanel"); //add RescuePanel
			add(mlp, "MiniLessonPanel"); //add MiniLessonPanel
			
			
		}
		public CardLayout getCards()
		{
			return cards;
		}
	
	
		class StartPanel extends JPanel 
		{
			private JButton start, gpbutton;
			private Image img;
			private String imageName;
			public StartPanel()
			{
				setLayout(null);												
				start = new JButton("Start"); //initialize the start button
				start.setLocation(405, 500); //set the location
				start.setSize(new Dimension(120, 35)); //set the size
				
				gpbutton = new JButton ("Go to Game"); //initialize the Go to Game button
				gpbutton.setLocation(528, 500);		//set location
				gpbutton.setSize(new Dimension(120,35));		//set size;
				
				JLabel label = new JLabel("The Dangerous Trig Rendezous");		
				Font font = new Font("Arial", Font.BOLD, 25);
				label.setFont(font);
				label.setBounds(340, 350, 750, 200);
				add(label);
				
				bHandler handle = new bHandler();
			
				start.addActionListener(handle);
				gpbutton.addActionListener(handle);

				add(start);
				add(gpbutton);
				add(label); //add all three components to panel
				img = null;
				imageName = "abstract-triangles-wallpaper-1.jpg";
				setBackground(Color.LIGHT_GRAY);
			}
			public void paintComponent(Graphics g) //paint component method
			{
				super.paintComponent(g);
				try
				{
					File file = new File("/Users/vshingad/Documents/workspace/learnJava/src/resources/"+imageName);
					img = ImageIO.read(file);
				}
				catch(IOException e)
				{
					System.err.println("File not found "+imageName);
					e.printStackTrace();
				}
				g.drawImage(img, 200, 0, 600, 400, this);
			}
			
			class bHandler implements ActionListener			//button handler class for the start panel class
			{
				public void actionPerformed(ActionEvent e)
				{
					String command = e.getActionCommand();
					System.out.print(command);
					if(command.equals("Start"))
					{
						System.out.print("1	23");
						 
						panel.getCards().show(panel, "DirectionsPanel");
					}
					else if(command.equals("Go to Game"))
					{
						System.out.print("98798574");
						panel.getCards().show(panel, "HomePanel");
					}
				}
			}
			
		}
		
	
		class DirectionsStory extends JPanel implements MouseListener
		{
			private CardLayout c;
			private int counter;
			private BufferedImage img1, img2, img3, img4, img5, imgdf;
			private String imgName1, imgName2, imgName3, imgName4, imgName5, imgNamedf; 
			public DirectionsStory()
			{
				counter =0;
				c = new CardLayout();
				setLayout(c);
								//create instance of each direction story panel class for each page
				Page1 p1 = new Page1 (); //Page1
				Page2 p2 = new Page2();//Page2
				Page3 p3 = new Page3();//Page3
				Page4 p4 = new Page4();//Page4
				Page5 p5 = new Page5();//Page5
				DirectionFinal df = new DirectionFinal();//DirectionFinal
				
				//image names
				imgName1 = "First.jpg";
				imgName2 = "Second.jpg";
				imgName3 = "Third.jpg";
				imgName4 = "Fourth.jpg";
				imgName5 = "Fifth.jpg";
				imgNamedf = "directions.jpg";
				
				//set all image values to null
				img1 = null;
				img2 = null;
				img3 = null;
				img4 = null;
				img5 = null;
				img5 = null;
				imgdf = null;
				//add mouselistener to all the panels
				addMouseListener(this);
				
				//add all to card layout
				add(p1);
				add(p2);
				add(p3);
				add(p4);
				add(p5);
				add(df);
			}
			public void mouseClicked(MouseEvent e) //mouseClicked method
			{
				counter++;
				if (counter <=5)
					c.next(this); // everytime the user clicks the screen a new Page will show
				else
					return;
			}
			
			public void mouseEntered(MouseEvent e) //rest of mouse methods
			{
			}
			public void mouseExited(MouseEvent e)
			{
			}
			public void mousePressed(MouseEvent e)
			{
			}
			public void mouseReleased(MouseEvent e)
			{
			}
			class Page1 extends JPanel //first page of the story
			{
				
				public void paintComponent(Graphics g) //find and draw image
				{
					super.paintComponent(g);
					try
					{
						File file = new File("/Users/vshingad/Documents/workspace/learnJava/src/resources/"+imgName1);
						img1 = ImageIO.read(file);
						
					}
					catch(IOException e)
					{
						System.err.println("File not found "+imgName1);
						e.printStackTrace();
					}
					g.drawImage(img1, 0, 0, 1000, 700, this);
					repaint();
				}
			
			
			}
			class Page2 extends JPanel//second page of the story
			{
				
				public void paintComponent(Graphics g) //find and draw image
				{
					super.paintComponent(g);
					try
					{
						File file = new File("/Users/vshingad/Documents/workspace/learnJava/src/resources/"+imgName2);
						img2 = ImageIO.read(file);
					}
					catch(IOException e)
					{
						System.err.println("File not found "+imgName2);
						e.printStackTrace();
					}
					g.drawImage(img2, 0, 0, 1000, 700, this);
					repaint();
				}
				
			}
			class Page3 extends JPanel //third page
			{
				public void paintComponent(Graphics g) //find and draw image
				{	
					super.paintComponent(g);
					try
					{
						File file = new File("/Users/vshingad/Documents/workspace/learnJava/src/resources/"+imgName3);
						img3 = ImageIO.read(file);
					}
					catch(IOException e)
					{
						System.err.println("File not found "+imgName3);
						e.printStackTrace();
					}
					g.drawImage(img3, 0, 0, 1000, 700, this);
					repaint();
				}
				
			
			}
			class Page4 extends JPanel  //4th page
			{
				
				public void paintComponent(Graphics g) //find and draw image
				{
					super.paintComponent(g);
					try
					{
						File file = new File("/Users/vshingad/Documents/workspace/learnJava/src/resources/"+imgName4);
						img4 = ImageIO.read(file);
					}
					catch(IOException e)
					{
						System.err.println("File not found "+imgName4);
						e.printStackTrace();
					}
					g.drawImage(img4, 0, 0, 1000, 700, this);
					repaint();
				}
				
			
			}
			class Page5 extends JPanel  // 5th page
			{
				
				public void paintComponent(Graphics g) //find and draw image
				{
					super.paintComponent(g);
					try
					{
						File file = new File("/Users/vshingad/Documents/workspace/learnJava/src/resources/"+imgName5);
						img5 = ImageIO.read(file);
					}
					catch(IOException e)
					{
						System.err.println("File not found "+imgName5);
						e.printStackTrace();
					}
					g.drawImage(img5, 0, 0, 1000, 700, this);
					repaint();
				}
				
			
			}
			class DirectionFinal extends JPanel //should print the rest of the directions
			{
				private JButton home;
				public DirectionFinal()
				{
					setLayout(null);
					home = new JButton("Begin");
					home.setLocation(450, 658);
					home.setSize(120, 35);
					BB handy = new BB();
					home.addActionListener(handy);
					add(home);
					setBackground(Color.BLUE);
				}
				class BB implements ActionListener
				{
					public void actionPerformed(ActionEvent e)
					{
						String command = e.getActionCommand();
						if(command.equals("Begin"))
						{
							panel.getCards().show(panel, "HomePanel");
						}
						
					}
				}
				public void paintComponent(Graphics g)
				{
					super.paintComponent(g);
					try
					{
						File file = new File("/Users/vshingad/Documents/workspace/learnJava/src/resources/"+imgNamedf);
						imgdf = ImageIO.read(file);
					}
					catch(IOException e)
					{
						System.err.println("File not found "+imgNamedf);
						e.printStackTrace();
					}
					g.drawImage(imgdf, 0, 0, 1000, 650, this);
					repaint();
				}
				
			
			}
		}
		
		class GamePlay extends JPanel
		{	
			private Scanner sb;
			private BorderLayout b;
			private String inFileName;
			private int rand;
			private String answer;
			private String a1,b1,c1,d1;
			
		
			public GamePlay()
			{
				b = new BorderLayout(60,50);
				setLayout(b);
				
				inFileName = "Questions.txt";
				sb= null;
				
				QuestionPanel qp = new QuestionPanel();
				AnswerPanel ap = new AnswerPanel();
				ScorePanel sp = new ScorePanel();
				
				sp.setPreferredSize(new Dimension(1000, 100));
				ap.setPreferredSize(new Dimension(200, 650));
				
				add(qp, BorderLayout.CENTER);
				add(sp, BorderLayout.NORTH);
				add(ap, BorderLayout.EAST);
				
			}
			
			class QuestionPanel extends JPanel
			{
				private String question;
				private int side1, side2, side3;
				private boolean picOprob;
				private JTextArea problem;
				private JButton help;
				public QuestionPanel()
				{
					picOprob = false;
					question = "1) Oh no! This triangle is missing its functions! Help this triangle find its sine and cosine by means of θ!";
					readFile();
					findQuestion();
					problem = new JTextArea(question);
					problem.setEditable(false);
					problem.setLineWrap(true);
					problem.setLocation(10, 10);
					problem.setSize(new Dimension(650, 200));
					
					help = new JButton("Help");
					add(help);
					add(problem);
				}
				public void readFile()
				{
					File inFile = new File("/Users/bipsdev2/Downloads/learnJava/src/resources/"+inFileName);
					try
					{
						sb = new Scanner(inFile);
					}
					catch(IOException e)
					{
						System.err.printf("ERROR: Cannot find/open file %s.\n", inFileName);
						System.exit(1);
					} 
					
				}
				public int randNum()
				{
					int rand = (int)(Math.random()*6+1);
					return rand;
				}
				public void findQuestion()
				{
					int questionNumber = randNum();
					String word = "";
					while(sb.hasNext())
					{
						word = sb.nextLine().trim();
						while(!(word.equals("Questions for level "+level)))
						{
							System.out.println("line read: " + word);
							word= sb.nextLine().trim();
						}
						sb.nextLine();
						word = sb.nextLine();
						while(word.indexOf(questionNumber+")") <0) 		//zsfdhg
						{
							word = sb.nextLine();
						}
						word = word.trim();
						question = word;
						
						sb.nextLine();
						word = sb.nextLine().trim();
						if(word.indexOf("triangle")>-1)
						{
							if(word.indexOf("(a, b, c)")>-1)//if abc triangle
							{
								picOprob = true;
							}
							else
							{
								String firstNum = word.substring(word.indexOf('(')+1, word.indexOf(',')).trim();
								if (firstNum.indexOf('?') > 0) {
									firstNum = word.substring(0, firstNum.indexOf('?') - 1);
									side1 = 10*(Integer.parseInt(firstNum));
								}
								else {
									side1 = 10*(Integer.parseInt(firstNum));
								}
								
								String secondNum = word.substring(word.indexOf(','), word.lastIndexOf(',')).trim();
								if (secondNum.indexOf('?') > 0) {
									secondNum = word.substring(0, secondNum.indexOf('?') - 1);
									side2 = 10*(Integer.parseInt(secondNum));
								}
								else {
									side2 = 10*(Integer.parseInt(secondNum));
								}
								side2 = 10*(Integer.parseInt(secondNum));
								
								String thirdNum = word.substring(word.lastIndexOf(','), word.lastIndexOf(')')).trim();
								if (thirdNum.indexOf('?') > 0) {
									thirdNum = word.substring(0, thirdNum.indexOf('?') - 1);
									side3 = 10*(Integer.parseInt(thirdNum));
								}
								else {
									side3 = 10*(Integer.parseInt(thirdNum));
								}
								side3 = 10*(Integer.parseInt(thirdNum));
							}
						}
						sb.nextLine();
						word = sb.nextLine();
						if(word.equalsIgnoreCase("answer"))
						{
							answer =word.substring(word.indexOf(':')+1).trim();
							word = sb.nextLine();
							if(word.indexOf("other answers:")>-1)
							{
								int randNumber = (int)(Math.random()*1+4);
								word = sb.nextLine();
								if(randNumber == 1)
								{
									a1 = answer;
									b1 = word.substring(':', ';');
									c1 = word.substring(';', word.lastIndexOf(';'));
									d1 = word.substring(word.lastIndexOf(';')+1);
								}
								else if(randNumber == 2)
								{
									b1 = answer;
									a1 = word.substring(':', ';');
									c1 = word.substring(';', word.lastIndexOf(';'));
									d1 = word.substring(word.lastIndexOf(';')+1);
								}
								else if(randNumber == 3)
								{
									c1 = answer;
									b1 = word.substring(':', ';');
									a1 = word.substring(';', word.lastIndexOf(';'));
									d1 = word.substring(word.lastIndexOf(';')+1);
								}
								else if (randNumber == 4)
								{
									d1 = answer;
									b1 = word.substring(':', ';');
									c1 = word.substring(';', word.lastIndexOf(';'));
									a1 = word.substring(word.lastIndexOf(';')+1);
								}
								
								//other answers
							}
						}
					}
				//	System.out.print("answer: "+answer);
				//	System.out.print("question: "+question);
				//	System.out.print("Triangle sides: "+side1+" "+side2+" "+side3);
					sb.close();
				}
				public void paintComponent(Graphics g)
				{
					super.paintComponent(g);
				}
			
			}
			class AnswerPanel extends JPanel
			{
				private JRadioButton a, b, c, d;
				private JButton hi;
				private ButtonGroup answers;
				private JRadioButton answerArray[];
				public AnswerPanel()
				{
					hi= new JButton("hi");
					add(hi);
					//rand answers
					setLayout(null);
					a = new JRadioButton(a1);
					b = new JRadioButton(b1);
					c = new JRadioButton(c1);
					d = new JRadioButton(d1);
					
					answerArray = new JRadioButton[] {a,b,c,d};
					
					answers = new ButtonGroup();
					
					AnswerHandler handle = new AnswerHandler();
					
					for(int i =0; i<=3; i++)
					{
						answers.add(answerArray[i]);
						answerArray[i].addActionListener(handle);
						answerArray[i].setLocation(15, 15+(i*5));
					}
					
				}
				class AnswerHandler implements ActionListener
				{
					public void actionPerformed(ActionEvent e)
					{
						for(int i = 0; i<=3; i++)
						{
							if(answerArray[i].isSelected())
							{
								String command = e.getActionCommand();
								command = ""+answer;
								//score plus one and next = true
							}
						}
					}
				}
			}
				
			class ScorePanel extends JPanel
			{
				private JButton score1;
				private JLabel level;
				private JLabel questionNumber;
				public ScorePanel()
				{
					setLayout(null);
					Color color = new Color(120, 170, 185);
					setBackground(color);
					score1 = new JButton ("Score: "+score);
					score1.setLocation(10,10);
					score1.setSize(new Dimension(85, 25));
					
					add(score1);
					
				}
				public void paintComponenet(Graphics g)
				{
					super.paintComponent(g);
				}
			}
		}
		class RescuePanel extends JPanel
		{
			public RescuePanel()
			{
				setLayout(new GridLayout(1,2));
				MapPanel mp = new MapPanel();
				SavedPanel sp = new SavedPanel();
				add(mp);
				add(sp);
				Color color = new Color(100, 100, 255);
				setBackground(color);
				
				
			}
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				g.setColor(Color.BLUE);
				g.drawRect(12, 3, 100, 200);
			}
			class MapPanel extends JPanel
			{ 
				private JTextArea scoreArea;
				private JTextArea levelArea;
				private JButton minilesson;
				private JButton goToGamePlay;
				private Color darkBlue;
				public MapPanel()
				{
					darkBlue = new Color(0,0,102);
					
					setLayout(null);
					scoreArea = new JTextArea("Score: "+score);
					scoreArea.setLocation(10,10);
					scoreArea.setSize(new Dimension(100, 15));
					scoreArea.setEditable(false);
					
					levelArea = new JTextArea("Level: "+level);
					levelArea.setLocation(125, 10);
					levelArea.setSize(new Dimension(100, 15));
					levelArea.setEditable(false);
					
					minilesson = new JButton("Mini-Lessons");
					minilesson.setLocation(235, 10);
					minilesson.setSize(new Dimension(120, 25));
					
					ButtonHandler h = new ButtonHandler();
					minilesson.addActionListener(h);
					
					goToGamePlay = new JButton("Play Level: "+level);
					goToGamePlay.setLocation(350,10);
					goToGamePlay.setSize(new Dimension(120,25));
					goToGamePlay.addActionListener(h);
					
					add(goToGamePlay);
					add(minilesson);
					add(scoreArea);
					add(levelArea);
					//setBackground(Color.green);
				}
				class ButtonHandler implements ActionListener
				{
					public void actionPerformed(ActionEvent e)
					{
						String command = e.getActionCommand();
						if(command.equals("Mini-Lessons"))
						{
							panel.getCards().show(panel, "MiniLessonPanel");
						}
						else if(command.equals("Play Level: "+level))
						{
							panel.getCards().show(panel, "GamePlayPanel");
						}
					}
				}
				public void paintComponent(Graphics g)
				{
					super.paintComponent(g);
					g.setColor(darkBlue);
					
				}
			}
			class SavedPanel extends JPanel
			{
				private Image imgp1, imgp2, imgp3, imgp4;
				private String imageName1, imageName2, imageName3, imageName4;
				private Image savedpuffles[];
				private String names[];
				private JLabel rescued;
				public SavedPanel()
				{
					setLayout(null);
					Color darkBlue = new Color(0,0,102);
					setBackground(darkBlue);
					
					rescued = new JLabel("Rescued");
					rescued.setLocation(20, 10 );
					rescued.setSize(new Dimension(300, 200));
					add(rescued);
					imgp1 = null;
					imgp2 = null;
					imgp3 = null;
					imgp4 = null;
					savedpuffles = new Image [] { imgp1, imgp2, imgp3, imgp4};
					
					imageName1 ="blackpuffle.gif";
					imageName2 ="purplepffle.gif";
					imageName3 = "brownpuffle.gif";
					imageName4 = "whitepuffle.gif";
					names =new String[]{ imageName1, imageName2, imageName3, imageName4};
				}
				public void paintComponent(Graphics g)
				{
					for(int i =0; i<=3; i++)
					{
						try
						{
							File file = new File("/Users/vshingad/Documents/workspace/learnJava/src/resources/"+names[i]);
							savedpuffles[i] = ImageIO.read(file);
					
						}
						catch(IOException e)
						{
							System.err.println("File not found "+names[i]);
							e.printStackTrace();
						} 
					}
					super.paintComponent(g);
					if(saved == 1)
					{
						g.drawImage(savedpuffles[0], 10, 410, 200, 200, this);
					}
					repaint();
					if(saved  == 2)
					{
						g.drawImage(savedpuffles[1], 210, 410, 200, 200, this);
					}
					repaint();
					if(saved == 3)
					{
						g.drawImage(savedpuffles[2], 10, 620, 200, 200, this);
					}
					repaint();
					if(saved== 4)
					{
						g.drawImage(savedpuffles[3], 210, 620, 200, 200, this);
					}
					repaint();
				}
			}
			
		}
		
		class MiniLessonPanel extends JPanel
		{
			public MiniLessonPanel()
			{
				setBackground(Color.YELLOW);
			}
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
			}
		}
	}
}








//Nested in GamePlay class AnswerPanel

//declare 4 JButtons
//declare int questions
//declare int tries 

//constructor
//initialize JButtons based on the values found in file
// add choice handler class
//add to the panel
//initialize questions
//Initialize tries

//nested in AnswerPanel ChoiceHandler //implements ActionListener

//actionPerformed

//command =  evt.getActionCommand 
//if (answer = command)
// questions +1
// findQuestion()
//repaint()

//else if(tries<3 )
// display try-again message, tries+1
//else
// go to rescue panel (rpv = true, gpv= false)


//Nested in GamePlay class Score
//JButton with icon
//JButton home
//JLabel levels
//constructor
//initialize JButton with icon as one of the images of the creatures (corresponding to the level)
//set background color, blue or gray
//Jbutton home -- if pressed goes back to rescue panel, rpv = true

//add JButtons to pannel
//JLabel to show which levels


//the home panel and achievement panel RescuePanel class

//constructor 
//create instance of AfterQuestions panel class -- aq
//create instance of HomePanel panel class -- hp


//in RescuePanel class, AfterQuestions panel class
//constructor
//setBackground to blue

//paintComponent
//if questionscorrect is 3
	// g.drawString("SUCESS!You completed a mission and rescued one of the creatures in the hands of evil")
	//level = level +1
//else
	//g.drawString("YOU have failed, try again")


//in RescuePanel class, HomePanel panel class
//constructor
//create an instance of Map panel class
//create an instance of rescued panel class
//put in BorderLayout


// in HomePanel class, Map panel class
//declare Image variables to hold the creature images
//declare string names for the images
//constructor
//set background color
//initialize the images to null

//initialise the image names

//create instance of the draw class (draws the images)

//main method
//create instance of class Map
//calls run

//run method
//getMyImage

//getMyImageMethod
//use try catch block to save image

//Nested in Map, class Draw
//constructor
//empty

//paintComponent
//draw Images in between draw rectangles that form a trail to the evil castle

//Nested in HomePanel class
//declare JLabel variables for level, name of game and saved
//constructor
//initialise the level --- depending on level varaible
//initialize the name of the game "dangerous trig rendezvous"
//initialize the number of creatures saved
//setBackground color gray or blue

//