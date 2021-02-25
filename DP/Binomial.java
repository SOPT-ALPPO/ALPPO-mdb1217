import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Binomial {

	static int memo[][];
	public static void main(String[] args) throws IOException {
		//nck 구하기
		//DP
		//탑다운
		int N, K;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		memo = new int[N + 1][K + 1];
		System.out.println(DP(N, K));
	}

	static int DP(int n, int k) {
		if(k == 0 || k == n) {
			return 1;
		}
		if(memo[n][k] > 0)
			return memo[n][k];
		else {
			memo[n][k] = (DP(n - 1, k - 1) + DP(n - 1, k)) % 10007; 
			return memo[n][k];
		}
	}
}
