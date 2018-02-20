//
// RunElectionPanel 
// The purpose of this method is to create a panel for the run election class
//
// Author: Nekesa Mercy
// Date: 12/07/16
//
package electionPackage;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
public class RunElectionPanelClass extends JPanel implements ActionListener
{
	
	private ElectionInfo ei;			//object for the election info
	private JButton showResults;		// the show resuts button 
	
	//group of radio buttons 
	private JRadioButton spiderman;
	private JRadioButton ironman;
	private JRadioButton greenHulk;
	private JRadioButton captainMerica;
	private JRadioButton batMan;
	private JRadioButton robin;
	private ButtonGroup bg;
	
	//declare variable 
	private int num1;
	private int num2;
	private int num3;
	private int num4;
	private int num5;
	private int num6;
	
	private String name1;
	private String name2;
	private String name3;
	private String name4;
	private String name5;
	private String name6;
	
	private String winner;
	

	
			
	
	public RunElectionPanelClass() throws IOException
	{
		
		//create spider radio button
		spiderman = new JRadioButton("Spiderman");
		add(spiderman);
		
		//create the ironman radio button
		ironman = new JRadioButton("Ironman");
		add(ironman);
		
		//create the greenhulk radio button
		greenHulk = new JRadioButton(" Green Hulk");
		add(greenHulk);
		
		//create the captain America radio button
		captainMerica = new JRadioButton("Captain America");
		add(captainMerica);
		
		//create the batman radio button
		batMan = new JRadioButton("Batman");
		add(batMan);
		
		//create the robin radio button
		robin = new JRadioButton("Robin");
		add(robin);
		
		//create the show results button
		showResults = new JButton("SHOW RESULTS");
		add(showResults);
		
		//create the button group 
		bg =  new ButtonGroup();
		
		//create the object c 
		ei =  new ElectionInfo();
		
		//file with the name of the candidates 
		ei.electionProcess("candidateList.txt");
		
		//add the buttons to the group 
		bg.add(spiderman);
		bg.add(batMan);
		bg.add(robin);
		bg.add(captainMerica);
		bg.add(greenHulk);
		bg.add(ironman);
		
		// add an action listener for spiderman
		spiderman.addActionListener(this);
		
		// add an action listener for batman
		batMan.addActionListener(this);
		
		// add an action listener for robin
		robin.addActionListener(this);
		
		// add an action listener for captain america
		captainMerica.addActionListener(this);
		
		// add an action listener for greenhulk
		greenHulk.addActionListener(this);
		
		// add an action listener for ironman
		ironman.addActionListener(this);
		
		// add an action listener for show results 
		showResults.addActionListener(this);
		
		//intialize variables 
		num1 = 0;
		num2 = 0;
		num3 = 0;
		num4 = 0;
		num5 = 0;
		num6 = 0;
		
		name1 = "none yet";
		name2 = "none yet";
		name3 = "none yet";
		name4 = "none yet";
		name5 = "none yet";
		name6 = "none yet";
		winner = "none yet";

		//create the printwriter 
		PrintWriter output = new PrintWriter("results.txt");

		
	}// end constructor 
	
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
		if (e.getSource() == spiderman)
		{
			castVotes(e);
			System.out.println("A vote was added for spiderman");
		}

		else if (e.getSource() == batMan)
		{
			
			castVotes(e);
			System.out.println(" A vote was added for batman!");
			
		}
		
		else if (e.getSource() == greenHulk)
		{			
			castVotes(e);
			System.out.println("A vote was added for green hulk!");
		}
		
		else if (e.getSource() == captainMerica)
		{			
			castVotes(e);
			System.out.println("A vote was added for captain America!");
		}
		
		else if (e.getSource() == robin)
		{			
			castVotes(e);
			System.out.println("A vote was added for robin!" );
		}
		
		else if (e.getSource() == ironman)
		{			
			castVotes(e);
			System.out.println("A vote was added for ironman!");
		}
		
		else if (e.getSource() == showResults)
		{		
			
			System.out.println();
			System.out.println("These are the results!");
			System.out.println();
			
			System.out.println("Spiderman " + " has " + num1 + " number of votes " );
			System.out.println("Batman " + " has " + num2 + " number of votes "  );
			System.out.println("Captain America " + " has " + num3 + " number of votes " );
			System.out.println("Ironman " + " has " + num4 + " number of votes " );
			System.out.println("Robin " + " has " + num5 + " number of votes ");
			System.out.println("Green Hulk " + " has " + num6 + " number of votes ");
			
			
			try
			{
				ei.showResults("results.txt");
			} catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			winner = ei.getWinner().getName();
			System.out.println("The winner is " + winner );
		}
		
		
		else
		{
			System.out.println("Unexpected Action Event in MyPanelClass");
		}
		
	}// end action performed 
	
	//
	//	castVotes
	//
	//	the purpose of this method is to cast votes to the candidates 
	//
	//	Input:	none
	//	REturn:	none
	//
	public void castVotes(ActionEvent e)
	{
		
		
		if (e.getSource() == spiderman)
		{
			 name1 = spiderman.getText();
			ei.getTheCandidates().castVote(name1);
			num1 = ei.getTheCandidates().getOneCandidate(0).getNumVotes();
			
			 System.out.println(num1);
				
		}
		
		else if (e.getSource() == ironman){
			
			name4 = ironman.getText();
			ei.getTheCandidates().castVote(name4);
			num4 = ei.getTheCandidates().getOneCandidate(1).getNumVotes();
			
		    System.out.println(num4);
		 }
		
		else if (e.getSource() == greenHulk){
			
			name6 = greenHulk.getText();
			ei.getTheCandidates().castVote(name6);
			num6 = ei.getTheCandidates().getOneCandidate(2).getNumVotes();
			
		    System.out.println(num6);
		}
		
		else if (e.getSource() == captainMerica){
			
			name3 = captainMerica.getText();
			ei.getTheCandidates().castVote(name3);
			num3 = ei.getTheCandidates().getOneCandidate(3).getNumVotes();
			
		    System.out.println(num3);
			
		}
		
		
		else if (e.getSource() == batMan)
		{
			 name2 = batMan.getText();
			ei.getTheCandidates().castVote(name2);
			num2 = ei.getTheCandidates().getOneCandidate(4).getNumVotes();
			
		    System.out.println(num2);
		}
		
		else if (e.getSource() == robin){
			
			name5 = robin.getText();
			ei.getTheCandidates().castVote(name5);
			num5 = ei.getTheCandidates().getOneCandidate(5).getNumVotes();
			
		    System.out.println(num5);
		}
				
	}// end castVotes
	
	

}// end RunElectionFramePanel
