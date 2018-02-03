package Contests.Hack10149;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 23/05/17
 **/
public class CartesianCountry {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            final int inf = -(int)1e9 + 7;
            int x1 = in.readInt();
            int y1 = in.readInt();
            int x2 = in.readInt();
            int y2 = in.readInt();
            int xc = in.readInt();
            int yc = in.readInt();
            long xvalid = inf;
            long yvalid = inf;
            for (int i = x1; i <= x2; i++) {
                if (valid(x1, x2, xc, i)) {
                    xvalid = i;
                }
            }
            for (int i = y1; i <= y2; i++) {
                if (valid(y1, y2, yc, i)) {
                    yvalid = i;
                }
            }
            long xmax = xvalid;
            long ymax = yvalid;
            long xmin = 2 * xc - xmax;
            long ymin = 2 * yc - ymax;
            long width = Math.max(xmax - xmin, xmin - xmax);
            long height = Math.max(ymax - ymin, ymin - ymax);
            width++;
            height++;
            long area = width * height;
            out.write(Long.toString(area / 2));
            out.newLine();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean valid(int x1, int x2, int xc, long x) {
        long xother = (2 * xc) - x;
        if (xother <= x2 && xother >= x1) {
            return true;
        }
        return false;
    }
}
