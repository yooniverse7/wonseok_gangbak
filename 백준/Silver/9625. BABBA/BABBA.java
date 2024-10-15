import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

		// A는 B로 치환해주고
		// B는 A로 치환해서 StringBuilder에 붙임 -> K번 반복

	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;
	        StringBuilder sb;
	        int K = Integer.parseInt(br.readLine()); // 클릭 개수
	        
	        int[] arrA = new int[46];
	        int[] arrB = new int[46];
	        
	        arrA[0] = 1;
	        arrA[1] = 0;
	        arrA[2] = 1;
	        
	        arrB[0] = 0;
	        arrB[1] = 1;
	        
	        for(int i = 3; i<46; i++) {
	        	arrA[i] = arrA[i-1] + arrA[i-2];
	        }
	        
	        for(int i = 2; i<46; i++) {
	        	arrB[i] = arrB[i-1] + arrB[i-2];
	        }
	        
	        
	        System.out.println(arrA[K] + " " + arrB[K]);
	        
	    }
	    
}
