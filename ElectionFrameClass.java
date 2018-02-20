//
// ElectionFrameClass
// The purpose of this class is to create the frame class
//
// Author: Nekesa Mercy
// Date: 12/05/16
//
package electionPackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.awt.event.*;

public class ElectionFrameClass extends JFrame 
{
	//declare attributes 
	private GridLayout frameLayout;
	private ElectionPanelClass firstPanel;
	
	public ElectionFrameClass(){
		
		//create flowLayout object 
		frameLayout = new GridLayout(1,1);
		setLayout(frameLayout);
		
		//define parameters for the frame
		setTitle("Election Frame for Nekesa Mercy");
		setSize(500,400);
		setLocation(60,60);
		
		//terminate program on close of frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		
		//create a panel layout and add it to the frame 
		try
		{
			firstPanel = new ElectionPanelClass();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		add(firstPanel);	
		
		//show frame on the screen
		setVisible(true);
		
	}// end ElectionFrameClass
	
	

}// end ElectionFrameClass
