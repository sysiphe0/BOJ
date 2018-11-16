import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9095_plus123 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++){
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d[] = new int[n+1];
			if(n>=1) d[1]=1;
			if(n>=2) d[2]=2;
			if(n>=3) d[3]=4;
			if(n>=4){
				for(int i=4; i<=n; i++){
					d[i] = d[i-1]+d[i-2]+d[i-3];
				}
			}
			System.out.println(d[n]);
		}
	}
}
