class Node{
	public int data;
	public Node left;
	public Node right;
	public Node next;
	public Node(int data){
		this.data=data;
	}

	public boolean hasDescendent(Node parent,Node n){
		if (parent==null)
			return false;
		if (parent==n)
			return true;
		if (this.data>n.data)
			return hasDescendent(this.left,n);
		else{
			return hasDescendent(this.right,n);
		}
	}
}