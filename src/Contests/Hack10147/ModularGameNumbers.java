package Contests.Hack10147;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 21/03/17
 **/
public class ModularGameNumbers {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int p = in.readInt();
            int q = in.readInt();
            int ap[] = new int[p];
            int aq[] = new int[q];
            for (int i = 0; i < p; i++) {
                ap[i] = in.readInt();
            }
            for (int i = 0; i < q; i++) {
                aq[i] = in.readInt();
            }
            for (int i = 1; i <= n; i++) {
                Set<Integer> sums = new HashSet<>();
                for (int j = 0; j < p; j++) {
                    for (int k = 0; k < q; k++) {
                        int sum = i + ap[j] + aq[k];
                        sum %= n;
                        sums.add(sum);
                    }
                }
                if (sums.contains(0)) {
                    continue;
                }
                out.write(Integer.toString(i));
                out.newLine();
                out.close();
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
