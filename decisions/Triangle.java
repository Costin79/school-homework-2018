package decisions;

import javax.swing.JOptionPane;

public class Triangle {

	public static void main(String[] args) {
		
		int first = 0, second = 0, third = 0, shortest, middle, longest;
		String input, result, youGaveMe = "You gave me: ", inOrder = "In order: ";
		
		do{
			input = JOptionPane.showInputDialog("Enter first length");
		}while(inputNotValid(input));
		
		first= Integer.parseInt(input);
		
		
		do{
			input = JOptionPane.showInputDialog("Enter second length");
		}while(inputNotValid(input));
		
		second = Integer.parseInt(input);
		
		
		do{
			input = JOptionPane.showInputDialog("Enter third length?");
		}while(inputNotValid(input));
		
		third = Integer.parseInt(input);
		
		youGaveMe = youGaveMe + first + ", " + second + ", " + third + "\n\n";
		
		if(first > second)
		{
			longest = first;
			middle = second;
		}
		else
		{
			longest = second;
			middle = first;
		}
		
		if(third > longest)
		{
			shortest = middle;
			middle = longest;
			longest = third;
		}
		else
		{
			if(third > middle)
			{
				shortest = middle;
				middle = third;
			}
			else
			{
				shortest = third;
			}
		}
		
		inOrder = inOrder + shortest + ", " + middle + ", " + longest + "\n\n" ;
		
		if(isTriangle(shortest, middle, longest))
		{
			if(isEquilateral(shortest, middle, longest))
			{
				result = youGaveMe + inOrder + "You can make an equilateral \n" + "triangle with these sides";
				JOptionPane.showMessageDialog(null, result, "Results", JOptionPane.PLAIN_MESSAGE);
			}
			else if(isIsoceles(shortest, middle, longest))
			{
				if(isRight(shortest, middle, longest))
				{
					result = youGaveMe + inOrder + "You can make a right isoceles \n" + "triangle with these sides";
					JOptionPane.showMessageDialog(null, result, "Results", JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
					result = youGaveMe + inOrder + "You can make an isoceles \n" + "triangle with these sides";
					JOptionPane.showMessageDialog(null, result, "Results", JOptionPane.PLAIN_MESSAGE);
				}
			}
			else
			{
				if(isRight(shortest, middle, longest))
				{
					result = youGaveMe + inOrder + "You can make a right scalene \n" + "triangle with these sides";
					JOptionPane.showMessageDialog(null, result, "Results", JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
					result = youGaveMe + inOrder + "You can make a scalene \n" + "triangle with these sides";
					JOptionPane.showMessageDialog(null, result, "Results", JOptionPane.PLAIN_MESSAGE);
				}
			}
		}
		else
		{
			result = youGaveMe + inOrder + "You cannot make a \n" + "triangle with these sides";
			JOptionPane.showMessageDialog(null, result, "Results", JOptionPane.PLAIN_MESSAGE);
		}
		
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

	
	public static boolean isTriangle(int shortest, int middle, int longest)
	{
		if(shortest + middle > longest)
		{
			return true;
		}
		return false;
	}
	
	public static boolean isEquilateral(int shortest, int middle, int longest)
	{
		if(shortest == middle && shortest == longest)
		{
			return true;
		}
		return false;
	}
	
	public static boolean isIsoceles(int shortest, int middle, int longest)
	{
		if((shortest==middle && shortest!=longest) || (shortest==longest && shortest!=middle) || (longest==middle && longest!=shortest))
		{
			return true;
		}
		return false;
	}
	
	public static boolean isRight(int shortest, int middle, int longest)
	{
		if((shortest * shortest) + (middle * middle) == (longest * longest))
		{
			return true;
		}
		return false;
	}
}
