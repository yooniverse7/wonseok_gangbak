import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static int n, k;
	public static int[] arr, select;
	public static HashSet<String> hs;
	public static boolean[] visited;
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine()); // 카드 개수
        k = Integer.parseInt(br.readLine()); // 선택 가능 수
        arr = new int[n];
        select = new int[k];
        hs = new HashSet<>();
        visited = new boolean[n];
        
        for(int i = 0; i<n; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
       checkNum(0);
       System.out.println(hs.size());
        
    }
    
    public static void checkNum(int depth) {
		
    	if(depth == k) {
    		StringBuilder sb = new StringBuilder();
    		for(int i = 0; i<k; i++) {
    			sb.append(select[i]);
    		}
    		
    		hs.add(sb.toString());
    		return;
    	}
    	
    	for(int i = 0; i<n; i++) {
    		if(!visited[i]) {
    			visited[i] = true;
    			select[depth] = arr[i];
    			checkNum(depth+1);
    			visited[i] = false;
    		}
    	}
    	
	}
}
