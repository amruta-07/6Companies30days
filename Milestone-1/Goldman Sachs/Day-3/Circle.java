Distributing M items in a circle of size N starting from K-th position

M items are to be delivered in a circle of size N. Find the position where the M-th item will be delivered if we start from a given position K. Note that items are distributed at adjacent positions starting from K.
Examples : 
 

Input : N = 5 // Size of circle
        M = 2 // Number of items
        K = 1 // Starting position
Output : 2
The first item will be given to 1st 
position. Second (or last) item will 
be delivered to 2nd position

Input : N = 5 
        M = 8 
        K = 2
Output : 4
The last item will be delivered to 
4th position


Code:-

// Java program to find the position where
// last item is delivered.
class Circle{

	// n ==> Size of circle
	// m ==> Number of items
	// k ==> Initial position
	static int lastPosition(int n, int m, int k)
	{

		// n - k + 1 is number of positions
		// before we reach beginning of circle
		// If m is less than this value, then
		// we can simply return (m-1)th position
		if (m <= n - k + 1)
			return m + k - 1;

		// Let us compute remaining items before
		// we reach beginning.
		m = m - (n - k + 1);

		// We compute m % n to skip all complete
		// rounds. If we reach end, we return n
		// else we return m % n
		return (m % n == 0) ? n : (m % n);
	}

	// Driver Program to test above function
	public static void main(String arg[])
	{
		int n = 5;
		int m = 8;
		int k = 2;
		System.out.print(lastPosition(n, m, k));
	}
}


