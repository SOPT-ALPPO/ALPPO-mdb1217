import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimilarWord {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 브루트 포스
		int limit;
		int temp;
		int cnt = 0;
		String s;
		int input[];
		int comp[] = new int[26];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;

		N = Integer.parseInt(br.readLine());
		
		s = br.readLine();
		limit = s.length();
		for(int i = 0; i < limit; ++i)
			++comp[s.charAt(i) - 'A'];
		
		for(int i = 1; i < N; ++i) {
			temp = 0;
			input = new int[26];
			s = br.readLine();
			
			for(int j = 0; j < s.length(); ++j) {
				++input[s.charAt(j) - 'A'];
				if(comp[s.charAt(j) - 'A'] < input[s.charAt(j) - 'A'])
					++temp;
			}
			
			if(s.length() < limit)
				temp += limit - s.length();
			
			if(temp <= 1)
				++cnt;
		}
		
		System.out.println(cnt);
	}

}
