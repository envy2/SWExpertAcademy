import java.util.Scanner;

public class Solution_1231 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = 10;
		for(int i = 1 ; i <= iT ;i++) {
			int point = sc.nextInt();
			Node[] node = new Node[point];
			
		}

	}
	static class Node{
		int num;
		char value;
		Node left,right;
		public Node(int n,char v, Node l,Node r) {
			this.num = n;
			this.value = v;
			this.left = l;
			this.right = r;
		}
		public Node(int n,char v) {
			this.num = n;
			this.value = v;
			this.left = null;
			this.right = null;
		}
	}
}
