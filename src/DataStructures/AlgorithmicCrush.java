package DataStructures;

import java.io.*;
import java.util.*;
import java.math.*;

public class AlgorithmicCrush {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int m = in.readInt();
            long ar[] = new long[n + 2];
            for (int i = 0; i < m; i++) {
                int a = in.readInt();
                int b = in.readInt();
                long k = in.readLong();
                ar[a] += k;
                ar[b + 1] -= k;
            }
            long max = 0l;
            for (int i = 1; i <= n; i++) {
                ar[i] += ar[i - 1];
                max = Math.max(max, ar[i]);
            }
            out.write(Long.toString(max));
            out.newLine();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
