import java.util.ArrayList;
class Test{
	public static void main(String args[]){
		Graph g=new Graph(100);


		
		g.addEdge(1,2,0);
		g.addEdge(1,4,0);
		g.addEdge(2,6,0);
		g.addEdge(3,9,0);
		g.addEdge(4,8,0);
		g.addEdge(4,2,0);
		g.addEdge(5,3,0);
		g.addEdge(6,5,0);
		g.addEdge(8,9,0);
		g.addEdge(9,5,0);

		Vertex a=new Vertex(1);	
		g.addVertex(a);
		//System.out.println(a.getChildren().size());


		//for (int i=0;i<g.getEdges().size();i++){
		//	System.out.println(g.getEdges().get(i).getOrigin().getData() +" --"+g.getEdges().get(i).getWeight()+"--> "+g.getEdges().get(i).getDestination().getData());
		//}


		/*for (int i=0;i<g.getVertices().size();i++){
			System.out.println(g.getVertices().get(i).getData());
			System.out.println(g.getVertices().get(i).getChildren());
		}*/


		


		g.BFSTraversal(1);
		g.DFSTraversal(1);







		/*
		// QUEUE TEST
		Queue q=new Queue();
		Vertex a=new Vertex(1);
		Vertex b=new Vertex(2);
		Vertex c=new Vertex(3);
		q.enqueue(a);
		q.enqueue(b);
		q.enqueue(c);
		System.out.println(q.first.getData());
		q.dequeue();
		System.out.println(q.first.getData());
		q.dequeue();
		System.out.println(q.first.getData());
		System.out.println(q.first.getData());
		q.dequeue();
		
		q.enqueue(b);
		System.out.println(q.first.getData());
		q.dequeue();

		System.out.println(q.first.getData());
		*/

	}
}