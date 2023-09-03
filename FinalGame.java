//Name: Kanav Kaura
//Date: May 28,2018
//Purpose: To create a Harry Potter themed connect four

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;

public class FinalGame extends Applet implements ActionListener
{

    JLabel turnpic;
    int turn = 1;

    Panel p_card;  //to hold all of the screens
    Panel card1, card2, card3, card4, card5; //the two screens
    CardLayout cdLayout = new CardLayout ();

    //grid
    int row = 6;
    int col = 7;
    JButton a[] = new JButton [row * col];
    int b[] [] = {{0, 0, 0, 0, 0, 0, 0},
	    {0, 0, 0, 0, 0, 0, 0},
	    {0, 0, 0, 0, 0, 0, 0},
	    {0, 0, 0, 0, 0, 0, 0},
	    {0, 0, 0, 0, 0, 0, 0},
	    {0, 0, 0, 0, 0, 0, 0}};

    int r[] [] = {{0, 0, 0, 0, 0, 0, 0},
	    {0, 0, 0, 0, 0, 0, 0},
	    {0, 0, 0, 0, 0, 0, 0},
	    {0, 0, 0, 0, 0, 0, 0},
	    {0, 0, 0, 0, 0, 0, 0},
	    {0, 0, 0, 0, 0, 0, 0}};

    public void init ()
    {
	p_card = new Panel ();
	p_card.setLayout (cdLayout);
	screen1 ();
	screen2 ();
	screen3 ();
	screen4 ();
	screen5 ();
	resize (800, 650);
	setLayout (new BorderLayout ());
	add ("Center", p_card);
	
	setLayout (new BorderLayout ());
	initMenu ();
	add ("Center", p_card);
    }

    public void initMenu ()
    {
	JMenuBar menuBar = new JMenuBar ();
	JMenu menu;
	JMenuItem menuItem;
	menu = new JMenu ("File");
	menuBar.add (menu);
	menuItem = new JMenuItem ("Close");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("s6");
	menu.add (menuItem);
	menu = new JMenu ("Navigate");
	menuBar.add (menu);
	menuItem = new JMenuItem ("Instructions");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("s2");
	menu.add (menuItem);
     
	menuItem = new JMenuItem ("Play Game");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("s3");
	menu.add (menuItem);
	add ("North", menuBar);
    }

    

    public void screen1 ()
    { //screen 1 is set up.
	card1 = new Panel ();
	card1.setBackground (Color.black);
	JLabel title = new JLabel ("Welcome");
	JLabel tennis = new JLabel (createImageIcon ("tennis.png"));
	JButton next = new JButton ("Next");
	next.setActionCommand ("s2");
	next.addActionListener (this);
	card1.add (title);
	card1.add (tennis);
	card1.add (next);
	p_card.add ("1", card1);
    }



    public void screen2 ()
    { //screen 2 is set up.
	card2 = new Panel ();
	card2.setBackground (Color.black);
	JLabel title = new JLabel ("Instructions");
	JLabel instrument = new JLabel (createImageIcon ("instrument.png"));
	JButton next = new JButton ("Next");
	next.setActionCommand ("s3");
	next.addActionListener (this);
	card2.add (title);
	card2.add (instrument);
	card2.add (next);
	p_card.add ("2", card2);
    }


    public void screen3 ()
    { //screen 3 is set up.
	Panel top = new Panel ();

	JButton intstruct = new JButton ("Instructions");
	intstruct.setBackground (Color.black);
	intstruct.setForeground (Color.white);
	intstruct.addActionListener (this);
	intstruct.setActionCommand ("s2");
	top.add (intstruct);
	


	JLabel save = new JLabel ("Turn:");
	save.setForeground (Color.white);
	top.add (save);
	turnpic = new JLabel (createImageIcon ("1t.png"));
	top.add (turnpic);


	JButton score = new JButton ("High Score");
	score.setBackground (Color.black);
	score.setForeground (Color.white);
	score.addActionListener (this);
	score.setActionCommand ("score");
	top.add (score);


	JButton undo = new JButton ("Undo/Redo");
	undo.setBackground (Color.black);
	undo.setForeground (Color.white);
	undo.addActionListener (this);
	undo.setActionCommand ("undo");
	top.add (undo);

	JButton help = new JButton ("help");
	help.setBackground (Color.black);
	help.setForeground (Color.white);
	help.addActionListener (this);
	help.setActionCommand ("help");
	top.add (help);


	JButton reset = new JButton ("Reset");
	reset.setBackground (Color.black);
	reset.setForeground (Color.white);
	reset.addActionListener (this);
	reset.setActionCommand ("reset");
	top.add (reset);


	JButton newb = new JButton ("New");
	newb.setBackground (Color.black);
	newb.setForeground (Color.white);
	newb.addActionListener (this);
	newb.setActionCommand ("newb");
	top.add (newb);


	JButton strat = new JButton ("Strategies");
	strat.setBackground (Color.black);
	strat.setForeground (Color.white);
	strat.addActionListener (this);
	strat.setActionCommand ("strat");
	top.add (strat);

	JButton info = new JButton ("Turn Info");
	info.setBackground (Color.black);
	info.setForeground (Color.white);
	info.addActionListener (this);
	info.setActionCommand ("info");
	add (info);

	JButton swins = new JButton ("Slytherin Wins:");
	swins.setBackground (Color.black);
	swins.setForeground (Color.white);
	swins.addActionListener (this);
	swins.setActionCommand ("swins");
	add (swins);

	JButton quit = new JButton ("Quit");
	quit.setBackground (Color.black);
	quit.setForeground (Color.white);
	quit.addActionListener (this);
	quit.setActionCommand ("quit");
	top.add (quit);





	card3 = new Panel ();
	card3.setBackground (Color.black);
	JLabel title = new JLabel ("Game");
	JButton next = new JButton ("Next");
	next.setActionCommand ("s4");
	next.addActionListener (this);

	//Set up grid
	Panel p = new Panel (new GridLayout (row, col));
	int move = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    { //take out when you've got pictures
		// a [move] = new JButton ("");
		//add in when you have pictures
		a [move] = new JButton (createImageIcon (b [i] [j] + ".png"));
		a [move].setPreferredSize (new Dimension (100, 100));
		a [move].addActionListener (this);
		a [move].setActionCommand ("" + move);
		p.add (a [move]);
		move++;
	    }
	}
	card3.add (top);

	card3.add (p);
	// card3.add (next);
	p_card.add ("3", card3);
    }


    public boolean horizontalwin ()
    {
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col - 3 ; j++)
	    {
		if (b [i] [j] != 0 && b [i] [j] == b [i] [j + 1] && b [i] [j] == b [i] [j + 2] && b [i] [j] == b [i] [j + 3])
		{
		    if (b [i] [j] == 1)
			showStatus ("Gryffindor Wins");
		    else
			showStatus ("Slytherin Wins");
		    return true;
		}
	    }
	}
	return false;
    }


    public boolean verticalwin ()
    {
	for (int i = 0 ; i < row - 3 ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		if (b [i] [j] != 0 && b [i] [j] == b [i + 1] [j] && b [i] [j] == b [i + 2] [j] && b [i] [j] == b [i + 3] [j])
		{
		    if (b [i] [j] == 1)
			showStatus ("Gryffindor Wins");
		    else
			showStatus ("Slytherin Wins");
		    return true;
		}
	    }
	}
	return false;
    }


    public boolean diagonalwin ()
    {
	for (int i = 0 ; i < row - 3 ; i++)
	{
	    for (int j = 0 ; j < col - 3 ; j++)
	    {
		if (b [i] [j] != 0 && b [i] [j] == b [i + 1] [j + 1] && b [i] [j] == b [i + 2] [j + 2] && b [i] [j] == b [i + 3] [j + 3])
		{
		    if (b [i] [j] == 1)
			showStatus ("Gryffindor Wins");
		    else
			showStatus ("Slytherin Wins");
		    return true;
		}
	    }
	}
	return false;
    }


    public void reset ()
    { //copy every element of r into b
	//that sets it back to the original
	for (int i = 0 ; i < row ; i++)
	    for (int j = 0 ; j < col ; j++)
		b [i] [j] = r [i] [j];
	//call redraw to update b on the screen
	redraw ();
    }


    public void screen4 ()
    { //screen 4 is set up.
	card4 = new Panel ();
	card4.setBackground (Color.yellow);
	JLabel title = new JLabel ("You Win!");
	JButton next = new JButton ("Next");
	next.setActionCommand ("s5");
	next.addActionListener (this);
	card4.add (title);
	card4.add (next);
	p_card.add ("4", card4);
    }


    public void screen5 ()
    { //screen 5 is set up.
	card5 = new Panel ();
	card5.setBackground (Color.cyan);
	JLabel title = new JLabel ("You Lose.");
	JButton next = new JButton ("Back to Introduction?");
	next.setActionCommand ("s1");
	next.addActionListener (this);
	JButton end = new JButton ("Quit?");
	end.setActionCommand ("s6");
	end.addActionListener (this);
	card5.add (title);
	card5.add (next);
	card5.add (end);
	p_card.add ("5", card5);
    }


    protected static ImageIcon createImageIcon (String path)
    { //change the red to your class name
	java.net.URL imgURL = FinalGame.class.getResource (path);
	if (imgURL != null)
	{
	    return new ImageIcon (imgURL);
	}
	else
	{
	    System.err.println ("Couldn't find file: " + path);
	    return null;
	}
    }


    public void redraw ()
    {
	int move = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		a [move].setIcon (createImageIcon (b [i] [j] + ".png"));
		move++;
	    }
	}
    }


    public void actionPerformed (ActionEvent e)
    { //moves between the screensreset();
	if (e.getActionCommand ().equals ("s1"))
	    cdLayout.show (p_card, "1");
	else if (e.getActionCommand ().equals ("s2"))
	    cdLayout.show (p_card, "2");
	else if (e.getActionCommand ().equals ("s3"))
	    cdLayout.show (p_card, "3");
	else if (e.getActionCommand ().equals ("s4"))
	    cdLayout.show (p_card, "4");
	else if (e.getActionCommand ().equals ("s5"))
	    cdLayout.show (p_card, "5");
	else if (e.getActionCommand ().equals ("s6"))
	    System.exit (0);
	else if (e.getActionCommand ().equals ("reset"))
	    reset ();
	else
	{ //code to handle the game
	    int n = Integer.parseInt (e.getActionCommand ());
	    int x = n / col;
	    int y = n % col;



	    while (x < row && b [x] [y] == 0)
		x++;

	    x--;

	    if (x >= 0 && b [x] [y] == 0)
	    {
		//code to handle game
		b [x] [y] = turn;
		redraw ();
		horizontalwin ();
		verticalwin ();
		diagonalwin ();

		if (turn == 1)
		{
		    turnpic.setIcon (createImageIcon ("2t.png"));
		    turn = 2;
		}
		else
		{
		    turnpic.setIcon (createImageIcon ("1t.png"));
		    turn = 1;
		}

	    }
	    else
		showStatus ("You can't go there, choose again");

	}
    }
}


