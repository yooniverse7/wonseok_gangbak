import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	
	public static int N, X, M;
	public static int[] arr;
	public static int[] maxArr;
	public static int[][] doc;
	public static PriorityQueue<int[]> pq;
	public static int max_sum;
	

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++) {
        	st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken()); // 우리의 수
        	X = Integer.parseInt(st.nextToken()); // 햄스터 최대 수
        	M = Integer.parseInt(st.nextToken()); // 기록의 수
        	max_sum = Integer.MIN_VALUE; // 최대 합
        	
        	arr = new int[N]; // 우리
        	doc = new int[M][3]; // 기록 
        	maxArr = new int[N]; // 최대 순서
        	
        	for(int i = 0; i<M; i++) {
        		st = new StringTokenizer(br.readLine());
        		doc[i][0] = Integer.parseInt(st.nextToken()) - 1;
        		doc[i][1] = Integer.parseInt(st.nextToken()) - 1;
        		doc[i][2] = Integer.parseInt(st.nextToken());
        	}
        	dfs(0, 0);
        	
        	sb.append("#").append(tc + " ");
        	
        	if (max_sum == Integer.MIN_VALUE) {
				sb.append(-1);
			} else {
				for(int i = 0; i<N; i++) {
					sb.append(maxArr[i] + " ");
				}
			}
        	
        	sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    
    public static void dfs(int cnt, int sum) {
    	if(cnt == N) { // 배열 다 채워졌을 때
    		for(int i = 0; i < M; i++) {
    			int check_sum = 0;
    			for(int j = doc[i][0]; j<=doc[i][1]; j++) {
    				check_sum += arr[j];
    			}
    			if(check_sum != doc[i][2]) return;
    		}
    		if(sum > max_sum) { // 합 최대 구하기
    			max_sum = sum;
    			maxArr = arr.clone();
    		}
    		return;
    	}
    	
    	for(int i = 0; i<=X; i++) {
    		arr[cnt] = i;
    		dfs(cnt+1, sum+i);
    	}
    }
    
}
