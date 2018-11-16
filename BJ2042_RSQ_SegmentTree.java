import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ2042_RSQ_SegmentTree {
	
	static long tree[],a[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		a = new long[1000001];
		tree = new long[3000001];
		ArrayList<Long> sol = new ArrayList<Long>();
		for(int i=1; i<=n ;i++){
			st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		init(1,1,n);
		for(int i=1; i<=m+k; i++){
			st = new StringTokenizer(br.readLine());
			int t1 = Integer.parseInt(st.nextToken());
			int t2 = Integer.parseInt(st.nextToken());
			if(t1==1){
				long t3 = Long.parseLong(st.nextToken());
				long tmp = t3-a[t2];
				a[t2] = t3;
				update(1,1,n,t2,tmp);
			}else if(t1==2){
				int t3 = Integer.parseInt(st.nextToken());
				sol.add(sum(1,1,n,t2,t3));
			}
		}
		
		for(int i=0; i<k; i++){
			System.out.println(sol.get(i));
		}
		
		
	}
	
	static long init(int node, int start, int end){
		if(start==end){
			return tree[node] = a[start];
		}else{
			return tree[node] = init(node*2,start,(start+end)/2)+init(node*2+1,(start+end)/2+1,end);
		}
		
	}
	
	static void update(int node, int start, int end, int i, long diff){
		if(i<start || i>end) return;
		tree[node] += diff;
		if(start!=end){
			update(node*2,start,(start+end)/2,i,diff);
			update(node*2+1,(start+end)/2+1,end,i,diff);
		}
	}
	
	static long sum(int node, int start, int end, int i, int j){
		if(i>end || j<start) return 0;
		if(i<=start&&j>=end){
			return tree[node];
		}else{
			return sum(node*2,start,(start+end)/2,i,j)+sum(node*2+1,(start+end)/2+1,end,i,j);
		}
		
	}
}
