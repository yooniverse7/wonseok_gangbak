import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, String> hm = new HashMap<>();
		
		for(int i = 0; i<N; i++) {
			String[] elements = br.readLine().split(" ");
			hm.put(elements[0], elements[1]);
		}
		
		for(int i = 0; i<M; i++) {
			String str = br.readLine();
			System.out.println(hm.get(str));
		}
		
	}
	

}
