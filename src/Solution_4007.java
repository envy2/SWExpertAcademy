import java.util.Scanner;

public class Solution_4007 {
	static int[] graph;
	static boolean[] visit;
	static Minheap minheap;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ;i <= iT ; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int X = sc.nextInt();
			
			int[][] forward = new int[N+1][N+1];
			int[][] reverse = new int[N+1][N+1];
			int start,end,value;
			for (int j = 0; j < M; j++) {
				start = sc.nextInt();
				end = sc.nextInt();
				value = sc.nextInt();
				
				forward[start][end] = value;
				reverse[end][start] = value;
			}
			
			graph = new int[N+1];
			visit = new boolean[N+1];
			dijkstra(forward,X);
			int[] sum = graph;
			
			graph = new int[N+1];
			visit = new boolean[N+1];
			dijkstra(reverse,X);
			for (int j = 0; j < graph.length; j++) {
				sum[j] += graph[j];
			}
			int result = Integer.MIN_VALUE;
			
			for (int j = 1; j < sum.length; j++) {
				result = result > sum[j] ? result : sum[j];
			}
			System.out.println("#"+i+" "+result);
		}
	}
	public static void dijkstra(int[][] forward,int start) {
		for (int j = 1; j < graph.length; j++) {
			graph[j] = Integer.MAX_VALUE;
		}
		graph[start] = 0;
		visit[start] = true;
		
		for (int i = 0; i < forward.length; i++) {
			if(forward[start][i] > 0) {
				graph[i] = forward[start][i];
			}
		}
		
		while(true) {
			if(Allvisit()) {
				break;
			}
			int min = Integer.MAX_VALUE;
			int minNode = 0;
			for (int i = 1; i < forward.length; i++) {
				if(!visit[i] && graph[i] < min) {
					min = graph[i];
					minNode = i;
				}
			}
			
			visit[minNode] = true;
			for (int i = 1; i < forward.length; i++) {
				if(!visit[i] && forward[minNode][i] != 0 && graph[minNode] + forward[minNode][i] < graph[i]) {
					graph[i] = graph[minNode] + forward[minNode][i];
				}
			}
		}
		
	}
	public static boolean Allvisit() {
		for (int i = 1; i < visit.length; i++) {
			if(!visit[i]) {
				return false;
			}
		}
		return true;
	}
	static class Minheap{
		int[] heap;
		int index;

		public Minheap(int size) {
			super();
			int cnt = 1;
			while(size / 2 > 0) {
				cnt *= 2;
			}
			this.heap = new int[cnt];
			for (int i = 0; i < heap.length; i++) {
				heap[i] = Integer.MAX_VALUE;
			}
			this.index = 1;
		}
		public void push(int n) {
			int now = index;
			int temp;
			heap[index++] = n;
			
			while(now > 0) {
				if(heap[now] < heap[now/2]) {
					temp = heap[now];
					heap[now] = heap[now/2];
					heap[now/2] = temp;
					now /= 2;
				}
				else {
					break;
				}
			}
		}
		public int pop() {
			int p = heap[0];
			int now = index;
			int temp;
			heap[0] = heap[now];
			
			while(now > 0) {
				if(heap[now*2] < heap[now*2 +1]) {
					if(heap[now*2] < heap[now]) {
						temp = heap[now*2];
						heap[now*2] = heap[now];
						heap[now] = temp;
						now = now*2;
					}
					else {
						break;
					}
				}
				else {
					if(heap[now*2 +1] < heap[now]) {
						temp = heap[now*2+1];
						heap[now*2+1] = heap[now];
						heap[now] = temp;
						now = now*2 +1;
					}
					else {
						break;
					}
				}
			}
			index--;
			return p;
		}
	}
}
