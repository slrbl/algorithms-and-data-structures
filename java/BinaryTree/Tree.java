import java.util.ArrayList;
class Tree{
	
	Node root;

	public Tree(Node root){
		this.root=root;
	}

	public void addNode(Node root, int data){
		Node n=new Node(data);
		this.addNode(root,n);
	}

	public  void addNode(Node root,Node node){
		if (root.data>node.data){
			if (root.left==null)
				root.left=node;
			else
				addNode(root.left,node);
			
		} else
		{
			if (root.right==null)
				root.right=node;
			else
				addNode(root.right,node);

		}
	}


	public int getHeight(Node node){
		if (node==null)
			return 0;
		return (1+max(getHeight(node.left),getHeight(node.right)));
	}



	public boolean isBalanced(){
		int leftHeight=getHeight(this.root.left);
		int rightHeight=getHeight(this.root.right);
		System.out.println("Height diff="+(leftHeight-rightHeight));
		if ((leftHeight-rightHeight)>1 || (leftHeight-rightHeight)<-1)
			return false;
		return true;
	}


	public int max(int a,int b){
		if (a>=b)
			return a;
		else
			return b;
	}


	public  ArrayList<Node> PreorderTraversal(Node from){
		ArrayList<Node> nodes=new ArrayList<Node>();
		System.out.println("Tree PreorderTraversal starting from: "+from.data);
		Stack backWay=new Stack();
		Node current=from;
		while(current!=null || backWay.isEmpty()==false){
			if (current!=null){
			System.out.print(current.data+" | ");
			nodes.add(current);
			if (current.right!=null)
				backWay.push(current.right);
			current=current.left;
		}
		else
			current=backWay.pop();
		}
		System.out.println("\n");
		return nodes;


	}


	public ArrayList<Node> InOrderTraversal(Node from){
		ArrayList<Node> nodes=new ArrayList<Node>();

		System.out.println("Tree InOrderTraversal starting from: "+from.data);
		Stack backWay=new Stack();
		Node current=from;
		while (current!=null || backWay.isEmpty()==false){
			if (current!=null){
				backWay.push(current);
				current=current.left;
			}
			else{
				current=backWay.pop();
				System.out.print(current.data+" | ");
				nodes.add(current);
				current=current.right;
			}
		}
		System.out.println("\n");
		return nodes;
	}

	public void PostOrderTrversal(Node from){
		System.out.println("Tree PostOrderTrversal starting from: "+from.data);
		Node current=from;
		Stack backWay=new Stack();
		Node lastVisited=null;
		while (current!=null || backWay.top!=null){
			if (current!=null ){
				backWay.push(current);
				current=current.left;
			}
			else{
				current=backWay.top;
				if (current.right==null || current.right==lastVisited){
					System.out.print(current.data+" | ");
					backWay.pop();
					lastVisited=current;
					current=null;
				}
				else
					current=current.right;
			}
		}
		System.out.println("\n");
	}


		public boolean hasDescendent(Node parent,int n){
		if (parent==null)
			return false;
		if (parent.data==n)
			return true;
		if (parent.data>n)
			return hasDescendent(parent.left,n);
		else{
			return hasDescendent(parent.right,n);
		}
	}


	public Node findLCA(int n1,int n2){
		ArrayList<Node> PreorderTraversalResult=this.PreorderTraversal(this.root);
		int checkStartIndex=0;
		for (int i=PreorderTraversalResult.size()-1;i>=0;i--){
			if (PreorderTraversalResult.get(i).data==n1 || PreorderTraversalResult.get(i).data==n1){
				checkStartIndex=i;
				break;
			}
		}
		
		for (int j=checkStartIndex;j>=0;j--){
			if (hasDescendent(PreorderTraversalResult.get(j),n1) && hasDescendent(PreorderTraversalResult.get(j),n2)){
				return PreorderTraversalResult.get(j);
			}
		}
		return null;
		}

	



}