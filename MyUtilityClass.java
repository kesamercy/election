package electionPackage;
//
// MyUtilityClass
// The purpose of this class is to have the generic utility methods 
//
// 


import java.util.Scanner;
public class MyUtilityClass {
	
//	inputString
	//
	//	the purpose of this method is to input a string from the keyboard
	//
	//	Input:	prompt			the prompt message for the dialog box
	//
	//	Return:	inputStr		the string that was entered at the keyboard
	//
	
	public static String inputString(String prompt)
	{
		Scanner input = new Scanner(System.in);
		String inputStr;
		
		// prompt user to enter the string
		System.out.print(prompt);
		
		// read in value as string from keyboard
		inputStr = input.nextLine();
		
		// return input string
		return(inputStr);
	}// end inputString

	//
	//	inputInteger
	//
	//	the purpose of this method is to input an integer value from the keyboard
	//
	//	Input:		prompt		The prompt message for the user
	//	Return:		num			the integer entered at the keyboard
	//
	
	public static int inputInteger(String prompt)
	{
		Scanner input = new Scanner(System.in);
		String cleanUpStr;
		int num;
		
		num = 0;
		cleanUpStr = "no string yet";
		
		System.out.print(prompt);
		num = input.nextInt();
		cleanUpStr = input.nextLine();
		
		return(num);

	}// end inputInteger

	
	//
	//	inputDouble
	//
	//	the purpose of this method is to input a double value from the keyboard
	//
	//	Input:		prompt		The prompt message for the user
	//	Return:		num			the double value entered at the keyboard
	//
	
	public static double inputDouble(String prompt)
	{
		Scanner input = new Scanner(System.in);
		String cleanUpStr;
		double num;
		
		num = 0.0;
		cleanUpStr = "no string yet";
		
		System.out.print(prompt);
		num = input.nextDouble();
		cleanUpStr = input.nextLine();
		
		return(num);

	}// end inputDouble

	//
	//	genRandom
	//
	//	The purpose of this method is to generate a random number
	//	between the minimum and maximum values specified inclusively
	//
	//	Input:	min		the minimum value in the range of numbers
	//		max		the maximum value in the range of numbers
	//
	//	Return:	num		the random number in the given range
	//
	
	public static int genRandom(int min, int max)
	{
		double rNum;		// the original random number generated
		double range;		// the range of random numbers allowed
		int num;

		rNum = 0.0;
		range = 0.0;
		num = 0;
	        
	    // generate a random number 0.0 <= rNum < 1.0
	   	rNum = Math.random( );
	        
	   	// determine the range
	    range = (double)max - (double)min + 1.0;
	        
	    // scale the number between min and max inclusively
	    rNum = rNum * range;       
	    rNum = rNum + (double)min;
	        
	    // convert back to integer value
	    num = (int)rNum;
	    
	    // return the integer
	    return(num);      		
	}// end genRandom

}// end
