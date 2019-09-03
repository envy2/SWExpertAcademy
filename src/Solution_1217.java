import java.util.Scanner;

public class Solution_1217 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
	
	

	}
	public static int Square(int n, int m) {
		if(m == 1) {
			return n;
			}
		return n * Square(n,m-1);
		
	}

}
