import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EatGrapeDrink {

	static int memo[];
	static int list[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// DP
		int N;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		memo = new int[N + 1];
		
		Arrays.fill(memo, -1);
		list = new int[N + 1];
		for(int i = 1; i <= N; ++i)
			list[i] = Integer.parseInt(br.readLine());
		
		System.out.println(DP(N));
	}
	
	static int DP(int N) {
		if(N < 1)
			return 0;
		if(N == 1)
			return list[N];
		if(memo[N] >= 0)
			return memo[N];
		else {
			memo[N] = Math.max(DP(N - 2), list[N - 1] + DP(N - 3)) + list[N];
			memo[N] = Math.max(DP(N - 1), memo[N]);
			return memo[N];
		}
	}
}
