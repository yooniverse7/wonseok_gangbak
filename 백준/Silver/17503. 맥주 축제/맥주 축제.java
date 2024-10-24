import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	// 우선순위큐 생성
	// 도수 낮은 순서대로 우선순위큐에 넣기
	// n개 넘어가면 선호도 가장 낮은거 큐에서 빼기
	// n개 맥주 선호도가 m 이상이면 출력하기
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 기간 = 맥주 수
        int m = Integer.parseInt(st.nextToken()); // 선호도 합
        int k = Integer.parseInt(st.nextToken()); // 맥주 종류
        int sum = 0; // 선호도 합
        int min = -1; // 마지막 도수
        
        int[][] beer = new int[k][2];
        
        for(int i = 0; i<k; i++) {
        	st = new StringTokenizer(br.readLine());
        	beer[i][0] = Integer.parseInt(st.nextToken());
        	beer[i][1] = Integer.parseInt(st.nextToken());
        }
        
        // 도수값을 낮은 순으로 정렬
        Arrays.sort(beer, Comparator.comparingInt(o -> o[1]));
        
        // 선호도를 담는 우선순위 큐
        // 선호도가 높은 순서로 담기기 때문에 큐 사이즈가 n이 되고 선호도 합이 m이 될 때의 맥주 도수를 출력
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i<k; i++) {
        	pq.offer(beer[i][0]); // 도수가 낮은 맥주의 선호도를 담음
        	
        	sum += beer[i][0]; // 선호도를 더한다
        	
        	if(pq.size() > n) { // 맥주 개수가 n개 넘어가면 
        		int num = pq.poll(); // 맨 뒤쪽을 뺀다
        		sum -= num;
        	}
        	
        	if(pq.size() == n && sum >= m) { // 사이즈같은데 선호도도 이상이면 도수 바꿔주기
        		min = beer[i][1];
        		break;
        	}
        	
        	
        }
        
        System.out.println(min);
        
    }
}
