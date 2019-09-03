import java.util.Scanner;

public class Solution_3282 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		for (int x = 0; x < iT; x++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			Knapsack[] bag = new Knapsack[N+1];
			for (int i = 1; i < N+1; i++) {
				bag[i] = new Knapsack(sc.nextInt(), sc.nextInt());
			}
			int[][] table = new int[N+1][M+1];
			
			for (int i = 1; i < table.length; i++) {
				for (int j = 1; j < table[0].length; j++) {
					if(bag[i].volume > j) {
						table[i][j] = table[i-1][j];
					}
					else {
						table[i][j] = Math.max(bag[i].value+table[i-1][j-bag[i].volume], table[i-1][j]);
					}
				}
			}
			System.out.println("#"+(x+1)+" "+table[N][M]);
		}

	}
}
class Knapsack{
	int volume;
	int value;
	public Knapsack(int volume, int value) {
		this.volume = volume;
		this.value = value;
	}
	
}
