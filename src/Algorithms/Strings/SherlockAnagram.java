package Algorithms.Strings;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class SherlockAnagram {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                char sar[] = (in.readLine()).toCharArray();
                int n = sar.length;
                int ans = 0;
                int [][] freqi = new int[n][26];
                for (int i = 0; i < n; i++) {
                    if (i - 1 >= 0) {
                        for (int j = 0; j < 26; j++) {
                            freqi[i][j] = freqi[i - 1][j];
                        }
                    }
                    freqi[i][sar[i] - 'a']++;
                }
                Map<String, Integer> hm = new HashMap<String, Integer>();
                Set<String> hs = new HashSet<String>();
                for (int i = 0; i < n; i++) {
                    for (int j = i; j < n; j++) {
                        int freq[] = new int[26];
                        System.arraycopy(freqi[j], 0, freq,  0, 26);
                        if (i - 1 >= 0) {
                            for (int k = 0; k < 26; k++) {
                                freq[k] -= freqi[i - 1][k];
                            }
                        }
                        String freqs = "";
                        for (int k = 0; k < 26; k++) {
                            freqs += Integer.toString(freq[k]);
                        }
                        hm.put(freqs, hm.containsKey(freqs) ? hm.get(freqs) + 1 : 1);
                        hs.add(freqs);
                    }
                }
                for (String s: hs) {
                    int count = hm.get(s);
                    ans += (count * (count - 1) / 2);
                }
                System.out.println(ans);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
