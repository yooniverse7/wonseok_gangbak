import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 설탕 무게
		int result = 0;
		
		int fiveCnt = N/5; // 5개수
	
		
		if(N%5 == 1 && fiveCnt>=1) { // 나머지가 1일 때,
			result = 2 + (fiveCnt - 1);
		} else if (N%5 == 2 && fiveCnt >=2) { // 나머지가 2일 때,
			result = 4 + (fiveCnt - 2);
		} else if (N%5 == 3) { // 나머지가 3일 때,
			result = fiveCnt + 1;
		} else if (N%5 == 4 && fiveCnt>=1) { // 나머지가 4일 때,
			result = 3 + (fiveCnt - 1);
		} else if(N%5 == 0) { // 나머지가 0 일때,
			result = fiveCnt;
		} else {
			result = -1;
		}
		
		System.out.println(result);
		
	}

}
