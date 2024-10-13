import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	// 위치 start를 저장하고 더해가면서 M이 될 때 count++
	// start 위치를 +1로 늘리면서 찾아가기

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) { // 배열 채우기
        	arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        
       cute : while (start<N) { // start가 N이 되기 전까지 반복
        	int sum = 0;
			for(int i = start; i<N; i++) {
				sum += arr[i]; // sum에 더하기
				if(sum == M) { // sum이 M과 같아지면 cnt, start 올린 후 for문 빠져나오기
					cnt++;
					start++;
					break;
				}else if(sum > M) { // 합이 M을 넘어가면 start만 증가
					start++;
					break;
				}
				if(i == N-1) {
					break cute;
				}

			}
		}
        
        System.out.println(cnt);
    }


}
