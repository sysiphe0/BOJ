import java.util.Scanner;

public class BJ1003_DP_fibonacci {

	static int fb[][];
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++){
			int n = sc.nextInt();
			fb = new int[n+1][2];
			fb[0][0] = 1;
			fb[0][1] = 0;
			if(n==0){
				System.out.println("1 0");
			}else{
				fb[1][0] = 0;
				fb[1][1] = 1;
				for(int i=2; i<=n; i++){
					fb[i][0] = fb[i-2][0] + fb[i-1][0];
					fb[i][1] = fb[i-2][1] + fb[i-1][1];
				}
				System.out.print(fb[n][0]);
				System.out.println(" "+fb[n][1]);
			}
		}
	}
	

	
}
