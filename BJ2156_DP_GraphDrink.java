import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2156_DP_GraphDrink {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s[] = new int[n+1];
		int a[] = new int[n+1];
		
		for(int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		if(n==1){
			System.out.println(a[1]);
		}else if(n==2){
			System.out.println(a[1]+a[2]);
		}else if(n==3){
			s[3] = Math.max(a[1]+a[2], a[1]+a[3]);
			s[3] = Math.max(s[3], a[2]+a[3]);
			System.out.println(s[3]);
		}else{
			s[1] = a[1];
			s[2] = a[1]+a[2];
			s[3] = Math.max(s[2], a[1]+a[3]);
			s[3] = Math.max(s[3], a[2]+a[3]);
			
			for(int i=4; i<=n; i++){
				s[i] = Math.max(s[i-1],a[i]+a[i-1]+s[i-3]);
				s[i] = Math.max(s[i],a[i]+s[i-2]);
			}
			
			System.out.println(s[n]);
		}
	}
}
