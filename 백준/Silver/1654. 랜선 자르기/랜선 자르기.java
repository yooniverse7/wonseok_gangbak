import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken()); // 랜선 개수
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[K];
		
		long max = 0;
		
		// 랜선의 최대길이 찾기
		for(int i = 0; i<K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(max < arr[i]) {
				max = arr[i];
			}
		}

		max++;
		
		long min = 0;
		long mid = 0;
		
		while (min < max) {
			mid = (max + min) /2;
			
			long cnt = 0;
			
			for(int i = 0; i<arr.length; i++) { // 구해진 중간 길이로 잘라서 총 몇개 만들어지는지 확인
				cnt += (arr[i]/mid); 
			}
			
			if(cnt<N) {
				max = mid;
			}
			else {
				min = mid+1;
			}
		}
		System.out.println(min-1);
	}

}
