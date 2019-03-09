import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2163_DP_cutChocolate {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int d[][] = new int[n+1][m+1];
		
		d[n][1] = n-1;
		for(int i=2; i<=m; i++){
			d[n][i] = d[n][i-1]+d[n][1]+1;
		}
		System.out.println(d[n][m]);
	}
	
}
