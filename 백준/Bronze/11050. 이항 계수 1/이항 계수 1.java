import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int N, K;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        
        int result = factorial(N) / (factorial(N-K) * factorial(K));
        System.out.println(result);
       
    }
    public static int factorial(int N) {
		
    	if(N <= 1) {
    		return 1;
    	}
    	return N * factorial(N-1);
	}
    
}