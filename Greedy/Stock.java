import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Stock {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// ±×¸®µð
		StringBuilder sb = new StringBuilder();
		int T;
		int N;
		long a;
		long max;
		long list[];
		long sum;
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());

		for(int i = 0; i < T; i++) {
			max = 0;
			sum = 0;
			N = Integer.parseInt(br.readLine());
			list = new long[N];
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				a = Long.parseLong(st.nextToken());
				list[j] = a;
			}
			
			max = list[N - 1];
			for(int j = N - 2; j >= 0; j--) {
				if(max > list[j])
					sum += max - list[j];
				else
					max = list[j];
			}
			
			sb.append(sum + "\n");
		}
		System.out.println(sb.toString());
	}

}
