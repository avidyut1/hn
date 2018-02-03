package HackerRankHiring;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class WinningLotteryTicketBrute {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            char inp[][] = new char[n][];
            for (int i = 0; i < n; i++) {
                inp[i] = in.readLine().trim().toCharArray();
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (test(inp[i],inp[j])) {
                        ans++;
                    }
                }
            }
            System.out.println(ans);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean test(char f[], char s[]) {
        boolean num[] = new boolean[10];
        for (int i = 0; i < f.length; i++) {
            num[f[i] - '0'] = true;
        }
        for (int i = 0; i < s.length; i++) {
            num[s[i] - '0'] = true;
        }
        for (int i = 0; i < num.length; i++) {
            if (!num[i])
                return false;
        }
        return true;
    }
}
