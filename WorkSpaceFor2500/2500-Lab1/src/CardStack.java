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
		int n = userInput.nextInt();
		int m = userInput.nextInt();
		
		for (int i = 1; i <= n * m; i++)
		{
			String OSVString = userInput.nextLine();
			ValidateOSV(OSVString);
			int OSVInt = OSVtoInt(OSVString);
			//add OSVInt to array or node or stack or whatever
		}
		
		for (int i = 1; i <= n + m - 2; i++)
		{
			String flipString = userInput.nextLine();
			//add flipString to array or something to keep track
		}
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
		if (OSV.charAt(1) == 'C' || OSV.charAt(1) == 'c' || OSV.charAt(1) == 'D' || OSV.charAt(1) == 'd' || OSV.charAt(1) == 'H' || OSV.charAt(1) == 'h' || OSV.charAt(1) == 'S' || OSV.charAt(1) == 's')
		{
			SValid = true;
		}
		if (OSV.charAt(2) == '2' || OSV.charAt(2) == '3' || OSV.charAt(2) == '4' || OSV.charAt(2) == '5' || OSV.charAt(2) == '6' || OSV.charAt(2) == '7' || OSV.charAt(2) == '8' || OSV.charAt(2) == '9' || OSV.charAt(2) == 'T' || OSV.charAt(2) == 't' || OSV.charAt(2) == 'J' || OSV.charAt(2) == 'j' || OSV.charAt(2) == 'Q' || OSV.charAt(2) == 'q' || OSV.charAt(2) == 'K' || OSV.charAt(2) == 'k' || OSV.charAt(2) == 'A' || OSV.charAt(2) == 'a')
		{
			VValid = true;
		}
		
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