import java.util.Scanner;

public class Solution_3813 {
	static int result;
	static int[] memory,file;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i <= iT ; i++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			result = 0;
			
			memory = new int[N];
			for (int m = 0; m < memory.length; m++) {
				memory[m] = sc.nextInt();
				max = max > memory[m] ? max : memory[m];
				min = min < memory[m] ? min : memory[m];
			}
			file = new int[K];
			for (int f = 0; f < file.length; f++) {
				file[f] = sc.nextInt();
			}
			
			save(min,max);
			System.out.println("#"+i+" "+result);
		}

	}
	public static void save(int left, int right) {
		if(left == right) {
			result = left;
			return;
		}
		
		int cnt = 0;
		int index = 0;
		int wear = (left + right) / 2;
		boolean check = false;
		for (int i = 0; i < memory.length; i++) {
			if(memory[i] <= wear) {
				cnt++;
			}
			else {
				cnt = 0;
			}
			if(file[index] == cnt) {
				index++;
				cnt = 0;
			}
			if(index == file.length) {
				check = true;
				break;
			}
		}
		if(check) {
			save(left, wear);
		}
		else {
			save(wear+1,right);
		}
	}

}
