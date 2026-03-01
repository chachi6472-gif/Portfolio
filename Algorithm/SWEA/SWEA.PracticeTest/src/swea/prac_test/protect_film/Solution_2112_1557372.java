package swea.prac_test.protect_film;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_2112_1557372 {
    private static int T, D, K, W, min;
    private static BufferedReader br;
    static int[][] map;
    static int[] selected;
 
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            min = Integer.MAX_VALUE;
            map = new int[D][W];
            selected = new int[D];
            for (int row=0; row<D; row++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int col=0; col<W; col++) {
                    map[row][col] = Integer.parseInt(st.nextToken());
                }
            }
             
            dfs(0, 0);
             
            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
        System.out.println(sb.toString());
    }
     
    static void dfs(int row, int cnt) {
        if (min <= cnt) return;
        if (row == D) {
            if (check()) {
                min = Math.min(min, cnt);
            }
            return;
        }
         
        selected[row] = 0;
        dfs(row+1, cnt);
         
        selected[row] = 1;
        dfs(row+1, cnt+1);
         
        selected[row] = 2;
        dfs(row+1, cnt+1);
    }
     
    static boolean check() {
        for (int col=0; col<W; col++) {
            boolean flag = false;
            int prev = 1;
            if (selected[0] == 0) prev = map[0][col];
            else if (selected[0] == 1) prev = 0;
            int count = 1;
            for (int row=1; row<D; row++) {
                if (selected[row] == 0) {
                    if (prev == map[row][col]) {
                        count++;
                    } else {
                        count = 1;
                    }
                    prev = map[row][col];
                } else if (selected[row] == 1) {
                    if (prev == 0) count++;
                    else count = 1;
                    prev = 0;
                } else {
                    if (prev == 1) count++;
                    else count = 1;
                    prev = 1;
                }
                if (count >= K) {
                    flag = true;
                    break;
                }
            }
            if (!flag) return false;
        }
        return true;
    }
}