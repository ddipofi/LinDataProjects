public class Tester
{
	static long perms; // How many permutations did we identify?
	static int size; // What's the size of the set we're permuting (the first "size" elements of A)
	static String format = "%-11s %d permutations in %15.10f seconds (%9d permutations / second)\n";

	public static void main(String[] args)
	{
		long time; // What time did we start this test?
		double elapsed; // What was the elapsed time for all repetitions of this test (in seconds)?

		long reps = 10000; // How many repetitions to run (to average out variation)
		size = 5; // How large is the set we're permuting?

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
				generate01a(A);
				break;
			}
			case 2:
			{
				generate02a(A);
				break;
			}
			case 3:
			{
				generate03a(A);
				break;
			}
			case 4:
			{
				generate04a(A);
				break;
			}
			case 5:
			{
				generate05a(A);
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
			case 12:
			{
				//generate12(A);
				break;
			}
			case 13:
			{
				//generate13(A);
				break;
			}
			}
		}
		elapsed = ((System.nanoTime() - time) / 1000000000.0 / reps);
		System.out.printf(format, "Naive for", perms / reps, elapsed, (long) (perms / elapsed / reps));
	} // end main
	
	public static void generate01a(int[] A)
	{
		perms++;
	}

	public static void generate02a(int[] A)
	{
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 2; j++)
				if (i != j)
				{
					perms++;
				}
	}

	public static void generate03a(int[] A)
	{
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (i != j)
					for (int k = 0; k < 3; k++)
						if (i != k && j != k)
						{
							perms++;
						}
	}

	public static void generate04a(int[] A)
	{
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				if (i != j)
					for (int k = 0; k < 4; k++)
						if (i != k && j != k)
							for (int l = 0; l < 4; l++)
								if (i != l && j != l && k != l)
								{
									perms++;
								}
	}

	public static void generate05a(int[] A)
	{
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				if (i != j)
					for (int k = 0; k < 5; k++)
						if(i != k && j != k)
							for (int l = 0; l < 5; l++)
								if(i != l && j != l && k != l)
									for (int m = 0; m < 5; m++)
										if (i != m && j != m && k != m && l != m)
										{
											perms++;
										}
	}

	public static void generate06(int[] A)
	{
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 6; j++)
				for (int k = 0; k < 6; k++)
					for (int l = 0; l < 6; l++)
						for (int m = 0; m < 6; m++)
							for (int n = 0; n < 6; n++)
								if (i != j && i != k && i != l && i != m && i != n && 
								j != k && j != l && j != m && j != n && 
								k != l && k != m && k != n && 
								l != m && l != n && 
								m != n)
								{
									perms++;
									//System.out.println(A[i] + " " + A[j] + " " + A[k] + " " + A[l] + " " + A[m] + " " + A[n]);
								}
	}
	
	public static void generate07(int[] A)
	{
		for (int i = 0; i < 7; i++)
			for (int j = 0; j < 7; j++)
				for (int k = 0; k < 7; k++)
					for (int l = 0; l < 7; l++)
						for (int m = 0; m < 7; m++)
							for (int n = 0; n < 7; n++)
								for (int o = 0; o < 7; o++)
									if (i != j && i != k && i != l && i != m && i != n && i != o && 
									j != k && j != l && j != m && j != n && j != o && 
									k != l && k != m && k != n && k != o && 
									l != m && l != n && l != o && 
									m != n && m != o && 
									n != o)
									{
										perms++;
										//System.out.println(A[i] + " " + A[j] + " " + A[k] + " " + A[l] + " " + A[m] + " " + A[n] + " " + A[o]);
									}
	}
	
	public static void generate08(int[] A)
	{
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++)
				for (int k = 0; k < 8; k++)
					for (int l = 0; l < 8; l++)
						for (int m = 0; m < 8; m++)
							for (int n = 0; n < 8; n++)
								for (int o = 0; o < 8; o++)
									for (int p = 0; p < 8; p++)
										if (i != j && i != k && i != l && i != m && i != n && i != o && i != p && 
										j != k && j != l && j != m && j != n && j != o && j != p && 
										k != l && k != m && k != n && k != o && k != p && 
										l != m && l != n && l != o && l != p && 
										m != n && m != o && m != p && 
										n != o && n != p && 
										o != p)
										{
											perms++;
											//System.out.println(A[i] + " " + A[j] + " " + A[k] + " " + A[l] + " " + A[m] + " " + A[n] + " " + A[o] + " " + A[p]);
										}
	}
	
	public static void generate09(int[] A)
	{
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				for (int k = 0; k < 9; k++)
					for (int l = 0; l < 9; l++)
						for (int m = 0; m < 9; m++)
							for (int n = 0; n < 9; n++)
								for (int o = 0; o < 9; o++)
									for (int p = 0; p < 9; p++)
										for (int q = 0; q < 9; q++)
											if (i != j && i != k && i != l && i != m && i != n && i != o && i != p && i != q && 
											j != k && j != l && j != m && j != n && j != o && j != p && j != q && 
											k != l && k != m && k != n && k != o && k != p && k != q &&
											l != m && l != n && l != o && l != p && l != q &&
											m != n && m != o && m != p && m != q && 
											n != o && n != p && n != q && 
											o != p && o != q &&
											p != q)
											{
												perms++;
												//System.out.println(A[i] + " " + A[j] + " " + A[k] + " " + A[l] + " " + A[m] + " " + A[n] + " " + A[o] + " " + A[p] + " " + A[q]);
											}
	}
	
	public static void generate10(int[] A)
	{
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				for (int k = 0; k < 10; k++)
					for (int l = 0; l < 10; l++)
						for (int m = 0; m < 10; m++)
							for (int n = 0; n < 10; n++)
								for (int o = 0; o < 10; o++)
									for (int p = 0; p < 10; p++)
										for (int q = 0; q < 10; q++)
											for (int r = 0; r < 10; r++)
												if (i != j && i != k && i != l && i != m && i != n && i != o && i != p && i != q && i != r &&
												j != k && j != l && j != m && j != n && j != o && j != p && j != q && j != r && 
												k != l && k != m && k != n && k != o && k != p && k != q && k != r && 
												l != m && l != n && l != o && l != p && l != q && l != r && 
												m != n && m != o && m != p && m != q && m != r && 
												n != o && n != p && n != q && n != r && 
												o != p && o != q && o != r && 
												p != q && p != r &&
												q != r)
												{
													perms++;
													//System.out.println(A[i] + " " + A[j] + " " + A[k] + " " + A[l] + " " + A[m] + " " + A[n] + " " + A[o] + " " + A[p] + " " + A[q] + " " + A[r]);
												}
	}
	
	public static void generate11(int[] A)
	{
		for (int i = 0; i < 11; i++)
			for (int j = 0; j < 11; j++)
				for (int k = 0; k < 11; k++)
					for (int l = 0; l < 11; l++)
						for (int m = 0; m < 11; m++)
							for (int n = 0; n < 11; n++)
								for (int o = 0; o < 11; o++)
									for (int p = 0; p < 11; p++)
										for (int q = 0; q < 11; q++)
											for (int r = 0; r < 11; r++)
												for (int s = 0; s < 11; s++)
													if (i != j && i != k && i != l && i != m && i != n && i != o && i != p && i != q && i != r && i != s && 
													j != k && j != l && j != m && j != n && j != o && j != p && j != q && j != r && j != s && 
													k != l && k != m && k != n && k != o && k != p && k != q && k != r && k != s && 
													l != m && l != n && l != o && l != p && l != q && l != r && l != s && 
													m != n && m != o && m != p && m != q && m != r && m != s && 
													n != o && n != p && n != q && n != r && n != s && 
													o != p && o != q && o != r && o != s && 
													p != r && p != s && 
													r != s)
													{
														perms++;
														//System.out.println(A[i] + " " + A[j] + " " + A[k] + " " + A[l] + " " + A[m] + " " + A[n] + " " + A[o] + " " + A[p] + " " + A[q] + " " + A[r] + " " + A[s]);
													}
	}
} // end class