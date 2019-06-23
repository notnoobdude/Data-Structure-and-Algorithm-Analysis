package coe20;

/*
 * FABRO, DAN NINO I.				BSCpE2A_C1			COE20				Lab Assignment #10
 * 
 * Sorting of the elements is done via this class. 
 *
 */

public class Fabro_QuickSort {

	public static void sort(int[] arr){
		quickSort(arr, 0, arr.length-1);				//quickSort() method is accessible via this sort() method wherein array elements, depending on the number of the desired elements, will be passed
	}																	//here, stored, and will then be the basis of quickSort's low, high, and pivot comparison.
	
	public static void quickSort(int arr[], int low, int high){		//Since quick sort is a sorting algorithm based upon partitioning an array of data into smaller arrays, a pivot value is made so that a large array
		int i = low, j = high;																	//is partitioned into two arrays one of which holds values smaller than the specified value based on which the partition is made and another
		int temp;																					//array holds values greater than the pivot value. This method partitions an array and then calls itself recursively twice to sort two resulting
		int pivot = arr[(low + high)/2];												//sub-arrays formed.
																			
		while (i <= j){										//A while loop having a condition wherein if low is actually less than or equal to high, block of statements below is executed.
			while (arr[i] < pivot)							//A sub-while loop having a condition wherein if the current low array element is less than the pivot value, low is incremented.
				i++;		
			while (arr[j] > pivot)							//A sub-while loop having a condition wherein if the current high array element is greater than the pivot value, high is decremented.
				j--;
			if (i <=j){											//This if statement is where the swapping happens with a condition wherein  if low is actually less than or equal to high, block of statements below is executed.
				temp = 	arr[i];								//Current low array element will be temporarily stored into field temp, current high array element will then be stored into the position of current low array element
				arr[i] = arr[j];									//and as such, the stored low array element in field temp will be placed into position of the transferred high array element.
				arr[j] = temp;
				
				i++;													//low is then incremented
				j--;													//high is then decremented
			}
		}
		
		if (low < j){												//If low array element is less than the current high array element indexed as j itself, then quickSort() method is called again but low array element will be the course of basis in comparison
			quickSort(arr, low, j);							//to current high array element indexed as j.
		}
		
		if (i < high){											//If indexed current low array element is less than the current high array element, then quickSort() method is called again but indexed current low array element will be the course of basis in comparison
			quickSort(arr, i, high);						//to the high array element.
		}
	}
}