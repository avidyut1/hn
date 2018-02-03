package Algorithms.Implementation;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class SherlockandSquare {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            Vector<Long> squares = new Vector<>();
            int max = (int)1e5 + 1;
            for (int i = 1; i < max; i++) {
                long ii = (long)i;
                squares.add(new Long(ii * ii));
            }
            for (int t = 0; t < tc; t++) {
                long a = in.readLong();
                long b = in.readLong();
                int indf = Collections.binarySearch(squares, a);
                int inds = Collections.binarySearch(squares, b);
                int ans = 0;
                if (indf < 0 && inds < 0) {
                    indf = -1 - indf;
                    inds = -1 - inds;
                    ans = inds - indf;
                }
                else if (indf < 0 && inds >= 0){
                    indf = -1 - indf;
                    ans = inds - indf + 1;
                }
                else if (inds < 0 && indf >= 0) {
                    inds = -1 - inds;
                    ans = inds - indf;
                }
                else {
                    ans = inds - indf + 1;
                }
                out.write(Integer.toString(ans));
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
