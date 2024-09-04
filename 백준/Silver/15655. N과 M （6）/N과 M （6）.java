import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static int N,M;
	public static int[] arr;
	public static boolean[] visited;
	public static int[] arr1;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	arr = new int[M];
    	visited = new boolean[N];
    	arr1 = new int[N];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i<N; i++) {
    		arr1[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(arr1);
    	
    	dfs(0, 0);
    	System.out.println(sb.toString());
	}
    
    public static void dfs(int depth, int idx) {
    	if (depth == M) {
			for(int i = 0; i<M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
    	
    	for(int i = idx; i<N; i++) {
    		if(!visited[i]) {
    			visited[i] = true;
    			arr[depth] = arr1[i];
    			dfs(depth+1, i);
    			visited[i] = false;
    		}
    	}
	}

}
