import java.util.Scanner;

public class Solution_9700 {
	static String result;
	public static void init(Scanner sc) {
		double p = sc.nextDouble();
		double q = sc.nextDouble();
		
		result = "";
		
		solution(p,q);
	}
	
	public static void solution(double p , double q) {
		double s1 = (1-p) * q;
		double s2 = p * (1-q) * q;
		
		result = s1 < s2 ? "YES" : "NO" ;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int t = 1 ; t <= tc ; t++) {
			init(sc);
			System.out.println("#"+ t + " " + result);
		}
	}

}
