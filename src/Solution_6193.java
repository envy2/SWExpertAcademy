import java.util.Scanner;

public class Solution_6193 {
	static int[] first, second, Acount, Bcount;
	static int N, result;
	
	public static void init(Scanner sc) {
		N = sc.nextInt();
		first = new int[N];
		second = new int[N];
		
		Acount = new int[N+1];
		Bcount = new int[N+1];
		
		for (int i = 0; i < N; i++) {
			first[i] = sc.nextInt();
			Acount[first[i]]++;
		}
		
		for (int i = 0; i < N; i++) {
			second[i] = sc.nextInt();
			Bcount[second[i]]++;
		}
		
		result = 0;
	}
	
	public static void solution() {
		int index = 0;
		int temp = 0;
		
		for (int i = 0; i < N - 1; i++) {
			if(first[i] == second[i]) {
				continue;
			}
			else {
				if(Acount[first[i]] == 2 && Bcount[second[i]] == 2) {
					Acount[first[i]]--;
					Acount[second[i]]++;
					Bcount[second[i]]--;
					Bcount[first[i]]++;
					
					index = SearchIndex(first, i+1, first[i]);
					temp = first[index];
					first[index] = second[i];
					second[i] = temp;
					
					result++;
				}
				else if(Acount[first[i]] == 2 && Bcount[second[i]] == 1) {
					index = SearchIndex(first, i+1, second[i]);
					temp = first[index];
					first[index] = first[i];
					first[i] = temp;
					
					result++;
					
				}
				else if(Acount[first[i]] == 1 && Bcount[second[i]] == 2) {
					index = SearchIndex(second, i+1, first[i]);
					temp = second[index];
					second[index] = second[i];
					second[i] = temp;
					
					result++;
				}
				else if(Acount[first[i]] == 1 && Bcount[second[i]] == 1) {
					index = SearchIndex(first, i+1, second[i]);
					temp = first[index];
					first[index] = first[i];
					first[i] = temp;
					
					result++;
				}
			}
		}
	}
	
	public static int SearchIndex(int[] arr, int start, int number) {
		for (int i = start; i < arr.length; i++) {
			if(arr[i] == number) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			init(sc);
			solution();
			System.out.println("#"+ t + " " + result);
		}

	}

}
