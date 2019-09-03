import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_2115 {
	static int[][] board;
	static int removemax;
	static int C;
	static int Cmax = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		for (int i = 1; i <= iT; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			C = sc.nextInt();
			
			board = new int[N][N];
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					board[j][j2] = sc.nextInt();
				}
			}
			
			int[][] max = new int[N][N-M+1];
			int sum = 0;
			int[] cup = new int[M]; 
			boolean[] use = new boolean[cup.length];
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 <= board[0].length-M; j2++) {
					for (int k = 0; k < M; k++) {
						cup[k] = board[j][j2+k];
						sum += cup[k]; 
					}
					if(sum <= C) {
						for (int k = 0; k < cup.length; k++) {
							max[j][j2] += (int)Math.pow(cup[k], 2);
						}
					}
					else { 
						power(cup,use,0);
						max[j][j2] = Cmax;
						Cmax = 0;
					}
					sum = 0;
				}
			}
			for (int k = 0; k < max.length; k++) {
				Arrays.sort(max[k]);
			}
			int[] b = new int[N];
			for (int k = 0; k < max.length; k++) {
				b[k] = max[k][N-M];
			}
			Arrays.sort(b);
			System.out.printf("#%d %d\n",i,b[b.length-1]+b[b.length-2]);
		}

	}
	
	public static void power(int[] cup,boolean[] use,int depth) {
		if(depth == cup.length) {
			int sum = 0;
			int isum = 0;
			for (int i = 0; i < cup.length; i++) {
				if(use[i]) {
					isum += cup[i];
					sum += (int)Math.pow(cup[i], 2);
				}
			}
			if(isum <= C) {
				Cmax = Cmax > sum ? Cmax : sum; 
			}
			return;
		}
		
		use[depth] = false;
		power(cup,use,depth+1);
		use[depth] = true;
		power(cup,use,depth+1);
		
		
		
	}
	public static void swap(int[] cup,int a ,int b) {
		int t = cup[a];
		cup[a] = cup[b];
		cup[b] =t;
	}
}
