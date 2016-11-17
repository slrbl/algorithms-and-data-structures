
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap h=new Heap();
		//50| 30 | 40 | 15 | 10 |9 |28|
		h.addElement(30);
		h.addElement(50);
		h.addElement(40);
		h.addElement(15);
		h.addElement(10);
		h.addElement(9);
		h.addElement(28);
		
		System.out.println(h.elements);
		
		System.out.println("----------- Heap Sort -----------");
		h.heapSort();
		System.out.println(h.elements);
		
	}

}
