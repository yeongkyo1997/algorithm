import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[][] map;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    static class Node {
        int x, y, depth;
        int wall;

        public Node(int x, int y, int depth, int wall) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.wall = wall;
        }

    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(new Node(0, 0, 1, 0));
        int[][][] visited = new int[N][M][2];
        visited[0][0][0] = 1;
        visited[0][0][1] = 1;

        int result = -1;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                result = cur.depth;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int ndepth = cur.depth + 1;

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 0) {
                        if (visited[nx][ny][cur.wall] == 0) {
                            queue.add(new Node(nx, ny, ndepth, cur.wall));
                            visited[nx][ny][cur.wall] = 1;
                        }
                    } else {
                        if (visited[nx][ny][1] == 0 && cur.wall == 0) {
                            queue.add(new Node(nx, ny, ndepth, 1));
                            visited[nx][ny][1] = 1;
                        }
                    }
                }
            }
        }
        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}