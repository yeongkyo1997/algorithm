import java.io.*;
import java.util.StringTokenizer;

public class Main_24078 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        bw.write((n % 21) + "");
        bw.close();
    }
}
