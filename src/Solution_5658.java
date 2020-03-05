import java.util.Scanner;
import java.util.TreeSet;

public class Solution_5658 {
	static char[] number;
	static int result;
	
	public static void init(Scanner sc) {
		int N = sc.nextInt(); // 숫자개수
		int K = sc.nextInt(); // K 번째로 큰수
		
		number = new char[N];
		number = sc.next().toCharArray();
		
		result = 0;
		
		//System.out.println(Arrays.toString(number));
		password(K);
	}
	
	public static void password(int K) {
		String[] hex = new String[4];
		
		TreeSet<Integer> over_check = new TreeSet<>();
		int size = number.length/4;
		
		for (int i = 0; i < size; i++) {
			clear(hex);
			for (int x = 0; x < number.length; x++) {
				hex[x / size] = hex[x / size] + number[x]; 
			}
			
			for (int n = 0; n < hex.length; n++) {
				over_check.add(Integer.parseInt(hex[n], 16));
			}
			carry(number);
		}
		
		int res = over_check.size() - K + 1;
		System.out.println(over_check);
		for(int n : over_check) {
			res--;
			if(res == 0) {
				result = n;
			}
		}
	}
	
	public static void carry(char[] arr) {
		char first = arr[0];
		for (int i = 0; i < arr.length-1; i++) {
			arr[i] = arr[i+1];
		}
		arr[arr.length-1] = first;
	}
	
	public static void clear(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = "";
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			init(sc);
			System.out.println("#"+ t + " " + result);
		}

	}

}
