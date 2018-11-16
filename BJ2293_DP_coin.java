import java.util.Scanner;

public class BJ2293_DP_coin {

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

			for(int j=0; j<n; j++){
				if(p[j]<=m){
					d[p[j]]++;
					if(p[j]<m){
						for(int i=p[j]+1; i<=m; i++){
							d[i] += d[i-p[j]];
						}
					}
				}
			}
			
			System.out.println(d[m]);
			
		}
		
	}
	
}
