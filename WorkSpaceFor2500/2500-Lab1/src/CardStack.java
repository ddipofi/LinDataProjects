
import java.util.Scanner;

//TODO figure out scanner input issues
//TODO clean up and comment code
//TODO test more
public class CardStack
{
	public static void main(String[] args)
	{
		Scanner userInput = new Scanner(System.in);
		
		//TODO should be in loop for as many tests as there are
		int n = userInput.nextInt();
		int m = userInput.nextInt();
		int T = 0;
		int B = n - 1;
		int L = 0;
		int R = m - 1;
		userInput.nextLine();
		@SuppressWarnings("unchecked")
		LLStack<Integer>[][] cards = new LLStack[n][m];
		
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				String OSVString = userInput.nextLine();
				OSV.ValidateOSV(OSVString);
				int OSVInt = OSV.OSVToInt(OSVString);
				cards[i][j] = new LLStack();
				cards[i][j].push(OSVInt);
			}
		}
		
		for (int i = 0; i < n + m - 2; i++)
		{
			char flipChar = userInput.next().charAt(0);
			flipChar = Character.toUpperCase(flipChar);
			
			switch (flipChar)
			{
				case 'T':
					for (int j = L; j <= R; j++)
					{
						while (!cards[T][j].isEmpty())
						{
							int card = cards[T][j].top();
							card *= -1;
							cards[T+1][j].push(card);
							cards[T][j].pop();
						}	
					}
					T += 1;
					break;
				case 'B':
					for (int j = L; j <= R; j++)
					{
						while (!cards[B][j].isEmpty())
						{
							int card = cards[B][j].top();
							card *= -1;
							cards[B-1][j].push(card);
							cards[B][j].pop();
						}	
					}
					B -= 1;
					break;
				case 'L':
					for (int j = T; j <= B; j++)
					{
						while (!cards[j][L].isEmpty())
						{
							int card = cards[j][L].top();
							card *= -1;
							cards[j][L+1].push(card);
							cards[j][L].pop();
						}
					}
					L += 1;
					break;
				case 'R':
					for (int j = T; j <= B; j++)
					{
						while (!cards[j][R].isEmpty())
						{
							int card = cards[j][R].top();
							card *= -1;
							cards[j][R-1].push(card);
							cards[j][R].pop();
						}
					}
					R -= 1;
					break;
				default:
					break;
			}
		}
		
		@SuppressWarnings("unchecked")
		LLStack<Integer>[][] results = new LLStack[1][1];
		results[0][0] = new LLStack();
		
		while (!cards[T][L].isEmpty())
		{
			int card = cards[T][L].top();
			
			if (card < 0)
			{
				results[0][0].push(card);
			}
			
			cards[T][L].pop();
		}
		
		//OUTPUT
		System.out.print("Test " + "1" + ": ");
		while (!results[0][0].isEmpty())
		{
			int card = results[0][0].top();
			String SV = OSV.IntToSV(card);
			System.out.print(SV + " ");
			results[0][0].pop();
		}
		
		userInput.close();
	}
}