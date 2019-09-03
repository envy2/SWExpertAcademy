import java.util.Scanner;

public class Solution_3233 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tcase = sc.nextInt();
		
		for (int i = 0; i < tcase; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			long result = 0L;
			if(a/b == 1) {
				result = 1;
			}
			else{
				result = 0L + (a/b) *(a/b);
			}
			System.out.print("#"+(i+1)+" "+result+"\n");
		}

	}

}
