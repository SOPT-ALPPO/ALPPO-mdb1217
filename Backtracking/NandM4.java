import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NandM4 {

	static StringBuilder ans = new StringBuilder();
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	public static void main(String[] args) throws IOException {
		// backtracking
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		tracking(1, 0);
		
		System.out.print(ans);
	}
	
	static void tracking(int start, int d) {
		if(d == M)
			ans.append(sb + "\n");
		else {
			for(int i = start; i <= N; ++i) {
				sb.append(i + " ");
				tracking(i, d + 1);
				sb.delete(sb.length() - 2, sb.length());
			}
		}
	}

}
