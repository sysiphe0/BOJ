import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1463_DP_makeOne {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d[] = new int[n+1];
		for(int i=0; i<=n; i++){
			d[i] = Integer.MAX_VALUE;
		}
		if(n == 1){
			System.out.println(0);
		}else if(n==2 || n==3){
			System.out.println(1);
		}else if(n > 3){
			d[1] = 1;
			d[2] = 1;
			d[3] = 1;
			
			for(int i=4; i<=n; i++){
				d[i] = d[i-1]+1;
				if(i%2==0){
					d[i] = Math.min(d[i], d[i/2]+1);
				}
				if(i%3==0){
					d[i] = Math.min(d[i], d[i/3]+1);
				}
			}
			System.out.println(d[n]);
		}
	}
	
}
