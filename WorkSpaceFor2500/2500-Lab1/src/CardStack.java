/*
 * make separate class for OSV if possible
 * at least make new method so there aren't 5000 cases in the switch statements
 */

import java.util.Scanner;

public class CardStack
{
	public static void main(String[] args)
	{
		Scanner userInput = new Scanner(System.in);
//		int n = userInput.nextInt();
//		int m = userInput.nextInt();
		
		String OSV = userInput.nextLine();
		
	}
	
	public static boolean ValidateOSV(String OSV)
	{
		boolean valid = false;
		boolean OValid = false;
		boolean SValid = false;
		boolean VValid = false;
		
		if (OSV.charAt(0) == 'U' || OSV.charAt(0) == 'u' || OSV.charAt(0) == 'D' || OSV.charAt(0) == 'd')
		{
			OValid = true;
		}
		if (OSV.charAt(0) == 'C' || OSV.charAt(0) == 'c' || OSV.charAt(0) == 'D' || OSV.charAt(0) == 'd' || OSV.charAt(0) == 'H' || OSV.charAt(0) == 'h' || OSV.charAt(0) == 'S' || OSV.charAt(0) == 's')
		{
			SValid = true;
		}
		//TODO VValid if statement
		if (OValid == true && SValid == true && VValid == true)
		{
			valid = true;
		}
		
		return valid;
	}
	
	public static int OSVtoInt(String OSV)
	{
		int OSVInt = 0;
		char S = OSV.charAt(1);
		char V = OSV.charAt(2);
		
		switch (S)
		{
			case 'C':
				break;
			case 'c':
				break;
			case 'D':
				OSVInt += 13;
				break;
			case 'd':
				OSVInt += 13;
				break;	
			case 'H':
				OSVInt += 26;
				break;
			case 'h':
				OSVInt += 26;
				break;
			case 'S':
				OSVInt += 39;
				break;
			case 's':
				OSVInt += 39;
				break;
			default:
				break;
		}
		
		if (V != 'T' && V != 'J' && V != 'Q' && V != 'K' && V != 'A' && V != 't' && V != 'j' && V != 'q' && V != 'k' && V != 'a')
		{
			int VInt = V - '0';
			
			OSVInt += VInt;
		}
		else
		{
			switch (V)
			{
				case 'T':
					OSVInt += 10;
					break;
				case 't':
					OSVInt += 10;
					break;
				case 'J':
					OSVInt += 11;
					break;
				case 'j':
					OSVInt += 11;
					break;
				case 'Q':
					OSVInt += 12;
					break;
				case 'q':
					OSVInt += 12;
					break;
				case 'K':
					OSVInt += 13;
					break;
				case 'k':
					OSVInt += 13;
					break;
				case 'A':
					OSVInt += 1;
					break;
				case 'a':
					OSVInt += 1;
					break;
				default:
					break;
			}
		}
		
		if (OSV.charAt(0) != 'U' && OSV.charAt(0) != 'u')
		{
			OSVInt *= -1;
		}
		
		return OSVInt;
	}
}