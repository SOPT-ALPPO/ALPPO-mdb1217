import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CardString {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// ±×¸®µð
		String a;
		StringBuilder ans;
		StringBuilder sb = new StringBuilder();
		int T, N;
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; ++i) {
			N = Integer.parseInt(br.readLine());
			ans = new StringBuilder();
			
			st = new StringTokenizer(br.readLine());
			a = st.nextToken();
			ans.append(a);
			for(int j = 1; j < N; ++j) {
				a = st.nextToken();
				if(ans.toString().compareTo(a) <= 0)
					ans.append(a);
				else
					ans.insert(0, a);
			}
			sb.append(ans);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
