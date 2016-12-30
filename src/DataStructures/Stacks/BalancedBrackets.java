package DataStructures.Stacks;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class BalancedBrackets {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                char c[] = (in.readLine()).toCharArray();
                Stack<Character> st = new Stack<>();
                boolean ans = true;
                for (int i = 0; i < c.length; i++) {
                    if (c[i] == '{' || c[i] == '[' || c[i] == '(') {
                        st.push(c[i]);
                    }
                    else{
                        if (c[i] == '}') {
                            if (st.size() > 0 && st.peek() == '{') {
                                st.pop();
                            }
                            else{
                                ans = false;
                            }
                        }
                        else if (c[i] == ']') {
                            if (st.size() > 0 && st.peek() == '[') {
                                st.pop();
                            }
                            else
                                ans = false;
                        }
                        else if (c[i] == ')') {
                            if (st.size() > 0 && st.peek() == '(') {
                                st.pop();
                            }
                            else{
                                ans = false;
                            }
                        }
                    }
                }
                if (ans && st.empty()) {
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
