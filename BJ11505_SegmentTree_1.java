import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ11505_SegmentTree_1 {

	static long tree[], p[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		p = new long[n+1];
		tree = new long[n*4+1];
		ArrayList<Long> sol = new ArrayList<Long>();
		for(int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine());
			p[i] = Integer.parseInt(st.nextToken());
		}
		init(1,1,n);
		for(int i=1; i<=m+k; i++){
			st = new StringTokenizer(br.readLine());
			int t1 = Integer.parseInt(st.nextToken());
			int t2 = Integer.parseInt(st.nextToken());
			int t3 = Integer.parseInt(st.nextToken());
			if(t1==1){
				p[t2] = t3;
				update(1,1,n,t2,t3);
			}else if(t1==2){
				sol.add(sum(1,1,n,t2,t3));
			}
		}
		for(int i=0; i<k; i++){
			System.out.println(sol.get(i));
		}
	}
	
	static long init(int node, int start, int end){
		if(start==end){
			return tree[node] = p[start]%1000000007;
		}else{
			init(node*2,start,(start+end)/2);
			init(node*2+1,(start+end)/2+1,end);
			return tree[node] = (tree[node*2]*tree[node*2+1])%1000000007;
		}
	}
	
	static void update(int node, int start, int end, int i, int val){
		if(i<start || i>end){
			return;
		}else{
			if(start==end){
				tree[node] = val%1000007;
			}else{
				update(node*2,start,(start+end)/2,i,val);
				update(node*2+1,(start+end)/2+1,end,i,val);
				tree[node] = (tree[node*2]*tree[node*2+1])%1000000007;
			}
		}
	}
	
	static long sum(int node, int start, int end, int i, int j){
		if(i>end || j<start){
			return -1;
		}else if(i<=start && j>=end){
			return tree[node];
		}else{
			long s1 = sum(node*2,start,(start+end)/2,i,j);
			long s2 = sum(node*2+1,(start+end)/2+1,end,i,j);
			if(s1==-1){
				return s2;
			}else if(s2==-1){
				return s1;
			}else{
				return (s1*s2)%1000000007;
			}
		}
	}
}
