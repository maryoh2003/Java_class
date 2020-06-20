package afterschool;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class DFS_BFS {
    static int[][] map;
    static boolean[] visit;
    static int n, m, v;  // 정점의 개수, 간선의 개수, 탐색을 시작할 정점의 번호

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("정점의 개수 / 간선의 개수 / 탐색을 시작할 정점의 번호");
        n = scan.nextInt();
        m = scan.nextInt();
        v = scan.nextInt();

        map = new int[n + 1][n + 1];
        visit = new boolean[n + 1];

        int num1, num2;

        for(int i = 1; i <= m; i++){
            num1 = scan.nextInt();
            num2 = scan.nextInt();
            map[num1][num2] = map[num2][num1] = 1;
        }

        dfs(v);
//        bfs(v);
    }

    public static void dfs(int v){
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        int p; // 탐색중인 정점
        boolean flag;

        visit[v] = true;
        System.out.print(v + " ");

        while(!stack.isEmpty()){
            p = stack.peek();
            flag = false;

            for(int i = 1; i < n + 1; i++){
                if(map[p][i] == 1 && !visit[i]){
                    stack.push(i);
                    visit[i] = true;
                    System.out.print(i + " ");
                    flag = true;
                    break;
                }
            }

            if(!flag){
                stack.pop();
            }
        }
    }

    public static void bfs(int v){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(v);
        visit[v] = true;

        while (!queue.isEmpty()){
            v = queue.poll();
            System.out.print(v + " ");

            for(int i = 1; i < n + 1; i++){
                if(map[v][i] == 1 && !visit[i]){
                    queue.offer(i);
                    visit[i] = true;
                }
            }
        }
    }
}