import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1149_RGB {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c[][] = new int[n+1][3];
		int d[][] = new int[n+1][3];
		for(int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++){
				c[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<3; i++){
			d[1][i] = c[1][i];
		}
		for(int i=2; i<=n; i++){
			d[i][0] = Math.min(d[i-1][1]+c[i][0], d[i-1][2]+c[i][0]);
			d[i][1] = Math.min(d[i-1][0]+c[i][1], d[i-1][2]+c[i][1]);
			d[i][2] = Math.min(d[i-1][0]+c[i][2], d[i-1][1]+c[i][2]);
		}
		System.out.println(Math.min(Math.min(d[n][0], d[n][1]),d[n][2]));
	}
}
