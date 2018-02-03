package Contests.SearDots;

import java.io.*;
import java.util.*;
import java.math.*;

public class ClosestString {
    public static void main(String args[]) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = Integer.parseInt(in.readLine());
            for (int t = 0; t < tc; t++) {
                String sp[] = (in.readLine()).split(" ");
                String s = sp[0];
                int k = Integer.parseInt(sp[1]);
                char ans[] = s.toCharArray();
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) != 'a') {
                        ans[i] = 'a';
                        k--;
                        if (k == 0) {
                            break;
                        }
                    }
                }
                if (k > 0)
                    for (int i = s.length() - 1; i >= 0; i--) {
                        if (s.charAt(i) == 'a' && ans[i] == 'a') {
                            k--;
                            ans[i] = 'b';
                            if (k == 0)
                                break;
                        }
                    }
                out.write(ans);
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
