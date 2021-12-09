import java.util.ArrayList;



public class Heap {
	ArrayList<Integer> elements;
	
	public Heap(){
		this.elements=new ArrayList();
	}
	
  /*
            50
          /    \
        30       40
      /   \      /  \
    15     10   9    28
        
0 |  1 |  2 |  3 | 4  |5 | 6|
50| 30 | 40 | 15 | 10 |9 |28|

 left=2*n+1
 right=2*n+2
 parent=(n-1)/2
 */
	
	
	
	public void swap(ArrayList list,int a,int b){
		int tmp=elements.get(a);
		elements.set(a, elements.get(b));
		elements.set(b, tmp);
	}

	public void addElement(int e){
		this.elements.add(e);
		maxHeapifyRecursive(0,elements.size());
		
		}
	
	
	public void heapSort(){
		int end=elements.size();
		while(end>0){
			System.out.println("\n\n"+this.elements);
			//maxHeapify(end);
			maxHeapifyRecursive(0,end);
			swap(elements,0,end-1);
			end--;
			System.out.println("aftr\n"+this.elements);
		}
		

	}
	
	public void maxHeapifyIterative(int untilIndex){
		System.out.println("---"+untilIndex);
		for (int i=0;i<untilIndex/2;i++){
			if ( (2*i+1)<=untilIndex/2 && elements.get(2*i+1)>elements.get(i)){
				swap(elements,i,(2*i)+1);
				System.out.println(this.elements);
			}
			if((2*i+2)<=untilIndex/2 && elements.get(2*i+2)>elements.get(i)){
				swap(elements,i,(2*i)+2);	
				System.out.println(this.elements);
			}
		}
		
	}
	
	public void maxHeapifyRecursive(int i,int end){
		int largest=i;
		int left=2*i+1;
		int right=2*i+2;
		
		if(left<end && elements.get(left)>elements.get(largest)){
			swap(elements,left,largest);
			largest=left;
		}
		if(right<end && elements.get(right)>elements.get(largest)){
			swap(elements,right,largest);
			largest=right;
		}
		if(largest!=i)
			maxHeapifyRecursive(largest,end);
	}
}
