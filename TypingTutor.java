/*

	Author
			Himanshu Sharma
			himanshusharma2972@gmail.com
			www.blaregroup.com
	
	

	===============================================================
				Typing Tutor - A Typing instructor
	===============================================================


	About 
			This is a simple Typing Tutor which helps you to check you typing speed and accuracy.
			It also help you to increase your typing speed.

	uses
			To use this tool you computer system must contain Java. 
			For using Typing Tutor simply compile TypingTutor.java and then run TypingTutor

			commands:- 1) javac TypingTutor.java
					   2) java TypingTutor
		

*/


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



//main class
class TypingTutor extends JFrame implements ActionListener
{


	/*============ Declaring important variable ====================*/


		Timer countdown;		//for display time 
		
		//below panels are used as border of main panel
		JPanel TopPanel = new JPanel();	
		JPanel BottomPanel = new JPanel();
		JPanel LeftPanel = new JPanel();
		JPanel RightPanel = new JPanel();

		//header and footer of panels
		JLabel header = new JLabel("TYPING TUTOR");
		JLabel footer = new JLabel("Check your Typing Speed");
		
		//this is main panel which contains all other panels and components
		JPanel mainPanel = new JPanel();

		//components and panels of home window
		JPanel homePanel = new JPanel();
		JPanel ContentListPanel = new JPanel();
		JPanel listPanel = new JPanel();
		JPanel DurationListPanel = new JPanel();
		JLabel contentListHeader = new JLabel("Select Content Type");
		JList<String> contentList;
		JLabel durationLabel = new JLabel("Select Duration");
		JButton startTestButton = new JButton("    Start Test    ");
		JRadioButton twominute = new JRadioButton("02:00");
		JRadioButton fiveminute = new JRadioButton("05:00");
		JRadioButton tenminute = new JRadioButton("10:00");
		JRadioButton thirtyminute = new JRadioButton("30:00");
		ButtonGroup durationbuttongroup = new ButtonGroup();
		JScrollPane scrollcontentList;

		
		//components and panels of sidepanel in typing window
		JPanel sidePanel = new JPanel();
		JLabel timerLabel = new JLabel("Timer");
		JLabel clock = new JLabel("05:00");
		JPanel buttonPanel = new JPanel();
		JButton startButton = new JButton("START");
		JButton homeButton = new JButton("Home");
		JButton resultButton = new JButton("Result");
		JButton exitButton = new JButton("Exit");

		//components and panels of typing window
		JPanel typingWindow = new JPanel();
		JPanel content = new JPanel();
		JPanel userText = new JPanel();
		JScrollPane contentscroll;
		JScrollPane userTextscroll;
		JTextArea contentarea;
		JTextArea userinputarea;

		//components and panels of result window
		JPanel resultPanel = new JPanel();
		JLabel typingSpeed = new JLabel();
		JLabel accuracyLabel = new JLabel();
		JLabel grossTypingSpeed = new JLabel();
		JLabel remarks = new JLabel();
		JButton resultToHomeButton = new JButton("   Home   ");
		JButton resultExitButton = new JButton("   Exit    ");
		JPanel resultButtonPanel = new JPanel();



		//useful variable to do important operations 
		int StartButtonStatus=0;		//give the status of start button pressed or not
		int timerstatus=0;				//give the status of timer is running or not
		int appearones=0;				//give the status of typing window appears ones or not
		int resultappear=0;				//give the status of result window appears ones or not

		int getMinute;					//contains user selected minute
		int getSecond;					//contains user selected second
		String userTime="";				//contains user selected time

		//important variables for calculating speed,accuracy and gross speed
		int speed=0;					//contains typing speed
		int grossSpeed=0;				//contains gross speed
		int accuracy=0;					//contains accuracy
		int wrongWords=0;				//contains wrong word entered by user
		

	/*==========	End of variable declaration ================*/

	//contructor of main class	
	TypingTutor()
	{
		super("Typing Tutor");			//setting title of JFrame
			
		//config JFrame
		setSize(1800,1000);
		getContentPane().setBackground(Color.black);	 
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			
		/********  config panels mainly used as a border or better look	*******/
	
		//Config Top Panel
		TopPanel.setBackground(Color.BLUE);
		TopPanel.setPreferredSize(new Dimension(50,50));
		
		//Config Right Panel
		RightPanel.setBackground(Color.BLUE);
		RightPanel.setPreferredSize(new Dimension(50,50));
		
		//Config Left Panel
		LeftPanel.setBackground(Color.BLUE);
		LeftPanel.setPreferredSize(new Dimension(50,50));
		
		//Config Bottom Panel
		BottomPanel.setBackground(Color.BLUE);
		BottomPanel.setPreferredSize(new Dimension(50,50));

		header.setForeground(Color.white);
		header.setFont(new Font("",Font.BOLD,30));

		footer.setForeground(Color.white);
		footer.setFont(new Font("",Font.BOLD,30));		

		//Adding header and footer to Top and Bottom Panel
		TopPanel.add(header);
		BottomPanel.add(footer);
	
		//config main panel
		mainPanel.setBackground(new Color(31, 35, 64));
		mainPanel.setBorder(new LineBorder(Color.YELLOW,10,true));

		//adding components to JFrame
		add(mainPanel,BorderLayout.CENTER);
		add(TopPanel,BorderLayout.NORTH);
		add(BottomPanel,BorderLayout.SOUTH);
		add(RightPanel,BorderLayout.EAST);
		add(LeftPanel,BorderLayout.WEST);

		//initializing JFrame window by creating home window
		setHomeWindow();		//this method will create home window

	
		setVisible(true);

	}

	//this method will create home window
	public void setHomeWindow()
	{
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
		startTestButton.addActionListener(this);


		
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

		//setting up main panel for home window
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		mainPanel.add(Box.createRigidArea(new Dimension(0,5)));
		mainPanel.add(ContentListPanel);
		mainPanel.add(Box.createRigidArea(new Dimension(0,5)));
		mainPanel.add(DurationListPanel);
		mainPanel.add(Box.createRigidArea(new Dimension(100,5)));
		mainPanel.add(startTestButton);
		mainPanel.add(Box.createRigidArea(new Dimension(0,30)));

		//Config Alignment of components on main panel
		ContentListPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		DurationListPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		startTestButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
	}

	//this method will create Typing window for user 
	public void setTypingWindow()
	{
		
		appearones=1;		//this will tell is this method runs ones or not 
		
		
		//config both textarea 
		contentarea = new JTextArea(getHeight()/85,getWidth()/70);		//in this typing content is given to user
		userinputarea = new JTextArea(getHeight()/85,getWidth()/70);	//in this user type 
		
		
		
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

		contentarea.setText(getContent());  //sending seleted content for type
		contentarea.setCaretPosition(0);	//setting scroll bar to top
		clock.setText(userTime);			//setting text on clock label
		//setting up main panel
		mainPanel.setLayout(new BorderLayout(10,10));
		mainPanel.add(typingWindow,BorderLayout.CENTER);
		mainPanel.add(sidePanel,BorderLayout.EAST);

		
		
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
		startButton.setBounds(70,10,250,60);
		homeButton.setBounds(70,90,250,60);
		exitButton.setBounds(70,170,250,60);

		//sdding button to button panel
		buttonPanel.add(startButton);
		buttonPanel.add(homeButton);
		buttonPanel.add(exitButton);
		buttonPanel.setBackground(Color.BLACK);


		//config sidepanel 
		sidePanel.setPreferredSize(new Dimension(400,300));
		sidePanel.setBackground(Color.BLUE);
		sidePanel.setLayout(new BoxLayout(sidePanel,BoxLayout.Y_AXIS));
	
		//adding components on sidepanel	
		sidePanel.add(Box.createRigidArea(new Dimension(0,25)));
		sidePanel.add(timerLabel);
		sidePanel.add(Box.createRigidArea(new Dimension(0,25)));
		sidePanel.add(clock);
		sidePanel.add(Box.createRigidArea(new Dimension(00,65)));
		sidePanel.add(buttonPanel);
		

		//aliging of components
		timerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		clock.setAlignmentX(Component.CENTER_ALIGNMENT);		
		buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
	
		//adding listerers to buttons
		startButton.addActionListener(this);
		exitButton.addActionListener(this);
		homeButton.addActionListener(this);
					
	}

	

	//this method will create result window
	public void setResultWindow()
	{
			resultappear = 1;		//this will tell is this method runs ones or not 
			

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
			resultToHomeButton.addActionListener(this);

			//config exit button
			resultExitButton.setBackground(Color.RED);
		 	resultExitButton.setForeground(Color.WHITE);
		 	resultExitButton.setFont(new Font("",Font.BOLD,35));
		 	resultExitButton.setPreferredSize(new Dimension(300,100));
			resultExitButton.addActionListener(this);

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


			//setting main panel for result window
			mainPanel.add(resultPanel,BorderLayout.CENTER);
			mainPanel.add(resultButtonPanel,BorderLayout.SOUTH);

	}

	//this method will calculate speed,accuracy and gross speed
	public void calculation()
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
		accuracy = (((userwords.length-wrongWords)*100)/userwords.length);
		if(accuracy<0){accuracy=0;}

		//calculating gross speed
		grossSpeed = (userwords.length-wrongWords)/getMinute;

		//setting up result in result window
		grossTypingSpeed.setText("Gross Typing Speed = "+ grossSpeed);
		accuracyLabel.setText("Accuracy = " + accuracy + "%");
		typingSpeed.setText("Typing Speed = " + speed);

	}
	


	//performinng action of each button
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==startButton)
		{
			if(StartButtonStatus==0)
			    {	
			    	getTimer(getMinute,getSecond);		//starting timer
			    	startButton.setText("Re-Start");	//change text of startbutton to restart

			    	StartButtonStatus=1;
			    }
			    else{
			    	countdown.stop();					//stoping timer
			    	startButton.setText("Start");		//change text of startbutton to start
			    	clock.setText(userTime);			//reload time
			    	userinputarea.setText("");			//make Jtextarea empty
			    	StartButtonStatus=0;		
			    }		

		}
		else if(e.getSource()==exitButton)
		{	
			System.exit(0);								//exit window
		}
		else if(e.getSource()==homeButton)
		{
						
			reloadHomewindow();							//reloading home window 
			revalidate();
			repaint();
		}
		else if(e.getSource()==resultExitButton)
		{
				System.exit(0);							//exit window
		}
		else if(e.getSource()==resultToHomeButton)
		{
			//reload home window form result window
			mainPanel.remove(resultPanel);
			mainPanel.remove(resultButtonPanel);
			mainPanel.add(Box.createRigidArea(new Dimension(0,5)));
			mainPanel.add(ContentListPanel);
			mainPanel.add(Box.createRigidArea(new Dimension(0,5)));
			mainPanel.add(DurationListPanel);
			mainPanel.add(Box.createRigidArea(new Dimension(100,5)));
			mainPanel.add(startTestButton);
			mainPanel.add(Box.createRigidArea(new Dimension(0,30)));
			revalidate();
			repaint();
		}
		else if(e.getSource()==startTestButton)
		{	
			//gets the user seleted time duration
			userTime = durationbuttongroup.getSelection().getActionCommand();	
			
			//seperating and converting time 
			if(userTime.charAt(0)=='0'){
				
				getMinute = Character.getNumericValue(userTime.charAt(1));

			}
			else
			{
				getMinute = Integer.parseInt(userTime.substring(0,2));

			}
			getSecond = Character.getNumericValue(userTime.charAt(3));

					
			//loading typing window by removing home window
			if(appearones==0)
			{
				mainPanel.remove(ContentListPanel);
				mainPanel.remove(DurationListPanel);
				mainPanel.remove(startTestButton);

				setTypingWindow();					//setting typing window
				
				setSidePanel();						//setting sidepanel
				
			}
			else{
				reloadTypingwindow();				//reaload typing after it appers ones
			}
			
			revalidate();
			repaint();
		}
	}

	//realoding home window
	public void reloadHomewindow()
	{
		mainPanel.remove(typingWindow);
		mainPanel.remove(sidePanel);

		mainPanel.add(Box.createRigidArea(new Dimension(0,5)));
		mainPanel.add(ContentListPanel);
		mainPanel.add(Box.createRigidArea(new Dimension(0,5)));
		mainPanel.add(DurationListPanel);
		mainPanel.add(Box.createRigidArea(new Dimension(100,5)));
		mainPanel.add(startTestButton);
		mainPanel.add(Box.createRigidArea(new Dimension(0,30)));
	
		if(timerstatus==1){		
			countdown.stop();
	    	startButton.setText("Start");
	    	clock.setText(userTime);
	    	userinputarea.setText("");
	    	StartButtonStatus=0;
		}

		revalidate();
		repaint();

	}

	//reloading typing window
	public void reloadTypingwindow()
	{
		mainPanel.remove(ContentListPanel);
		mainPanel.remove(DurationListPanel);
		mainPanel.remove(startTestButton);
		
		mainPanel.add(typingWindow,BorderLayout.CENTER);
		mainPanel.add(sidePanel,BorderLayout.EAST);
		clock.setText(userTime);
		contentarea.setText(getContent());  //sending seleted content for type
		contentarea.setCaretPosition(0);

		revalidate();
		repaint();

	}

	//reloading result window
	public void reloadResultWindow()
	{
		mainPanel.remove(typingWindow);
		mainPanel.remove(sidePanel);

		resultPanel.add(Box.createRigidArea(new Dimension(0,5)));
		resultPanel.add(grossTypingSpeed);
		resultPanel.add(Box.createRigidArea(new Dimension(0,5)));
		resultPanel.add(accuracyLabel);
		resultPanel.add(Box.createRigidArea(new Dimension(0,5)));
		resultPanel.add(typingSpeed);
		resultPanel.add(Box.createRigidArea(new Dimension(0,5)));

		resultButtonPanel.add(resultToHomeButton);
		resultButtonPanel.add(resultExitButton);


			
		mainPanel.add(resultPanel,BorderLayout.CENTER);
		
		mainPanel.add(resultButtonPanel,BorderLayout.SOUTH);


		revalidate();
		repaint();

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
					 		if(resultappear == 0)
							{
								mainPanel.remove(typingWindow);
								mainPanel.remove(sidePanel);
								
								calculation();
								setResultWindow();
								startButton.setText("Start");
								userinputarea.setText("");
			    				StartButtonStatus=0;
							}
							else
							{	
								
								calculation();
								reloadResultWindow();
								startButton.setText("Start");
								userinputarea.setText("");
			    				StartButtonStatus=0;
							}

							revalidate();
							repaint(); 

					 		countdown.stop();	//timer stop
					 		
						}
					}

				second--;	
				
				
				String stringMinute=Integer.toString(minute);
				String stringSecond = Integer.toString(second);
				
				if(second<10){stringSecond="0"+stringSecond;}
				if(minute<10){stringMinute="0"+stringMinute;}
				

				//change time of clock label
				String timechange =String.format("%s:%s",stringMinute,stringSecond);
						
				
				clock.setText(timechange);		//setting text of clock lable at each second
			}

		});

		countdown.start();
	}



	//get seleted content in content textarea
	public String getContent()
	{
		String typingContent = "";
			
			try{
				

				typingContent = new String(Files.readAllBytes( Paths.get("./TypingContent/"+contentList.getSelectedValue()+".txt")));
			}
			catch(Exception error){
				System.out.println(error);
				error.printStackTrace();
			}

		return typingContent;
	}

	//main method
	public static void main(String []args)
	{	
		TypingTutor obj = new TypingTutor();

	}


}
