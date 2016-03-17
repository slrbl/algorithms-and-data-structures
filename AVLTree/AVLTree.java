class AVLTree{
	public AVLNode root;
	
	public AVLTree(AVLNode root){
		this.root=root;
	}


	public int getNodeHeight(AVLNode n){
		if (n==null)
			return 0;
		return n.height;
	}

	public void setNodeHeight(AVLNode node){
		node.height=1+max(node.left.height,node.left.height);
		System.out.println(node.data+":"+node.height);
	}




/*

				(10)
				/
			(7)
			/ \
		  (6) (8) 
*/



	public int max(int a,int b){
		if (a>=b)
			return a;
		else
			return b;
	}


	public AVLNode rotateRight(AVLNode root){
		System.out.println("rotateLeft");
		AVLNode newRoot=root.left;
		newRoot.right=root;
		root.left=null;
		root.left=newRoot.right;
		setNodeHeight(newRoot);
		return newRoot;
	}

	public AVLNode rotateLeft(AVLNode root){
		System.out.println("rotateRight");
		AVLNode newRoot=root.right;
		newRoot.left=root;
		root.right=null;
		root.right=newRoot.left;
		setNodeHeight(newRoot);
		return newRoot;

	} 


	public AVLNode insertNode(AVLNode root,int data){
		if (root==null)
			return new AVLNode(data);
		else{
			if (root.data>data){
				root.left=insertNode(root.left,data);
				if (getNodeHeight(root.left)-getNodeHeight(root.right)>=2){
					if (getNodeHeight(root.left.left)>getNodeHeight(root.left.right)){
						root=rotateRight(root);
					} else {
						root.left=rotateLeft(root.left);
						root=rotateRight(root);
					}
				}
				if( getNodeHeight(root.left)-getNodeHeight(root.right)<=-2){
					if (root.right.right.height>root.right.left.height){
						root=rotateLeft(root);
					} else{
						root.right=rotateRight(root.right);
						root=rotateLeft(root);
					}
				}
			}
			else if (root.data<data){
				root.right=insertNode(root.right,data);
				if (getNodeHeight(root.left)-getNodeHeight(root.right)<=-2){
					if (root.left.left.height>root.left.right.height){
						root=rotateRight(root);
					} else {
						root.left=rotateLeft(root.left);
						root=rotateRight(root);
					}
				}
				if(getNodeHeight(root.left)-getNodeHeight(root.right)>=2){
					if (root.right.right.height>root.right.left.height){
						root=rotateLeft(root);
					} else{
						root.right=rotateRight(root.right);
						root=rotateLeft(root);
					}
				}

			}
			else{
				//Node already exists, nothing to do.
			}
			setNodeHeight(root);
			return root;
		}
	}
}