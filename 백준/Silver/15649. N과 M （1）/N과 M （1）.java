import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int[] arr;
	public static boolean[] visited;
	public static int N, M;
	public static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		visited = new boolean[N];
		dfs(0);		
		System.out.println(sb.toString());
	}

	public static void dfs(int depth) {
		if(depth == M) {
			for(int i = 0; i<M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i<=N; i++) {
			if(!visited[i-1]) {
				visited[i-1] = true; // 방문 처리
				arr[depth] = i;
				dfs(depth + 1);
				visited[i-1] = false; // 원복
			}
		
		}
	}

}
