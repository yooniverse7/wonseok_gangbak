import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
			arr[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
		}
        // 끝나는 시간을 기준 정렬
 		Arrays.sort(arr, new Comparator<int[]>() {
 			@Override
 			public int compare(int[] o1, int[] o2) {
 				
 				if(o1[1] == o2[1]) {
 					return o1[0] - o2[0];
 				}
 				return o1[1] - o2[1];
 			}
  
 		});
 		
 		int cnt = 0;
 		int tmp = 0; // 직전 종료 시간
 		
 		for(int i = 0; i < N; i++) {
			
			// 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 
			if(tmp <= arr[i][0]) {
				tmp = arr[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
    }
}
