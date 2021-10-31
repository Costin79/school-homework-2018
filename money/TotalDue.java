package money;

import javax.swing.JOptionPane;

public class TotalDue {

	public static void main(String[] args) {
		
		int quantitySold = 0;
		double  priceEach = 0, discountRate = 0, totalDueBeforeDiscount, discountAmount, totalDueAfterDiscount;
		boolean wrongInput = true, hasBeenCanceled = false;
		
		String userEntry, result;
		
		
		
		do
		{	
			userEntry = JOptionPane.showInputDialog("Enter quantity sold");
			
			if(userEntry == null)
			{
				hasBeenCanceled = true;
				
			}
			else
			{	
				try{
						quantitySold = Integer.parseInt(userEntry);
					
						if(quantitySold < 0)
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
			}while(wrongInput && !hasBeenCanceled);
		
		
		
		if(hasBeenCanceled) {System.exit(0);}
		
		wrongInput = true;
		hasBeenCanceled = false;
		
		do{
			userEntry = JOptionPane.showInputDialog("Enter price each");
			
			if(userEntry == null)
			{
				hasBeenCanceled = true;
				
			}
			else
			{
				try{
					    priceEach = Double.parseDouble(userEntry);
					
						if(priceEach < 0)
						{
							JOptionPane.showMessageDialog(null, "You have to enter a positive number.", "Invalid Input", JOptionPane.PLAIN_MESSAGE);
						}
						else
						{
							wrongInput = false;
						}
					}
				catch(Exception e){
			
						JOptionPane.showMessageDialog(null, "You have to enter a double", "Invalid Input", JOptionPane.PLAIN_MESSAGE);
					}
			}
		}while(wrongInput && !hasBeenCanceled);
		
		if(hasBeenCanceled) {System.exit(0);}
		
		wrongInput = true;
		hasBeenCanceled = false;
		
		do{
			userEntry = JOptionPane.showInputDialog("Enter discount rate as a decimal");
			
			if(userEntry == null)
			{
				hasBeenCanceled = true;
				
			}
			else
			{
				try{
					discountRate = Double.parseDouble(userEntry);
					wrongInput = false;
				}
				catch(Exception e){
			
					JOptionPane.showMessageDialog(null, "You have to enter a double", "Invalid Input", JOptionPane.PLAIN_MESSAGE);
				}
			}
		}while(wrongInput && !hasBeenCanceled);
		
		if(hasBeenCanceled) {System.exit(0);}
		
		hasBeenCanceled = false;
		
		totalDueBeforeDiscount = quantitySold * priceEach;
		totalDueBeforeDiscount = Math.round(totalDueBeforeDiscount * 100) / 100.0;
		
		discountAmount = totalDueBeforeDiscount * discountRate;
		discountAmount = Math.round(discountAmount * 100) / 100.0;
		
		totalDueAfterDiscount = totalDueBeforeDiscount - discountAmount;
		totalDueAfterDiscount = Math.round(totalDueAfterDiscount * 100) / 100.0;
		
		
		result = "Total due before discount is $" + totalDueBeforeDiscount + "\n" +
				 "Discount amount is $" + discountAmount + "\n" +
				 "Total due after discount is $" + totalDueAfterDiscount +"**";
		
		JOptionPane.showMessageDialog(null, result, "Results", JOptionPane.PLAIN_MESSAGE);
		
		System.exit(0);
	}//END OF MAIN
}
