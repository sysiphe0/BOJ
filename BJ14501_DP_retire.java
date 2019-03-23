import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14501_DP_retire {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t[] = new int[n+1];
		int p[] = new int[n+1];
		int d[] = new int[n+2];
		for(int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=n; i++){
			if(i+t[i] > n+1) continue;
			d[i+t[i]] = Math.max(d[i+t[i]], d[i]+p[i]);
			for(int j=i+t[i]; j<=n+1; j++){
				d[j] = Math.max(d[j], d[i+t[i]]);
			}
		}
		System.out.println(d[n+1]);
	}
	
}
