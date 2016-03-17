import java.util.ArrayList;

class Graph{
	private int size;
	private ArrayList<Vertex> vertices;
	private ArrayList<Edge> edges;
	public Graph(int size){
		this.size=size;
		this.vertices=new ArrayList<Vertex>();
		this.edges=new ArrayList<Edge>();
	}

	public ArrayList<Edge> getEdges(){
		return this.edges;
	}
	public ArrayList<Vertex> getVertices(){
		return this.vertices;
	}



	public Vertex getVertexFromValue(int vertexValue){
		for (int i=0;i<this.vertices.size();i++){
			if (this.vertices.get(i).getData()==vertexValue)
				return this.vertices.get(i);
		}
		return null;
		
	}



	public int addVertex(Vertex vertex){

		if (this.vertices.size()<this.size && this.getVertexFromValue(vertex.getData())==null){
			this.vertices.add(vertex);
			return this.vertices.indexOf(vertex);
		}
		//this.vertices.add(vertex);
		return this.vertices.indexOf(vertex);
	}

	public Vertex addVertex(int vertexValue){
		for (int i=0;i<this.vertices.size();i++){
			if (this.vertices.get(i).getData()==vertexValue)
				return this.vertices.get(i);
		}
		Vertex v=new Vertex(vertexValue);
		this.vertices.add(v);
		return v;
	}

	public void addEdge(Vertex origin, Vertex destination, int weight){
		this.addVertex(origin);
		this.addVertex(destination);
	
		Edge e=new Edge(origin,destination,weight);
		this.edges.add(e);

		if (origin.hasChild(destination.getData())==false)
			origin.addChild(destination);
	}
	public void addEdge(int origin, int destination, int weight){

		Vertex originVertex=this.addVertex(origin);
		Vertex destinationVertex=this.addVertex(destination);
		if (originVertex.hasChild(destinationVertex)==false)
			originVertex.addChild(destinationVertex);

		Edge e=new Edge(originVertex,destinationVertex,weight);
		this.edges.add(e);
	}

	public void setAllToNotVisited(){
		for (int i=0;i<this.vertices.size();i++){
			this.vertices.get(i).visited=false;
			this.vertices.get(i).next=null;
		}
	}

	public void DFSTraversal(int start){
		this.setAllToNotVisited();
		System.out.println("DFSTraversal starting from "+start);
		Stack backWay=new Stack();
		Vertex current=getVertexFromValue(start);
		while(current!=null){
				if (current.visited==false){
					System.out.println(current.getData());
					current.visited=true;
				}
				if (current.getFirstNotVisited()!=null){
					backWay.push(current);
					current=current.getFirstNotVisited();
				}
				else
					current=backWay.pop();
		}
	}

	public void BFSTraversal(int start){
		this.setAllToNotVisited();
		System.out.println("BFSTraversal starting from "+start);
		Queue toBeDiscovered=new Queue();
		toBeDiscovered.enqueue(getVertexFromValue(start));
		while(toBeDiscovered.first!=null){
			Vertex current=toBeDiscovered.dequeue();
			if (current.visited==false){
				System.out.println(current.getData());
				current.visited=true;
			
			for (int i=0;i<current.getChildren().size();i++){
				if (current.getChildren().get(i).visited==false){
					toBeDiscovered.enqueue(current.getChildren().get(i));
				}
			}
		}

		}
	}











}