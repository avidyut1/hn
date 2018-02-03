package Contests.Week27;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class Substring {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int q = in.readInt();
            String s = in.readLine();
            for (int i = 0; i < q; i++) {
                int l = in.readInt();
                int r = in.readInt();
                String sub = s.substring(l, r + 1);
                SuffixArray sa = new SuffixArray(sub);
                int lcp[] = sa.lcp;
                Suffix sar[] = sa.suffix_ar;
                long ans = 0l;
                ans += sub.length() - sar[0].string.length() + 1;
                for (int j = 1; j < sub.length(); j++) {
                    ans += sub.length() - sar[j].len + 1 - lcp[j];
                }
                out.write(Long.toString(ans));
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Suffix implements Comparable<Suffix>{
    public int ind;
    public String string;
    public int len;
    public Suffix(String s, int i){
        this.ind = i;
        this.string = s.substring(i);
        this.len = s.length() - i;
    }
    public int compareTo(Suffix that){
        return this.string.compareTo(that.string);
    }
}

class SuffixArray {
    public Suffix suffix_ar[];
    public int lcp[];
    public String t;

    public SuffixArray(String s) {
        this.t = s;
        suffix_ar = new Suffix[t.length()];
        lcp = new int[t.length()];
        lcp[0] = -7;
        for (int i = 0; i < t.length(); i++) {
            suffix_ar[i] = new Suffix(t, i);
        }
        Arrays.sort(suffix_ar);
        buildLcp();
    }

    public void buildLcp() {
        for (int i = 1; i < lcp.length; i++) {
            lcp[i] = lcp(suffix_ar[i - 1].string, suffix_ar[i].string);
        }
    }

    public int lcp(String a, String b) {
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return i;
            }
        }
        return Math.min(a.length(), b.length());
    }
}