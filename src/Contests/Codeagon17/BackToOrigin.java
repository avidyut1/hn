package Contests.Codeagon17;

import java.io.*;
import java.util.*;
import java.math.*;

public class BackToOrigin {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            long xt = in.readLong();
            long yt = in.readLong();
            int n = in.readInt();
            for (int i = 0; i < n; i++) {
                long x = in.readLong();
                long y = in.readLong();
                xt -= x;
                yt -= y;
            }
            out.write(Long.toString(xt) + " ");
            out.write(Long.toString(yt));
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
