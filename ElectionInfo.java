//
// ElectionInfo
// The purpose of this class is to run the election class information
//
// Author: Nekesa Mercy
// Date: 12/07/16
//
package electionPackage;
import java.io.*;

public class ElectionInfo
{
	// attributes
		private CandidateList  theCandidates;	// all candidates in the election
		private Candidate winner;				// winning candidate
		
		//
		//	ElectionFromFile
		//
		//	The purpose of this method is to initialize all attributes
		//
		//	Input:	none
		//	Return:	none
		//
		
		public ElectionInfo()
		{
			
			// create the list of candidates
			theCandidates = new CandidateList();
		
			// create the winning candidate object
			winner = new Candidate();
			
		}// end ElectionFromFile constructor
		
		//
		//	setTheCandidates
		//
		//	The purpose of this method is to modify the list of candidates
		//
		//	Input:	cl		the new candidate list
		//	REturn:	none
		//
		public void setTheCandidates(CandidateList cl)
		{
			theCandidates = cl;
		}// end setTheCandidates
		
		//
		//	getTheCandidates
		//
		//	The purpose of this method is to return a copy of the candidate list
		//	
		//	Input:	none
		//	Return:	theCandidates
		//
		
		public CandidateList getTheCandidates()
		{
			return(theCandidates);
			
		}// end getTheCandidates
		
		//
		//	getWinner
		//
		//	the purpose of this method is to return a copy of the
		//	winning candidate
		//
		//	Input:	none
		//	Return:	winner
		//
		
		public Candidate getWinner()
		{
			return(winner);
		}// end getWinner
		
		
		
	    //
	    //	toString
	    //
	    //	The purpose of this method is to create a string holding
	    //	all attributes.
	    //
	    //	Input:	none
	    //	REturn:	retStr		the complete string
	    //
	    
	    public String toString()
	    {
	        String retStr;
	        StringBuffer buff;
	        String canListStr;
	        String winStr;

	        buff = new StringBuffer();
	  
	        // add the candidate list to the string
	        canListStr = theCandidates.toString();
	        buff.append("CANDIDATE LIST\r\n");
	        buff.append(canListStr + "\r\n");

	        // add the winner to the string
	        winStr = winner.toString();
	        buff.append("Winner\r\n");
	        buff.append(winStr + "\r\n");
	        
	        retStr = buff.toString();
	        return(retStr);
	        
	    } // end toString

	   
	    
	    
	    
	    //
	    //	runElection
	    //
	    //	the purpose of this method is to run an election between the candidates.
	    //
	    //	Input:	canFile		the file name holding the candidate names
	    //			resultsFile	the file name in which the results should be stored
	    //	Return:	none
	    //
	    
	    public void runElection(String canFile, String resultsFile) throws IOException
	    {
	        String input;
	        
	        // register the candidates
	        theCandidates.inputCandidates(canFile);
	        
	        // input all votes from the keyboard
	        do
	        {
	            // get the candidate name
	            input = MyUtilityClass.inputString("Enter name of Candidate\t");
	            
	            // Election is over when user enters END
	            if (input.equalsIgnoreCase("END") == false)
	            {
	            	// cast the vote for the candidate
	            	theCandidates.castVote(input);

	            } // end if election not over
	            
	        }while(input.equalsIgnoreCase("END")== false);
	        
	        // determine the winner of the election
	        determineWinner();
	        
	        // save the results to a file
	        saveResults(resultsFile);

	        
	    } // end runElection

	    //
	    //	determineWinner
	    //
	    //	the purpose of this method is to determine the winner of the election.
	    //
	    //	Input:	none
	    //	Return:	none
	    //
	    
	    public void determineWinner()
	    {
	    	int maxVotes;
	    	int maxCandidate;
	    	int cntr;
	    	int[] allCanVotes;
	    	
	    	maxVotes = -1;
	    	maxCandidate = -1;
	    	
	    	// get the number of votes for all candidates
	    	allCanVotes = theCandidates.collectAllVotes();
	    	
	    	for (cntr = 0; cntr < allCanVotes.length;++cntr)
	    	{  		
	    		// check to see if this is the winning candidate so far
	    		if (allCanVotes[cntr] > maxVotes)
	    		{
	    			maxVotes = allCanVotes[cntr];
	    			maxCandidate = cntr;
	    		}
	    	}// end for each cntr
	    	
	    	// so now we need to assign the actual candidate object to the
	    	// winning candidate object
	    	if ((maxCandidate >= 0) && (maxCandidate < allCanVotes.length))
	    	{
	    		winner = theCandidates.getOneCandidate(maxCandidate);
	    	}
	    	else
	    	{
	    		System.out.println("No winning candidate");
	    	}
	    	
	    	
	    }// end determineWinner
	    
	    //
	    //	saveResults
	    //
	    //	The purpose of this method is to save the results from the election
	    //	to a file.  The results must show the votes for all candidates and
	    //	also the winner.
	    //
	    //	Input:	fileName		the name of the file in which to save the election
	    //	Return:	none
	    //
	    
	    public void saveResults(String fileName) throws IOException
	    {
	   
		    PrintWriter  outputWriter;
		    
	    	// open the file for writing
	   		outputWriter = new PrintWriter(fileName);

	     	// print out all votes for all candidates
	     	outputWriter.println("CANDIDATES\r\n");
	     	outputWriter.println(theCandidates);
	     		
	     	// print out the winner
	     	outputWriter.println("WINNER\r\n");
	     	outputWriter.println(winner);
	 
	           
	    	// close the file now that we have saved the results
	    	outputWriter.close();
	  	
		   	
	    }// end saveResults
	 
	    //
	    //	runElection
	    //
	    //	the purpose of this method is to run an election between the candidates.
	    //	this method will generate random votes for the candidates
	    //
	    //	Input:	canFile		the file name holding the candidate names
	    //			resultsFile	the file name in which the results should be stored
	    //			totalVotes	the total number of votes to generate
	    //	Return:	none
	    //
	    
	    public void runElection(String canFile, String resultsFile, int totalVotes) throws IOException
	    {
	        String[] allCanNames;
	        int maxCanIndex;
	        int index;
	        int cntr;
	        
	        // register the candidates
	        theCandidates.inputCandidates(canFile);
	        
	        // get a list of all candidate names
	        allCanNames = theCandidates.collectAllNames();
	        maxCanIndex = allCanNames.length - 1;
	        
	        
	        // input all votes randomly
	        for (cntr = 0; cntr < totalVotes;++cntr)
	        {
	        	// generate a random candidate number
	        	index = MyUtilityClass.genRandom(0,maxCanIndex);
	        	
	        	// cast the vote for that candidate
	        	theCandidates.castVote(allCanNames[index]);
	        	
	        }// end for each vote
	        
	        // determine the winner of the election
	        determineWinner();
	        
	        // save the results to a file
	        saveResults(resultsFile);
	  
	    } // end runElection
	    
	    
	    //
	    // electionProcess
	    // the purpose of this method is to run the election process 
	    //
	    // input:	candidate list		the file with candidate names 
	    // return: 	none
	    //
	    public void electionProcess(String candidateList) throws IOException {
	        
	        
	        theCandidates.inputCandidates(candidateList);

	    }//end electionProcess
	    
	    
	    // showResults
	    // the purpose of this method is to end the election process
	    //
	    // input:	resultsFile      file to keep the information 
	    // return:	none
	    //
	    public void showResults(String endResults) throws IOException{
	    	
		    //determine the winner 
		    determineWinner();
		    
		   //save results 
		    saveResults(endResults);
		    
	    }// end showResults
	    

}// end ElectionInfo
