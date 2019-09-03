import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Solution_1808 {
	static ArrayList<Integer> arr;
	static ArrayList<Integer> prime = new ArrayList<>();
	static boolean[] pr = new boolean[1000001];
	static boolean[] use;
	static ArrayList<ArrayList<Integer>> res;
	static int count,min;
	static Stack<Integer> result = new Stack<>();
	public static void main(String[] args) {
		Eratos();
		for (int j = 2; j < pr.length; j++) {
			if(!pr[j]) {
				prime.add(j);
			}
		}
		
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1; i <= iT ; i++) {
			int[] calc = new int[10];
			for (int j = 0; j < calc.length; j++) {
				calc[j] = sc.nextInt();
			}
			int number = sc.nextInt();
			arr = new ArrayList<>();
			
			Decomposition(number);
			use = new boolean[arr.size()];
			res = new ArrayList<>();
			X(0,use);
			
			
			min = Integer.MAX_VALUE;
			for(ArrayList<Integer> a : res) {
				System.out.println(a);
				count = 0;
				boolean calccheck = true;
				for (int x = 0; x < a.size(); x++) {
					String str = a.get(x) + "";
					for (int j = 0; j < str.length(); j++) {
						if(calc[str.charAt(j) - '0'] == 0) {
							calccheck = false;
							break;
						}
						else {
							count++;
						}
					}
				}
				if(calccheck) {
					count += a.size()-1;
					min = Math.min(count, min);
				}
			}
			if(min == Integer.MAX_VALUE) {
				System.out.printf("#%d %d\n",i,-1);
			}
			else {
				System.out.printf("#%d %d\n",i,min+1);
			}
			
		}

	}
	public static void find() {
		
	}
	public static void X(int depth, boolean[] use) {
		
		//use 로 안될듯
		
		
		
		//모든 경우의 약수들을 만들면 됨.
	}
	public static void Decomposition(int n) {
		int number = 0;
		for (int i = 0; i < prime.size(); i++) {
			if(n % prime.get(i) == 0) {
				arr.add(prime.get(i));
				number = n / prime.get(i);
				break;
			}
		}
		if(n != 1) {
			Decomposition(number);
		}
		
		
	}
	public static void Eratos() {
		for (int i = 2; i < Math.sqrt(pr.length); i++) {
			if(!pr[i]) {
				for (int j = i+i; j < pr.length; j+=i) {
					if(j % i == 0) {
						pr[j] = true;
					}
				}
			}
		}
	}
}
