package Contests.Hack10146;

import java.io.*;
import java.util.*;
import java.math.*;

public class MarcCakewalk {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            Vector<Integer> vec = new Vector<>();
            for (int i = 0; i < n; i++) {
                vec.add(in.readInt());
            }
            Collections.sort(vec, Collections.reverseOrder());
            long ans = 0l;
            for (int i = 0; i < n; i++) {
                ans += Math.pow(2, i) * vec.get(i);
            }
            out.write(Long.toString(ans));
            out.newLine();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
