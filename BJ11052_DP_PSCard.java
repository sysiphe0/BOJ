import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11052_DP_PSCard {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d[] = new int[n+1];
		st=  new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++){
			d[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=2; i<=n ;i++){
			for(int j=1; j<=i/2; j++){
				d[i] = Math.max(d[i],d[i-j]+d[j]);
			}
		}
		System.out.println(d[n]);
	}
}
