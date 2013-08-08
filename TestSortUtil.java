package assignment4;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TestSortUtil extends TestCase 
{
	ArrayList<Integer> temp;
	ArrayList<Integer> compareTemp;
	protected void setUp() throws Exception 
	{
		
		super.setUp();
		
	}

	protected void tearDown() throws Exception 
	{
		super.tearDown();
	}

	public void testMergesortBestcase() throws Exception 
	{  //Testing for mergesort for best case scenarios.
		
		//Testing with size 1
		 temp = SortUtil.generateBestCase(1);
		 compareTemp = SortUtil.generateBestCase(1);
		 SortUtil.mergesort(temp);
		 assertEquals(compareTemp, temp);
		 
		//Testing with size 20
		 temp = SortUtil.generateBestCase(20);
		 compareTemp = SortUtil.generateBestCase(20);
		 SortUtil.mergesort(temp);
		 assertEquals(compareTemp, temp);
		 
		//Testing with size 100
		 temp = SortUtil.generateBestCase(100);
		 compareTemp = SortUtil.generateBestCase(100);
		 SortUtil.mergesort(temp);
		 assertEquals(compareTemp, temp);
		 
		//Testing for size 349
		 temp = SortUtil.generateBestCase(349);
		 compareTemp = SortUtil.generateBestCase(349);
		 SortUtil.mergesort(temp);
		 assertEquals(compareTemp, temp);
		 
		 //Testing for size 4073
		 temp = SortUtil.generateBestCase(4073);
		 compareTemp = SortUtil.generateBestCase(4073);
		 SortUtil.mergesort(temp);
		 assertEquals(compareTemp, temp);
		 
	}
	
	public void testMergesortAveragecase() throws Exception
	{
		//Testing for average case scenario
		//Testing with size 1
		 temp = SortUtil.generateAverageCase(1);
		 compareTemp = SortUtil.generateBestCase(1);
		 SortUtil.mergesort(temp);
		 assertEquals(compareTemp, temp);
		 
		//Testing with size 10
		 temp = SortUtil.generateAverageCase(10);
		 compareTemp = SortUtil.generateBestCase(10);
		 SortUtil.mergesort(temp);
		 assertEquals(compareTemp, temp);
		 
			//Testing with size 20
		 temp = SortUtil.generateAverageCase(20);
		 compareTemp = SortUtil.generateBestCase(20);
		 SortUtil.mergesort(temp);
		 assertEquals(compareTemp, temp);
		 
			//Testing with size 100
		 temp = SortUtil.generateAverageCase(100);
		 compareTemp = SortUtil.generateBestCase(100);
		 SortUtil.mergesort(temp);
		 assertEquals(compareTemp, temp);
		 
			//Testing with size 177
		 temp = SortUtil.generateAverageCase(177);
		 compareTemp = SortUtil.generateBestCase(177);
		 SortUtil.mergesort(temp);
		 assertEquals(compareTemp, temp);
		 
			//Testing with size 230900
		 temp = SortUtil.generateAverageCase(230900);
		 compareTemp = SortUtil.generateBestCase(230900);
		 SortUtil.mergesort(temp);
		 assertEquals(compareTemp, temp);
	}
	
	public void testMergesortWorstCase() throws Exception
	{
		//Testing for worst case scenario
	
		//Testing with size 1
		 temp = SortUtil.generateWorstCase(1);
		 compareTemp = SortUtil.generateBestCase(1);
		 SortUtil.mergesort(temp);
		 assertEquals(compareTemp, temp);
		 
		//Testing with size 10
		 temp = SortUtil.generateWorstCase(10);
		 compareTemp = SortUtil.generateBestCase(10);
		 SortUtil.mergesort(temp);
		 assertEquals(compareTemp, temp);
		
		//Testing for worst case scenario
		//Testing with size 50
		 temp = SortUtil.generateWorstCase(50);
		 compareTemp = SortUtil.generateBestCase(50);
		 SortUtil.mergesort(temp);
		 assertEquals(compareTemp, temp);
		 
		//Testing for worst case scenario
		//Testing with size 204
		 temp = SortUtil.generateWorstCase(204);
		 compareTemp = SortUtil.generateBestCase(204);
		 SortUtil.mergesort(temp);
		 assertEquals(compareTemp, temp);
		 
		//Testing for worst case scenario
		//Testing with size 500
		 temp = SortUtil.generateWorstCase(500);
		 compareTemp = SortUtil.generateBestCase(500);
		 SortUtil.mergesort(temp);
		 assertEquals(compareTemp, temp);
	}
	public void testMergeDuplicates() throws Exception
	{
		temp = new ArrayList<Integer>();
		for (int i = 0; i < 30; i++)
			temp.add(i);
		for (int i = 0; i < 30; i++)
			temp.add(i);
		compareTemp = new ArrayList<Integer>();
		for (int i = 0; i < 30; i++)
			{
				compareTemp.add(i);
				compareTemp.add(i);
			}
		SortUtil.mergesort(temp);
		assertEquals(compareTemp,temp);
	}
	
	public void testMergeSortException()
	{
		//Testing the exception throwing for mergesort
		try
		{
			temp = SortUtil.generateWorstCase(0);
			SortUtil.mergesort(temp);
			fail("Didn't throw the expected exception.");
		}
		catch (Exception e){}
		
	}
	public void testQuick()
	{
		//Testing quicksort.
		//Testing with size 1
		 temp = SortUtil.generateAverageCase(1);
		 compareTemp = SortUtil.generateBestCase(1);
		 SortUtil.quicksort(temp);
		 assertEquals(compareTemp, temp);
		
		//Testing with size 8
		 temp = SortUtil.generateAverageCase(8);
		 compareTemp = SortUtil.generateBestCase(8);
		 SortUtil.quicksort(temp);
		 assertEquals(compareTemp, temp);
		 
			//Testing with size 10
		 temp = SortUtil.generateAverageCase(10);
		 compareTemp = SortUtil.generateBestCase(10);
		 SortUtil.quicksort(temp);
		 assertEquals(compareTemp, temp);
		 
		 
			//Testing with size 304343
		 temp = SortUtil.generateAverageCase(304343);
		 compareTemp = SortUtil.generateBestCase(304343);
		 SortUtil.quicksort(temp);
		 assertEquals(compareTemp, temp);
		 
	}
	public void testQuickWorstCase()
	{
		//Testing with size 1
		 temp = SortUtil.generateWorstCase(1);
		 compareTemp = SortUtil.generateBestCase(1);
		 SortUtil.quicksort(temp);
		 assertEquals(compareTemp, temp);
		 
		//Testing with size 34
		 temp = SortUtil.generateWorstCase(34);
		 compareTemp = SortUtil.generateBestCase(34);
		 SortUtil.quicksort(temp);
		 assertEquals(compareTemp, temp);
		 
		//Testing with size 105
		 temp = SortUtil.generateWorstCase(105);
		 compareTemp = SortUtil.generateBestCase(105);
		 SortUtil.quicksort(temp);
		 assertEquals(compareTemp, temp);
		 
		//Testing with size 2304
		 temp = SortUtil.generateWorstCase(2304);
		 compareTemp = SortUtil.generateBestCase(2304);
		 SortUtil.quicksort(temp);
		 assertEquals(compareTemp, temp);
		 
		//Testing with size 102800
		 temp = SortUtil.generateWorstCase(102800);
		 compareTemp = SortUtil.generateBestCase(102800);
		 SortUtil.quicksort(temp);
		 assertEquals(compareTemp, temp);
	}
	public void testQuickDuplicates()
	{
		temp = new ArrayList<Integer>();
		for (int i = 0; i < 30; i++)
			temp.add(i);
		for (int i = 0; i < 30; i++)
			temp.add(i);
		compareTemp = new ArrayList<Integer>();
		for (int i = 0; i < 30; i++)
			{
				compareTemp.add(i);
				compareTemp.add(i);
			}
		SortUtil.quicksort(temp);
		assertEquals(compareTemp,temp);
	}
	public void testQuickSortException()
	{
		//Testing the exception throwing for mergesort
		try
		{
			temp = SortUtil.generateWorstCase(0);
			SortUtil.quicksort(temp);
			fail("Didn't throw the expected exception.");
		}
		catch (Exception e){}
		
	}
}
