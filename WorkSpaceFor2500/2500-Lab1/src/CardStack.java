
import java.util.Scanner;

public class CardStack
{
	public static void main(String[] args)
	{
		Scanner userInput = new Scanner(System.in);
		
		//should be in loop for as many tests as there are
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
							var card = cards[T][j].top();
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
							var card = cards[B][j].top();
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
							var card = cards[j][L].top();
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
							var card = cards[j][R].top();
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
		
		
		
		userInput.close();
	}
}