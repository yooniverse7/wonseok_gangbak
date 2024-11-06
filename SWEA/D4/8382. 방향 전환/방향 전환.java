import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++) {
        	int result = 0;
        	int[] arr = new int[4];
        	st = new StringTokenizer(br.readLine());
        	for(int i = 0; i<4; i++) {
        		arr[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	int x = Math.abs(arr[2] - arr[0]); // x 차이
        	int y = Math.abs(arr[3] - arr[1]); // y 차이
        	
        	if((x%2 == 0 && y%2 == 0) || (x%2 == 1 && y%2 == 1)) { // 둘 다 짝수 혹은 홀수면,
        		result = Math.max(x, y) * 2;
        	}
        	else { // 한쪽이 홀수고 한쪽이 짝수면, 
        		result = Math.max(x, y) * 2 -1;
        	}
        	
        	sb.append("#").append(tc + " ").append(result + "\n");
        }
        System.out.println(sb.toString());
        
    }
}
