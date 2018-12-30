import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1912_DP_SeriesSum {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int a[] = new int[n+1];
		long sum[] = new long[n+1];
		long sol = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++){
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		sum[1] = a[1];
		sol = a[1];
		
		for(int i=2; i<=n; i++){
			if(sum[i-1]>0){
				sum[i] = sum[i-1]+a[i];
			}else{
				sum[i] = a[i];
			}
			sol = Math.max(sol, sum[i]);
		}
		System.out.println(sol);
	}
}
