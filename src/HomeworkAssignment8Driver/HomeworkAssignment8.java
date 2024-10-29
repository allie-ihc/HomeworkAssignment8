package HomeworkAssignment8Driver;

import java.util.Random;

public class HomeworkAssignment8 {
	public static void main(String[] args) {
		int size = 100000;
		int[] shellArray = RandomizedArray(size, 1);
		int[] quickArray = new int[size];
		for (int i = 0; i < size-1; i++)
		{
			quickArray[i] = shellArray[i];
		}
		long shellStart = System.currentTimeMillis();
		shellSort(shellArray);
		long shellFinish = System.currentTimeMillis();
		long shellTimeElapsed = shellFinish - shellStart; 
		long quickStart = System.currentTimeMillis();
		quickSort(quickArray, 0, size-1);
		long quickFinish = System.currentTimeMillis();
		long quickTimeElapsed = quickFinish - quickStart;
		System.out.println("Sorting a random array of size " + size + " took shell sort " + shellTimeElapsed + "ms to complete");
		System.out.println("Sorting a random array of size " + size + " took quick sort " + quickTimeElapsed + "ms to complete");
		
	}
	public static int[] RandomizedArray(int size, int start)
		{
			Random rand = new Random();
			int[] tempArray = new int[size];
			for (int i = 0; i<tempArray.length-1; i++)
			{
				tempArray[i] = i + start;
			}
			for (int i = 0; i < 10000; i++)
			{
				//find two random indexes of array
				int firstRandIndex = rand.nextInt(tempArray.length);
				int secondRandIndex = rand.nextInt(tempArray.length);
				int temp = tempArray[firstRandIndex];
				//swap indexes
				tempArray[firstRandIndex] = tempArray[secondRandIndex];
				tempArray[secondRandIndex] = temp;
			}
			return tempArray;
		}
	public static void shellSort(int[] array)
	{
		for (int i = array.length/2; i > 0; i = i/2)
		{
			for (int j = i; j < array.length; j++)
			{
				int tempNum = array[i];
				int k = 0;
				for(k = i; k >= j && array[k-i] > tempNum; k-= i)
				{
					array[i] = array[k-i];
				}
				array[k] = tempNum;
			}
		}
	}
	public static void quickSort(int[] array, int low, int high)
	{
		if (low < high)
		{
			int pivot = array[high];
			int tempIndex = low - 1;
			for (int i = low; i < high; i++)
			{
				if(array[i] < pivot)
				{
					tempIndex++;
					int temp = array[tempIndex];
					array[tempIndex] = array[i];
					array[i] = temp;
				}
				
			}
			int temp2 = array[tempIndex+1];
			array[tempIndex+1] = array[high];
			array[high] = temp2;
			int partition = tempIndex+1;
			quickSort(array, low, partition-1);
			quickSort(array, partition+1, high);
		}
	}
}
