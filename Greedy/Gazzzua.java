import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gazzzua {

	public static void main(String[] args) throws IOException {
		// ÁÖÈ« ÄÚÀÎ
		int list[];
		int N;
		int max;
		int sum = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		list = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i)
			list[i] = Integer.parseInt(st.nextToken());
		
		max = list[N - 1];
		for(int j = N - 2; j >= 0; j--) {
			if(max > list[j])
				sum += max - list[j];
			else
				max = list[j];
		}
		
		System.out.println(sum);
	}

}
