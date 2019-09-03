import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution_3124 {
	static int N,E;
	static int[] parent;
	static boolean[] visit;
	static ArrayList<Edge> mst;
	static PriorityQueue<Edge> pq; 
	
	static class Edge {
		int start, end, value;

		Edge(int s, int e, int v) {
			this.start = s;
			this.end = e;
			this.value = v;
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", value=" + value + "]";
		}

	}
	
	static int find(int n) {
		if(n == parent[n]) {
			return n;
		}
		parent[n] = find(parent[n]);
		return parent[n];
	}
	
	static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if(p1 != p2) {
			parent[p2] = p1;
		}
	}
	static class EdgeComparator implements Comparator<Edge>{

		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.value > o2.value ? 1:-1;
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		for(int i = 1 ;i <= iT ; i++) {
			N = sc.nextInt();
			E = sc.nextInt();
			
			visit = new boolean[N+1];
			parent = new int[N+1];
			pq = new PriorityQueue<>(new EdgeComparator());
			mst = new ArrayList<>();
			
			for (int j = 0; j < E; j++) {
				int st = sc.nextInt();
				int end = sc.nextInt();
				int value = sc.nextInt();
				
				pq.add(new Edge(st,end,value));
			}
			kruskal();
			long sum = 0;
			for (int j = 0; j < mst.size(); j++) {
				sum += mst.get(j).value;
			}
			System.out.printf("#%d %d\n",i,sum);
		}
	}
	static void kruskal() {
		for (int i = 1; i <= N;  i++) {
			parent[i] = i;
		}
		for(int i = 0; i<E; i++) {
			Edge edge = pq.poll();
			if(find(edge.start) == find(edge.end)) {
				continue;
			}
			union(edge.start,edge.end);
			mst.add(edge);
		}
	}
}
