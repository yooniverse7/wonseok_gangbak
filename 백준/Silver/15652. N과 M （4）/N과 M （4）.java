import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static int N,M;
	public static int[] arr;
	public static boolean[] visited;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	arr = new int[M];
    	visited = new boolean[N];
    	
    	dfs(0, 1);
    	System.out.println(sb.toString());
	}
    
    public static void dfs(int depth, int idx) {
		if(depth == M) {
			for(int i = 0; i<M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = idx; i<=N; i++) {
			
				arr[depth] = i;
				dfs(depth+1, i);
	
		}
	}

}
