class BinarySearch{

	public static int RecursiveBinarySearch(int[] arr,int value, int start,int end){
		if (start>=end)
			return -1;
		int middle=start+(end-start)/2;
		if (arr[middle]==value)
			return middle;
		if (arr[middle]<value)
			return RecursiveBinarySearch(arr,value,middle+1,end);
		else
			return RecursiveBinarySearch(arr,value,start,middle-1);
	}

	public static int IterativeBinarySearch(int[] arr,int value){
		int i=0;
		int start=0;
		int end=arr.length-1;
		int middle;
		while(start<=end){
			middle=start+(end-start)/2;
			if (arr[middle]==value)
				return middle;
			else if (arr[middle]>value)
				end=middle-1;
			else
				start=middle+1;
		}
		return -1;	
	}


	public static void main (String args[]){
		int[] array={1,4,6,8,15,19,24,31,46,55,70};
		System.out.println(RecursiveBinarySearch(array,19,0,array.length-1));
		System.out.println(IterativeBinarySearch(array,70));

	}
}