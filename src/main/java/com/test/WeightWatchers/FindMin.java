package com.test.WeightWatchers;

import java.util.Arrays;
import java. util. Scanner; 

public class FindMin
{
	public static int[] CreateRandIntArr()
	{
		int [] RandIntsGenerated = new int [500];
		for (int i = 0; i < RandIntsGenerated.length; i++ )
		{
			RandIntsGenerated[i] = (int)(Math.random()*500+1);
		}
		return RandIntsGenerated;
	}

	public static int FindNthSmallestElement(int RandInts[], int n)
	{
		Arrays.sort(RandInts);	
		return RandInts[n-1];
	}

	public static void main(String args[ ])
	{

		System.out.println("Please enter the n'th smallest element you want to find: ");
		Scanner read =  new Scanner(System. in);
		int nInput = read.nextInt();

		int [] RandInts = CreateRandIntArr();
		int nthSmallestElement = FindNthSmallestElement(RandInts, nInput); 
		System.out.println("The "+nInput +"th "+ "smallest element is: " + nthSmallestElement);
	}	
}
