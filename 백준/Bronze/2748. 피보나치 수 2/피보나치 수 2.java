import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	// 미리 90으로 배열을 만들어두고 시작
	// 0번째와 1번째는 같으니 담아두고 배열 계속 채우기
	// 사이즈가 커지니 long으로 담기

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        long[] arr = new long[91];
        
        arr[0] = 0;
        arr[1] = 1;
        
        for(int i = 2; i<91; i++) {
        	arr[i] = arr[i-1] + arr[i-2];
        }
        
        System.out.println(arr[Integer.parseInt(br.readLine())]);
        
     }

}
