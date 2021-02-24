import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parity {

	public static void main(String[] args) throws IOException {
		int one_cnt = 0;
		String s;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		while(!s.equals("#")) {
			one_cnt = 0;
			for(int i = 0; i < s.length() - 1; i++) {
				if(s.charAt(i) == '1') {
					++one_cnt;
				}
			}
			
			if(s.charAt(s.length() - 1) == 'e') {
				if(s.length() != 1) {
					if(one_cnt % 2 == 0)
						System.out.println(s.substring(0, s.length() - 1) + '0');
					else
						System.out.println(s.substring(0, s.length() - 1) + '1');
				}
				else
					System.out.println('0');
			}
			else {
				if(s.length() != 1) {
					if(one_cnt % 2 == 0)
						System.out.println(s.substring(0, s.length() - 1) + '1');
					else
						System.out.println(s.substring(0, s.length() - 1) + '0');
				}
				else
					System.out.println('1');
			}
			s = br.readLine();
		}
	}
}