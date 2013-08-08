package assignment4;

import java.util.ArrayList;

public class TimeSortUtil 
{

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception
	{
		// Testing amounts
		int timesToLoop = 100;
		long startTime = 0;
		int arraySize = 100;
		long midTime = 0;
		long endTime = 0;
		
		ArrayList<Long> merge = new ArrayList<Long>();
		ArrayList<Long> quick = new ArrayList<Long>();
		
	//////////////////////////////TEST MERGESORT//////////////////////////////////////////////	

		
		for (arraySize = 1000; arraySize <= 50000; arraySize+=1000)
		{
			System.out.println(arraySize);
			ArrayList<Integer> test = SortUtil.generateBestCase(arraySize);
			ArrayList<Integer> testCopy = new ArrayList<Integer>();
		//Test threshold for set values.
//		for (int i = 5; i < 13; i++)
//		{
			//Add the values for each arraysize value to an array so we can print out the list together to copy and paste into excel.
			ArrayList<Long> mergeSortTime = new ArrayList<Long>();
			for (int j = 0; j < timesToLoop; j++)
			{
				// Create a copy of the test array to sort.
				testCopy = new ArrayList<Integer>();
				testCopy.addAll(test);
				
				// Set the threshold.
				SortUtil.setThreshold(15);
				
				// Record time for mergesort
				startTime = System.nanoTime();
				SortUtil.mergesort(testCopy);
				endTime = System.nanoTime();
				// Add the time to mergeSortTime
				mergeSortTime.add(endTime - startTime);
			}
			
			long sum = 0;
			// Get the sum of all the times for mergeSortTime
			for (int k = 0; k < mergeSortTime.size(); k++)
				sum = sum + mergeSortTime.get(k);		
			// Get the average time
			merge.add(sum / mergeSortTime.size());
			
			
			
	//		sum = 0;
			// Get the sum of all the times for thresholdZero
//			for (int k = 0; k < thresholdZero.size(); k++)
//				sum = sum + thresholdZero.get(k);
			//System.out.println(sum / thresholdZero.size());
//				
//		}
		

		
		
		
	//////////////////////////////TEST QUICKSORT//////////////////////////////////////////////
		ArrayList<Long> quicksortTime = new ArrayList<Long>();
		for (int j = 0; j < timesToLoop; j++)
		{
			// Create a copy of the test array to sort.
			testCopy = new ArrayList<Integer>();
			testCopy.addAll(test);
				
			// Record time for mergesort
			startTime = System.nanoTime();
			SortUtil.mergesort(testCopy);
			endTime = System.nanoTime();
			// Add the time to mergeSortTime
			quicksortTime.add(endTime - startTime);			
		}
		
		sum = 0;
		// Get the sum of all the times for mergeSortTime
		for (int k = 0; k < quicksortTime.size(); k++)
			sum = sum + quicksortTime.get(k);		
		// Get the average time
		quick.add(sum / quicksortTime.size());
		
		
		}
		System.out.println("Mergesort");
		for (int i = 0; i < 50; i++)
			System.out.println(merge.get(i));
		System.out.println("Quicksosort");
		for (int i = 0; i < 50; i++)
			System.out.println(quick.get(i));
	}
	
	
}

