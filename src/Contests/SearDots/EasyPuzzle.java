package Contests.SearDots;

import java.io.*;
import java.util.*;
import java.math.*;

public class EasyPuzzle {
    public static void main(String args[]) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = Integer.parseInt(in.readLine());
            for (int t = 0; t < tc; t++) {
                String nk[] = (in.readLine()).split(" ");
                int n = Integer.parseInt(nk[0]);
                int k = Integer.parseInt(nk[1]);
                String sar[] = (in.readLine()).split(" ");
                int ar[] = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = Integer.parseInt(sar[i]);
                }
                boolean ans = false;
                for (int i = 0; i < n; i++) {
                    if(ar[i] % k == 0) {
                        ans = true;
                        break;
                    }
                }
                if (ans) {
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
