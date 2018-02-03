package HackerRankTechnicalContent;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

class MagicalStrings {
    static int MOD = (int)1e9 + 7;
    static int magicalStrings(int n) {
        int dp[][] = new int[n][5];
        for (int i = 0; i < 5; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[i][1] += dp[i - 1][0];
            dp[i][0] += dp[i - 1][1];
            dp[i][2] += dp[i - 1][1];
            dp[i][0] += dp[i - 1][2];
            dp[i][1] += dp[i - 1][2];
            dp[i][3] += dp[i - 1][2];
            dp[i][4] += dp[i - 1][2];
            dp[i][2] += dp[i - 1][3];
            dp[i][4] += dp[i - 1][3];
            dp[i][0] += dp[i - 1][4];
            for (int j = 0; j < 5; j++) {
                dp[i][j] %= MOD;
            }
        }
        Long ans = 0L;
        for (int i = 0; i < 5; i++) {
            ans += dp[n - 1][i];
            ans %= MOD;
        }
        return ans.intValue();
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
                bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
                bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int res;
        int n;
        n = Integer.parseInt(in.nextLine().trim());

        res = magicalStrings(n);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }
}
