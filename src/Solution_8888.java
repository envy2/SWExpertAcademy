import java.util.Scanner;

public class Solution_8888 {
	static int[][] ranking;
	static Point[] rank;
	static int result, me;
	public static void init(Scanner sc) {
		int people = sc.nextInt();
		int test = sc.nextInt();
		me = sc.nextInt();
		
		result = 0;
		ranking = new int[people][test];
		
		sc.nextLine();
		for (int i = 0; i < ranking.length; i++) {
			String line = sc.nextLine();
			String[] num = line.split(" ");
			for (int j = 0; j < ranking[0].length; j++) {
				ranking[i][j] = Integer.parseInt(num[j]);
			}
		}
	}
	
	public static void knowRank() {
		rank = new Point[ranking.length];
		for (int i = 0; i < rank.length; i++) {
			rank[i] = new Point(0,0);
		}
		
		int count;
		for (int p = 0; p < ranking[0].length; p++) {
			count = 0;
			for (int c = 0; c < rank.length; c++) {
				if(ranking[c][p] == 0) {
					count++;
				}
				else {
					rank[c].test_count++;
				}
			}
			for (int c = 0; c < rank.length; c++) {
				if(ranking[c][p] == 1) {
					rank[c].test_point += count;
				}
			} 
		}
		
		
		for (int i = 0; i < me; i++) {
			if(rank[i].test_point > rank[me-1].test_point) {
				result++;
			}
			else if(rank[i].test_point == rank[me-1].test_point) {
				if(rank[i].test_count >= rank[me-1].test_count) {
					result++;
				}
			}
		}
		
		for(int i = me ; i < rank.length; i++) {
			if(rank[i].test_point > rank[me-1].test_point) {
				result++;
			}
			else if(rank[i].test_point == rank[me-1].test_point) {
				if(rank[i].test_count > rank[me-1].test_count) {
					result++;
				}
			}
		}
		
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1 ; t <= tc; t++) {
			init(sc);
			knowRank();
			System.out.println("#"+t+" "+rank[me-1].test_point+" "+result);
		}
		
	}
	static class Point{
		int test_point, test_count;

		public Point(int test_point, int test_count) {
			super();
			this.test_point = test_point;
			this.test_count = test_count;
		}

		@Override
		public String toString() {
			return "Point [test_point=" + test_point + ", test_count=" + test_count + "]";
		}
		
		
	}
}
