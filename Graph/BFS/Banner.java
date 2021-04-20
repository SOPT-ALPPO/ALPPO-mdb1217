import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Banner {
	static class Graph {
		int x;
		int y;
		
		Graph(int a, int b) {
			x = a;
			y = b;
		}
	}
	
	static int[] op_x = {1, -1, 0, 0, 1, 1, -1, -1};
	static int[] op_y = {0, 0, 1, -1, 1, -1, 1, -1};
	static int M, N;
	static boolean Visited[][];
	static int Map[][];
	public static void main(String[] args) throws IOException {
		// bfs
		int cnt = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		Map = new int[M][N];
		Visited = new boolean[M][N];
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j)
				Map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < M; ++i) {
			for(int j = 0; j < N; ++j) {
				if(!Visited[i][j] && Map[i][j] == 1) {
					Visited[i][j] = true;
					bfs(new Graph(i, j));
					++cnt;
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	static void bfs(Graph g) {
		int op_X, op_Y;
		Graph gp;
		Queue<Graph> queue = new LinkedList<>();
		queue.add(g);
		
		while(!queue.isEmpty()) {
			gp = queue.poll();
			
			for(int i = 0; i < 8; ++i) {
				op_X = gp.x + op_x[i];
				op_Y = gp.y + op_y[i];
				
				if(op_X >= 0 && op_X < M && op_Y >= 0 && op_Y < N) {
					if(Map[op_X][op_Y] == 1 && !Visited[op_X][op_Y]) {
						Visited[op_X][op_Y] = true;
						queue.add(new Graph(op_X, op_Y));
					}
				}
			}
		}
	}
}
