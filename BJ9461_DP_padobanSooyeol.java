import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9461_DP_padobanSooyeol {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++){
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			long p[] = new long[n+1];
			if(n==1){
				System.out.println(1);
			}else if(n==2){
				System.out.println(1);
			}else if(n==3){
				System.out.println(1);
			}else if(n==4){
				System.out.println(2);
			}else if(n==5){
				System.out.println(2);
			}else if(n==6){
				System.out.println(3);
			}else{
				p[1]=1;
				p[2]=1;
				p[3]=1;
				p[4]=2;
				p[5]=2;
				p[6]=3;
				for(int i=7; i<=n; i++){
					p[i] = p[i-1]+p[i-5];
				}
				System.out.println(p[n]);
			}
		}
	}
}
