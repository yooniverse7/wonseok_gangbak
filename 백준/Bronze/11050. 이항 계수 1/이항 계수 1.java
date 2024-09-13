import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int N, K;
	public static int[][] arr;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1][K+1];
        
        System.out.println(factorial(N, K));
       
    }
    public static int factorial(int N, int K) {
		
    	if(arr[N][K] > 0) {
    		return arr[N][K];
    	}
    	if (K == 0 || N == K) {
			return arr[N][K] = 1;
		}
    	
    	return arr[N][K] = factorial(N-1, K-1) + factorial(N-1, K);
	}
    
}