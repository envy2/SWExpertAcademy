import java.util.Arrays;
import java.util.Scanner;

public class Solution_1244 {
	static int maxnum;
	static int change;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for (int i = 1; i <= iT; i++) {
			String input = sc.next();
			change = sc.nextInt();
			int len = input.length();
			
			int[] list = new int[len];
			for (int j = 0; j < input.length(); j++) {
				list[j] = input.charAt(j) - '0';
			}
			general(list, 0);
			
			char[] c = (maxnum+"").toCharArray();
			boolean check = false;
			for (int j = 0; j < c.length-1; j++) {
				for (int k = j+1; k < c.length; k++) {
					if(c[j] == c[k]) {
						check = true;
						
					}
				}
				if(check) {
					break;
				}
			}
			if(len < change) {
				if(check) {
					
				}
				else {
					if((change - len) % 2 == 1) {
						char a = c[len-1];
						c[len-1] = c[len-2];
						c[len-2] = a;
					}
				}
			}
			String st ="";
			for (int j = 0; j < c.length; j++) {
				st += c[j];
			}
			maxnum = Integer.parseInt(st);
			System.out.printf("#%d %d\n",i,maxnum);
            maxnum = 0;
		}
	}
	public static void general(int[] list,int depth) {
		if(depth == change) {
			
			String str ="";
			for (int i = 0; i < list.length; i++) {
				str += list[i];
			}
			if(Integer.parseInt(str) >= maxnum) {
				maxnum = Integer.parseInt(str);
			}
			return;
		}
		
		if( list.length < change) {
			String str ="";
			for (int i = 0; i < list.length; i++) {
				str += list[i];
			}
			if(Integer.parseInt(str) >= maxnum) {
				maxnum = Integer.parseInt(str);
			}
		}
		for (int i = depth; i < list.length; i++) {
			swap(list,i,depth);
			general(list, depth+1);
			swap(list,i,depth);
			
			
		}
	}
	
	public static void swap(int[] list, int a, int b) {
		int tmp = list[a];
		list[a] = list[b];
		list[b] = tmp;
	}
	
}	
