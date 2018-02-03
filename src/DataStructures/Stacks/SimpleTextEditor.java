package DataStructures.Stacks;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class SimpleTextEditor {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            Stack<String> s = new Stack<>();
            s.push("");
            int q = in.readInt();
            String st = "";
            for (int i = 0; i < q; i++) {
                String op[] = (in.readLine()).split(" ");
                int type = Integer.parseInt(op[0]);
                switch (type) {
                    case 1: st += op[1];
                            s.push(st);
                            break;
                    case 2: int k = Integer.parseInt(op[1]);
                            st = st.substring(0, st.length() - k);
                            s.push(st);
                            break;
                    case 3: k = Integer.parseInt(op[1]);
                            out.write(st.charAt(k - 1));
                            out.newLine();
                            break;
                    case 4: s.pop();
                            st = s.peek();
                            break;
                }
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
