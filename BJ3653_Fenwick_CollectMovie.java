import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ3653_Fenwick_CollectMovie {
	static int n, m;
	static int p[], tree[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		for(int T=1; T<=tc; T++){
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			p = new int[n+1];
			tree = new int[n+m+1];
			for(int i=1; i<=n; i++){
				p[i] = i+m;
				update(p[i],1);
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<m; i++){
				int k = Integer.parseInt(st.nextToken());
				System.out.print(sum(p[k])-1);
				update(p[k],-1);
				p[k] = m-i;
				update(p[k],1);
				if(i!=m-1){
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	static void update(int i, int diff){
		while(i<=n+m){
			tree[i] += diff;
			i += (i & -i);
		}
	}
	
	static int sum(int i){
		int ans = 0;
		while(i>0){
			ans += tree[i];
			i -= (i & -i);
		}
		return ans;
	}
}
