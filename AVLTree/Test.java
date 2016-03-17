class Test{
	
	public static void main(String args[]){

		AVLNode root2=new AVLNode(10);
		AVLTree AVL=new AVLTree(root2);

		root2=AVL.insertNode(root2,7);
		root2=AVL.insertNode(root2,5);
		root2=AVL.insertNode(root2,2);
		System.out.println(root2.left.left.data);





		// /AVLNode b=AVL.insertNode(AVL.root,5);
	

		//AVLNode c=AVL.insertNode(AVL.root,2);



	}
}