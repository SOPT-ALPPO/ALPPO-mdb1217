import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LuckyString {

	static int ans = 0;
	static String s;
	static int list[] = new int[26];
	public static void main(String[] args) throws IOException {
		// 백트래킹
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = br.readLine();
		for(int i = 0; i < s.length(); ++i)
			++list[s.charAt(i) - 'a'];
		
		tracking(0, -1);
		System.out.println(ans);
	}
	
	static void tracking(int depth, int prev) {
		if(depth == s.length())
			++ans;
		else {
			for(int i = 0; i < 26; ++i) {
				if(list[i] != 0 && prev != i) {
					--list[i];
					tracking(depth + 1, i);
					++list[i];
				}
			}
		}
	}

}
