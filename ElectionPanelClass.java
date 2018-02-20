//
// ElectionPanelClass
// The purpose of this class is to create the election panel clas
//
// Author: Nekesa Mercy
// Date: 12/05/16
//
package electionPackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.io.IOException;

public class ElectionPanelClass extends JPanel implements ActionListener
{
	private FlowLayout frameLayout;

	private JButton election;			// the election button
	private JButton count;				// the count button
	private Color currentColor;			// the current color for the radio buttons 
	
	//declare the radio buttons 
	private ButtonGroup bg;
	private JRadioButton red;			
	private JRadioButton green;
	private JRadioButton yellow;
	
	//declare variables 
	int push;
	
	
	
	//
	//	ElectionPanelClass
	//
	//	The purpose of this method is to initialize all attributes.
	//	Attributes in this class and also inherited attributes must
	//	be initialized.
	//
	//	Input:	none
	//	Return:	none
	//
	public ElectionPanelClass( ) throws IOException {
		
		//create the layout manager and assign it to the panel 
		frameLayout = new FlowLayout();
		setLayout(frameLayout);
		
		//create the election button
		election = new JButton("ELECTION");
		add(election);
		
		//create the count button 
		count = new JButton("COUNT");
		add(count);
		
		//create red radio button
		red = new JRadioButton("Red");
		add(red);
		
		//specify the properties of the red button
		red.setForeground(Color.red);
		
		//create the green radio button
		green = new JRadioButton("Green");
		add(green);
		
		//specify the properties of the green button
		green.setForeground(Color.green);
		
		//create the yellow radio button
		yellow = new JRadioButton("Yellow");
		add(yellow);
		
		//specify the properties of the yellow button
		yellow.setForeground(Color.yellow);
		
		// add an action listener for button red
		red.addActionListener(this);
		
		// add an action listener for button green
		green.addActionListener(this);
		
		// add an action listener for button yellow
		yellow.addActionListener(this);
		
		// add an action listener for button green
		election.addActionListener(this);
		
		// add an action listener for button yellow
		count.addActionListener(this);
		
		
		//initialize the current color 
		currentColor = Color.red;
		
		bg =  new ButtonGroup();
		
		//group of the radio buttons 
		bg.add(red);
		bg.add(yellow);
		bg.add(green);
		
		setBackground(Color.red);
		
		//intialize variables 
		push = 0;
		
		//set visible 
		setVisible(true);
		
	}// end ElectionPanelClass
	
	
	//
	//	actionPerformed
	//
	//	This is the event handler for the ActionEvents
	//
	//	Input:	e		the action event
	//	Return:	none
	//
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == red)
		{
			toggleColor(e);
			System.out.println("red was pushed!");
		}

		else if (e.getSource() == green)
		{
			
			toggleColor(e);
			System.out.println("green was pushed!");
			
		}
		
		else if (e.getSource() == yellow)
		{			
			toggleColor(e);
		
			System.out.println("yellow was pushed!");
		}
		
		else if (e.getSource() == election) 
		{			
			try
			{
				RunElectionFrameClass frame2;
				frame2 = new RunElectionFrameClass( );
			} catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("election was pushed!");
		}
		
		else if (e.getSource() == count)
		{			
			++push;
		
			System.out.println("Count has been pushed " + push + " times");
		}
		
		else
		{
			System.out.println("Unexpected Action Event in MyPanelClass");
		}

	}// end actionPerformed

	
	//
	//	toggleColor
	//
	//	the purpose of this method is to toggle the background color of the panel between red, green and yellow
	//
	//	Input:	none
	//	REturn:	none
	//
	public void toggleColor(ActionEvent e)
	{
		if (e.getSource() == red)
		{
			currentColor = Color.red;
				
		}
		else if (e.getSource() == green)
		{
			currentColor = Color.green;
			
		}
		
		else if (e.getSource() == yellow){
			
			currentColor = Color.yellow;
		}
		
		setBackground(currentColor);
		
		
		
	}// end toggleColor
	


}// end ElectionPanelClass
