import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M;
	public static int[] arr, arr1;
	public static StringBuilder sb;
	public static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        arr1 = new int[N];
        visited = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
        	arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);
        dfs(0);
        System.out.println(sb.toString());
    }
    
    public static void dfs(int depth) {
		if(depth==M) {
			for(int i = 0; i<M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
    	
    	int temp = -1;
    	for(int i = 0; i<N; i++) {
    		
    			if(temp != arr1[i]) {
    				
        			arr[depth] = arr1[i];
        			temp = arr1[i];
            		dfs(depth+1);
            		
    			}
    			
			
    		
    	}
	}
    

}
