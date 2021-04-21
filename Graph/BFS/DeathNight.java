import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DeathNight {
	static class Chess {
		int x;
		int y;
		int cnt;
		
		Chess(int a, int b, int c) {
			x = a;
			y = b;
			cnt = c;
		}
	}
	
	
	static boolean success = false;
	static int ans;
	static int end_x, end_y;
	static int N;
	static boolean Visited[][];
	static int op_x[] = {-2,-2,0,0,2,2};
	static int op_y[] = {-1,1,-2,2,-1,1};
	public static void main(String[] args) throws IOException {
		// bfs
		int start_x, start_y;
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		Visited = new boolean[N][N];
		
		st = new StringTokenizer(br.readLine());
		
		start_x = Integer.parseInt(st.nextToken());
		start_y = Integer.parseInt(st.nextToken());
		end_x = Integer.parseInt(st.nextToken());
		end_y = Integer.parseInt(st.nextToken());
		
		bfs(start_x, start_y);
		
		System.out.println(success? ans : -1);
	}

	static void bfs(int x, int y) {
		Chess c;
		Queue<Chess> queue = new LinkedList<>();
		int temp_x, temp_y;
		Visited[x][y] = true;
		
		queue.add(new Chess(x, y, 0));
		
		while(!queue.isEmpty()) {
			c = queue.poll();
			
			if(c.x == end_x && c.y == end_y) {
				success = true;
				ans = c.cnt;
				break;
			}
			for(int i = 0; i < 6; ++i) {
				temp_x = c.x + op_x[i];
				temp_y = c.y + op_y[i];
				
				if(temp_x >= 0 && temp_x < N && temp_y >= 0 && temp_y < N) {
					if(!Visited[temp_x][temp_y]) {
						Visited[temp_x][temp_y] = true;
						queue.add(new Chess(temp_x, temp_y, c.cnt + 1));
					}
				}
			}
		}
	}
}
