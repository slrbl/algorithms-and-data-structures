class Stack{
	Vertex top;
	public Stack(){
		this.top=null;
	}
	public boolean isEmpty(){
		if (this.top==null)
			return true;
		return false;
	}
	public void push(Vertex v){
		if (this.isEmpty()){
			this.top=v;
		} else{
			v.next=this.top;
			this.top=v;
		}
	}
	public Vertex pop(){
		if (this.isEmpty())
			return null;
		Vertex v=this.top;
		this.top=v.next;
		return v;
	}
}