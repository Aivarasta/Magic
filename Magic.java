// Java Program to check if a number is cyclic 

class GFG { 
	// Function to generate all cyclic aka Magic
	// permutations of a number 
	static boolean isMagic(long N) 
	{ 
		// Count digits and check if all 
		// digits are same 
		long num = N; 
		int count = 0; 
		int digit = (int)(num % 10); 
		boolean allSame = true; 
		while (num > 0) { 
			count++; 
			if (num % 10 != digit) 
				allSame = false; 
			num = num / 10; 
		} 

		// If all digits are same, then 
		// not considered Magic. 
		if (allSame == true) 
			return false; 

		// If counts of digits is even and 
		// two halves are same, then the 
		// number is not considered Magic. 
		if (count % 2 == 0) { 
			long halfPower = (long)Math.pow(10, count / 2); 
			long firstHalf = N % halfPower; 
			long secondHalf = N / halfPower; 
			if (firstHalf == firstHalf && isMagic(firstHalf)) 
				return false; 
		} 

		num = N; 
		while (true) { 
			// Following three lines generates a 
			// circular pirmutation of a number. 
			long rem = num % 10; 
			long div = num / 10; 
			num = (long)(Math.pow(10, count - 1)) 
					* rem 
				+ div; 

			// If all the permutations are checked 
			// and we obtain original number exit 
			// from loop. 
			if (num == N) 
				break; 

			if (num % N != 0) 
				return false; 
		} 

		return true; 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		long N = 142857; 
		if (isMagic(N)) 
			System.out.print("It's magic!"); 
		else
			System.out.print("No"); 
	} 
} 

// This code is contributed by Anant Agarwal. 
