import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AconvertB {
	static class OP {
		long num;
		int cnt;
		
		OP(long a, int b) {
			num = a;
			cnt = b;
		}
	}

	static int cnt;
	static boolean success = false;
	static long ans;
	static Queue<OP> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// BFS
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		queue.add(new OP(Long.parseLong(st.nextToken()), 0));
		ans = Long.parseLong(st.nextToken());
		
		bfs();
		System.out.println(success? cnt + 1 : -1);
	}

	static void bfs() {
		OP temp;
		while(!queue.isEmpty()) {
			temp = queue.poll();
			
			if(temp.num == ans) {
				success = true;
				cnt = temp.cnt;
				break;
			}
				
			else if(temp.num < ans) {
				queue.add(new OP(temp.num * 2, temp.cnt + 1));
				queue.add(new OP(temp.num * 10 + 1, temp.cnt + 1));
			}
		}
	}
}
