package DataStructures.Stacks;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class MaxElement {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            Queue<Integer> pq = new PriorityQueue<>(1000000, Collections.reverseOrder());
            Stack<Integer> st = new Stack<>();
            for (int i = 0; i < n; i++) {
                int type = in.readInt();
                if (type == 1) {
                    int num = in.readInt();
                    st.push(num);
                    pq.add(num);
                }
                else if (type == 2) {
                    int rem = st.pop();
                    pq.remove(new Integer(rem));
                }
                else {
                    System.out.println(pq.peek());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
