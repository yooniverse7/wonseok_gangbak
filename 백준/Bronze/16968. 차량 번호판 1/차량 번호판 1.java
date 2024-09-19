import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int result = 1;
        
        String[] elements = br.readLine().split("");
        for(int i = 0; i<elements.length; i++) {
        	// 첫번째 숫자 경우의 수
        	if(i == 0) {
        		// 알파벳
        		if(elements[i].equals("c")) {
        			result *= 26;
        		// 숫자
        		}else {
        			result *= 10;
        		}
        	// 두번째부터 
        	} else {
        		if(elements[i].equals(elements[i-1])) {
        			if(elements[i].equals("c")) {
            			result *= 25;
            		// 숫자
            		}else {
            			result *= 9;
            		}
        		} else {
        			if(elements[i].equals("c")) {
            			result *= 26;
            		// 숫자
            		}else {
            			result *= 10;
            		}
        		}
        	}
        }
        
        System.out.println(result);
	}
    
}