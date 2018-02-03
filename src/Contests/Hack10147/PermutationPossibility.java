package Contests.Hack10147;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 21/03/17
 **/
public class PermutationPossibility {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int m = in.readInt();
            List<Integer> ar = new ArrayList<>();
            Set<Integer> hs = new HashSet<>();
            for (int i = 0; i < m; i++) {
                int val = in.readInt();
                ar.add(val);
                hs.add(val);
            }
            if (hs.size() == ar.size()) {
                out.write("YES");
            }
            else {
                out.write("NO");
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
