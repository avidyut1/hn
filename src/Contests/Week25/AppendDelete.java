package Contests.Week25;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class AppendDelete {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            String s = in.readLine();
            String t = in.readLine();
            int k = in.readInt();
            if (k >= s.length() +  t.length()) {
                System.out.println("YES");
            }
            else{
                int reqk = 0;
                int lens = s.length();
                int lent = t.length();
                if(lens > lent) {
                    s = s.substring(0, lent);
                    reqk += (lens - lent);
                    lens = s.length();
                }
                int same = 0;
                for (int i = 0; i < Math.min(lent, lens) ; i++) {
                    if (s.charAt(i) == t.charAt(i)) {
                        same++;
                    } else {
                        break;
                    }
                }
                s = s.substring(0, same);
                reqk += (lens - s.length());
                reqk += (lent - s.length());
                int remk = k - reqk;
                if (reqk > k) {
                    System.out.println("No");
                }
                else {
                    if (remk % 2 == 0) {
                        System.out.println("Yes");
                    }
                    else {
                        System.out.println("No");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
