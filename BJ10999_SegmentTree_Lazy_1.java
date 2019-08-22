import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10999_SegmentTree_Lazy_1 {
	
	static long p[], tree[], lazy[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		p = new long[n+1];
		tree = new long[4*n+1];
		lazy = new long[4*n+1];
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
				long t4 = Long.parseLong(st.nextToken());
				update(1,1,n,t2,t3,t4);
			}else if(t1==2){
				System.out.println(sum(1,1,n,t2,t3));
			}
		}
	}
	
	static long init(int node, int start, int end){
		if(start == end){
			return tree[node] = p[start];
		}else{
			return tree[node] = init(node*2, start, (start+end)/2)+init(node*2+1, (start+end)/2+1, end);
		}
	}
	
	static void update_lazy(int node, int start, int end){
		if(lazy[node] != 0){
			tree[node] += (end-start+1)*lazy[node];
			if(start != end){
				lazy[node*2] += lazy[node];
				lazy[node*2+1] += lazy[node];
			}
			lazy[node] = 0;
		}
	}
	
	static void update(int node, int start, int end, int i, int j, long diff){
		update_lazy(node,start,end);
		if(i>end || j<start){
			return;
		}
		if(i<=start && j>=end){
			tree[node] += (end-start+1)*diff;
			if(start != end){
				lazy[node*2] += diff;
				lazy[node*2+1] += diff;
			}
		}else{
			update(node*2, start, (start+end)/2, i, j, diff);
			update(node*2+1, (start+end)/2+1, end, i, j, diff);
			tree[node] = tree[node*2]+tree[node*2+1];
		}
	}
	
	static long sum(int node, int start, int end, int i, int j){
		update_lazy(node,start,end);
		if(i>end || j<start){
			return 0;
		}
		if(i<=start && j>=end){
			return tree[node];
		}else{
			return sum(node*2, start, (start+end)/2, i, j)+sum(node*2+1, (start+end)/2+1, end, i, j);
		}
	}
}
