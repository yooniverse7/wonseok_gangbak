import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); 
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr); // 정렬

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i<M; i++) {
			
			// 찾는 값이 있으면 1 출력, 없으면 0 출력
			if(binarySearch(Integer.parseInt(st.nextToken())) >= 0) {
				sb.append(1).append("\n");
			}
			else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	public static int binarySearch(int key) {
		int lo = 0; // 왼쪽 끝 인덱스
		int hi = arr.length -1; // 오른쪽 끝 인덱스
		
		while (lo<=hi) {
			
			int mid = (lo + hi) / 2; // 중간위치
			
			if(key < arr[mid]) { // key 값이 중간보다 작을 때,
				hi = mid - 1;  // 오른쪽 끝에 중간-1값을 넣어줌
			}
			else if(key > arr[mid]) { // key 값이 중간보다 클 때,
				lo = mid + 1; // 완쪽 끝에 중간+1값을 넣어줌
			}
			else { // key와 중간값이 같을 때 중간값 리턴
				return mid;
			}
		}
		
		return -1;
	}
	

}
