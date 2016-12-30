package DataStructures.Arrays;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class DynamicArray {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int lastAnswer = 0;
            int n = in.readInt();
            Vector<Integer> seqList[] = new Vector[n];
            for (int i = 0; i < n; i++) {
                seqList[i] = new Vector<>();
            }
            int q = in.readInt();
            for (int i = 0; i < q; i++) {
                int type = in.readInt();
                if (type == 1) {
                    int x = in.readInt();
                    int y = in.readInt();
                    int seqind = (x ^ lastAnswer) % n;
                    seqList[seqind].add(y);
                }
                else{
                    int x = in.readInt();
                    int y = in.readInt();
                    int seqind = (x ^ lastAnswer) % n;
                    lastAnswer = seqList[seqind].get(y % seqList[seqind].size());
                    out.write(Integer.toString(lastAnswer));
                    out.newLine();
                }
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
