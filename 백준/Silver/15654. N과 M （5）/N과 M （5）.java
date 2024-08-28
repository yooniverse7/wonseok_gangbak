import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int[] arr;
	public static int[] arr1;
	public static boolean[] visited;
	public static int N, M;
	public static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr1 = new int[N];
		StringTokenizer str = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr1[i] = Integer.parseInt(str.nextToken());
		}
		Arrays.sort(arr1); // 정렬하기
		
		arr = new int[M];
		visited = new boolean[N];
		dfs(0);		
		System.out.println(sb.toString());
	}

	public static void dfs(int depth) { // 깊이랑 현재 깊이를 저장하는 매개변수(끝 값)
		if(depth == M) {
			for(int i = 0; i<M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = arr1[i];
				dfs(depth + 1);
				visited[i] = false;
			}
			
		}
	}

}
