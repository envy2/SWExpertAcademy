import java.util.Arrays;
import java.util.Scanner;

public class Solution_9280 {
	static int[] parking_space;
	static int[] cost;
	static int[] car;
	static int[] come_leave;
	static int result;
	
	public static void init(Scanner sc) {
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		parking_space = new int[n];
		cost = new int[n];
		for (int i = 0; i < cost.length; i++) {
			cost[i] = sc.nextInt();
		}
		
		car = new int[m+1];
		for (int i = 1; i < car.length; i++) {
			car[i] = sc.nextInt();
		}
		
		come_leave = new int[m*2];
		for (int i = 0; i < come_leave.length; i++) {
			come_leave[i] = sc.nextInt();
		}
		
		result = 0;
	}
	
	public static void calculation(Scanner sc) {
		int parking;
		
		for (int i = 0; i < come_leave.length; i++) {
			parking = come_leave[i];
			if(checkFull() && parking > 0) {
				waiting(i);
				i--;
			}
			else if(!checkFull() && parking > 0) {
				come(parking);
			}
			else {
				parking = Math.abs(parking);
				leave(parking);
			}
		}
	}
	
	public static void come(int number) {
		for (int p = 0; p < parking_space.length; p++) {
			if(parking_space[p] == 0) {
				result += car[number] * cost[p];
				parking_space[p] = number;
				break;
			}
		}
	}
	
	public static void leave(int number) {
		int space = search(number);
		parking_space[space] = 0;
	}
	
	public static int search(int number) {
		int space = -1;
		for (int i = 0; i < parking_space.length; i++) {
			if(parking_space[i] == number) {
				space = i;
				break;
			}
		}
		return space;
		
	}
	
	public static boolean checkFull() {
		for (int i = 0; i < parking_space.length; i++) {
			if(parking_space[i] == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void waiting(int car_number) {
		int swap = 0;
		for (int i = car_number; i < come_leave.length; i++) {
			if(come_leave[i] < 0) {
				swap = i;
				break;
			}
		}
		
		int temp = come_leave[swap];
		for (int i = swap; i > car_number; i--) {
			come_leave[i] = come_leave[i-1];
		}
		come_leave[car_number] = temp;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			init(sc);
			calculation(sc);
			
			System.out.println("#"+t+" "+result);
		}
	}
}
