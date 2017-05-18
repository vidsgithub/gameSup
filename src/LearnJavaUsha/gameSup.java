
package LearnJavaUsha;

import java.awt.Color;	
import java.awt.Graphics;
import java.awt.Font;

import javax.swing.JFrame;	
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
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

public class gameSup
{
	private JFrame framew;
	private Panels panel;
	private boolean repaintb = false;
	public static String resDir="/Users/bipsdev2/Downloads/learnJava/src/resources/";
	public gameSup()
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
		gameSup tdtr = new gameSup();
	}
	
	class Panels extends JPanel
	{
		private StartPanel sp;
		private DirectionsStory ds;
		private GamePlay gp;
		private RescuePanel rp;
		private MiniLessonPanel mlp;
		private FinishLevelPanel fqp;
		private FailLevelPanel flp;
		private CardLayout cards;
		private int level, levelPlay;
		private int score;
		private Image imgp1, imgp2, imgp3, imgp4;
		private String puffle1, puffle2, puffle3, puffle4;
		private Image savedpuffles[];
		private String names[];
		private int saved;
		public Panels()
		{
			level = 1;
			levelPlay = 1;
			score= 1;
			saved = 0;
			cards = new CardLayout();
			setLayout(cards);
			setBackground(Color.RED);
			

			imgp1 = null;
			imgp2 = null;
			imgp3 = null;
			imgp4 = null;
			savedpuffles = new Image [] { imgp1, imgp2, imgp3, imgp4};
			
			puffle1 ="blackpuffle.gif";
			puffle2 ="purplepffle.gif";
			puffle3 = "brownpuffle.gif";
			puffle4 = "whitepuffle.gif";
			names =new String[]{ puffle1, puffle2, puffle3, puffle4};
			
			for(int i =0; i<=3; i++)
			{
				try
				{
					File file = new File(resDir+names[i]);
					savedpuffles[i] = ImageIO.read(file);
			
				}
				catch(IOException e)
				{
					System.err.println("File not found "+names[i]);
					e.printStackTrace();
				} 
			}
			
			flp = new FailLevelPanel();
			fqp = new FinishLevelPanel();
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
			add(flp, "FailLevelPanel");
			add(fqp, "FinishLevelPanel");
			
			
			
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
					File file = new File(resDir+imageName);
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
						File file = new File(resDir+imgName1);
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
						File file = new File(resDir+imgName2);
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
						File file = new File(resDir+imgName3);
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
						File file = new File(resDir+imgName4);
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
						File file = new File(resDir+imgName5);
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
						File file = new File(resDir+imgNamedf);
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
			private ButtonGroup answers;
			private String a1,b1,c1,d1;
			private QuestionPanel qp;
			private int questionum;
			private AnswerPanel ap;
			public GamePlay()
			{
				b = new BorderLayout();
				setLayout(b);
				
				inFileName = "Questions.txt";
				sb= null;
				questionum = 1;
				qp = new QuestionPanel();
				ap = new AnswerPanel();
				ScorePanel sp = new ScorePanel();
				
				sp.setPreferredSize(new Dimension(100, 100));
				qp.setPreferredSize(new Dimension(650, 200));
				ap.setPreferredSize(new Dimension(900, 450));
				
				add(sp, BorderLayout.NORTH);
				add(qp, BorderLayout.CENTER);
				add(ap, BorderLayout.SOUTH);
				
			}
			
			class QuestionPanel extends JPanel
			{
				private String question;
				private int rand;
				private int side1, side2, side3;
				private boolean picOprob;
				private JTextArea problem;
				private JButton help;
				private int trackQuestion;
				public QuestionPanel()
				{
					rand =0;
					picOprob = false;
					question = "";
					readFile();
					findQuestion();
					problem = new JTextArea(question);
					problem.setEditable(false);
					problem.setLineWrap(true);
					problem.setLocation(10, 10);
					problem.setSize(new Dimension(450, 100));
					
					help = new JButton("Help");
					HelpActionListener helpActionListener = new HelpActionListener();
					help.addActionListener(helpActionListener);
					add(help);
					add(problem);
				}
				
				public void readFile()
				{
					File inFile = new File(resDir+inFileName);
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
					int rand1 = (int)(Math.random()*6+1);
					
					if(rand == rand1)
					{
						randNum();
					}
					else
						rand = rand1;
					return rand;
				}
				public void findQuestion()
				{
					int questionNumber =randNum();
					System.out.print(questionNumber);
					String word = "";
					boolean falsebreak= true;
					
					while(sb.hasNext() && falsebreak)
					{
						word = sb.nextLine().trim();
						while(!(word.equalsIgnoreCase("Questions for level "+levelPlay)))
						{
							System.out.println("line read: " + word);
							word= sb.nextLine().trim();
						}
						sb.nextLine();
						word = sb.nextLine();
						while( word.indexOf(questionNumber+")") < 0 ) 		//zsfdhg
						{
							word = sb.nextLine();
						}
						word = word.substring(word.indexOf(')')+2).trim();
						question = questionNumber+") "+word;
						
						sb.nextLine();
						word = sb.nextLine().trim();
						if(word.indexOf("triangle")>-1)
						{
							if(word.indexOf("(a, b, c)")>-1)//if abc triangle
							{
								picOprob = true;
							}
							else if(word.indexOf("none") > 0) {
								// what needed to be done ?
							}
							else
							{
								String firstNum = word.substring(word.indexOf('(')+1, word.indexOf(',')).trim();
								int firstQuestionMarkIndex = firstNum.indexOf('?');
								if (firstQuestionMarkIndex > 0) 
								{
									firstNum = firstNum.substring(0, firstQuestionMarkIndex);
									side1 = 10*(Integer.parseInt(firstNum));
								}
								else 
								{
									side1 = 10*(Integer.parseInt(firstNum));
								}
								
								String secondNum = word.substring(word.indexOf(',')+1, word.lastIndexOf(',')).trim();
								int secondQuestionMarkIndex = secondNum.indexOf('?');
								if (secondQuestionMarkIndex > 0) 
								{
									secondNum = secondNum.substring(0, secondQuestionMarkIndex);
									side2 = 10*(Integer.parseInt(secondNum));
								}
								else 
								{
									side2 = 10*(Integer.parseInt(secondNum));
								}
								
								String thirdNum = word.substring(word.lastIndexOf(',')+1, word.lastIndexOf(')')).trim();
								int questionMarkIndex = thirdNum.indexOf('?');
								if (questionMarkIndex > 0) 
								{
									thirdNum = thirdNum.substring(0, questionMarkIndex);
									side3 = 10*(Integer.parseInt(thirdNum));
								}
								else 
								{
									side3 = 10*(Integer.parseInt(thirdNum));
								}
							}
						}		// triangle
						
						sb.nextLine();
						word = sb.nextLine().trim();
						if(word.indexOf("answer") >= 0)
						{
							answer = word.substring(word.indexOf(':')+1).trim();
							word = sb.nextLine().trim();
							if(word.indexOf("other answers:") >= 0)
							{
								int randNumber = (int)(Math.random()*4+1);
								System.out.print(randNumber);
								//word = sb.nextLine();
								if(randNumber == 1)
								{
									a1 = answer;
									b1 = word.substring(word.indexOf(':')+1, word.indexOf(';')).trim();
									c1 = word.substring(word.indexOf(';')+1, word.lastIndexOf(';')).trim();
									d1 = word.substring(word.lastIndexOf(';')+1).trim();
								}
								else if(randNumber == 2)
								{
									b1 = answer;
									a1 = word.substring(word.indexOf(':')+1, word.indexOf(';')).trim();
									c1 = word.substring(word.indexOf(';')+1, word.lastIndexOf(';')).trim();
									d1 = word.substring(word.lastIndexOf(';')+1).trim();
								}
								else if(randNumber == 3)
								{
									c1 = answer;
									b1 = word.substring(word.indexOf(':')+1, word.indexOf(';')).trim();
									a1 = word.substring(word.indexOf(';')+1, word.lastIndexOf(';')).trim();
									d1 = word.substring(word.lastIndexOf(';')+1).trim();
								}
								else if (randNumber == 4)
								{
									d1 = answer;
									b1 = word.substring(word.indexOf(':')+1, word.indexOf(';')).trim();
									c1 = word.substring(word.indexOf(';')+1, word.lastIndexOf(';')).trim();
									a1 = word.substring(word.lastIndexOf(';')+1).trim();
								}
							}		//other answers
						}			// answers:
						falsebreak = false; //break;
					}	// whileloop
					sb.close();
				}
				
				public void paintComponent(Graphics g)
				{
					super.paintComponent(g);
					//readFile();
					//findQuestion();
					int intx []= {400, 400, 400+side2};
					int inty []= {60, 250+side3, 150};
					
					g.drawPolygon(intx, inty, 3);
					
					problem.setText(question);
					if(repaintb )
					{
						readFile();
						findQuestion();
						repaint();
						answers.clearSelection();
						panel.repaint();
						repaintb =false;
					}
				
					
				}
				
				class HelpActionListener implements ActionListener {
					public void actionPerformed(ActionEvent e) {
						// show rescue panel
						panel.getCards().show(panel, "HomePanel");
					}
				}
			
			}
			
			class AnswerPanel extends JPanel
			{
				private JRadioButton a, b, c, d;
				private JRadioButton answerArray[];
				private JLabel correct;
				private JButton next;
				private JLabel wrong;
				private int trackQuestionTries, correctQuestionCount;
				private boolean usercorrect = false;
				private boolean userwrong = false;
				

				public AnswerPanel()
				{
					//rand answers
					setLayout(null);
					a = new JRadioButton(a1);
					a.setLocation(10,55 );
					a.setSize(new Dimension(800,20));
					b = new JRadioButton(b1);
					b.setLocation(10, 85);
					b.setSize(new Dimension(800,20));
					c = new JRadioButton(c1);
					c.setLocation(10, 115);
					c.setSize(new Dimension(800,20));
					d = new JRadioButton(d1);
					d.setLocation(10, 145);
					d.setSize(new Dimension(800,20));
					
					trackQuestionTries = 1;
					questionum = 1;
					correctQuestionCount = 0;
					answerArray = new JRadioButton[] {a,b,c,d};
					answers = new ButtonGroup();
					AnswerHandler handle = new AnswerHandler();
					for(int i =0; i<=3; i++)
					{
						answers.add(answerArray[i]);
						answerArray[i].addActionListener(handle);
						add(answerArray[i]);
					}
					
						AnswerHandler2 handle2 = new AnswerHandler2();
						
						correct = new JLabel("CORRECT!");
						add(correct);
						correct.setVisible(false);
						correct.setLocation(725, 35);
						correct.setSize(new Dimension(200, 50));
						
						next = new JButton("Next Question");
						next.setLocation(725, 95);
						next.setSize(new Dimension(140, 50));
						next.addActionListener(handle2);
						add(next);
						next.setVisible(false);
						
						wrong = new JLabel("Wrong Try Again");
						//wrong.addActionListener(handle2);
						wrong.setLocation(725, 35);
						wrong.setSize(new Dimension(200, 50));
						add(wrong);
						wrong.setVisible(false);
				}
				
				public void paintComponent(Graphics g)
				{
					super.paintComponent(g);
					a.setText(a1);
					b.setText(b1);
					c.setText(c1);
					d.setText(d1);
					
				}
				
				// Handle RadioButton calls
				class AnswerHandler implements ActionListener
				{
					private JDialog wrongFrame;
					public void actionPerformed(ActionEvent e)
					{
						String command = e.getActionCommand();
						if(command.equals(answer))
						{
							usercorrect = true;
							correctQuestionCount++;

							correct.setVisible(true);
							next.setVisible(true);
							wrong.setVisible(false);
							//sp.repaint();
						}
						else
						{
							correct.setVisible(false);
							next.setVisible(true);
							wrong.setVisible(true);
							
							if(trackQuestionTries == 2)
							{
								wrongFrame = new JDialog();
								wrongFrame.setSize(300, 100);				
								wrongFrame.setDefaultCloseOperation(wrongFrame.DISPOSE_ON_CLOSE);
								wrongFrame.setTitle("Incorrect");
								wrongFrame.setLocation(500,100);
								QuestionWrong qw = new QuestionWrong();
								wrongFrame.setContentPane(qw);
								wrongFrame.setVisible(true);
								wrong.setVisible(false);
								
								trackQuestionTries = 1; //reset
								//panel.getCards().show(panel, "GamePlayPanel");
							}
							else
								trackQuestionTries++;
						}
						
						if (questionum >= 2) 
						{
							questionum = 1;	// reset question tracker
							if (correctQuestionCount >= 2)
							{
								trackQuestionTries =1;
								correctQuestionCount = 0; // reset the corrected questions count
								// proceed with next level
								level++;
								saved++;
								panel.getCards().show(panel, "FinishLevelPanel");
								qp.readFile();
								qp.findQuestion();
								qp.repaint();
							} 
							else 
							{
								// exceeds the limit of question of this level, move to home
								panel.getCards().show(panel, "FailLevelPanel");
							}
						} 
						panel.repaint();
					}
					
					class QuestionWrong extends JPanel 
					{
						private JLabel uwrong;
						private JButton back;
						public QuestionWrong()
						{
							setLayout(new GridLayout(2,1));
							uwrong = new JLabel("              You got the question wrong");
							add(uwrong);
							
							back = new JButton("Back");
							ButtonH h = new ButtonH();
							back.addActionListener(h);
							add(back);
						}
						class ButtonH implements ActionListener
						{
							public void actionPerformed(ActionEvent e) {
								String command = e.getActionCommand();
								answers.clearSelection();
								questionum++;
								if(command.equals("Back"))
								{
									wrongFrame.dispose();
									
		 							// hide all right side buttons
									correct.setVisible(false);
									next.setVisible(false);
									wrong.setVisible(false);
									
									qp.readFile();
									qp.findQuestion();
									qp.repaint();
									
									panel.repaint();
								}
							}
						}
					}
				}
				
				// Handles Next Button calls
				class AnswerHandler2 implements ActionListener
				{
					public void actionPerformed(ActionEvent e)
					{
						String command =e.getActionCommand();
						answers.clearSelection();
						if(command.equals("Next Question"))
						{
							if(level ==1)
							{
								score =100+score;
								sp.repaint();
							}
							else if(level ==2)
							{
								score = 200+score;
								sp.repaint();
							}
							else if(level == 3)
							{
								score = 300+score;
								sp.repaint();
							}
							else if(level ==4)
							{
								score = 400+score;
								sp.repaint();
							}
							trackQuestionTries = 1;		// for next question reset try questions
							questionum++;
							
							
 							// hide all right side buttons
							correct.setVisible(false);
							next.setVisible(false);
							wrong.setVisible(false);
							
							if (level <= 4) {
								// if number of question attempted is 2 then
								if (questionum > 2) 
								{
		
									if (correctQuestionCount >= 2)
									{
										correctQuestionCount = 0; // reset the corrected questions count
										// proceed with next level
										level++;
										saved++;
										panel.getCards().show(panel, "FinishLevelPanel");
										qp.readFile();
										qp.findQuestion();
										qp.repaint();

										panel.repaint();
									} 
									else 
									{
										// exceeds the limit of question of this level, move to home
										panel.getCards().show(panel, "FailLevelPanel");
									}
									questionum = 1;	// reset question tracker
								} 
								else 
								{
									qp.readFile();
									qp.findQuestion();
									qp.repaint();

									panel.repaint();
								}
							}
							else 
							{
								// no more levels to go home
								panel.getCards().show(panel, "HomePanel");
							}
						}
					}
				}
				
			}
				
			class ScorePanel extends JPanel
			{
				private JButton score1;
				private JLabel levelLbl;
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
					
					levelLbl = new JLabel("Level: "+level);
					levelLbl.setLocation(100, 10);
					levelLbl.setSize(new Dimension(85,25));
					
					add(levelLbl);
					
					questionNumber = new JLabel("Question: "+questionum);
					questionNumber.setLocation(210, 10);
					questionNumber.setSize(new Dimension(85,25));
					add(questionNumber);
				}
				public void paintComponenet(Graphics g)
				{
					super.paintComponent(g);
					score1.setText("Score-> "+score);
					levelLbl.setText("Level-> "+level);
					questionNumber.setText("Question-> "+questionum);
				}
			}
		}
		class FinishLevelPanel extends JPanel
		{
			private JButton continue1;
			private JLabel yay;
			private JLabel puffles;
			private JLabel pic;
			public FinishLevelPanel()
			{
				setLayout(new GridLayout(2, 2, 30, 30));
				yay = new JLabel("YAy you finished the level!!");
				puffles = new JLabel("This means you saved a puffle!");
				add(yay);
				add(puffles);
				continue1 = new JButton("Home");
				BH hh = new BH();
				continue1.addActionListener(hh);
				add(continue1); 
				if(saved == 0)
				{
					pic = new JLabel(new ImageIcon(savedpuffles[0]));
				}
				else if(saved == 1)
				{
					pic = new JLabel(new ImageIcon(savedpuffles[1]));
				}
				else if(saved == 2)
				{
					pic = new JLabel(new ImageIcon(savedpuffles[2]));
				}
				else if(saved == 4)
				{
					pic = new JLabel(new ImageIcon(savedpuffles[3]));
				}
				add(pic);
			}
			
			public void paintComponenet(Graphics g)
			{
				super.paintComponent(g);
			}
			
			class BH implements ActionListener
			{
				public void actionPerformed(ActionEvent e)
				{
					String command = e.getActionCommand();
					if(command.equals("Home"))
					{
						panel.getCards().show(panel, "HomePanel");
						rp.sp.addSavedPuffles();
					}
				}
			}
		}
		
		class FailLevelPanel extends JPanel
		{
			private JLabel fail;
			private JButton tryagain;
			private JButton home;
			public FailLevelPanel()
			{
				setLayout(new GridLayout(2,1));
				fail = new JLabel("You failed this level !!");
				tryagain = new JButton("Try Level "+levelPlay+" again");
				home = new JButton("Go Home");
				BH h = new BH();
				tryagain.addActionListener(h);
				home.addActionListener(h);
				add(fail);
				add(tryagain);
				add(home);
			}
			class BH implements ActionListener
			{
				public void actionPerformed(ActionEvent e)
				{
					String command = e.getActionCommand();
					
					if(command.equals("Try Level "+levelPlay+" again"))
					{
						panel.getCards().show(panel, "GamePlayPanel");
						repaintb = true;
					}
					else if(command.equals("Go Home"))
					{
						panel.getCards().show(panel, "HomePanel");
					}
				}
			}
		}
		class RescuePanel extends JPanel
		{
			public SavedPanel sp;
			public RescuePanel()
			{
				setLayout(new GridLayout(1,2));
				MapPanel mp = new MapPanel();
				sp = new SavedPanel();
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
				private JButton level1Play, level2Play, level3Play, level4Play;
				private Color darkBlue;
				public MapPanel()
				{
					darkBlue = new Color(0,0,102);
					
					setLayout(null);
					scoreArea = new JTextArea("Score: "+score);
					scoreArea.setLocation(10,10);
					scoreArea.setSize(new Dimension(100, 15));
					scoreArea.setEditable(false);
					
					levelArea = new JTextArea("Levels Unlocked: "+level);
					levelArea.setLocation(125, 10);
					levelArea.setSize(new Dimension(100, 15));
					levelArea.setEditable(false);
					
					minilesson = new JButton("Mini-Lessons");
					minilesson.setLocation(235, 10);
					minilesson.setSize(new Dimension(120, 25));
					
					ButtonHandler h = new ButtonHandler();
					minilesson.addActionListener(h);
					
					level1Play = new JButton("Play Level: 1");
					level1Play.setLocation(350,10);
					level1Play.setSize(new Dimension(120,25));
					level1Play.addActionListener(h);
					
					level2Play = new JButton("Play Level: 2");
					level2Play.setLocation(350,35);
					level2Play.setSize(new Dimension(120,25));
					level2Play.addActionListener(h);
					level2Play.setVisible(false);
					
					level3Play = new JButton("Play Level: 3");
					level3Play.setLocation(350,60);
					level3Play.setSize(new Dimension(120,25));
					level3Play.addActionListener(h);
					level3Play.setVisible(false);
					
					level4Play = new JButton("Play Level: 4");
					level4Play.setLocation(350,85);
					level4Play.setSize(new Dimension(120,25));
					level4Play.addActionListener(h);
					level4Play.setVisible(false);
					
					add(level1Play);
					add(level2Play);
					add(level3Play);
					add(level4Play);
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
						else if(command.equals("Play Level: 1"))
						{
							panel.getCards().show(panel, "GamePlayPanel");
							levelPlay =1;
							
						}
						else if(command.equals("Play Level: 2"))
						{
							panel.getCards().show(panel, "GamePlayPanel");
							levelPlay = 2;
							repaintb = true;
						}
						else if(command.equals("Play Level: 3"))
						{
							panel.getCards().show(panel, "GamePlayPanel");
							levelPlay = 3;
							repaintb = true;
						}
						else if(command.equals("Play Level: 4"))
						{
							panel.getCards().show(panel, "GamePlayPanel");
							levelPlay = 4;
							repaintb = true;
						}
					}
				}
				public void paintComponent(Graphics g)
				{
					super.paintComponent(g);
					g.setColor(darkBlue);
				//	goToGamePlay.setText("Play Level: "+level);
					if(level >=2)
					{
						level2Play.setVisible(true);
					}
					if(level >=3)
					{
						level3Play.setVisible(true);
					}
					if(level >=4)
					{
						level4Play.setVisible(true);
					}
					levelArea.setText("Level: "+level);
					scoreArea.setText("Score: "+score);
					
					if (level > 4) {
			//			goToGamePlay.setEnabled(false);
						levelArea.setEnabled(false);
						scoreArea.setEditable(false);
					}
					
				}
			}
			class SavedPanel extends JPanel
			{
				private JLabel rescued;
				public SavedPanel()
				{
					//setLayout(null);
					setLayout(new GridLayout(2,2));
					Color darkBlue = new Color(0,0,102);
					setBackground(darkBlue);
					
					rescued = new JLabel("Rescued");
					rescued.setBackground(Color.WHITE);
					rescued.setLocation(20, 10 );
					rescued.setSize(new Dimension(300, 200));
					add(rescued);
				}
				public void addSavedPuffles() {
					this.removeAll();
					for(int i = 0; i < saved; i++) {
						JLabel pic = new JLabel(new ImageIcon(savedpuffles[i]));
						this.add(pic);
					}
				}
				public void paintComponent(Graphics g)
				{
					super.paintComponent(g);
				}
			}
			
		}
		
		class MiniLessonPanel extends JPanel implements MouseListener
		{
			private CardLayout c;
			private Image img1, img2, img3, img4, img5, img6=null;
			public MiniLessonPanel()
			{
				c = new CardLayout();
				setLayout(c);
				MiniLessonButtons mlb = new MiniLessonButtons();
				Minilesson1 m1 = new Minilesson1();
				Minilesson2 m2 = new Minilesson2();
				Minilesson3 m3 = new Minilesson3();
				Minilesson4 m4 = new Minilesson4();
				addMouseListener(this);
				add(mlb, "ButtonsPanel");
				add(m1, "Lesson 1");
				add(m2, "Lesson 2");
				add(m3, "Lesson 3");
				add(m4, "Lesson 4");
				
			}
			class MiniLessonButtons extends JPanel
			{
				private JButton level1;
				private JButton level2;
				private JButton level3;
				private JButton level4;
				private JButton back;
				public MiniLessonButtons()
				{
					setLayout(new GridLayout(5,1));
					setBackground(Color.LIGHT_GRAY);
					level1 = new JButton("Mini-Lesson Level 1");
					level2 = new JButton("Mini-Lesson Level 2");
					level3 = new JButton("Mini-Lesson Level 3");
					level4 = new JButton("Mini-Lesson Level 4");
					back = new JButton("Back");
					ButtonH h = new ButtonH();
					//ButtonH2 h2 = new ButtonH2();
					level1.addActionListener(h);
					level2.addActionListener(h);
					level3.addActionListener(h);
					level4.addActionListener(h);
					back.addActionListener(h);
					add(level1);
					add(level2);
					add(level3);
					add(level4);
					
					add(back);
				}
			}
			class Minilesson1 extends JPanel
			{
				public void paintComponent(Graphics g)
				{
					g.drawString("Learn what your need to know for level 1 (click to go back)", 100, 25);
					g.drawString("Key points:", 100, 100);
					
					try
					{
						File file = new File(resDir+"level1Notes.jpg");
						img1 = ImageIO.read(file);
				
					}
					catch(IOException e)
					{
						System.err.println("File not found "+"level1Notes.jpg");
						e.printStackTrace();
					} 
					g.drawImage(img1, 150, 150, 465, 500, this);
					
					g.drawString("These are very important trigonometric values used to solve a triangle and put them back together!", 150, 670);
					repaint();
				}
			}
			class Minilesson2 extends JPanel
			{
				public void paintComponent(Graphics g)
				{
					g.drawString("Learn what your need to know for level 2", 100, 25);
					g.drawString("Key points:", 100, 100);
					g.drawString("The Law of Cosines", 175, 100);
					try
					{
						File file = new File(resDir+"level2Notes1.png");
						img2 = ImageIO.read(file);
				
					}
					catch(IOException e)
					{
						System.err.println("File not found "+"level2Notes1.png");
						e.printStackTrace();
					} 
					try
					{
						File file = new File(resDir+"level2Notes.png");
						img3 = ImageIO.read(file);
				
					}
					catch(IOException e)
					{
						System.err.println("File not found "+"level2Notes.png");
						e.printStackTrace();
					} 
					g.drawImage(img2, 50, 150, 600, 400, this);
					g.drawImage(img3, 655, 150, 300, 400, this);
					g.drawString("These are very important trigonometric values used to solve a triangle and put them back together!", 150, 670);
					repaint();
				}
			}
			class Minilesson3 extends JPanel
			{
				public void paintComponent(Graphics g)
				{
					g.drawString("Learn what your need to know for level 3", 100, 25);
					g.drawString("Key points:", 100, 100);
					g.drawString("The Law of Sines", 175, 100);
					
					try
					{
						File file = new File(resDir+"Law-of-Sines-Ambiguous-Case.png");
						img4 = ImageIO.read(file);
				
					}
					catch(IOException e)
					{
						System.err.println("File not found "+"Law-of-Sines-Ambiguous-Case.png");
						e.printStackTrace();
					} 
					g.drawImage(img4, 10, 13, 800, 666, this);
					//g.drawString("These are very important trigonometric values used to solve a triangle and put them back together!", 150, 670);
					repaint();
				}
			}
			class Minilesson4 extends JPanel
			{
				public void paintComponent(Graphics g)
				{
					g.drawString("Learn what your need to know for level 4", 100, 25);
					g.drawString("Key points:", 100, 100);
					g.drawString("How to put law of sines and law of cosines together. Here are some examples of solving general tryings", 175, 100);
					/*try
					{
						File file = new File(resDir+"Screen Shot 2017-05-16 at 10.50.43 PM.png");
						img5 = ImageIO.read(file);
				
					}
					catch(IOException e)
					{
						System.err.println("File not found "+"Screen Shot 2017-05-16 at 10.50.43 PM.png");
						e.printStackTrace();
					} */
					repaint();
				}
			}
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				
			}
			class ButtonH implements ActionListener
			{
				public void actionPerformed(ActionEvent e)
				{
					String command = e.getActionCommand();
					if(command.equals("Mini-Lesson Level 1"));
					{
						c.show(mlp, "Lesson 1");
					}
					if(command.equals("Mini-Lesson Level 2"))
					{
						c.show(mlp, "Lesson 2");
					}
					if(command.equals("Mini-Lesson Level 3"))
					{
						c.show(mlp, "Lesson 3");
					}
					if(command.equals("Mini-Lesson Level 4"))
					{
						c.show(mlp, "Lesson 4");
					}
					if(command.equals("Back"))
					{
						panel.getCards().show(panel, "HomePanel");
					}
					
				}
			}
			class ButtonH2 implements ActionListener
			{
				public void actionPerformed (ActionEvent e)
				{
					
				}
			}
			
			public void mouseClicked(MouseEvent e) 
			{
				c.show(mlp, "ButtonsPanel");
				repaint();
				
			}
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
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