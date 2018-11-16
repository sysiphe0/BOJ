import java.util.Scanner;

public class BJ10942_DP_palindrome {

	static int n,p[],d[][],m,s[][];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T=1;
		for(int tc=1; tc<=T; tc++){
			n = sc.nextInt();
			p = new int[n];
			d = new int[n][n];
			
			for(int i=0; i<n; i++){
				p[i] = sc.nextInt();
			}
			
			m = sc.nextInt();
			s = new int[m][2];
			
			for(int i=0; i<m; i++){
				for(int j=0; j<2; j++){
					s[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<n; i++){
				d[i][i] = 1;
			}
			
			for(int i=0; i<n-1; i++){
				if(p[i]==p[i+1]){
					d[i][i+1] = 1;
				}
			}
			
			for(int i=0; i<n; i++){
				int x = i;
				int y = i;
				while(x-1 >= 0 && y+1 < n){
					if(d[x--][y++]==1 && p[x]==p[y]){
						d[x][y] = 1;
					}
				}
				
				x = i;
				y = i+1;
				while(x-1 >= 0 && y+1 < n){
					if(d[x--][y++]==1 && p[x]==p[y]){
						d[x][y] = 1;
					}
				}
			}
			
			for(int i=0; i<m; i++){
				System.out.println(d[s[i][0]-1][s[i][1]-1]);
			}
			
		}
		
	}
	
}
