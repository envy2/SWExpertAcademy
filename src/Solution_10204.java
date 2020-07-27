import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution_10204 {
	static int[] a, b;
	static Sum[] sum;
	static long result;
	
	public static void init(Scanner sc) {
		int n = sc.nextInt();
		a = new int[n];
		b = new int[n];
		
		sum = new Sum[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
			
			sum[i] = new Sum(a[i] + b[i], i);
		}
		
		result = 0;
	}
	
	public static void happy() {
		PriorityQueue<Sum> pq = new PriorityQueue<>();
		
		for (int i = 0; i < sum.length; i++) {
			pq.offer(sum[i]);
		}
		
		int count = 0;
		
		while(!pq.isEmpty()) {
			int index = pq.poll().index;
			
			if(count % 2 == 0) {
				result += a[index];
			}
			else {
				result -= b[index];
			}
			count++;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			init(sc);
			happy();
			System.out.println("#" + t + " " + result);
		}
	}

	static class Sum implements Comparable<Sum>{
		int value;
		int index;
		
		public Sum(int value, int index) {
			super();
			this.value = value;
			this.index = index;
		}

		@Override
		public int compareTo(Sum o) {
			if(this.value > o.value) {
				return -1;
			}
			else if(this.value < o.value) {
				return 1;
			}
			else {
				return 0;
			}
		}

		@Override
		public String toString() {
			return "Sum [value=" + value + ", index=" + index + "]";
		}
		
		
	}
}
