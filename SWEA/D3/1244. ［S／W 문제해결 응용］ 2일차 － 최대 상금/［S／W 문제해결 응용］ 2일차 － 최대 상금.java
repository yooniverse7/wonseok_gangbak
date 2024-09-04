import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	public static char[] arr;
	public static int N;
	public static int max;
	public static Set<String> visited;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	
    	int T = Integer.parseInt(br.readLine());
    	for(int tc = 1; tc<=T; tc++) {
    		st = new StringTokenizer(br.readLine());
    		arr = st.nextToken().toCharArray();
    		N = Integer.parseInt(st.nextToken());
    		visited = new HashSet<>();
    		max = 0;
    		
    		dfs(0);
    		
    		sb.append("#" + tc).append(" ").append(max).append("\n");
    	}
    	System.out.println(sb.toString());
	}
    
    public static void dfs(int depth) {
    	if (depth == N) {
    		int current = Integer.parseInt(new String(arr));
			max = Math.max(max, current);
			return;
		}
		String visitedCheck = new String(arr) + depth;
		if (visited.contains(visitedCheck)) {
			return;
		}
    	visited.add(visitedCheck);
    	
    	char temp = 0;
    	for(int i = 0; i<arr.length; i++) {
    		for(int j = 0; j<arr.length; j++) {
    			if(i != j) {
    				temp = arr[j];
    		    	arr[j] = arr[i];
    		    	arr[i] = temp;
    		    	
    	    		dfs(depth+1);
    	    		
    	    		temp = arr[i];
    		    	arr[i] = arr[j];
    		    	arr[j] = temp;
    			}
    		}
    		
    	}
	}

}
