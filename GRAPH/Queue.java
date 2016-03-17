class Queue{
	Vertex first;
	Vertex last;
	public Queue(){
		this.first=null;
		this.last=null;
	}
	public boolean isEmpty(){
		if (this.first==null)
			return true;
		return false;
	}

	public void enqueue(Vertex v){
		if (this.first==null){
			this.first=v;
		} else if(this.last==null){
			this.last=v;
			this.first.next=this.last;
		} else{
			this.last.next=v;
			this.last=v;
		}
	}
	public Vertex dequeue(){
		Vertex v;
		if (this.isEmpty())
			 v=null;
		else{
			v=this.first;
			this.first=this.first.next;
			if (this.first==this.last)
				this.last=null;
		}
		return v;
	}
}