class Stack{
	Node top;
	public Stack(){
		this.top=null;
	}
	public boolean isEmpty(){
		if (this.top==null)
			return true;
		return false;
	}
	public void push(Node v){
		if (this.isEmpty()){
			this.top=v;
		} else{
			v.next=this.top;
			this.top=v;
		}
	}
	public Node pop(){
		if (this.isEmpty())
			return null;
		Node v=this.top;
		this.top=v.next;
		return v;
	}
}