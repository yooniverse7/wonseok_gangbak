import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import org.w3c.dom.html.HTMLBaseElement;

public class Main {
	
	public static int k;
	public static int[] arr, select;
	public static HashSet<String> hs;
	public static boolean[] visited;
	public static StringBuilder sb;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        
        while (true) {
        	st = new StringTokenizer(br.readLine());
        	k = Integer.parseInt(st.nextToken());
        	if(k == 0) break;
        	arr = new int[k];
        	select = new int[6];
        	for(int i = 0; i<k; i++) {
        		arr[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	checkNum(0, 0);
        	System.out.println();
		}
        
    }
    
    public static void checkNum(int depth, int cnt) {
		
    	if(cnt == 6) {
    		for(int i = 0; i<6; i++) {
    			System.out.print(select[i] + " ");
    		}
    		System.out.println();
    		return;
    	}
    	
    	for(int i = depth; i<k; i++) {
    		select[cnt] = arr[i];
    		checkNum(i+1, cnt+1);
    	}
    	
	}
}
