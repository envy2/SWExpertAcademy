import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1494 {
	static Worms[] worm;
	static Worms[] wworm;
	static long min;
	static boolean[] use;
	static long xsum,ysum,vec;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int iT = Integer.parseInt(br.readLine());
		for (int i = 1; i <= iT; i++) {
			int N = Integer.parseInt(br.readLine());
			worm = new Worms[N/2];
			wworm = new Worms[N/2];
			use = new boolean[N];
			min = Long.MAX_VALUE;
			for (int j = 0; j < N/2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				worm[j] = new Worms(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			for (int j = 0; j < N/2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				wworm[j] = new Worms(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			p(0);
			System.out.printf("#%d %d\n",i,min);
		}

	}
	public static void p(int depth) {
		if(depth == worm.length) {
			xsum = 0;
			ysum = 0;
			vec = 0;
			for (int i = 0; i < worm.length; i++) {
				xsum += worm[i].x - wworm[i].x;
				ysum += worm[i].y - wworm[i].y;

			}
			vec = (xsum * xsum) + (ysum * ysum);
			
			min = min < vec ? min : vec;
			return;
		}
		for (int i = depth; i < worm.length; i++) {
			swap(i,depth);
			p(depth+1);
			swap(i,depth);
		}
		
	}
	public static void swap(int a, int b) {
		Worms t = worm[a];
		worm[a] = worm[b];
		worm[b] = t;
	}
}
class Worms{
	int x;
	int y;
	public Worms(int x,int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "Worms [x=" + x + ", y=" + y + "]";
	}
	
}