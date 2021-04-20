import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SafeArea {
	static class Graph {
		int x;
		int y;
		
		Graph(int a, int b) {
			x = a;
			y = b;
		}
	}
	
	static int op_x[] = {1,-1,0,0};
	static int op_y[] = {0,0,1,-1};
	static int N;
	static boolean visit[][];
	static int Map[][];
	public static void main(String[] args) throws IOException {
		// bfs
		int cnt;
		int max_area = 1;
		int max = 0;
		StringTokenizer st;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		Map = new int[N][N];
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; ++j) {
				Map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(Map[i][j], max);
			}
		}
		
		for(int i = 1; i <= max; ++i) {
			cnt = 0;
			visit = new boolean[N][N];
			for(int j = 0; j < N; ++j) {
				for(int k = 0; k < N; ++k) {
					if(Map[j][k] > i && !visit[j][k]) {
						visit[j][k] = true;
						bfs(j, k, i);
						++cnt;
					}
				}
			}
			max_area = Math.max(cnt, max_area);
		}
		
		System.out.println(max_area);
	}
	
	static void bfs(int x, int y, int height) {
		Graph g;
		int temp_x, temp_y;
		Queue<Graph> queue = new LinkedList<>();
		
		queue.add(new Graph(x, y));
		
		while(!queue.isEmpty()) {
			g = queue.poll();
			
			for(int i = 0; i < 4; ++i) {
				temp_x = g.x + op_x[i];
				temp_y = g.y + op_y[i];
				
				if(temp_x >= 0 && temp_x < N && temp_y >= 0 && temp_y < N) {
					if(Map[temp_x][temp_y] > height && !visit[temp_x][temp_y]) {
						queue.add(new Graph(temp_x, temp_y));
						visit[temp_x][temp_y] = true;
					}
				}
			}
		}
	}

}
