/*###############################################################
#		Program Name :- SpeedTester.java 						#
#		Github:- himanshusharma2972								#
#		Gmail:- himanshusharma2972								#
#               												#
#                  www.blaregroup.com							#
#	About:- SpeedTester is Typing tool which helps to you to 	#
#			check and increase your typing speed and accuracy.	#
#																#
#################################################################

//importing modules
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.lang.System;
import java.io.*;
import javax.swing.text.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.border.*;
import java.awt.FlowLayout;
import java.util.List;
import java.util.ArrayList;
import javax.swing.UIManager; 
/*****		This class will create Home Window of SpeedTester	*****/
class HomeWindowSection extends JPanel
{
		//components and panels of home window
		JPanel ContentListPanel;
		JPanel listPanel;
		JPanel DurationListPanel;
		JLabel contentListHeader;
		JList<String> contentList;
		JLabel durationLabel;
		JButton startTestButton;
		JRadioButton twominute;
		JRadioButton fiveminute;
		JRadioButton tenminute;
		JRadioButton thirtyminute;
		ButtonGroup durationbuttongroup;
		JScrollPane scrollcontentList;
	
	

		//this constructor will create components for home window
		public HomeWindowSection()
		{	
			
			/* initializing components  */
			ContentListPanel = new JPanel();
			listPanel = new JPanel();
			DurationListPanel = new JPanel();
			contentListHeader = new JLabel("Select Content Type");
			
			durationLabel = new JLabel("Select Duration");
			startTestButton = new JButton("    Start Test    ");
			twominute = new JRadioButton("02:00");
			fiveminute = new JRadioButton("05:00");
			tenminute = new JRadioButton("10:00");
			thirtyminute = new JRadioButton("30:00");
			durationbuttongroup = new ButtonGroup();
			
			//setting up heading for content choosing display
			contentListHeader.setForeground(Color.WHITE);
			contentListHeader.setFont(new Font("",Font.BOLD,40));
			
			//settin up items of typing for user to choose in JList
			String topicName[] = {"Good Company and Bad Company","Hundred Gold Coins & Birbal","Keep Your Dream","The Circle of Good Deed","The Needy King and a Sage","The Poor Man’s Wealth","Be Grateful"};
			contentList = new JList<String>(topicName);					//Jlist created
			
			//Config Content List
			contentList.setFixedCellWidth(1000);						//setting width of Jlist panel
		 	contentList.setFixedCellHeight(60);							//setting height of each list item 
		 	contentList.setFont(new Font("",Font.BOLD,26));				//setting  font style of list
		 	contentList.setVisibleRowCount(4);							//setting visible row count 	
		 	contentList.setSelectedIndex(1);							//setting default option
		 	contentList.setBackground(new Color(102,186,191));			//set background
		 	contentList.setForeground(new Color(235,254,255));			//set foreground
		 	contentList.setSelectionBackground(new Color(238,149,113));	//setting selection background
		 	
		 	//adding scroll bar to Jlist
		 	scrollcontentList= new JScrollPane(contentList);

		 	
		 	listPanel.add(scrollcontentList);
			listPanel.setBackground(new Color(31, 35, 64));

		 		
		 	//setting up heading for duration choosing panel
		 	durationLabel.setForeground(Color.WHITE);
			durationLabel.setFont(new Font("",Font.BOLD,50));

			//Config TwoMinute button
			twominute.setActionCommand("02:00");
			twominute.setFont(new Font("",Font.BOLD,25));
			twominute.setSelected(true);		//default option

			//Config Five Minute Button
			fiveminute.setActionCommand("05:00");
			fiveminute.setFont(new Font("",Font.BOLD,25));
			
			//Config Ten Minute Button
			tenminute.setActionCommand("10:00");
			tenminute.setFont(new Font("",Font.BOLD,25));
			
			//Config Thirty minute Button
			thirtyminute.setActionCommand("30:00");
			thirtyminute.setFont(new Font("",Font.BOLD,25));


			//adding all radio button in single button group
			durationbuttongroup.add(twominute);
			durationbuttongroup.add(fiveminute);
			durationbuttongroup.add(tenminute);
			durationbuttongroup.add(thirtyminute);

			
			//config start button 
		 	startTestButton.setBackground(Color.RED);
		 	startTestButton.setForeground(Color.WHITE);
		 	startTestButton.setFont(new Font("",Font.BOLD,35));
		 	startTestButton.setPreferredSize(new Dimension(100,80));
			

			//config contentlist panel
			ContentListPanel.setBackground(new Color(31, 35, 64));
			ContentListPanel.setLayout(new BoxLayout(ContentListPanel,BoxLayout.Y_AXIS));
			ContentListPanel.setPreferredSize(new Dimension(500,150));

			//adding components to content list panel
			ContentListPanel.add(Box.createRigidArea(new Dimension(100,10)));
			ContentListPanel.add(contentListHeader);
			contentListHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
			ContentListPanel.add(Box.createRigidArea(new Dimension(100,10)));
			ContentListPanel.add(listPanel);
			listPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
			ContentListPanel.add(Box.createRigidArea(new Dimension(0,0)));

			
			//config durationlist panel
			DurationListPanel.setBackground(new Color(31, 35, 64));
			DurationListPanel.setLayout(new BoxLayout(DurationListPanel,BoxLayout.Y_AXIS));
			DurationListPanel.setPreferredSize(new Dimension(1500,350));

			//adding components to Duration list panel
			DurationListPanel.add(Box.createRigidArea(new Dimension(1200,5)));
			DurationListPanel.add(durationLabel);
			
			DurationListPanel.add(Box.createRigidArea(new Dimension(1000,20)));
			DurationListPanel.add(twominute);
			
			DurationListPanel.add(Box.createRigidArea(new Dimension(1000,20)));
			DurationListPanel.add(fiveminute);
			
			DurationListPanel.add(Box.createRigidArea(new Dimension(1000,20)));
			DurationListPanel.add(tenminute);
			
			DurationListPanel.add(Box.createRigidArea(new Dimension(1000,20)));
			DurationListPanel.add(thirtyminute);
			
			//Config Alignment of components on duration List Panel
			durationLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			twominute.setAlignmentX(Component.CENTER_ALIGNMENT);
			fiveminute.setAlignmentX(Component.CENTER_ALIGNMENT);
			tenminute.setAlignmentX(Component.CENTER_ALIGNMENT);
			thirtyminute.setAlignmentX(Component.CENTER_ALIGNMENT);

			

			//Config Alignment of components on main panel
			ContentListPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
			DurationListPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
			startTestButton.setAlignmentX(Component.CENTER_ALIGNMENT);

				
			//setting up main panel for home window
			setBackground(new Color(31, 35, 64));
			setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
			add(Box.createRigidArea(new Dimension(0,5)));
			add(ContentListPanel);
			add(Box.createRigidArea(new Dimension(0,5)));
			add(DurationListPanel);
			add(Box.createRigidArea(new Dimension(100,5)));
			add(startTestButton);
			add(Box.createRigidArea(new Dimension(0,30)));
			
		}

	
}

/******	This class will create TypingWindow for SpeedTester	******/
class TypingWindowSection extends JPanel
{	 
		//components and panels of sidepanel in typing window
		JPanel sidePanel;
		JLabel timerLabel;
		JLabel clock;
		JPanel buttonPanel;
		JButton startButton;
		JButton homeButton;
		JButton resultButton;
		JButton exitButton;
		//JPanel liveSpeedPanel;
		//JLabel liveSpeedLabel;

		//components and panels of typing window
		JPanel typingWindow ;
		JPanel content;
		JPanel userText;
		JScrollPane contentscroll;
		JScrollPane userTextscroll;
		JTextArea contentarea;
		JTextArea userinputarea;

		

	//this method will create Typing window for user 
		public TypingWindowSection(int screenHeight,int screenWidth)
		{	
			//typingWindowPanel = new JPanel();
			sidePanel = new JPanel();
			timerLabel = new JLabel("Timer");
			clock = new JLabel("05:00");
			buttonPanel = new JPanel();
			startButton = new JButton("START");
			homeButton = new JButton("Home");
			resultButton = new JButton("Result");
			exitButton = new JButton("Exit");
			//liveSpeedPanel = new JPanel();
			//liveSpeedLabel = new JLabel();

			//components and panels of typing window
			typingWindow = new JPanel();
			content = new JPanel();
			userText = new JPanel();
		
			//config both textarea 
			contentarea = new JTextArea(screenHeight/85,screenWidth/70);		//in this typing content is given to user
			userinputarea = new JTextArea(screenHeight/85,screenWidth/70);	//in this user type 
			
			
			
			//config content area 
			contentarea.setEditable(false);
			contentarea.setLineWrap(true);
			contentarea.setMargin(new Insets(15,15,0,5));
			contentarea.setWrapStyleWord(true);
			contentarea.setBackground(new Color(31, 35, 64));
			contentarea.setForeground(Color.WHITE);
			contentarea.setFont (new Font("",Font.BOLD,28));
			contentarea.setCaretPosition(0);
			
				
			
			//config content area
			userinputarea.setLineWrap(true);
			userinputarea.setMargin(new Insets(15,15,0,5));
			userinputarea.setCaretColor(Color.WHITE);
			userinputarea.setWrapStyleWord(true);
			userinputarea.setBackground(new Color(31, 35, 64));
			userinputarea.setForeground(Color.WHITE);
			userinputarea.setFont (new Font("",Font.BOLD,28));

			//adding scroll bar to Jtextarea(contentarea and userinputarea)
			contentscroll= new JScrollPane(contentarea,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			userTextscroll= new JScrollPane(userinputarea,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	

			//config typing window panel
			typingWindow.setLayout(new BorderLayout(10,10));
			typingWindow.setPreferredSize(new Dimension(400,400));
			typingWindow.add(contentscroll,BorderLayout.NORTH);
			typingWindow.add(userTextscroll);
			typingWindow.setBorder(new LineBorder(Color.GREEN,10,true));

			setSidePanel();
			

			//setting up main panel for TypingWindow 
			setBackground(new Color(27,38,44));
			setLayout(new BorderLayout(10,10));
			add(typingWindow,BorderLayout.CENTER);
			add(sidePanel,BorderLayout.EAST);
			
		}

	//this method will set the sidepanel in typing window
		public void setSidePanel()
		{

			//config timer label 
			timerLabel.setForeground(Color.WHITE);
			timerLabel.setFont(new Font("",Font.BOLD,30));	

			//config clock label 
			clock.setForeground(Color.YELLOW);
			clock.setFont(new Font("",Font.BOLD,70));
			
			//creating button panels to contain buttons
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(null);	//setting layout to null for using our own custom layout

					
			/***************  config button ****************/


			homeButton.setBackground(Color.RED);
			homeButton.setForeground(Color.WHITE);
			homeButton.setFont(new Font("",Font.BOLD,30));
			

			startButton.setBackground(Color.RED);
			startButton.setForeground(Color.WHITE);
			startButton.setFont(new Font("",Font.BOLD,30));

			
			exitButton.setBackground(Color.RED);
			exitButton.setForeground(Color.WHITE);
			exitButton.setFont(new Font("",Font.BOLD,30));
			

			//setting up position of buttons 
			startButton.setBounds(70,100,250,60);
			homeButton.setBounds(70,180,250,60);
			exitButton.setBounds(70,260,250,60);

			//sdding button to button panel
			buttonPanel.add(startButton);
			buttonPanel.add(homeButton);
			buttonPanel.add(exitButton);
			buttonPanel.setBackground(Color.BLACK);

			//setting up live Panel 
			/*liveSpeedPanel.setPreferredSize(new Dimension(10,10));
			liveSpeedPanel.setBackground(Color.YELLOW);
			liveSpeedPanel.setLayout(null);
			liveSpeedPanel.add(liveSpeedLabel);
			//liveSpeedLabel.setBounds(30,100,200,40);
			liveSpeedLabel.setFont(new Font("",Font.BOLD,45));
			liveSpeedLabel.setText("Live Speed: 0");
			liveSpeedLabel.setForeground(Color.YELLOW);*/

			//config sidepanel 
			sidePanel.setPreferredSize(new Dimension(400,300));
			sidePanel.setBackground(new Color(27,38,44));
			sidePanel.setLayout(new BoxLayout(sidePanel,BoxLayout.Y_AXIS));
		
			//adding components on sidepanel	
			sidePanel.add(Box.createRigidArea(new Dimension(0,35)));
			sidePanel.add(timerLabel);
			sidePanel.add(Box.createRigidArea(new Dimension(0,35)));
			sidePanel.add(clock);
			sidePanel.add(Box.createRigidArea(new Dimension(50,65)));
			sidePanel.add(buttonPanel);
			//sidePanel.add(Box.createRigidArea(new Dimension(0,150)));
			//sidePanel.add(liveSpeedLabel);
			//sidePanel.add(Box.createRigidArea(new Dimension(20,20)));
			

			//aliging of components
			timerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			clock.setAlignmentX(Component.CENTER_ALIGNMENT);		
			buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
			//liveSpeedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	
						
		}


}

/*****	This Class will create Result Window for SpeedTester 	****/
class ResultWindowSection extends JPanel
{	
	
	//components and panels of result window
		JPanel resultPanel;
		JLabel typingSpeed ;
		JLabel accuracyLabel;
		JLabel grossTypingSpeed;
		JLabel remarks;
		JButton resultToHomeButton;
		JButton resultExitButton;
		JPanel resultButtonPanel;
		


	//this method will create result window
		public ResultWindowSection()
		{	
			//resultWindowPanel = new JPanel();
			resultPanel = new JPanel();
			typingSpeed = new JLabel();
			accuracyLabel = new JLabel();
			grossTypingSpeed = new JLabel();
			remarks = new JLabel();
			resultToHomeButton = new JButton("   Home   ");
			resultExitButton = new JButton("   Exit    ");
			resultButtonPanel = new JPanel();


			//	resultappear = 1;		//this will tell is this method runs ones or not 
				

				/*	config labels for diplaying speed,accuracy and gross speed	*/
				grossTypingSpeed.setForeground(Color.WHITE);
			    grossTypingSpeed.setFont(new Font("",Font.BOLD,50));

			    accuracyLabel.setForeground(Color.WHITE);
			    accuracyLabel.setFont(new Font("",Font.BOLD,50));

			    typingSpeed.setForeground(Color.WHITE);
			    typingSpeed.setFont(new Font("",Font.BOLD,50));


			    //config result to home button
			    resultToHomeButton.setBackground(Color.RED);
			 	resultToHomeButton.setForeground(Color.WHITE);
			 	resultToHomeButton.setFont(new Font("",Font.BOLD,35));
			 	resultToHomeButton.setPreferredSize(new Dimension(300,100));
				

				//config exit button
				resultExitButton.setBackground(Color.RED);
			 	resultExitButton.setForeground(Color.WHITE);
			 	resultExitButton.setFont(new Font("",Font.BOLD,35));
			 	resultExitButton.setPreferredSize(new Dimension(300,100));
				

				//config resilt panel
				resultPanel.setLayout(new BoxLayout(resultPanel,BoxLayout.Y_AXIS));
				resultPanel.setBackground(new Color(31, 35, 64));
				resultPanel.setPreferredSize(new Dimension(1500,350));


				//adding components to result panel
				resultPanel.add(Box.createRigidArea(new Dimension(0,150)));
				resultPanel.add(grossTypingSpeed);
				resultPanel.add(Box.createRigidArea(new Dimension(0,20)));
				resultPanel.add(accuracyLabel);
				resultPanel.add(Box.createRigidArea(new Dimension(0,20)));
				resultPanel.add(typingSpeed);
				resultPanel.add(Box.createRigidArea(new Dimension(0,20)));
				


				grossTypingSpeed.setAlignmentX(Component.CENTER_ALIGNMENT);
				accuracyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
				typingSpeed.setAlignmentX(Component.CENTER_ALIGNMENT);

				//config result button panel
				resultButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,50,10));
				resultButtonPanel.setBackground(new Color(31, 35, 64));
				resultButtonPanel.setPreferredSize(new Dimension(1500,350));
				
				//adding button to result button panel
				resultButtonPanel.add(resultToHomeButton);
				resultButtonPanel.add(resultExitButton);

				

				//setting up main panel to result Panel
				setBackground(new Color(27,38,44));
				setLayout(new BorderLayout(10,10));
				add(resultPanel,BorderLayout.CENTER);
				add(resultButtonPanel,BorderLayout.SOUTH);
				
		}

	
}



/*
    Class To Compare Two seperate String Array Words And Find Matching Words.
*/
class TextCmpAnalyser{

    /* Internal Variables Used For Analysis */

    private String Primary;        // For Primary Array Word
    private String Secondary;      // For Secondary Array Word
    
    // Array Containers
    private String[] PrimaryArray;
    public String[] SecondaryArray;
    
    
    public boolean debug = false; // Debug Conditions To Control Ouptput
    
    // Store Words
    public List<String> JumpWords = new ArrayList<String>();
    public List<String> MatchedWords = new ArrayList<String>();

    public int primary_matched = 0;   // Matched Word Counter
    private int sliding_motion = 1;    // Pointer Sliding Position Motion Record
    private int secondary_sliding = 0; // Secondary Array Sliding Position Offset
    private int primary_jump = 0;      // Primary Array Jump Offset
    private int secondary_jump = 0;    // Secondary Array Jump Offset
    private int counter = 0;           // Algorithm Run Cycle Counter
    private int breaker = 0;           // Breaker Counter
    public int breakerlimit = 2000;   // Emergency Cycle Run Processing Cutout
    public int secondary_forward_range = 3; // Search Range
    

    //simple constructor
    TextCmpAnalyser()
    {

    }
    // Contructor With Array Argument
    TextCmpAnalyser(String[] array_one, String[] array_two){
    
    
        loadArray(array_one, array_two);
    }
    
    // Contructor With String Argument
    TextCmpAnalyser(String string_one, String string_two){
        String[] tmp1 = string_one.split(" "); 
        String[] tmp2 = string_two.split(" "); 
    
        loadArray(tmp1, tmp2);
    }
    
    
    public void loadArray(String[] array_one, String[] array_two){   
    
        if(array_one.length <= array_two.length){
            
            PrimaryArray = array_two;
            SecondaryArray = array_one;
        }
        else{
        
            SecondaryArray = array_two;
            PrimaryArray = array_one;
        }
        
        if(debug){
            System.out.println(String.format("Primary Array Length : %d Secondary Array Length : %d", PrimaryArray.length, SecondaryArray.length));
        }
        
        processText();
    }
    
    // Process Text
    private void processText(){
     
        // Range Start
        for(int pointer = 0; pointer< PrimaryArray.length; pointer++){
        
            breaker++;
            
            // Get Word From Primary
            if( pointer + primary_jump < PrimaryArray.length ){

                // Take Word 
                Primary = PrimaryArray[ pointer + primary_jump];

            }else{

                Primary = "";
                pointer += PrimaryArray.length;

            }

            // Get Word From Secondary Array 
            if( pointer + secondary_sliding + secondary_jump < SecondaryArray.length ){

                Secondary = SecondaryArray[ pointer + secondary_sliding + secondary_jump ];

            }else{

                Secondary = "";
            }

            if(debug){
            
                System.out.println(String.format(" >%s< cmp >%s<", Primary, Secondary));
                
            }
            counter++;


            // If Primary And Secondary Word Matched 
            if( Primary.equals(Secondary)){

                if(Primary!=""){
                                primary_matched++;
                                MatchedWords.add(Primary);

                }

                if(debug){

                        System.out.println(String.format("Matched %s - %s, Sliding : %d, Primary Jump : %d, secondary Jump : %d , Motion %d,  I : %d", 
                                                             Primary, 
                                                             Secondary,
                                                             secondary_sliding,
                                                            primary_jump,
                                                          secondary_jump,
                                                            sliding_motion,
                                                             pointer
                                                            ));

                }
                secondary_jump += secondary_sliding;
                secondary_sliding = 0;
        
                }
                else{
                    // If Word Not Matched Then, Sliding Routine Start 
                    if( secondary_sliding < secondary_forward_range && sliding_motion == 1 ){
                        secondary_sliding++;

                    }else if( secondary_sliding >= secondary_forward_range && sliding_motion != 0){
                        sliding_motion = 0;
                        secondary_sliding = 0;

                    }
                    else{
                        sliding_motion = 1;
                        primary_jump++;
                        JumpWords.add(Primary);
                        
                        if(debug){
                        
                            System.out.println(String.format("ELSE %s - %s, Sliding : %d, Jump : %d , Motion %d,  I : %d", 
                                                             Primary, 
                                                             Secondary,
                                                             secondary_sliding,
                                                            primary_jump,
                                                            sliding_motion,
                                                             pointer
                                                            ));
                        }
                    }
                   pointer--;       

                }
           if(breaker>breakerlimit){
                    System.out.println("Emergency Break Cutout");
                    break;

                }
        }
    }
        
    public void fullreport(){
    
        // Call Report
        report();
        
        System.out.println("[+] Un-matched words from primary array.");
        
        // Iterate All Items and Print 
        for(String x:JumpWords){
            System.out.println(x);
        }


        System.out.println("[+] matched words from primary array.");

        // Iterate All Items And print 
        for(String x:MatchedWords){
            System.out.println(x);
        }

    }
    
    
    // Print Useful Variable Report
    public void report(){
    
        System.out.println(String.format("[+] Word Matched ................> %d", primary_matched));
        System.out.println(String.format("[+] Cycle Counter ...............> %d", counter));
        System.out.println(String.format("[+] Primary Jump ................> %d", primary_jump));
        System.out.println(String.format("[+] Primary Array Length ........> %d", PrimaryArray.length));
        System.out.println(String.format("[+] Secondary Array Length ......> %d", SecondaryArray.length));
        System.out.println(String.format("[+] Search Around Range .........> %d", secondary_forward_range));
    
    }
   

}

//main class
class SpeedTester extends JFrame implements ActionListener, DocumentListener
{
	
		//Declaring Objects of classes 
		HomeWindowSection homeWindowObject; 
		TypingWindowSection typingWindowObject;
		ResultWindowSection resultWindowObject;
		TextCmpAnalyser textAnalyserObj;


		/*============ Declaring important variable ====================*/


		Timer countdown;		//for display time 
		
		//below panels are used as border of main panel
		JPanel TopPanel = new JPanel();	
		JPanel BottomPanel = new JPanel();
		JPanel LeftPanel = new JPanel();
		JPanel RightPanel = new JPanel();

		//header and footer of panels
		JLabel header = new JLabel("Check Your Typing Speed");
		JLabel footer = new JLabel("© 2019 BlareGroup ");
		
		//this is main panel which contains homeWindowPanel,TypingWindowPanel,resultWindowPanel 
		JPanel mainPanel = new JPanel();

		

		//useful variable to do important operations 
		public	int StartButtonStatus=0;		//give the status of start button pressed or not
		public	int timerstatus=0;				//give the status of timer is running or not
		public	int appearones=0;				//give the status of typing window appears ones or not
		public	int resultappear=0;				//give the status of result window appears ones or not

		public	int getMinute;					//contains user selected minute
		public	int getSecond;					//contains user selected second
		public	String userTime="";				//contains user selected time

		//important variables for calculating speed,accuracy and gross speed
		public	int speed=0;					//contains typing speed
		public	int grossSpeed=0;				//contains gross speed
		public	int accuracy=0;					//contains accuracy
		public	int wrongWords=0;				//contains wrong word entered by user
		
		public boolean isTimerRunning = false;	//this will tell eighter timer is running or not 


	/*==========	End of variable declaration ================*/

	//contructor of main class	
	SpeedTester()
	{
		super("SpeedTester");			//setting title of JFrame
		 try { 
  
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); 
        } 
        catch (Exception e) { 
            System.out.println("Look and Feel not set"); 
        } 
		//config JFrame
		setSize(1800,1000);
		getContentPane().setBackground(Color.black);	 
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//initialize object for creating window section
		homeWindowObject = new HomeWindowSection();
		typingWindowObject = new TypingWindowSection(this.getHeight(),this.getWidth());  //this will pass the height & width of JFrame
		resultWindowObject = new ResultWindowSection();
		textAnalyserObj  = new TextCmpAnalyser();
		
		
		/********  config panels mainly used as a border or better look	*******/
	
		//Config Top Panel
		TopPanel.setBackground(new Color(15,76,117));
		TopPanel.setPreferredSize(new Dimension(50,50));
		
		//Config Right Panel
		RightPanel.setBackground(new Color(15,76,117));
		RightPanel.setPreferredSize(new Dimension(50,50));
		
		//Config Left Panel
		LeftPanel.setBackground(new Color(15,76,117));
		LeftPanel.setPreferredSize(new Dimension(50,50));
		
		//Config Bottom Panel
		BottomPanel.setBackground(new Color(15,76,117));
		BottomPanel.setPreferredSize(new Dimension(50,50));

		header.setForeground(Color.white);
		header.setFont(new Font("",Font.BOLD,30));

		footer.setForeground(Color.white);
		footer.setFont(new Font("",Font.BOLD,30));		

		//Adding header and footer to Top and Bottom Panel
		TopPanel.add(header);
		BottomPanel.add(footer);
	
		//config main panel
		mainPanel.setBackground(new Color(27,38,44));
		mainPanel.setBorder(new LineBorder(new Color(187,225,250),10,true));
		mainPanel.setLayout(new BorderLayout());
		 
		mainPanel.add(homeWindowObject,BorderLayout.CENTER);
	
	
			

		//adding components to JFrame
		add(mainPanel,BorderLayout.CENTER);
		add(TopPanel,BorderLayout.NORTH);
		add(BottomPanel,BorderLayout.SOUTH);
		add(RightPanel,BorderLayout.EAST);
		add(LeftPanel,BorderLayout.WEST);

		
		//adding listerers to buttons
		homeWindowObject.startTestButton.addActionListener(this);
		typingWindowObject.startButton.addActionListener(this);
		typingWindowObject.exitButton.addActionListener(this);
		typingWindowObject.homeButton.addActionListener(this);
		resultWindowObject.resultToHomeButton.addActionListener(this);
		resultWindowObject.resultExitButton.addActionListener(this);
		typingWindowObject.userinputarea.getDocument().addDocumentListener(this);
		
	
		setVisible(true);

	}


	//document listener (they are used to start the timer when user directly start typing without pressing start button)
	public void changedUpdate(DocumentEvent documentEvent) {
		// System.out.println("Document Change Update");
			
		};

	public void removeUpdate(DocumentEvent documentEvent) {
		// System.out.println("remove Update");
			
		};

	public void insertUpdate(DocumentEvent documentEvent) {
			
			if(isTimerRunning == false)
			{
				typingWindowObject.startButton.doClick();
				StartButtonStatus = 1;
				
			}
			else
			{

			}
			
		};


	//performinng action of each button
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==homeWindowObject.startTestButton)
		{	
			
			
			//gets the user seleted time duration
			userTime = homeWindowObject.durationbuttongroup.getSelection().getActionCommand();	
			
			//seperating and converting time 
			if(userTime.charAt(0)=='0'){
				
				getMinute = Character.getNumericValue(userTime.charAt(1));

			}
			else
			{
				getMinute = Integer.parseInt(userTime.substring(0,2));

			}
			getSecond = Character.getNumericValue(userTime.charAt(3));

			/*****loading typing window by removing home window******/

			mainPanel.remove(homeWindowObject);			
			
			mainPanel.add(typingWindowObject);
			
			//initializing component at runtime
			typingWindowObject.clock.setText(userTime);
			typingWindowObject.contentarea.setText(getContent());  //sending seleted content for type
			typingWindowObject.contentarea.setCaretPosition(0);
			typingWindowObject.userinputarea.setText("");
			StartButtonStatus=0;
			typingWindowObject.startButton.setText("Start");
		
			 
			 revalidateJframe();

		}
		else if(e.getSource()==typingWindowObject.startButton)
		{
			
				if(StartButtonStatus==0)
			    {	
			    	getTimer(getMinute,getSecond);		//starting timer
			    	typingWindowObject.startButton.setText("Re-Start");	//change text of startbutton to restart

			    	StartButtonStatus=1;
			    	isTimerRunning = true;
			    }
			    else{
			    	countdown.stop();					//stoping timer
			    	typingWindowObject.startButton.setText("Start");		//change text of startbutton to start
			    	typingWindowObject.clock.setText(userTime);			//reload time
			    	typingWindowObject.userinputarea.setText("");			//make Jtextarea empty
			    	isTimerRunning = false;
			    	StartButtonStatus=0;		
			    }		
			

		}
		else if(e.getSource()==typingWindowObject.exitButton)
		{	
			System.exit(0);
		}
		else if(e.getSource()==typingWindowObject.homeButton)
		{
			countdown.stop();
	    	
			mainPanel.remove(typingWindowObject);
			mainPanel.add(homeWindowObject); 
			
			revalidateJframe();
		}
		else if(e.getSource()==resultWindowObject.resultExitButton)
		{
			System.exit(0);			
		}
		else if(e.getSource()==resultWindowObject.resultToHomeButton)
		{	
			//reload home window form result window
			mainPanel.remove(resultWindowObject);
			mainPanel.add(homeWindowObject);

			revalidateJframe();
		
			
			
		}
		
	}

	
	//this method will handle the timer
		public void getTimer(int takeminute,int takesecond)
		{
			timerstatus = 1;
			countdown = new Timer(1000,new ActionListener(){

			int minute=takeminute;  //minute 
			int second=takesecond;	//second

				public void actionPerformed(ActionEvent e)
				{

					if(second==0 && minute>=1){
						minute--;
						second=60;
						
					}
					else{
							if(minute==0 && second==0)
						 	{	
						 		//setting result window on completing time
						 		
						 		mainPanel.remove(typingWindowObject);
						 		textAnalyserObj = new TextCmpAnalyser(typingWindowObject.userinputarea.getText(),typingWindowObject.contentarea.getText());
						 		calculation(typingWindowObject.userinputarea,typingWindowObject.contentarea);
						 		mainPanel.add(resultWindowObject);
						 		//textanalyser.fullreport();
								revalidate();
								repaint(); 

						 		countdown.stop();	//timer stop
						 		isTimerRunning=false;
						 		
							}
						}

					second--;	
					
					
					String stringMinute=Integer.toString(minute);
					String stringSecond = Integer.toString(second);
					
					if(second<10){stringSecond="0"+stringSecond;}
					if(minute<10){stringMinute="0"+stringMinute;}
						
					 //String liveSpeed = Integer.toString((typingWindowObject./((takeminute-minute)+(60-second))));

					//change time of clock label
					String timechange =String.format("%s:%s",stringMinute,stringSecond);
							
					
					typingWindowObject.clock.setText(timechange);		//setting text of clock lable at each second
					//typingWindowObject.liveSpeedLabel.setText(" Live Speed : "+liveSpeed);
				}

			});

			countdown.start();
		}

	//get seleted content in content textarea
		public String getContent()
		{
			String typingContent = "";
				
				try{
					

					typingContent = new String(Files.readAllBytes( Paths.get("./TypingContent/"+homeWindowObject.contentList.getSelectedValue()+".txt")));
				}
				catch(Exception error){
					System.out.println(error);
					error.printStackTrace();
				}

			return typingContent;
		}

	

	//this method will calculate speed,accuracy and gross speed
		public void calculation(JTextArea userinputarea,JTextArea contentarea)
		{
			//taking content of of both textarea in string
			String userinputText = userinputarea.getText();		//user typed content
			String typingText = contentarea.getText();			//typing content 

			//eliminating new lines and extra spaces added by user
			userinputText=userinputText.replaceAll("\\s+"," ");
			userinputText=userinputText.replaceAll("\n","");
			typingText = typingText.replaceAll("\n","");

			//seperating each word from string 
			String[] userwords = userinputText.split("\\s");
			String[] inputwords = typingText.split("\\s");

			//calculating speed 
			speed = userwords.length/getMinute;


			//calculating wrong words entered by user
			for(int i=0;i<userwords.length;i++)
			{
				if(inputwords[i].compareTo(userwords[i])!=0)
					wrongWords++;

			}

			//calculating accuracy
			accuracy = (((textAnalyserObj.primary_matched)*100)/textAnalyserObj.SecondaryArray.length);
			if(accuracy<0){accuracy=0;}

			//calculating gross speed
			grossSpeed = (textAnalyserObj.primary_matched)/getMinute;

			//setting up result in result window
			resultWindowObject.typingSpeed.setText("Typing Speed = " + speed);
			resultWindowObject.grossTypingSpeed.setText("Gross Typing Speed = "+ grossSpeed);
			resultWindowObject.accuracyLabel.setText("Accuracy = " + accuracy + "%");
			
			

		}

	//for revalidating Jframe when we transfer from one window section to another
	public void revalidateJframe()
	{
		revalidate();
		repaint();

	}

	//main method
		public static void main(String []args)
		{	
			SpeedTester obj = new SpeedTester();

		}


}
