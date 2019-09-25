import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_2383 {
	static int[][] maps;
	static int[] step_1, step_2;
	static ArrayList<Point> people,step;
	static int min;
	static class Point{
		int x,y,dis;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public Point(int x, int y, int dis) {
			super();
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}
	public static int dist(Point person, Point step) {
		return Math.abs(person.x - step.x) + Math.abs(person.y - step.y);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		
		for(int i = 1 ; i <= iT ;i++) {
			int N = sc.nextInt();
			maps = new int[N][N];
			step = new ArrayList<>();
			people = new ArrayList<>();
			min = Integer.MAX_VALUE;
			
			for (int x = 0; x < maps.length; x++) {
				for (int y = 0; y < maps.length; y++) {
					maps[x][y] = sc.nextInt();
					if(maps[x][y] == 1) {
						people.add(new Point(x,y));
					}
					if(maps[x][y] > 1) {
						step.add(new Point(x,y,maps[x][y]));
					}
				}
			}
			
			step_1 = new int[people.size()];
			step_2 = new int[people.size()];
			
			for (int s = 0; s < step_1.length; s++) {
				step_1[s] = dist(people.get(s), step.get(0));
				step_2[s] = dist(people.get(s), step.get(1));
			}
			Step[] result = new Step[people.size()];
			dfs(0,result);
			System.out.println("#"+i+" "+min);
		}

	}
	static class Step{
		int dis,num;

		public Step(int dis, int num) {
			super();
			this.dis = dis;
			this.num = num;
		}

		@Override
		public String toString() {
			return "Step [dis=" + dis + ", num=" + num + "]";
		}
		
	}
	public static void dfs(int depth,Step[] result) {
		if(depth == people.size()) {
			int time = 0;
			int step1 = 0;
			int step2 = 0;
			boolean[] down = new boolean[people.size()];
			boolean[] arrive = new boolean[people.size()];
			boolean check;
			while(true) {
				check = true;
				time++;
				for (int i = 0; i < result.length; i++) {
					if(down[i] && result[i].dis + step.get(result[i].num).dis <= time) {
						if(result[i].num == 0) {
							if(step1 > 0) {
								step1--;
							}
							arrive[i] = true;
						}
						if(result[i].num == 1) {
							if(step2 > 0) {
								step2--;
							}
							arrive[i] = true;
						}
					}
					if(!down[i] && result[i].dis <= time) {
						if(result[i].num == 0 && step1 < 3) {
							step1++;
							down[i] = true;
						}
						if(result[i].num == 1 && step2 < 3) {
							step2++;
							down[i] = true;
						}
					}
				}
				
				System.out.println(Arrays.toString(result));
				System.out.println(Arrays.toString(arrive));
				System.out.println(Arrays.toString(down));
				for (int i = 0; i < arrive.length; i++) {
					if(!arrive[i]) {
						check = false;
					}
				}
				if(check) {
					break;
				}
			}
			min = min < time ? min : time;
			return;
		}
		
		result[depth] = new Step(step_1[depth], 0);
		dfs(depth+1, result);
		result[depth] = new Step(step_2[depth], 1);
		dfs(depth+1, result);
	}
}
