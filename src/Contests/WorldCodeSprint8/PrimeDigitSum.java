package Contests.WorldCodeSprint8;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class PrimeDigitSum {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            boolean isprime[] = new boolean[10000];
            Arrays.fill(isprime, true);
            isprime[0] = false;
            isprime[1] = false;
            for (int i = 0; i < isprime.length; i++) {
                if(isprime[i]) {
                    for (int j = 2 * i; j < isprime.length; j+=i) {
                        isprime[j] = false;
                    }
                }
            }
            int max = (int)4e5 + 1;
            Set<Long> g[] = new HashSet[max];
            for (int i = 0; i < g.length; i++) {
                g[i] = new HashSet<>();
            }
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    for (int k = 0; k < 10; k++) {
                        for (int l = 0; l < 10; l++) {
                            for (int m = 0; m < 10; m++) {
                                String num = ""+i+j+k+l+m;
                                if (satisfy(true, num, isprime)) {
                                    int length = (Integer.parseInt(num)+"").length();
                                    g[length].add(Long.parseLong(num));
                                }
                            }
                        }
                    }
                }
            }
            Set<String> [] hs = new HashSet[max];
            for (int i = 0; i < hs.length; i++) {
                hs[i] = new HashSet<>();
            }
            for(long i : g[5]) {
                hs[5].add(""+i);
            }
            int ansupto = 20;
            for (int i = 6; i < ansupto; i++) {
                for (String val : hs[i - 1]) {
                    for (int j = 0; j < 10; j++) {
                        String newval = val +j;
                        if (satisfy(false, newval, isprime)){
                            hs[i].add(newval);
                        }
                    }
                }
            }
            for (int i = 0; i < ansupto; i++) {
                System.out.println("length i= " + i + " "+hs[i].size());
                Vector<Long> numv = new Vector<>();
            }
            int q = in.readInt();
            for (int i = 0; i < q; i++) {
                int n = in.readInt();
                if (n < 20) {
                    out.write(Integer.toString(hs[n].size()));
                    out.newLine();
                }
                else{
                    out.write("");
                    out.newLine();
                }
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean satisfy(boolean all, String n, boolean prime[]) {
        if (all) {
            boolean ans = true;
            for (int i = 0; i < n.length(); i++) {
                int j = i + 3;
                if(j > n.length()){
                    continue;
                }
                String sub = n.substring(i, j);
                int sum = 0;
                for (int k = 0; k < sub.length(); k++) {
                    sum += Integer.parseInt(Character.toString(sub.charAt(k)));
                }
                if (!prime[sum]) {
                    ans = false;
                }
            }
            for (int i = 0; i < n.length(); i++) {
                int j = i + 4;
                if(j > n.length()){
                    continue;
                }
                String sub = n.substring(i, j);
                int sum = 0;
                for (int k = 0; k < sub.length(); k++) {
                    sum += Integer.parseInt(Character.toString(sub.charAt(k)));
                }
                if (!prime[sum]) {
                    ans = false;
                }
            }
            for (int i = 0; i < n.length(); i++) {
                int j = i + 5;
                if(j > n.length()){
                    continue;
                }
                String sub = n.substring(i, j);
                int sum = 0;
                for (int k = 0; k < sub.length(); k++) {
                    sum += Integer.parseInt(Character.toString(sub.charAt(k)));
                }
                if (!prime[sum]) {
                    ans = false;
                }
            }
            return ans;
        }
        else{
            String last3 = n.substring(n.length() - 3, n.length());
            String last4 = n.substring(n.length() - 4, n.length());
            String last5 = n.substring(n.length() - 5, n.length());
            int sum = 0;
            boolean ans = true;
            for (int i = 0; i < last3.length(); i++) {
                sum += Integer.parseInt(Character.toString(last3.charAt(i)));
            }
            if (!prime[sum]) {
                ans = false;
            }
            sum = 0;
            for (int i = 0; i < last4.length(); i++) {
                sum += Integer.parseInt(Character.toString(last4.charAt(i)));
            }
            if (!prime[sum]) {
                ans = false;
            }
            sum = 0;
            for (int i = 0; i < last5.length(); i++) {
                sum += Integer.parseInt(Character.toString(last5.charAt(i)));
            }
            if (!prime[sum]) {
                ans = false;
            }
            return ans;
        }
    }
}
