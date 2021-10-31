package money;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class CountChange {

	public static void main(String[] args) {
		
		int quarters = 0, dimes = 0, nickels = 0, pennies = 0;
		double total = 0;
		
		String numberOfQuarters, numberOfDimes, numberOfNickels, numberOfPennies, theAmount, result;
		
		DecimalFormat twoDecimals = new DecimalFormat("0.00");
		
		
		do {
			numberOfQuarters = JOptionPane.showInputDialog("How many quarters?");
		}while(inputNotValid(numberOfQuarters));
		
		quarters = Integer.parseInt(numberOfQuarters);
		
		
		do {
			numberOfDimes = JOptionPane.showInputDialog("How many dimes?");
		}while(inputNotValid(numberOfDimes));
		
		dimes = Integer.parseInt(numberOfDimes);
		
		
		do {
			numberOfNickels = JOptionPane.showInputDialog("How many nickels?");
		}while(inputNotValid(numberOfNickels));
		
		nickels = Integer.parseInt(numberOfNickels);
		
		
		do {
			numberOfPennies = JOptionPane.showInputDialog("How many pennies?");
		}while(inputNotValid(numberOfPennies));
		
		pennies = Integer.parseInt(numberOfPennies);
		
		
		total = Math.round (((quarters * 0.25) + (dimes * 0.10) + (nickels * 0.05) + (pennies * 0.01)) * 100) / 100.0;
		theAmount =	"$" + twoDecimals.format(total);
		
		result = "The total value of " + quarters + " quarter" + isMoreThanOne(quarters, "") + ", " + dimes + " dime" + isMoreThanOne(dimes, "") + ",\n"
				 + nickels + " nickel" + isMoreThanOne(nickels, "") + ", and " + pennies + " " + isMoreThanOne(pennies,"penny") + " is " + theAmount;
		
		JOptionPane.showMessageDialog(null, result, "Results",  JOptionPane.PLAIN_MESSAGE);
		
		System.exit(0);
	}//END OF MAIN
	
	
	public static boolean inputNotValid (String input)
	{
		boolean wrongInput = true, canceled = false;
		int checkIfInteger = 0; 
		
		if(input == null)
		{
			canceled = true;
			
		}
		else
		{	
			try{
					checkIfInteger = Integer.parseInt(input);
				
					if(checkIfInteger < 0)
					{
						JOptionPane.showMessageDialog(null, "You have to enter a positive number.", "Invalid Input", JOptionPane.PLAIN_MESSAGE);
					}
					else
					{
						wrongInput = false;
					}
				}
			catch(Exception e)
				{
		
					JOptionPane.showMessageDialog(null, "You have to enter an integer", "Invalid Input", JOptionPane.PLAIN_MESSAGE);
				}
		}
		
		if(canceled) {System.exit(0);}
		return wrongInput;
	}
	
	public static String isMoreThanOne (int theNumber, String changeType )
	{
		String plural = "";
		
		if(changeType.equals("penny") && theNumber == 1)
		{
			return "penny";
		}
		else if(changeType.equals("penny") && theNumber != 1)
		{
			return "pennies";
		}
		else if(theNumber != 1)
		{
			plural = plural + "s";
		}
		return plural;
	}
	
}
