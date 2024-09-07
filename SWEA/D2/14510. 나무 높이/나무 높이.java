import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
		public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
	
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 나무 개수
			int[] tree = new int[N]; // 나무 높이 배열
			int max = 0; // 가장 높은 나무 
			int cnt1 = 0; // 홀수 날 개수
			int cnt2 = 0; // 짝수 날 개수
			int result = 0; // 결과 일수
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) { // 나무 높이 담아주면서 가장 큰 값 찾기
				tree[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, tree[i]);
			}
			
			// max값에서 나무 높이를 빼면 자라야하는 길이가 나옴
			for(int i = 0; i<N; i++) {
				cnt1 += (max - tree[i]) % 2; // 홀수 날짜의 개수 더해주기
				cnt2 += (max - tree[i]) / 2; // 짝수 날짜의 개수 더해주기
			}
			
			// 짝수 날짜, 홀수 날짜 개수를 다 세줬을 때 조정을 해줘야함
			// 두 날짜 수 얼추 비슷해야 최소 날짜가 나오기 때문
			// 짝수 날짜가 홀수 날짜보다 많다면 빼서 3으로 나눠줌
			int temp = Math.max(cnt2-cnt1, 0) / 3; 
			cnt1 += temp * 2;
			cnt2 -= temp;
			
			// 예제 : 2 3 10 5 가 입력 되었을 떄,
			// cnt1 = 2, cnt2 = 9 가 나오게 된다.
			// 두개의 차이가 7이므로 분배를 해줘야하고 2 하나는 1 두개 이므로 temp 값이 7/3=2기 때문에
			// 홀수 일자에 2*2=4를 더해주고, 짝수 일자에 홀수에 보낸 2일을 빼준다.
			// 그럼 cnt1 = 6, cnt2 = 7 이 된다.
			
			// 짝수 날짜 수가 2만큼 많다면 홀수 날짜수에 2를 더하고 짝수 날짜수에 1을 뺀다.
			int remain = Math.max(cnt2-cnt1, 0) % 3;
			if(remain == 2) {
				cnt1 += 2;
				cnt2--;
			}
			
			if(cnt1 <= cnt2) { // 짝수일자가 더 크다면, 짝수 일*2 출력
				result = cnt2*2;
			}else { // 홀수일자가 더 크다면, 홀수 일*2 -1 출력 
				result = cnt1 * 2 - 1;
			}
	
			sb.append("#" + tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
}