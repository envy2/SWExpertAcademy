import java.util.Arrays;
import java.util.Scanner;

public class Solution_8658 {
	static int[] max_heap,min_heap;
	static int max_idx, min_idx;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ;i <= iT;i++) {
			max_heap = new int[16];
			min_heap = new int[16];
			max_idx = min_idx = 1;
			max_heap[0] = Integer.MAX_VALUE;
			min_heap[0] = Integer.MIN_VALUE;
			
			int num = 0;
			
			for (int n = 0; n < 10; n++) {
				num = sum(sc.nextInt());
				maxHeap(num);
				minHeap(num);
			}
			System.out.println("#"+i+" "+ max_heap[1] + " "+ min_heap[1]);
		}
	}
	public static int sum(int num) {
		int value = 0;
		int result = 0;
		for(int i = 1000000; i > 0 ; i /= 10) {
			value = num / i;
			num %= i;
			result += value;
		}
		return result;
	}
	public static void maxHeap(int num) {
		max_heap[max_idx] = num;
		int idx = max_idx;
		for(;;) {
			if(max_heap[idx] > max_heap[idx/2]) {
				swap(max_heap, idx, idx/2);
				idx /= 2;
			}
			else {
				break;
			}
		}
		max_idx++;
	}
	public static void minHeap(int num) {
		min_heap[min_idx] = num;
		int idx = min_idx;
		for(;;) {
			if(min_heap[idx] < min_heap[idx/2]) {
				swap(min_heap, idx, idx/2);
				idx /= 2;
			}
			else {
				break;
			}
		}
		min_idx++;
	}
	public static void swap(int[] heap, int a, int b) {
		int temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
}
