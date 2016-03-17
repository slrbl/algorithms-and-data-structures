class Sort{
	
	/*
		Bubble sort: O(n^2) complexity sorting algorithm
	*/

	public static void bubbleSort(int[] arr){
		boolean sorted=false;
		while(sorted==false){
			sorted=true;
			for (int i=0;i<arr.length-1;i++){
				if (arr[i]>arr[i+1]){
					swap(arr,i,i+1);
					sorted=false;
				}
			}
		}	
	}

	/*
		Select Sort: O(n^2) complexity sorting algorithm
	*/

	public static void selectSort(int[] arr){
		int min;
		for (int i=0;i<arr.length;i++){
			min=i;
			for (int j=i+1;j<arr.length;j++){
				if (arr[j]<arr[min])
					min=j;
			}
			if (min!=i)
				swap(arr,min,i);
		}
	}

	/*
		Merge Sort: O(nlogn) complexity sorting algorithm
					It uses extra space
	*/

	public static int[] mergeInOrder(int[] arrL,int[] arrR){
		int i=0;
		int j=0;
		int k=0;
		int[] arr=new int[arrL.length+arrR.length];
		while(i<arrL.length && j<arrR.length){
			if(arrL[i]<=arrR[j]){
				arr[k]=arrL[i];
				k++;
				i++;
			} else if(arrR[j]<=arrL[i]){
				arr[k]=arrR[j];
				k++;
				j++;
			}
		}
		while(i<arrL.length){
			arr[k]=arrL[i];
			k++;
			i++;
		}
		while(j<arrR.length){
			arr[k]=arrR[j];
			k++;
			j++;
		}
		return arr;

	}

	public static int[] mergeSort(int arr[]){
		
		if (arr.length>1){
			int[] arrL=new int[arr.length/2];
			int[] arrR=new int[arr.length-arrL.length];
			for (int i=0;i<arrL.length;i++)
				arrL[i]=arr[i];
			for (int i=0;i<arrR.length;i++)
				arrR[i]=arr[i+arrL.length];
			return mergeInOrder(mergeSort(arrL),mergeSort(arrR));
		} else{
			return arr;
		}
	}

	public static void quickSort(int[] arr, int startIndex,int endIndex){
		if (startIndex>=endIndex)
			return;
		int pivot=endIndex;
		int middle=(startIndex+(endIndex-startIndex)/2);
		
		swap(arr,pivot,middle); //by swapping the middle with the pivot we enhance the efficiency 
		
		int i=startIndex;
		int j=endIndex-1;
		while(i<j){
			if (arr[i]<=arr[pivot] && arr[j]>=arr[pivot]){
				i++;
				j--;
			} else if (arr[i]>=arr[pivot] && arr[j]<=arr[pivot]){
				swap(arr,i,j);
				i++;
				j--;
			} else if (arr[i]<=arr[pivot])
				i++;
			else if (arr[j]>=arr[pivot])
				j--;
		}
		if (arr[i]>arr[pivot]){
			swap(arr,i,pivot);
			quickSort(arr,startIndex,i-1);
			quickSort(arr,i+1,endIndex);
		} else{
			quickSort(arr,startIndex,i);
			quickSort(arr,i+1,endIndex);
		}
	}



	public static void maxHeapify(int arr[],int i,int lastIndex){
		if (i>=lastIndex || i<0)
			return;

		int leftIndex=2*i+1;
		int rightIndex=2*i+2;
		int max;
		if (leftIndex<lastIndex && arr[i]<arr[leftIndex])
			max=leftIndex;
		else
			max=i;
		if (rightIndex<lastIndex && arr[rightIndex]>arr[max])
			max=rightIndex;
		if (max!=i){
			swap(arr,max,i);
			maxHeapify(arr,max,lastIndex);
		}
	}
	


	
	public static void convertArrayToMaxHeap(int[] arr,int lastIndex){
		for (int i=(lastIndex)/2;i>=0;i--)
			maxHeapify(arr,i,lastIndex);
		
	}
	

	public static int[] removeLastElement(int arr[]){
		int[] result=new int[arr.length-1];
		for (int i=0; i<result.length;i++)
			result[i]=arr[i];
		return result;
	}

	
	


	public static int[] heapSort(int arr[]){
		int lastIndex;
		for (int j=0;j<arr.length;j++){
			lastIndex=arr.length-j;
			convertArrayToMaxHeap(arr,lastIndex);
			swap(arr,0,lastIndex-1);
		}
		
		return arr;
	}








	public static void swap(int[] arr, int i,int j){
		if (i<arr.length && j<arr.length){
			int tmp=arr[i];
			arr[i]=arr[j];
			arr[j]=tmp;
		} else
			return;
	}

	public static void displayArray(int[] arr){
		System.out.println("");
		for (int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" | ");
		}
		System.out.println("");
	}



	public static void main (String args[]){

		System.out.println("Bubble Sort");
		int[] arr={1,5,6,3,4,8,7,5};
		displayArray(arr);
		bubbleSort(arr);
		displayArray(arr);

		System.out.println("Select Sort");
		int[] arr2={1,5,6,3,4,8,7,5};	
		displayArray(arr2);
		selectSort(arr2);
		displayArray(arr2);

		System.out.println("Merge Sort");
		int[] arr3={1,5,6,3,4,8,7,5};	
		displayArray(arr3);
		arr3=mergeSort(arr3);
		displayArray(arr3);

		System.out.println("Quick Sort");
		int[] arr4={1,5,6,3,4,8,7,5,17,18,30,9};
		displayArray(arr4);
		quickSort(arr4,0,arr4.length-1);
		displayArray(arr4);

		System.out.println("Heap Sort");

		int[] arr5={1,5,6,3,4,8,15,32,9};
		displayArray(arr5);
		displayArray(heapSort(arr5));
	}
}
