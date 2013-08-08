package assignment4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Braeden Bodily
 * Julian Whitteron
 * 
 *  
 */
public class SortUtil 
{	
	private static int threshold = 4;
	
	/**
	 * Helper insertion sort method.  
	 * @param arr - input ArrayList of objects
	 * @param left - start of the subarray 
	 * @param right - end of the subarray
	 */
	

	private static <T extends Comparable<? super T>> void insertionsort(ArrayList<T> arr, int left, int right)
	{
		for(int i = left+1; i <= right; i++)
		{
			T val = arr.get(i);

			int j;
			for(j = i-1; (j >= left) && (arr.get(j).compareTo(val)) > 0; j--)
			{
				arr.set(j+1,arr.get(j)) ;
			}
			arr.set(j+1, val);
		}
	}
	
	/**
	 * MergSort algorithm driver.
	 * @param arr - input ArrayList of objects
	 * @throws Exception 
	 */
	public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> arr) throws Exception
	{
		//If the size of the list is 0, will throw an exception.
		if (arr.size() == 0)
			 throw new NoSuchElementException();
		
		
		//Creates the temp arraylist, same size as arr, to send to the recursive, as well as the left and right end values.
		ArrayList<T> temp = new ArrayList<T>();
		
		int	left = 0;
		int right = arr.size()-1;
		for(int x = left; x <= right; x++)
			temp.add(arr.get(x));
		
		mergesort(arr,temp,left,right);
	}

	/**
	 * Main mergeSort method. Makes recursive calls. 
	 * @param arr - input ArrayList of objects
	 * @param temp - temporary ArrayList to hold the merged result 
	 * @param left - start of the subarray 
	 * @param right - end of the subarray
	 */
	private static <T extends Comparable<? super T>> void mergesort(ArrayList<T> arr, ArrayList<T> temp, int left, int right)
	{
		
		//If the size of the array list is less than or equal to threshold then insertionsort is executed.
		if ( (right-left)<= threshold)
			insertionsort(temp,left,right);
		else
		{
			int midPoint = (left+right)/2;
			
			
			//Left sort
			mergesort(arr,temp,left,midPoint);
			
			//Right sort
			mergesort(arr,temp,midPoint+1,right);
			//Sends arr and temp to merge
			merge(arr,temp,left,right);
		}
	}

	/**
	 * Internal method for merging two sorted subarrays
	 * @param arr - input ArrayList of objects
	 * @param temp - temporary ArrayList in  which the result with be placed
	 * @param left - start of the subarray 
	 * @param right - end of the subarray
	 */
	private static <T extends Comparable<? super T>> void merge(ArrayList<T> arr, ArrayList<T> temp, int left, int right)
	{
		
		int midPoint = (left+right)/2;
		// Begin linear merge sort with 2 subarrays within the given left and right constraints.
		int i = left;
		int j = midPoint + 1;
		
		// Create a pointer for where to fill arr.
		int arrPointer = left;
		
		
		// While the subarrays have not reached the end, continue to sort them.
		while (i <= midPoint || j <= right)
		{

			// If j has reached the end but i hasn't fill the rest of i into arr.
			if (i <= midPoint && j > right)
			{
				arr.set(arrPointer, temp.get(i));
				i++;
				arrPointer++;
				continue;
			}
			// If i has reached the end but j hasn't fill the rest of j into arr.
			if (i > midPoint && j <= right)
			{
				arr.set(arrPointer, temp.get(j));
				j++;
				arrPointer++;
				continue;
			}
			// if i < j add i to arr
			if (temp.get(i).compareTo(temp.get(j)) < 0)
			{
				arr.set(arrPointer, temp.get(i));
				i++;
				arrPointer++;
				continue;
			}
			// if i > j add j to arr
			else if (temp.get(i).compareTo(temp.get(j)) > 0)
			{
				arr.set(arrPointer, temp.get(j));
				j++;
				arrPointer++;
				continue;
			}
			// Otherwise they are equal and add both.
			else
			{
				arr.set(arrPointer, temp.get(i));
				i++;
				arrPointer++;
				arr.set(arrPointer, temp.get(j));
				j++;
				arrPointer++;
				continue;
			}
		}
		for (int x = left;x <= right;x++)
			temp.set(x, arr.get(x));
	}
	
	/**
	 * Quicksort algorithm driver
	 * @param arr - input ArrayList of objects
	 */
	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> arr)
	{
		if (arr.size() == 0)
			 throw new NoSuchElementException();
		int	left = 0;
		int right = arr.size()-1;
	
		quicksort(arr,left,right);
	}

	/**
	 * Main quicksort method. Makes recursive calls. 
	 * @param arr - input ArrayList of objects. 
	 * @param left - start of the subarray 
	 * @param right - end of the subarray
	 */
	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> arr, int left, int right)
	{
		if (left < right)
		{	
			int pivot = pivotStrategy1(arr,left,right);
			int R = right-1;
			int L = left;
			// Put the pivot at the end of the subarray.
			swap(arr,right,pivot);
			T pivotObject = arr.get(right);
			
			// Create a midpoint integer for where to split off for recursive quicksorts
			int midpoint = right;
			
			while (L < R)
			{							
				// If R is greater than or equal to the pivot, move R to the left by 1.
				if ((arr.get(R).compareTo(pivotObject) >= 0))
				{
					midpoint = R;
					R--;
				}
				// If both the L and R are less than the pivot, move the L to the right by 1.
				else if ((arr.get(L).compareTo(pivotObject) < 0) && (arr.get(R).compareTo(pivotObject) < 0))
					L++;

				else if (arr.get(L).compareTo(pivotObject) >= 0 && (arr.get(R).compareTo(pivotObject) < 0))
				{
					swap(arr,L,R);
					midpoint = R;
					L++;
					R--;
				}				
			}
						
			// if R changed and R is greater than or equal to pivot object, set midpoint equal to this R
			if (arr.get(R).compareTo(pivotObject) >= 0)
				midpoint = R;
			
			// Swap midpoint with the right pivot object.
			swap(arr, midpoint, right);
			
			// Quicksort right if needed.
			quicksort(arr, left, midpoint);
				
			// Quicksort left if needed.
			quicksort(arr, midpoint + 1, right);	
		}
		
	}

	/**
	 * First pivot strategy
	 * Takes 3 random numbers, assigns those values as indices and returns the median value of the three as the pivot.
	 * @param arr - input ArrayList of objects.
	 * @param left - start of the subarray 
	 * @param right - end of the subarray
	 * @return index of chosen pivot
	 */
	public static <T extends Comparable<? super T>> int pivotStrategy1(ArrayList<T> arr, int left, int right)
	{
		//3 pivot candidates and the actual pivot variable to be used
		int size = right-left+1;
		int pivot1 = left + (int) (Math.random()*size);
		int pivot2= left + (int) (Math.random()*size);
		int pivot3 = left + (int)(Math.random()*size);
		
		//Creates an arraylist to put the candidates in and sorts them. Followed by grabbing the middle value.
		ArrayList<T> pivots = new ArrayList<T>();
		pivots.add(arr.get(pivot1));
		pivots.add(arr.get(pivot2));
		pivots.add(arr.get(pivot3));
		insertionsort(pivots,0,2);
		
		T medObject = pivots.get(1);
		
		// Determine which index contained the median object
		if (arr.get(pivot1).equals(medObject))
			return pivot1;
		if (arr.get(pivot2).equals(medObject))
			return pivot2;
		if (arr.get(pivot3).equals(medObject))
			return pivot3;
		return left;
		
		
	}
	
	/**
	 * Second pivot strategy
	 * Returns a simple random number.
	 * @param arr - input ArrayList of objects.
	 * @param left - start of the subarray 
	 * @param right - end of the subarray
	 * @return index of chosen pivot
	 */
	public static <T extends Comparable<? super T>> int pivotStrategy2(ArrayList<T> arr, int left, int right)
	{
		int size = right - left + 1;
		return left + (int) (Math.random()*size);
	}
	
	/**
	 * Third pivot strategy
	 * Takes a value half of the size of the array, roughly equaling the center.
	 * @param arr - input ArrayList of objects.
	 * @param left - start of the subarray 
	 * @param right - end of the subarray
	 * @return index of chosen pivot 
	 */
	public static <T extends Comparable<? super T>> int pivotStrategy3(ArrayList<T> arr, int left, int right)
	{
		
		return (left + right)/2;
	}


	/**
	 * Generates the BestCase (ascending sorted ArrayList) for input into sorting algorithms.
	 * @param size size of the returned ArrayList
	 * @return an ArrayList of integers in sorted, ascending order. 
	 */
	public static ArrayList<Integer> generateBestCase(int size)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		//Creates an arraylist in ascending order
		for (int i = 0; i < size; i++)
			temp.add(i);
		
		return temp;
	}

	/**
	 * Generates the AverageCase (permuted ArrayList) for input into sorting algorithms. 
	 * @param size the size of the returned ArrayList
	 * @return An ArrayList of random integers from 0-size in permuted order
	 */
	public static ArrayList<Integer> generateAverageCase(int size)
	{
		Random rand = new Random();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		//Creates an arraylist in ascending order.
		for (int i = 0; i < size; i++)
//			temp.add(rand.nextInt(size));
			temp.add(i);
		for (int i = 0; i < size; i++)
			swap(temp, i, (int)(Math.random() * size));
		return temp;	
	}

	/**
	 * Generates a WorstCase (descending sorted ArrayList) for input into sorting algorithms. 
	 * @param size the size of the returned ArrayList
	 * @return An ArrayList of integers in descending order
	 */
	public static ArrayList<Integer> generateWorstCase(int size)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		//Creates an arraylist in descending order.
		for(int i = size-1; i >= 0; i--)
			temp.add(i);
		return temp;
	}	
	/**
	 * Swap method that swaps two indexes represented by the 2 ints sent in.
	 * @param arr
	 * @param index1
	 * @param index2
	 */
	public static <T extends Comparable<? super T>>  void swap (ArrayList<T> arr,int index1, int index2)
	{
		T temp = arr.get(index1);
		arr.set(index1,arr.get(index2));
		arr.set(index2,temp);
	}
	
	public static void setThreshold(int i)
	{
		threshold = i;
	}
}
