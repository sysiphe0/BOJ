import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9465_DP_sticker {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc<=T; tc++){
			st= new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int a[][] = new int[3][n+1];
			int d[][] = new int[3][n+1];
			st= new StringTokenizer(br.readLine());
			for(int i=1; i<=n; i++){
				a[1][i] = Integer.parseInt(st.nextToken());
			}
			st= new StringTokenizer(br.readLine());
			for(int i=1; i<=n; i++){
				a[2][i] = Integer.parseInt(st.nextToken());
			}
			for(int i=4; i<=n; i++){
			}
			d[1][1] = a[1][1];
			d[2][1] = a[2][1];
			if(n>=2){
				d[1][2] = Math.max(d[2][1]+a[1][2], a[1][2]);
				d[2][2] = Math.max(d[1][1]+a[2][2], a[2][2]);
			}
			if(n>=3){
				for(int i=3; i<=n; i++){
					d[1][i] = Math.max(d[2][i-1]+a[1][i], d[2][i-2]+a[1][i]);
					d[2][i] = Math.max(d[1][i-1]+a[2][i], d[1][i-2]+a[2][i]);
				}
			}
			System.out.println(Math.max(d[1][n],d[2][n]));
		}
	}
	
}
