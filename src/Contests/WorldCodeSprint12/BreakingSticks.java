package Contests.WorldCodeSprint12;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class BreakingSticks {
    static HashMap<Long, Long> hm = new HashMap<>();
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
//            int n = in.readInt();
            int n = 100;
            int MAX = (int)1e6 + 2;
            long solution[] = new long[MAX];
            solution[0] = 0L;
            solution[1] = 1L;
            solution[2] = 3L;
            long ar[] = new long[MAX];
            for (int i = 2; i < MAX; i++) {
                solution[i] = Math.max(solution[i], i + 1);
                for (int j = 2 * i; j < MAX; j+=i) {
                    int times = j / i;
                    if (solution[j] < solution[i] * (long)times + 1){
                        ar[j] = i;
                    }
                    solution[j] = Math.max(solution[j], solution[i] * (long)times + 1);
                }
            }
            for (int i = 0; i < MAX; i++) {
                if (solution[i] == 0) {
                    solution[i] = i + 1;
                }
            }
            long ans = 0L;
            long num = (long)1e12 + 1;
            long st = System.currentTimeMillis();
            for (int i = 0; i < n; i++) {
//                long num = in.readLong();
                num--;
                if (num < MAX) {
                    ans += solution[(int)num];
                    continue;
                }
                long lans = 0L;
                for (int j = 2; j <= Math.sqrt(num); j++) {
                    if (num % j == 0) {
                        long ans1 = findAns(j, solution) * (num / j) + 1;
                        long ans2 = findAns(num / j, solution) * (j) + 1;
                        lans = Math.max(lans, Math.max(ans1, ans2));
                    }
                }
                out.newLine();
                if (lans == 0) {
                    lans = num + 1;
                }
                hm.put(num, lans);
                ans += lans;
            }
            long en = System.currentTimeMillis();
            out.write(Long.toString(en - st));
            out.newLine();
            out.write(Long.toString(ans));
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static long findAns(long i, long sol[]) {
        if (hm.containsKey(i)) {
            return hm.get(i);
        }
        if (i < sol.length) {
            return sol[(int)i];
        }
        long ans = 0L;
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                ans = Math.max(ans, findAns(j, sol) * (i / j) + 1);
                ans = Math.max(ans, findAns(i / j, sol) * j + 1);
            }
        }
        if (ans == 0) {
            ans = i + 1;
        }
        hm.put(i, ans);
        return ans;
    }
}
