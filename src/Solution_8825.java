import java.util.Arrays;
import java.util.Scanner;

public class Solution_8825 {
	static int floor;
	static int[] first_floor;
	
	public static void init(Scanner sc) {
		floor = sc.nextInt();
		first_floor = new int[floor * 2 - 1];
		
		for (int n = 0; n < first_floor.length; n++) {
			first_floor[n] = sc.nextInt();
		}
	}
	
	public static void binary() {
		int left = 1;
		int right = first_floor.length;
		
		while(left <= right) {
			int middle = (left + right) / 2;
			
			if(solution(middle)) {
				left = middle + 1;
			}
			else {
				right = middle - 1;
			}
		}
	}
	
	public static boolean solution(int value) {
		//TODO 크거나 같으면 1 작으면 0, 중간의 값이 110, 011 이면 무조건 가능 101, 010 일경우 양변이 모두 0 일경우 추가 경우를 체크해야함
		
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			init(sc);
			
		}

	}

}
