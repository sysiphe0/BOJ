import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11727_DP_2x1Tile {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long d[] = new long[n+1];
		d[1] = 1;
		if(n>1){
			d[2] = 3;
			for(int i=3; i<=n; i++){
				d[i] = (d[i-1]+d[i-2]*2)%10007;
			}
		}
		System.out.println(d[n]%10007);
	}
}
