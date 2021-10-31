package money;

import javax.swing.JOptionPane;

import java.text.DecimalFormat;

public class MakeChange {

	public static void main(String[] args) {
		
		int totalNumberOfPennies = 0, quarters = 0, dimes = 0, nickels = 0, pennies = 0;
		double value = 0;
		
		String result, enteredValue;
		
		DecimalFormat twoDecimals = new DecimalFormat("0.00");
		
		
		do {
			enteredValue = JOptionPane.showInputDialog("Enter the total value");
		}while(inputNotValid(enteredValue));
		
		value = Double.parseDouble(enteredValue);
		value = Math.round(value * 100) / 100.0;
		enteredValue = twoDecimals.format(value); 
	
		value = value * 100;
		totalNumberOfPennies = (int)value; 
		
		quarters = totalNumberOfPennies / 25;
		totalNumberOfPennies = totalNumberOfPennies % 25;
		
		dimes = totalNumberOfPennies / 10;
		totalNumberOfPennies = totalNumberOfPennies % 10;
		
		nickels = totalNumberOfPennies / 5;
		pennies = totalNumberOfPennies % 5;
		
		result = "The correct change for $" + enteredValue + " is\n"
				 + quarters + " quarter" +  isMoreThanOne(quarters, "") + ", " + dimes + " dime" + isMoreThanOne(dimes, "") + ", " + nickels + " nickel" + isMoreThanOne(nickels, "") + ",\n" 
				 + "and " + pennies + " " + isMoreThanOne(pennies,"penny") + ".";
		
		JOptionPane.showMessageDialog(null, result, "Results", JOptionPane.PLAIN_MESSAGE);
		
		System.exit(0); 
	}//END OF MAIN
	
	public static boolean inputNotValid (String input)
	{
		boolean wrongInput = true, canceled = false;
		double checkIfDouble = 0; 
		
		if(input == null)
		{
			canceled = true;
			
		}
		else
		{	
			try{
					checkIfDouble = Double.parseDouble(input);
				
					if(checkIfDouble < 0)
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
		
					JOptionPane.showMessageDialog(null, "You have to enter a double", "Invalid Input", JOptionPane.PLAIN_MESSAGE);
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
