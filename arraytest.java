package assignment4;

import java.util.ArrayList;

import assignment5.MyLinkedList;

public class arraytest {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		MyLinkedList<Integer> testlist = new MyLinkedList<Integer>();
		for (int i = 0; i <20; i++)
			testlist.addLast(i);
		
		Object[] test = testlist.toArray();
		ArrayList<Integer> output = new ArrayList<Integer>();
		for (int i = 0; i < test.length;i++)
			output.add((Integer) test[i]);
		System.out.println(output);
	}

}
