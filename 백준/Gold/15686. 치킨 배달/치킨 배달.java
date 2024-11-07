import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static int N, M, result;
	public static ArrayList<int[]> chicken; // 치킨집 위치
	public static ArrayList<int[]> people; // 집 위치
	public static boolean visited[]; // 치킨집 선택 여부
	public static int arr[][];
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE; // 치킨거리 최솟값
        chicken = new ArrayList<>();
        people = new ArrayList<>();
        arr = new int[N][N];
        
        
        for(int i = 0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j<N; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		if(arr[i][j] == 2) {
        			chicken.add(new int[] {i, j});
        		}
        		if(arr[i][j] == 1) {
        			people.add(new int[] {i, j});
        		}
        	}
        }
        visited = new boolean[chicken.size()];
        back(0, 0);
        System.out.println(result);
                
    }
    
    public static void back(int cnt, int start) {
    	if(cnt == M) {
    		int sum = 0;
    		for(int[] person : people) {
    			int min = Integer.MAX_VALUE;
    			for(int i = 0; i<chicken.size(); i++) {
    				if(visited[i]) { // 방문한 치킨집과의 거리를 구하기
    					int d = Math.abs(person[0] - chicken.get(i)[0]) + Math.abs(person[1] - chicken.get(i)[1]);
        				min = Math.min(min, d); 
    				}
    			}	
    			sum += min;
    		}
    		result = Math.min(result, sum);
    		return;
    		
    	}
    	for(int i = start; i<chicken.size(); i++) {
    		visited[i] = true;
    		back(cnt+1, i+1);
    		visited[i] = false;
    	}
    }
    
}
