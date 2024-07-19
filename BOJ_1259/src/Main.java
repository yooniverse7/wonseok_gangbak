import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bb = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while (true) {
            line = bb.readLine(); // 문자열 저장
            if ("0".equals(line)) {
                break;
            }
            
            int[] arr = new int[line.length()]; // int형으로 변환해서 배열 저장
            for (int i = 0; i < line.length(); i++) {
                arr[i] = line.charAt(i) - '0';
            }
            
            int[] result = new int[line.length()]; // 뒤집을 배열
            for(int i = 0; i<line.length(); i++) {
            	result[i] = arr[arr.length - 1-i];
            }
            
            String str = Arrays.toString(result); // 뒤집은 배열 문자열
            String arrS = Arrays.toString(arr); // 기존 배열 문자열
           
            
            if(arrS.equals(str)) {
            	System.out.println("yes");
            }else {
            	System.out.println("no");
            }

        }
	}

}
