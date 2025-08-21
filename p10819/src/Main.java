import java.io.*;
import java.util.*;
public class Main{
    /*
    브루트포스와 백트래킹을 떠올리긴 했으나 반으로 나눠서 탐색하면 N^2의 경우의 수로 줄지 않을까 했지만,
    그게 최대값인지 확신할 수 없어 풀이 실패
    배열의 모든 순서를 탐색할 때 vis배열을 두고 재귀로 풀때,
    depth == N인 경우에는 depth == N-1일때의 back 함수에서 vis[N-1] = false로 다시 되돌려 놓는 부분이 인상적이었다.
    이 점으로 0 1 2 3 4에서 0 1의 vis가 true일 때 2 3 4, 2 4 3, 3 2 4, 3 4 2 .. 등으로 전체 탐색이 된다는 것을 깨달았다.
     */
    static int N, arr[], cal[];
    static int result = 0;
    static boolean visit[];
    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        cal = new int[N];
        visit = new boolean[N];

        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }


        back(0);
        System.out.println(result);
    }

    static void back(int depth){
        if(depth==N){
            System.out.println();
            int sum = 0;
            for(int i=0;i<N-1;i++){
                sum += Math.abs(cal[i]-cal[i+1]);
            }
            result = Math.max(result, sum);
            return;
        }

        for(int i=0; i<N; i++){
            if(!visit[i]){
                System.out.print(i + " 방문 ");
                visit[i]=true;
                cal[depth]=arr[i];
                back(depth+1);
                visit[i]=false;
            }
        }
    }
}
// https://luz315.tistory.com/176