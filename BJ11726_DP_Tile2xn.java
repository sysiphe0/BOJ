import java.util.Scanner;

public class BJ11726_DP_Tile2xn {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 1;
		for(int tc=1; tc<=T; tc++){
			int n = sc.nextInt();
			if(n==1 || n==2){
				System.out.println(n);
			}else{
				int d[] = new int[n+1];
				d[1] = 1;
				d[2] = 2;
				for(int i=3; i<=n; i++){
					d[i]=(d[i-1]+d[i-2])%10007;
				}
				System.out.println(d[n]);
			}
		}
	}
}
