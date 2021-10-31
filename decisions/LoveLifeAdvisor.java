package decisions;

import javax.swing.JOptionPane;

public class LoveLifeAdvisor {

	public static void main(String[] args) {
		
		int yourAge = 0, dateAge = 0, income = 0, ageDifference = 0;
		
		String input, notAskOut = "Maybe you should find someone else...", askOut = "Ask out...and good look!";
		
		

		do {
			input = JOptionPane.showInputDialog("How old is your prospective date?");
		}while(inputNotValid(input));
		
		dateAge = Integer.parseInt(input);
		
		
		if(dateAge < 18)
		{
			JOptionPane.showMessageDialog(null, notAskOut, "Results", JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			do {
				input = JOptionPane.showInputDialog("How old are you?");
			}while(inputNotValid(input));
			
			yourAge = Integer.parseInt(input);
			
			
			ageDifference = Math.abs(yourAge - dateAge);
			
			 if(ageDifference <= 20)
			    {
			    	JOptionPane.showMessageDialog(null, askOut, "Results", JOptionPane.INFORMATION_MESSAGE);
			    }
			 else
			    {
				 do{
						input = JOptionPane.showInputDialog("What is your prospective date's income?");
					}while(inputNotValid(input));
					
					income = Integer.parseInt(input);
					
					
			    	if(income >= 200000)
			    	{
			    		JOptionPane.showMessageDialog(null, askOut, "Results", JOptionPane.INFORMATION_MESSAGE);
			    	}
			    	else
			    	{
			    		JOptionPane.showMessageDialog(null, notAskOut, "Results", JOptionPane.INFORMATION_MESSAGE);
			    	}
			    }
		   }
		
		System.exit(0);
	}
	
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
	

}
