import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10868_RMQ_SegmentTree_2 {

	static int p[], tree[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		p = new int[n+1];
		tree = new int[4*n+1];
		for(int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine());
			p[i] = Integer.parseInt(st.nextToken());
		}
		init(1,1,n);
		for(int i=1; i<=m; i++){
			st = new StringTokenizer(br.readLine());
			int t1 = Integer.parseInt(st.nextToken());
			int t2 = Integer.parseInt(st.nextToken());
			System.out.println(query(1,1,n,t1,t2));
		}
	}
	
	static int init(int node, int start, int end){
		if(start == end){
			return tree[node] = p[start];
		}else{
			return tree[node] = Math.min(init(node*2, start, (start+end)/2), init(node*2+1, (start+end)/2+1, end));
		}
	}
	
	static int query(int node , int start, int end, int i, int j){
		if(i>end || j<start){
			return Integer.MAX_VALUE;
		}else if(i<=start && j>=end){
			return tree[node];
		}else{
			return Math.min(query(node*2, start, (start+end)/2, i, j), query(node*2+1, (start+end)/2+1, end, i, j));
		}
	}
}
