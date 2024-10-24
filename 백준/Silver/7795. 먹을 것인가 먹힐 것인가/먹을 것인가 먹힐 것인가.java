import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


// 배열을 두개 만들고 둘다 정렬
// 배열B의 처음부터 시작해서 인덱스값을 저장하고 A는 반대 순서로 가면서 작거나 같은게 나올 때까지 ++
// 그러다가 작은게 나오면 인덱스 바꿔주기
public class Main {

	public static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); // 테스트케이스 수
        
        for(int tc = 1 ; tc<=T; tc++) {
        	st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 배열 a 크기
            int b = Integer.parseInt(st.nextToken()); // 배열 b 크기
            int[] arrA = new int[a];
            int[] arrB = new int[b];
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<a; i++) {
            	arrA[i] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<b; i++) {
            	arrB[i] = Integer.parseInt(st.nextToken());
            }
        	
            Arrays.sort(arrA);
            Arrays.sort(arrB);
            
            checkCount(arrA, arrB, a, b);
            
            
        }
        
        System.out.println(sb.toString());
       
    }
    
    public static void checkCount(int[] arrA, int[] arrB, int a, int b) {
    	int idx = 0; // 배열 B 인덱스
    	int cnt = 0;
    	
    	for(int i = idx; i<b; i++) {
    		for(int j = a-1; j>=0; j--) {
    			if(arrB[i] >= arrA[j]) {
    				idx++;
    				break;
    			}
    			cnt++;
    		}
    	}
    	
    	sb.append(cnt).append("\n");
    	
    }
}
