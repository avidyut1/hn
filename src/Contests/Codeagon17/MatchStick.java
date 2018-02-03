package Contests.Codeagon17;

import java.io.*;
import java.util.*;
import java.math.*;

public class MatchStick {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            long n = in.readLong();
            int c = in.readInt();
            Crate[] ar = new Crate[c];
            for (int i = 0; i < c; i++) {
                long b = in.readLong();
                long m = in.readLong();
                ar[i] = new Crate(b, m);
            }
            Arrays.sort(ar);
            long ans = 0l;
            for (int i = 0; i < c; i++) {
                if (n >= ar[i].matchbox) {
                    n -= ar[i].matchbox;
                    ans += (ar[i].eachmatchstick * ar[i].matchbox);
                }
                else {
                    ans += (ar[i].eachmatchstick * n);
                    n = 0;
                }
            }
            out.write(Long.toString(ans));
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Crate implements Comparable<Crate>{
    public long matchbox, eachmatchstick;
    public Crate(long mb, long ms) {
        this.matchbox = mb;
        this.eachmatchstick = ms;
    }
    public int compareTo(Crate that) {
        if (this.eachmatchstick < that.eachmatchstick) {
            return 1;
        }
        return -1;
    }
}
