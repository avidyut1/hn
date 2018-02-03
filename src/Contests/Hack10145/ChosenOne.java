package Contests.Hack10145;

import java.io.*;
import java.util.*;
import java.math.*;

public class ChosenOne {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.readLong();
            }
            if (n == 1) {
                out.write(Long.toString(a[0] + 1));
                out.newLine();
            }
            else {
                final int MAX = (int)1e5 + 1;
                boolean primes[] = new boolean[MAX];
                Arrays.fill(primes, true);
                primes[0] = false;
                primes[1] = false;
                for (int i = 0; i < primes.length; i++) {
                    if (primes[i]) {
                        for (int j = 2 * i; j < primes.length; j+=i) {
                            primes[j] = false;
                        }
                    }
                }
                for (int i = 0; i < primes.length; i++) {
                    if (primes[i]) {
                        if (count(a, i) == 1) {
                            out.write(Integer.toString(i));
                            out.newLine();
                            break;
                        }
                    }
                }
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int count(long ar[], int d) {
        int count = 0;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] % d == 0) {
                count++;
            }
        }
        return ar.length - count;
    }
}
