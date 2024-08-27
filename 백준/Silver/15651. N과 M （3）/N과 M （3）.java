import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	public static int N, M;
	public static StringBuilder sb;
	public static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 고를 수
		M = Integer.parseInt(st.nextToken()); // 고르는 개수
		
		arr = new int[M];
		dfs(0);
		System.out.println(sb.toString());

	}
	
	public static void dfs(int d) {
		
		if (d == M) { // 깊이가 M과 같다면
			for(int i = 0; i<M; i++) { // M까지 출력
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i = 1; i<=N; i++) {
			arr[d] = i;
			dfs(d+1);
		}
	}

}
