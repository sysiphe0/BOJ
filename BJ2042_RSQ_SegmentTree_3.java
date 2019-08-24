import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2042_RSQ_SegmentTree_3 {
	static long p[], tree[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		p = new long[n+1];
		tree = new long[4*n+1];
		for(int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine());
			p[i] = Long.parseLong(st.nextToken());
		}
		init(1,1,n);
		for(int i=1; i<=m+k; i++){
			st = new StringTokenizer(br.readLine());
			int t1 = Integer.parseInt(st.nextToken());
			int t2 = Integer.parseInt(st.nextToken());
			int t3 = Integer.parseInt(st.nextToken());
			if(t1==1){
				long diff = t3-p[t2];
				update(1,1,n,t2,diff);
				p[t2] = t3;
			}else if(t1==2){
				System.out.println(sum(1,1,n,t2,t3));
			}
		}
	}
	
	static long init(int node, int start, int end){
		if(start==end){
			return tree[node] = p[start];
		}else{
			return tree[node] = init(node*2, start, (start+end)/2) + init(node*2+1, (start+end)/2+1, end);
		}
	}
	
	static void update(int node, int start, int end, int i, long diff){
		if(i<start || i> end){
			return;
		}else{
			tree[node] += diff;
			if(start != end){
				update(node*2, start, (start+end)/2, i, diff);
				update(node*2+1, (start+end)/2+1, end, i, diff);
			}
		}
	}
	
	static long sum(int node, int start, int end, int i, int j){
		if(i>end || j<start){
			return 0;
		}else if(i<=start && j>=end){
			return tree[node];
		}else{
			return sum(node*2, start, (start+end)/2, i, j) + sum(node*2+1, (start+end)/2+1, end, i, j);
		}
	}
}
