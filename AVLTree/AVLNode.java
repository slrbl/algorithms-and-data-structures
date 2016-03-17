class AVLNode{
	public AVLNode left;
	public AVLNode right;
	public int data;
	public int height;

	public AVLNode(int data){
		this.data=data;
		this.height=1;
	}
}