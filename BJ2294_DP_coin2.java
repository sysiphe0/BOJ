import java.util.Scanner;

public class BJ2294_DP_coin2 {

	static int n,m,p[],d[];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = 1;
		
		for(int tc=1; tc<=T; tc++){
			n = sc.nextInt();
			m = sc.nextInt();
			p = new int[n];
			d = new int[m+1];
			
			for(int i=0;i<n;i++){
				p[i] = sc.nextInt();
			}
			for(int i=0; i<=m; i++){
				d[i] = Integer.MAX_VALUE-1;
			}

			for(int j=0; j<n; j++){
				if(p[j]<=m){
					d[p[j]] = 1;
					if(p[j]<m){
						for(int i=p[j]+1; i<=m; i++){
							d[i] = Math.min(d[i], d[i-p[j]]+1);
						}
					}
				}
			}
			if(d[m] != Integer.MAX_VALUE-1){
				System.out.println(d[m]);
			}else{
				System.out.println(-1);
			}
		}
	}
}
