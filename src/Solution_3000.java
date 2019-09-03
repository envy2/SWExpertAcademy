import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_3000 {
	static int p = 20171109;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int iT = sc.nextInt();
		for(int i= 1 ; i<= iT; i++) {
			int N = sc.nextInt();
			int A = sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			arr.add(A);
			for (int j = 0; j < N; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				arr.add(a);
				arr.add(b);
				//현재 중간값보다 하나는 작고 하나는 크면 중간값은 그대로
				//현재 중간값보다 둘다 작으면 전체 배열에서 현재 중간값보다 한단계 낮은값
				//현재 중간값보다 둘다 높으면 전체 배열에서 현재 중간값보다 한단계 높은값

				
			}
			
		}

	}

	public static int middle(ArrayList<Integer> a) {
		int m = 0;
		//Arrays.sort(a);
		
		return m;
				
	}
}
