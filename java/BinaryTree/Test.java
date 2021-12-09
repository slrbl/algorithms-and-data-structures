class Test{
	
	public static void main(String args[]){
		Node root=new Node(5);
		Tree t=new Tree(root);
		t.addNode(root,10);
		t.addNode(root,3);
		t.addNode(root,2);
		t.addNode(root,1);
		t.addNode(root,4);
		t.addNode(root,7);
		t.addNode(root,12);
		t.addNode(root,11);
		t.addNode(root,24);
		t.addNode(root,88);
		t.addNode(root,90);

		System.out.println(t.getHeight(root));
		System.out.println(t.isBalanced());
		//t.PreorderTraversal(root);
		//t.InOrderTraversal(root);
		//t.PostOrderTrversal(root);


		//System.out.println(t.hasDescendent(root,1111));
		//System.out.println(t.findLCA(24,1).data);


		


	}
}