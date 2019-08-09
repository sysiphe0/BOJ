import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ2042_FenwickTree_1 {

	static long p[], tree[];
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		p = new long[1000001];
		tree = new long[3000001];
		ArrayList<Long> sol = new ArrayList<Long>();
		for(int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine());
			p[i] = Integer.parseInt(st.nextToken());
			update(i,p[i]);
		}
		for(int i=1; i<=m+k; i++){
			st = new StringTokenizer(br.readLine());
			int t1 = Integer.parseInt(st.nextToken());
			int t2 = Integer.parseInt(st.nextToken());
			int t3 = Integer.parseInt(st.nextToken());
			if(t1==1){
				long diff = t3-p[t2];
				p[t2] = t3;
				update(t2,diff);
			}else if(t1==2){
				sol.add(sum(t3)-sum(t2-1));
			}
		}
		for(int i=0; i<k; i++){
			System.out.println(sol.get(i));
		}
	}
	
	static void update(int i, long diff){
		while(i<=n){
			tree[i] += diff;
			i += (i & -i);
		}
	}
	
	static long sum(int i){
		long ans = 0L;
		while(i>=1){
			ans += tree[i];
			i -= (i & -i);
		}
		return ans;
	}
	
}
