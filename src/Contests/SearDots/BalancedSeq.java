package Contests.SearDots;

import java.io.*;
import java.util.*;
import java.math.*;

public class BalancedSeq {
    public static void main(String args[]) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = Integer.parseInt(in.readLine());
            for (int t = 0; t < tc; t++) {
                String inp = (in.readLine());
                int res = 0;
                Stack<Character> st = new Stack<Character>();
                for (int i = 0; i < inp.length(); i++) {
                    char c = inp.charAt(i);
                    if (c == '('){
                        st.push(c);
                    }
                    else {
                        if (!st.empty()) {
                            st.pop();
                            res += 2;
                        }
                    }
                }
                System.out.println(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
