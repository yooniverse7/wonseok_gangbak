import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bb = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while (true) {
            line = bb.readLine(); // ���ڿ� ����
            if ("0".equals(line)) {
                break;
            }
            
            int[] arr = new int[line.length()]; // int������ ��ȯ�ؼ� �迭 ����
            for (int i = 0; i < line.length(); i++) {
                arr[i] = line.charAt(i) - '0';
            }
            
            int[] result = new int[line.length()]; // ������ �迭
            for(int i = 0; i<line.length(); i++) {
            	result[i] = arr[arr.length - 1-i];
            }
            
            String str = Arrays.toString(result); // ������ �迭 ���ڿ�
            String arrS = Arrays.toString(arr); // ���� �迭 ���ڿ�
           
            
            if(arrS.equals(str)) {
            	System.out.println("yes");
            }else {
            	System.out.println("no");
            }

        }
	}

}
