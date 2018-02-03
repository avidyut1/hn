package Algorithms.Strings;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class StringSimilarity {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                String s = in.readLine();
                SuffixArrayLinearithemic sa = new SuffixArrayLinearithemic(s.toCharArray());
                Integer saArray[] = sa.getArray();
                int lcp[] = sa.getLcp();
                int rank[] = sa.getRank();
                int stringind = rank[0];
                long ans = (long)s.length() + lcp[stringind];
                int mincommon = lcp[stringind];
                for (int i = stringind - 1; i > 0; i--) {
                    if (lcp[i] == 0){
                        break;
                    }
                    if (lcp[i] > mincommon) {
                        ans += mincommon;
                    }
                    else {
                        ans += lcp[i];
                        mincommon = lcp[i];
                    }
                }
                if (stringind + 1 < lcp.length) {
                    mincommon = lcp[stringind + 1];
                    for (int i = stringind + 1; i < lcp.length; i++) {
                        if (lcp[i] == 0) {
                            break;
                        }
                        if (lcp[i] >= mincommon) {
                            ans += mincommon;
                        }
                        else {
                            ans += lcp[i];
                            mincommon = lcp[i];
                        }
                    }
                }
                System.out.println(ans);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class SuffixArrayLinearithemic {
    private final int n;
    private final char[] str;
    public Integer[] pos;
    public int[] rank;
    private int[] cnt;
    private int[] next;
    public int[] lcp;
    private boolean[] bh;
    private boolean[] b2h;

    public SuffixArrayLinearithemic(char[] str) {
        this.n = str.length;
        this.str = str;
        this.pos = new Integer[n];
        this.rank = new int[n];
        this.cnt = new int[n];
        this.next = new int[n];
        this.lcp = new int[n];
        this.bh = new boolean[n];
        this.b2h = new boolean[n];
        suffixSort();
        computeLCP();
    }

    public void suffixSort() {
        for (int i = 0; i < n; ++i)
            pos[i] = i;
        Arrays.sort(pos, 0, n, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return str[o1] - str[o2];
            }
        });
        for (int i = 0; i < n; ++i) {
            bh[i] = i == 0 || str[pos[i]] != str[pos[i - 1]];
            b2h[i] = false;
        }
        for (int h = 1; h < n; h <<= 1) {
            int buckets = 0;
            for (int i = 0, j; i < n; i = j) {
                j = i + 1;
                while (j < n && !bh[j]) ++j;
                next[i] = j;
                ++buckets;
            }
            if (buckets == n) break;
            for (int i = 0; i < n; i = next[i]) {
                cnt[i] = 0;
                for (int j = i; j < next[i]; ++j)
                    rank[pos[j]] = i;
            }
            ++cnt[rank[n - h]];
            b2h[rank[n - h]] = true;
            for (int i = 0; i < n; i = next[i]) {
                for (int j = i; j < next[i]; ++j) {
                    int s = pos[j] - h;
                    if (s >= 0) {
                        int head = rank[s];
                        rank[s] = head + cnt[head]++;
                        b2h[rank[s]] = true;
                    }
                }
                for (int j = i; j < next[i]; ++j) {
                    int s = pos[j] - h;
                    if (s >= 0 && b2h[rank[s]])
                        for (int k = rank[s] + 1; k < n && !bh[k] && b2h[k]; ++k)
                            b2h[k] = false;
                }
            }
            for (int i = 0; i < n; ++i) {
                pos[rank[i]] = i;
                bh[i] |= b2h[i];
            }
        }
        for (int i = 0; i < n; ++i)
            rank[pos[i]] = i;
    }

    public void computeLCP() {
        for (int i = 0, h = 0; i < n; ++i) {
            if (rank[i] > 0) {
                int j = pos[rank[i] - 1];
                while (i + h < n && j + h < n && str[i + h] == str[j + h]) ++h;
                lcp[rank[i]] = h;
                if (h > 0) --h;
            }
        }
    }

    public Integer[] getArray() {
        return this.pos;
    }

    public int[] getLcp() {
        return this.lcp;
    }

    public int[] getRank(){
        return this.rank;
    }
}