import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2579_stairUp {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d[][] = new int[n+1][2];
		int s[] = new int[n+1];
		for(int i=1; i<=n; i++){
			st =  new StringTokenizer(br.readLine());
			s[i] = Integer.parseInt(st.nextToken());
		}
		d[1][0] = s[1];
		d[1][1] = s[1];
		d[2][0] = s[2];
		d[2][1] = s[1]+s[2];
		for(int i=3; i<=n; i++){
			d[i][0] = Math.max(d[i-2][0], d[i-2][1])+s[i];
			d[i][1] = d[i-1][0]+s[i];
		}
		System.out.println(Math.max(d[n][0],d[n][1]));
	}
}
