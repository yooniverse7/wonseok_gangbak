import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] result = new int[N]; // 결과 입력 배열
		
		
		for(int i = 0; i<N; i++) { // 배열 채우기
			arr[i] = i+1;
		}
		
		int resultIdx = 0; // 결과 배열 인덱스
		int currentIdx = 0; // 최근 인덱스 저장
		int count = 0;
		while (count < N) {
			int z = 0;
			while (z < K) {
				if(arr[currentIdx] != -1) { // 배열 해당 위치가 -1이 아니라면,
					z++;
				}
				if(z == K) { // 같아지면 나가기
					break;
				}
				currentIdx = (currentIdx + 1) % N;
			}
			result[resultIdx++] = arr[currentIdx];
			arr[currentIdx] = -1;
			count++;
		}
		
		System.out.print("<");
		for(int i = 0; i<N; i++) { // 결과 출력
			if(i == N-1) {
				System.out.print(result[i]);
			}else {
				System.out.print(result[i]+ ", ");
			}
			
		}
		System.out.print(">");
		
	}

}
