package Archive.P1018;

    import java.io.BufferedReader;
    import java.io.BufferedWriter;
    import java.io.InputStreamReader;
    import java.io.OutputStreamWriter;
    import java.util.StringTokenizer;

    public class Main {

        private static int ROW = 8;
        private static int COL = 8;
        private static char[] flag = {'B', 'W'};


        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String[] map = new String[N];
            for (int i = 0; i < N; i++) {
                map[i] = br.readLine();
            }

            int res = Integer.MAX_VALUE;
            for (int i = 0; i <= N - ROW; i++) {
                for (int j = 0; j <= M - COL; j++) {
                    res = Math.min(res, calc(map, i, j));
                }
            }

            bw.write(res+"");
            bw.flush();
        }

        public static int calc(String[] map, int si, int sj) {
            int cnt = 0;
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COL; j++) {
                    int ci = si + i;
                    int cj = sj + j;

                    cnt += map[ci].charAt(cj) == flag[(i + j) % 2] ? 1 : 0;
                }
            }

            // 시작점이 W,B 두가지 경우가 있으므로
            // 두가지 경우 중 더 작은 값을 반환
            return Math.min(cnt,ROW*COL-cnt);
        }
    }
