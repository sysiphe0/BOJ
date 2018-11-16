import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ11066_DP_fileSum {

	static int n, p[], d[][];
	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(bf.readLine());
		n = Integer.valueOf(bf.readLine());
		p = new int[n+1];
		d = new int[n+1][n+1];
		String nums[] = bf.readLine().split(" ");
		for(int i=1; i<=n; i++){
			p[i] = Integer.valueOf(nums[i-1]);
			Arrays.fill(d[i], Integer.MAX_VALUE);
		}
		
		System.out.println(go(1,n));
	}
	
	static int go(int i, int j){
		if(i==j){
			return 0;
		}
		if(d[i][j] != Integer.MAX_VALUE){
			return d[i][j];
		}
		
		int sum=0;
		for(int k=i; k<=j; k++){
			sum += p[k];
		}
		
		for(int k=i+1; k<=j; k++){
			int tmp = go(i,k-1) + go(k,j) + sum;
			d[i][j] = Math.min(d[i][j],tmp);
		}
		return d[i][j];
	
	}
	
}
