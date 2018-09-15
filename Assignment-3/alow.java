import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class alow {
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		String stringline = in.readLine();
		int V = Integer.parseInt(stringline);
		Graph g = new Graph(V);
		int vertex=0;
		while(stringline!= null){
			vertex++;
			System.out.println(vertex);
			stringline = in.readLine();
			if(stringline!= null){
				stringline=stringline.trim();
				if(!stringline.equals("-")){
					String[] neighbours = stringline.split(",");
						for(int i=0; i<neighbours.length; i++){
							if(!neighbours[i].equals(" ")){
								g.addDirectedEdge(vertex, Integer.parseInt(neighbours[i]));}
						}
					}
				else
					{System.out.println(stringline);
						break;}
					}
			}
			Graph gh = g.SCCs();
			System.out.println(alowConnected(gh));
			in.close();
	}

	public static int alowConnected(Graph DAG) {
		int[] inDegreeList = DAG.indegreeList;
		int source = -10;
		for (int i = 1; i <= DAG.Vertices; i++) {
			if (inDegreeList[i] == 0) {
				if (source != -10)
					return 0;
				else {
					source = i;
				}
			}
		}

		int count = 1;
		while (count <= inDegreeList.length) {
			int next = -10;
			if (DAG.adjacencyList.get(source) != null) {
				Iterator<Integer> h = DAG.adjacencyList.get(source).listIterator();
				while (h.hasNext()) {
					int k = h.next();
					DAG.indegreeList[k]--;
					if (inDegreeList[k] == 0) {
						if (next != -10)
							return 0;
						else {
							next = k;
						}
					}
				}
			}
			source = next;
			count++;
		}
		return 1;
	}
}
