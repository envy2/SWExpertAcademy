import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution_1251 {
	static island[] land;
	static ArrayList<Edge> mst; 
	static int[] parent;
	static PriorityQueue<Edge> pq;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int iT = sc.nextInt();
		
		for (int i = 1; i <= iT; i++) {
			int N = sc.nextInt();
			int[] x = new int[N];
			int[] y = new int[N];
			for (int j = 0; j < N; j++) {
				x[j] = sc.nextInt();
			}
			for (int j = 0; j < N; j++) {
				y[j] = sc.nextInt();
			}
			double tax = sc.nextDouble();
			land = new island[N];
			
			for (int j = 0; j < N; j++) {
				land[j] = new island(x[j],y[j]);
			}
			
			pq = new PriorityQueue<>(new EdgeCom());
			parent = new int[N];
			mst = new ArrayList<>();
			
			for (int j = 0; j < N-1; j++) {
				for (int j2 = j+1; j2 < N; j2++) {
					long value = (long)Math.pow((land[j].x-land[j2].x),2) + (long)Math.pow((land[j].y-land[j2].y),2);
					pq.add(new Edge(j,j2,value));
				}
			}
			
			for (int j = 0; j < N; j++) {
				parent[j] = j;
			}
			
			
			int len = pq.size();
			for(int k = 0; k < len; k++) {
				Edge edge = pq.poll();
				if(find(edge.start) == find(edge.end)) {
					continue;
				}
				union(edge.start,edge.end);
				mst.add(edge);
			}
			double sum =0;
			for (int j = 0; j < mst.size(); j++) {
				sum += mst.get(j).value;
			}
			sum *= tax;
			long res = Math.round(sum);
			System.out.printf("#%d %d\n",i,res);
			
		}
	}
	static class EdgeCom implements Comparator<Edge>{

		public int compare(Edge o1, Edge o2) {
			return o1.value > o2.value ? 1 : -1;
		}
		
	}
	static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if(p1 != p2) {
			parent[p2] = p1;
		}
	}
	static int find(int n) {
		if(parent[n] == n) {
			return n;
		}
		parent[n] = find(parent[n]);
		return parent[n];
	}
	static class island{
		int x;
		int y;
		public island(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static class Edge{
		int start;
		int end;
		long value;
		public Edge(int s, int e, long v) {
			this.start = s;
			this.end = e;
			this.value = v;
		}
		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", value=" + value + "]";
		}
		
	}
}
