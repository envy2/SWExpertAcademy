import java.util.Scanner;

public class Solution_1231 {
	static char[] tree;
	
	public static void init(Scanner sc) {
		int N = sc.nextInt();
		tree = new char[N+1];
		
		for (int i = 0; i < N; i++) {
			tree[sc.nextInt()] = sc.nextLine().charAt(1);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			init(sc);
			System.out.print("#" + t+ " ");
			InOrder(1);
			System.out.println();
		}
		
	}
	public static void InOrder(int node) {
		if(node >= tree.length) {
			return;
		}
		InOrder(node*2);
		System.out.print(tree[node]);
		InOrder(node*2 + 1);
		
	}
}
