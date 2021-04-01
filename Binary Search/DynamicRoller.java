import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DynamicRoller {

	public static void main(String[] args) throws IOException {
		// ÀÌºÐ Å½»ö
		StringBuilder sb = new StringBuilder();
		int left, right, mid;
		int N;
		int ans;
		long[] ink_list;
		long[] slime_list;
		StringTokenizer st;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		ink_list = new long[N];
		slime_list = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			ink_list[i] = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			slime_list[i] = Long.parseLong(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			left = i + 1;
			right = N - 1;
			ans = 0;
			while(left <= right) {
				mid = (left + right) / 2;
				
				if(slime_list[mid] <= ink_list[i]) {
					left = mid + 1;
					ans = mid;
				}
				else
					right = mid - 1;
			}
			sb.append(ans != 0? (ans - i) + " " : ans + " ");
		}
		
		System.out.println(sb.toString());
	}

}
