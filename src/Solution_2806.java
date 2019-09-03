import java.util.Scanner;

public class Solution_2806 {
	static int[] board;
	static int res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		for(int i = 1; i <= iT; i++) {
			int N = sc.nextInt();
			board = new int[N];
			res = 0;
			nQueen(0);
			System.out.printf("#%d %d\n",i,res);
		}
	}
	public static void nQueen(int depth) {
		if(depth == board.length) {
			res++;
			return;
		}
		
		for (int i = 0; i < board.length; i++) {
			board[depth] = i;
			if(isCheck(depth)) {
				nQueen(depth+1);
			}
		}
	}
	public static boolean isCheck(int i) {
		for (int j = 0; j < i; j++) {
			if(board[i] == board[j] || Math.abs(i-j) == Math.abs(board[i]-board[j])) {
				return false;
			}
		}
		return true;
	}
}
