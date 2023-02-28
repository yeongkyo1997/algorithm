import java.io.*;
import java.util.StringTokenizer;

public class Main_5676 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int N;
    private static int K;
    private static int[] arr;
    static class Command {
        char op;
        int a;
        int b;
        Command(char op, int a, int b) {
            this.op = op;
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {
       st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Command[] commands = new Command[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            char op = st.nextToken().charAt(0);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            commands[i] = new Command(op, a, b);
        }

        int[] result = new int[K];
        for (int i = 0; i < K; i++) {
            Command command = commands[i];
            if (command.op == 'C') {
                arr[command.a - 1] = command.b;
            } else {
                int product = 1;
                for (int j = command.a - 1; j < command.b; j++) {
                    product *= arr[j];
                }
                result[i] = product;
            }
        }

        for (int i = 0; i < K; i++) {
            if (commands[i].op == 'P') {
                bw.write(result[i] + "\n");
            }
        }
        bw.close();
    }
}