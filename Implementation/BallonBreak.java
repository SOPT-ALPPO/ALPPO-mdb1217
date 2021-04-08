import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BallonBreak {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// ±×¸®µð
		int list[];
		int comp;
		int arrow = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int N;
		
		N = Integer.parseInt(br.readLine());
		list = new int[1000002];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			comp = Integer.parseInt(st.nextToken());
			if(list[comp + 1] > 0) {
				++list[comp];
				--list[comp + 1];
			}
			else {
				++list[comp];
				++arrow;
			}
		}
		
		System.out.println(arrow);
	}

}
