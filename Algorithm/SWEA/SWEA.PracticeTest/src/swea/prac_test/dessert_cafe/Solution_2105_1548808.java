package swea.prac_test.dessert_cafe;

import java.io.*;
import java.util.*;
 
public class Solution_2105_1548808 {
    static int N;
    static int[] dx = {-1, 1, 1, -1};
    static int[] dy = {1, 1, -1, -1};
    static int[][] map;
    static boolean[][] visited;
    static int startX, startY;
    static boolean[] picked;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine());
 
        for(int tc=1; tc<=T; tc++){
            N = Integer.parseInt(br.readLine());
 
            map = new int[N][N];
            visited = new boolean[N][N];
            ans = 0;
            picked = new boolean[101];
 
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    startX = i;
                    startY = j;
                    visited[i][j] = true;
                    picked[map[i][j]] = true;
                    dfs(i, j, 0, 1);
                    picked[map[i][j]] = false;
                    visited[i][j] = false;
                }
            }
             
            if(ans == 0) ans = -1;
            sb.append("#").append(tc).append(" ").append(ans).append('\n');
        }
 
        System.out.print(sb);
    }
    static void dfs(int x, int y, int dir, int cnt){
        for(int turn=0; turn <=1; turn++){
            int ndir = dir + turn;
            if(ndir >= 4) continue;
 
            int nx = x + dx[ndir];
            int ny = y + dy[ndir];
 
            if(nx == startX && ny == startY && ndir == 3){
                ans = Math.max(ans, cnt);
                return;
            }
 
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (visited[nx][ny]) continue;
            if (picked[map[nx][ny]]) continue;
 
            visited[nx][ny] = true;
            picked[map[nx][ny]] = true;
 
            dfs(nx, ny, ndir, cnt + 1);
 
            visited[nx][ny] = false;
            picked[map[nx][ny]] = false;
        }
    }
}