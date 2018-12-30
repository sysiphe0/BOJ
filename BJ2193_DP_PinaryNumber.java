import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2193_DP_PinaryNumber {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long sol[] = new long[n+1];
		sol[0] = 1;
		sol[1] = 1;
		if(n<2){
			System.out.println(1);
		}else{
			sol[2] = 1;
			for(int i=3; i<=n; i++){
				sol[i] = sol[i-1]+sol[i-2]; 
			}
			System.out.println(sol[n]);
		}
	}
}
