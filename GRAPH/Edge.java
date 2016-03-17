import java.util.ArrayList;
class Edge{
	private Vertex origin;
	private Vertex destination;
	private int weight;

	public Edge(Vertex origin, Vertex destination, int weight){
		this.origin=origin;
		this.destination=destination;
		this.weight=weight;
		if (origin.hasChild(destination)==false)
			this.origin.addChild(destination);
	}

	public Vertex getOrigin(){
		return this.origin;
	}
	public Vertex getDestination(){
		return this.destination;
	}

	public int getWeight(){
		return this.weight;
	}

	public void destroy(){
		for (int i=0;i<this.origin.getChildren().size();i++){
			if (this.origin.getChildren().get(i)==destination)
				this.origin.getChildren().remove(i);
		}
	}

}