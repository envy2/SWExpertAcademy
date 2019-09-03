import java.util.ArrayList;
import java.util.Scanner;

public class Solution_8189 {
	static ArrayList<Integer> letter,post,result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ;i <= iT ; i++) {
			int N = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			letter = new ArrayList<>();
			post = new ArrayList<>();
			result = new ArrayList<>();
			
			for (int j = 0; j < N; j++) {
				letter.add(sc.nextInt());
			}
			int time = letter.get(N-1) + B;
			
			for (int t = 1; t <= time; t++) {
				if(letter.size() != 0 && letter.get(0) == t) {
					post.add(t);
					letter.remove(0);
				}
				if(post.size() == A || (post.size() != 0 && post.get(0) + B == t)) {
					read(post.size(),t);
				}
			}
			System.out.print("#"+i+" ");
			for(Integer res : result) {
				System.out.print(res+" ");
			}
			System.out.println();
		}
	}
	public static void read(int count,int time) {
		if(count % 2 == 1) {
			count += 1;
		}
		for (int r = 0; r < count/2; r++) {
			post.remove(0);
			result.add(time);
		}
	}
}
