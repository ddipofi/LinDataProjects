public class Tester
{
	static long perms; // How many permutations did we identify?
	static int size; // What's the size of the set we're permuting (the first "size" elements of A)
	static String format = "%-11s %d permutations in %15.10f seconds (%9d permutations / second)\n";

	public static void main(String[] args)
	{
		long time; // What time did we start this test?
		double elapsed; // What was the elapsed time for all repetitions of this test (in seconds)?

		long reps = 10; // How many repetitions to run (to average out variation)
		size = 10; // How large is the set we're permuting?

		long fact = 1;
		for (int i = size; i > 1; fact *= i--)
			; // compute size!
		System.out.println("Size: " + size + " (" + size + "! = " + fact + ")"); // Output size & target count

		perms = 0; // We've not generated any permutations yet
		time = System.nanoTime(); // mark the start time
		for (int times = 1; times <= reps; times++) // repeat test, to average out variations in run time
		{
			int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
			switch (size)
			{
			case 1:
			{
				generate01(A);
				break;
			}
			case 2:
			{
				generate02(A);
				break;
			}
			case 3:
			{
				generate03(A);
				break;
			}
			case 4:
			{
				generate04(A);
				break;
			}
			case 5:
			{
				generate05(A);
				break;
			}
			case 6:
			{
				generate06(A);
				break;
			}
			case 7:
			{
				generate07(A);
				break;
			}
			case 8:
			{
				generate08(A);
				break;
			}
			case 9:
			{
				generate09(A);
				break;
			}
			case 10:
			{
				generate10(A);
				break;
			}
			case 11:
			{
				generate11(A);
				break;
			}
			}
		}
		elapsed = ((System.nanoTime() - time) / 1000000000.0 / reps);
		System.out.printf(format, "Naive for", perms / reps, elapsed, (long) (perms / elapsed / reps));
	} // end main
	
	public static void generate01(int[] A)
	{
		perms++;
		System.out.println(A[0]);
	}

	public static void generate02(int[] A)
	{
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 2; j++)
				if (i != j)
				{
					perms++;
					System.out.println(A[i] + " " + A[j]);
				}
	}

	public static void generate03(int[] A)
	{
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				for (int k = 0; k < 3; k++)
					if (i != j && i != k && j != k)
					{
						perms++;
						System.out.println(A[i] + " " + A[j] + " " + A[k]);
					}
	}

	public static void generate04(int[] A)
	{
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				for (int k = 0; k < 4; k++)
					for (int l = 0; l < 4; l++)
						if (i != j && i != k && i != l && j != k && j != l && k != l)
						{
							perms++;
							System.out.println(A[i] + " " + A[j] + " " + A[k] + " " + A[l]);
						}
	}

	public static void generate05(int[] A)
	{
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				for (int k = 0; k < 5; k++)
					for (int l = 0; l < 5; l++)
						for (int m = 0; m < 5; m++)
							if (i != j && i != k && i != l && i != m && j != k && j != l && j != m && k != l && k != m && l != m)
							{
								perms++;
								System.out.println(A[i] + " " + A[j] + " " + A[k] + " " + A[l] + " " + A[m]);
							}
	}

	public static void generate11(int[] A)
	{
		for (int i = 0; i < 11; i++)
			for (int j = 0; j < 11; j++)
				for (int k = 0; k < 11; k++)
					for (int l = 0; l < 11; l++)
						for (int m = 0; l < 11; l++)
							for (int n = 0; l < 11; l++)
								for (int o = 0; l < 11; l++)
									for (int p = 0; l < 11; l++)
										for (int q = 0; l < 11; l++)
											for (int r = 0; l < 11; l++)
												for (int s = 0; l < 11; l++)
													if (i != j && i != k && i != l && i != m && i != n && i != o && i != p && i != q && i != r && i != s && j != k && j != l && j != m && j != n && j != o && j != p && j != q && j != r && j != s && k != l && k != m && k != n && k != o && k != p && k != q && k != r && k != s && l != m && l != n && l != o && l != p && l != q && l != r && l != s && m != n && m != o && m != p && m != q && m != r && m != s && n != o && n != p && n != q && n != r && n != s && o != p && o != q && o != r && o != s && p != r && p != s && r != s)
													{
														perms++;
														System.out.println(A[i] + " " + A[j] + " " + A[k] + " " + A[l]);
													}
	}
} // end class