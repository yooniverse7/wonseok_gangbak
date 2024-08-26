import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 사진틀 개수
		int M = Integer.parseInt(br.readLine()); // 총 추천 횟수

		int[] arr = new int[101]; // 추천수 누적 배열
		int[][] photo = new int[2][N]; // 사진틀 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		cute : for(int i = 0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			boolean check = true;
			for(int k = 0; k<N; k++) {
				if(photo[1][k] == num) {
					check = false;
				}
			}
			
			arr[num]++;
			
			
			if(check) {
				for(int j = 0; j<N; j++) {
					if(photo[1][j] == 0) {// 틀이 비어있다면,
						photo[1][j] = num; // 틀 채우기
						photo[0][j]++;
						for(int z = 0; z<j; z++) {
							photo[0][z]++;
						}
						continue cute;
					}
				}
				
				int min = Integer.MAX_VALUE; // 추천 수가 가장 작은 값 찾기 
				for (int j = 0; j<N; j++) { // 틀이 차있다면, 작은 값 찾기 
					if(arr[photo[1][j]] <= min) {
						min = arr[photo[1][j]];
					}
				}
				
				
				int maxCnt = 0;
				int idx = 0;
				for (int j = 0; j < N; j++) { // 최솟값과 같은 값을 가지는 좌표찾기
					if(arr[photo[1][j]] == min) { 
						if(photo[0][j] > maxCnt) {
							maxCnt = photo[0][j];
							idx = j;
						}
					}
				}
				
				for(int j = 0; j<N; j++) {
					if(j != idx) {
						photo[0][j]++;
					}
					else {
						photo[0][j] = 1;
					}
				}
				arr[photo[1][idx]] = 0;
				photo[1][idx] = num;
				
			}
			
		}
		
		
		int[] result = new int[N];
		
		for(int i = 0; i<N; i++) {
			result[i] = photo[1][i];
		}
		
		Arrays.sort(result);
		
		for(int i = 0; i<N; i++) {
			if(result[i] != 0) {
				sb.append(result[i]).append(" ");
			}
		}

		System.out.println(sb.toString());
	}
	

}
