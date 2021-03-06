import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Danji {
	static class Graph {
		int x;
		int y;
		
		Graph(int a, int b) {
			x = a;
			y = b;
		}
	}
	
	static int cnt;
	static int N;
	static int op_x[] = {0,0,-1,1};
	static int op_y[] = {-1,1,0,0};
	static String Map[];
	static boolean Visited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// bfs
		int danji = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		Map = new String[N];
		Visited = new boolean[N][N];
		for(int i = 0; i < N; i++)
			Map[i] = br.readLine();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(Map[i].charAt(j) == '1' && !Visited[i][j]) {
					cnt = 1;
					Visited[i][j] = true;
					bfs(i, j);
					++danji;
					queue.add(cnt);
				}
			}
		}
		System.out.println(danji);
		while(!queue.isEmpty()) 
			System.out.println(queue.poll());
	}

	static void bfs(int x, int y){
		Graph g;
		int op_X = 0, op_Y = 0;
		int temp_x, temp_y;
		Queue<Graph> queue = new LinkedList<>();
		queue.add(new Graph(x, y));
		while(!queue.isEmpty()) {
			g = queue.poll();
			temp_x = g.x;
			temp_y = g.y;
			for (int i = 0; i < 4; i++) {
				op_X = op_x[i] + temp_x; op_Y = op_y[i] + temp_y;
				if(op_X >= 0 && op_X < N && op_Y >= 0 && op_Y < N) {
					if (Map[op_X].charAt(op_Y) == '1' && !Visited[op_X][op_Y]) {
						Visited[op_X][op_Y] = true;
						++cnt;
						queue.add(new Graph(op_X, op_Y));
					}
				}
			}
		}
	}
}
