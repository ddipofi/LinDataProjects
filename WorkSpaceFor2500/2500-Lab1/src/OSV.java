
public class OSV
{
	public OSV()
	{
		
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
	
	public static int OSVToInt(String OSV)
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
	
	public static String IntToSV(int value)
	{
		String OSVString = "";
		
		if (value < 0)
		{
			value *= -1;
		}		
		
		switch (value)
		{
			case 1:
				OSVString = "CA";
				break;
			case 2:
				OSVString = "C2";
				break;
			case 3:
				OSVString = "C3";
				break;
			case 4:
				OSVString = "C4";
				break;
			case 5:
				OSVString = "C5";
				break;
			case 6:
				OSVString = "C6";
				break;
			case 7:
				OSVString = "C7";
				break;
			case 8:
				OSVString = "C8";
				break;
			case 9:
				OSVString = "C9";
				break;
			case 10:
				OSVString = "CT";
				break;
			case 11:
				OSVString = "CJ";
				break;
			case 12:
				OSVString = "CQ";
				break;
			case 13:
				OSVString = "CK";
				break;
			case 14:
				OSVString = "DA";
				break;
			case 15:
				OSVString = "D2";
				break;
			case 16:
				OSVString = "D3";
				break;
			case 17:
				OSVString = "D4";
				break;
			case 18:
				OSVString = "D5";
				break;
			case 19:
				OSVString = "D6";
				break;
			case 20:
				OSVString = "D7";
				break;
			case 21:
				OSVString = "D8";
				break;
			case 22:
				OSVString = "D9";
				break;
			case 23:
				OSVString = "DT";
				break;
			case 24:
				OSVString = "DJ";
				break;
			case 25:
				OSVString = "DQ";
				break;
			case 26:
				OSVString = "DK";
				break;
			case 27:
				OSVString = "HA";
				break;
			case 28:
				OSVString = "H2";
				break;
			case 29:
				OSVString = "H3";
				break;
			case 30:
				OSVString = "H4";
				break;
			case 31:
				OSVString = "H5";
				break;
			case 32:
				OSVString = "H6";
				break;
			case 33:
				OSVString = "H7";
				break;
			case 34:
				OSVString = "H8";
				break;
			case 35:
				OSVString = "H9";
				break;
			case 36:
				OSVString = "HT";
				break;
			case 37:
				OSVString = "HJ";
				break;
			case 38:
				OSVString = "HQ";
				break;
			case 39:
				OSVString = "HK";
				break;
			case 40:
				OSVString = "SA";
				break;
			case 41:
				OSVString = "S2";
				break;
			case 42:
				OSVString = "S3";
				break;
			case 43:
				OSVString = "S4";
				break;
			case 44:
				OSVString = "S5";
				break;
			case 45:
				OSVString = "S6";
				break;
			case 46:
				OSVString = "S7";
				break;
			case 47:
				OSVString = "S8";
				break;
			case 48:
				OSVString = "S9";
				break;
			case 49:
				OSVString = "ST";
				break;
			case 50:
				OSVString = "SJ";
				break;
			case 51:
				OSVString = "SQ";
				break;
			case 52:
				OSVString = "SK";
				break;
			default:
				break;
		}
		
		return OSVString;
	}
}
