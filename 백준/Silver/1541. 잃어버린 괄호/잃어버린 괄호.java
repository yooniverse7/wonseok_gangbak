import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int sum;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		String[] str = br.readLine().split("-");
		sum = 0;
	
		
		for(int i = 0; i<str.length; i++) {
			if(i == 0) { // 첫번째일 때,
				String[] elements = str[i].split("\\+");
				for(int j = 0; j<elements.length; j++) {
					sum += Integer.parseInt(elements[j]);
				}
			}
			else { 
				String[] element = str[i].split("\\+");
				for(int j = 0; j<element.length; j++) {
					sum -= Integer.parseInt(element[j]);
				}
			}
		}
		
		System.out.println(sum);
	}
}
