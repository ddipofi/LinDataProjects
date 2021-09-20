/*
 * make separate class for OSV if possible
 * at least make new method so there aren't 5000 cases in the switch statements
 */

import java.util.Scanner;

public class CardStack
{
	static int OSVInt = 0;
	
	public static void main(String[] args)
	{
		Scanner userInput = new Scanner(System.in);
//		int n = userInput.nextInt();
//		int m = userInput.nextInt();
		
		String OSVValue = userInput.nextLine();
		
		OSVtoInt(OSVValue);
		System.out.println(OSVInt);
	}
	
	public static boolean ValidateOSV(String OSV)
	{
		return false;
	}
	
	public static int OSVtoInt(String OSV)
	{
		int OSVIntt = 0;
		char S = OSV.charAt(1);
		char V = OSV.charAt(2);
		
		switch (S)
		{
			case 'C':
				break;
			case 'D':
				OSVInt += 13;
				break;
			case 'H':
				OSVInt += 26;
				break;
			case 'S':
				OSVInt += 39;
				break;
			default:
				break;
		}
		
		if (V != 'T' && V != 'J' && V != 'Q' && V != 'K' && V != 'A')
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
				case 'J':
					OSVInt += 11;
					break;
				case 'Q':
					OSVInt += 12;
					break;
				case 'K':
					OSVInt += 13;
					break;
				case 'A':
					OSVInt += 1;
					break;
				default:
					break;
			}
		}
		
		if (OSV.charAt(0) != 'U')
		{
			OSVInt *= -1;
		}
		
		return OSVInt;
	}
}