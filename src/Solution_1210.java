import java.util.Scanner;

public class Solution_1210 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 1; i <= 10; i++) {
			int test_case = sc.nextInt();
			
			int[][] data = new int[100][102];
			
			int end = 1;
			for (int x = 0; x < data.length; x++) {
				for (int y = 1; y < data[0].length-1; y++) {
					data[x][y] = sc.nextInt();
					if(data[x][y] == 2) {
						end = y;
						System.out.println(end);
					}
				}
			}
			
			
			for (int x = data.length-2 ; x >= 0 ; x--) {
				if(data[x][end-1] == 1 ) {
					end = left(data,x,end);
					
				}
				else if(data[x][end+1] == 1) {
					end = right(data,x,end);
					
				}
                else{
                	continue;
                }
			}
			System.out.printf("#%d %d\n",test_case,end-1);
			
			
			
		}

	}
	public static int left(int[][] arr,int x, int y) {
		int end = 0;
		for(int i = y ;i >= 0;i--) {
			if(arr[x][i] == 0) {
				end = i+1;
				break;
			}
		}
		return end;
	}
	
	public static int right(int[][] arr,int x, int y) {
		int end = 0;
		for(int i = y ;i < 102;i++) {
			if(arr[x][i] == 0) {
				end = i-1;
				break;
			}
		}
		return end;
	}

}
