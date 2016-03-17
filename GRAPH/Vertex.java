import java.util.ArrayList;
class Vertex{
	private int data;
	private ArrayList<Vertex> children;
	public Vertex next; //for stack and queue use
	public boolean visited;

	public Vertex(int data){
		this.data=data;
		this.children=new ArrayList<Vertex>();
		this.visited=false;
	}

	public ArrayList<Vertex> getChildren(){
		return this.children;
	}
	public int getData(){
		return this.data;
	}

	public Vertex getFirstNotVisited(){
		for (int i=0;i<this.children.size();i++){
			if (this.children.get(i).visited==false)
				return this.children.get(i);
		}
		return null;
	}




	public void addChild(Vertex child){
		this.children.add(child);
	}
	public void addChild(int  childValue){
		this.children.add(new Vertex(childValue));
	}
	public boolean hasChild(Vertex child){
		if (this.children.indexOf(child)>-1)
			return true;	
		return false;
	}



	public boolean hasChild(int childValue){
		for (int i=0;i<this.children.size();i++){
			if (this.children.get(i).data==childValue)
				return true;
		}
		return false;
		
	}

}