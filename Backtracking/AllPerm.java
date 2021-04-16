import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllPerm {

	static StringBuilder ans = new StringBuilder();
	static boolean Visited[];
	static StringBuilder sb = new StringBuilder();
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 백트래킹
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		Visited = new boolean[N + 1];
		tracking(0);
		
		System.out.print(ans.toString());
	}
	
	static void tracking(int d) {
		if(d == N)
			ans.append(sb + "\n");
		else {
			for(int i = 1; i <= N; ++i) {
				if(!Visited[i]) {
					Visited[i] = true;
					sb.append(i + " ");
					tracking(d + 1);
					Visited[i] = false;
					sb.delete(sb.length() - 2, sb.length());
				}
			}
		}
	}

}
