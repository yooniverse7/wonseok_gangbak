import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static int N;
    public static int[] arr;
    public static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            cnt = 0;
            check(0);
            
            sb.append("#" + tc).append(" " + cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
    
    public static void check(int x) {
    	
    	if (x == N) {
			cnt++;
			return;
		}
    	
    	for(int y = 0; y<N; y++) {
    		arr[x] = y;
    		if(checkNum(x)) {
    			check(x+1);
    		}
    	}
		
	}
    

    public static boolean checkNum(int x) { // true로 바꿔주기
    	for (int i = 0; i < x; i++) {
    		
    		if (arr[x] == arr[i]) {
				return false;
			}
    		
    		else if (Math.abs(x - i) == Math.abs(arr[x] - arr[i])) {
				return false;
			}
		}
    	
    	return true;
       
    }

}
