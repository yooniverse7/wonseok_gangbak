import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static int N, result;
	public static LinkedList<Integer> arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        arr = new LinkedList<>();
        result = 0;
       
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
        	arr.add(Integer.parseInt(st.nextToken()));
        }
        
        back(0);
        
        System.out.println(result);
    }
    
    public static void back(int sum) {
    	
    	if(arr.size() == 2) {
    		result = Math.max(result, sum);
    		return;
    	}
    	
    	
    	for(int i = 1; i<arr.size()-1; i++) {
    		int tmp = arr.get(i);
    		int chage = arr.get(i-1) * arr.get(i + 1);
    		arr.remove(i);
    		back(sum+chage);
    		arr.add(i, tmp);
    	}
    }
}
