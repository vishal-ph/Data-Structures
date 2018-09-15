import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

// representation via Adjacency list
public class Graph {
	public int Vertices;
	public HashMap<Integer, LinkedList<Integer>> adjacencyList;
	int[] indegreeList = new int[Vertices+1];
	int[] DAGComp = new int[Vertices+1];
	int compCount=1;
	
	//boolean discovered[] = new boolean[Vertices];	//for each vertex in the graph, true if visited or else false
	
	public Graph(int totalVertices){
		Vertices = totalVertices;
		adjacencyList = new HashMap<Integer, LinkedList<Integer>>(totalVertices);
		indegreeList = new int[totalVertices+1];
		DAGComp = new int[Vertices+1];
		for(int i=1; i<=totalVertices; i++){
			adjacencyList.put(i, new LinkedList<Integer>());
		}
	}
	// directed edge from vertex1 to vertex2
	void addDirectedEdge(int vertex1, int vertex2){
		adjacencyList.get(vertex1).add(vertex2);
		indegreeList[vertex2]++;
	}
	
	// storing vertices in Stack to implement KosaRaju
	public void stackedVerticesDFS1(StackAssn2 stack ,int vertex, boolean discovered[]){
		discovered[vertex] = true;

		Iterator<Integer> i = adjacencyList.get(vertex).iterator();
		while(i.hasNext()){
			int n = i.next();
			if(!discovered[n]){
				stackedVerticesDFS1(stack, n, discovered);
			}
		}
		stack.push(vertex);
	}
	void DFSKosaRaju2(int vertex, boolean discovered[]){
		// Mark the current node as visited and print it
		discovered[vertex] = true;
        DAGComp[vertex] = compCount;
        Iterator<Integer> i =adjacencyList.get(vertex).iterator();	
        while (i.hasNext()){
        	int n = i.next();
            if (!discovered[n]){
                DFSKosaRaju2(n,discovered);
            }
        }
    }
	
	public Graph ReverseGraph(){
		Graph revGraph = new Graph(Vertices);
		for(int v=1; v<=Vertices; v++){
		Iterator<Integer> i = adjacencyList.get(v).listIterator();
		while(i.hasNext()){
			revGraph.adjacencyList.get(i.next()).add(v);
			}
		}
		return revGraph;
	}
	
	public Graph SCCs(){ 
		StackAssn2 stackDFS = new StackAssn2();
		Graph Grev = ReverseGraph();
		boolean discovered[] = new boolean[Vertices+1];
		
		//mark all vertices as undiscovered/not visited
		for(int i=1; i<=Vertices; i++){
			discovered[i] = false;
		}
		
		// now run 1st DFS and store the vertices in the order of discovery in a stack
		for(int i=1; i<=Vertices; i++){
			if(discovered[i] == false){
				stackedVerticesDFS1(stackDFS, i, discovered);
			}
		}

		//mark all vertices as not visited again for the second DFS
		for(int i=1; i<=Vertices; i++){
			discovered[i] = false;
		}

		while(stackDFS.getSize() > 0){
			int vertex = stackDFS.pop();
			if(discovered[vertex] == false ){
				Grev.DFSKosaRaju2(vertex, discovered);
				Grev.compCount++;
			}
		}
		Graph DAGgr = new Graph(Grev.compCount-1);
		for(int i=1; i<=Vertices; i++){
			Iterator<Integer> j = adjacencyList.get(i).listIterator();
			while(j.hasNext()){
				int t=j.next();
				if((Grev.DAGComp[i] != Grev.DAGComp[t]) && !(DAGgr.adjacencyList.get(Grev.DAGComp[i]).contains(Grev.DAGComp[t]))){
					DAGgr.addDirectedEdge(Grev.DAGComp[i], Grev.DAGComp[t]);
				}
			}
		}
		return DAGgr;
	}
}
