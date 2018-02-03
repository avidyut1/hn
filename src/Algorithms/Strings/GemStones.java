package Algorithms.Strings;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class GemStones {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            String ar[] = new String[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.readLine();
            }
            int ans = 0;
            for (int i = 97; i < 123; i++) {
                char c = (char)i;
                boolean all = true;
                for (int j = 0; j < n; j++) {
                    if (ar[j].indexOf(c) < 0) {
                        all = false;
                        break;
                    }
                }
                if (all)
                    ans++;
            }
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
