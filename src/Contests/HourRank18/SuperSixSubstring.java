package Contests.HourRank18;

import java.io.*;
import java.util.*;
import java.math.*;

public class SuperSixSubstring {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            char []s = in.readLine().toCharArray();
            int n = s.length;
            int cums[] = new int[n];
            for (int i = 0; i < n; i++) {
                cums[i] = s[i] - '0';
                if (i - 1 >= 0) {
                    cums[i] += cums[i - 1];
                }
            }
            long ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    if (i == j && s[i] - '0' == 0) {
                        ans++;
                        continue;
                    }
                    if (s[i] - '0' == 0) {
                        continue;
                    }
                    int sod = cums[j] - (i - 1 >= 0 ? cums[i - 1] : 0);
                    if (sod % 3 == 0 && (s[j] - '0') % 2 == 0) {
                        ans++;
                    }
                }
            }
            out.write(Long.toString(ans));
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
