import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine()); // 친구가 맞은 문제 개수
		
		String myResult = br.readLine(); // 내 결과
		String friendResult = br.readLine(); // 친구 결과
		
		int myCnt = 0; // 내가 맞춘 개수
		int sameCnt = 0; // 둘이 같은 개수
		
		int n = myResult.length(); // 총 개수
		
		for(int i = 0; i<n; i++) {
			if(myResult.charAt(i) == friendResult.charAt(i)) {
				sameCnt++;
			}
		}
		
		if(sameCnt >= k) {
			myCnt = n - sameCnt + k;
		}else {
			myCnt = n - k + sameCnt;
		}
		
		System.out.println(myCnt);
		
		
	}

}
