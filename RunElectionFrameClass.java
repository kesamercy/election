//
// RunElectionFrameClass
// The purpose of this class is to create information for the election frame 
//
// Author: Nekesa Mercy
// Date: 12/ 07/ 16
//
package electionPackage;
import javax.swing.*;
import java.io.IOException;
import java.awt.*;

public class RunElectionFrameClass extends JFrame
{
	private RunElectionPanelClass firstPanel;
	
	public RunElectionFrameClass()throws IOException {
		
		// define parameters for the frame
		setTitle("RunElection Frame for Nekesa Mercy");
		setSize(400,300);
		setLocation(50,50);
		
		//create a panel layout and add it to the frame 
		firstPanel = new RunElectionPanelClass();
		add(firstPanel);	
		
		// show frame on screen
		setVisible(true);	

	}// end constructor 

}// end RunElection class 
