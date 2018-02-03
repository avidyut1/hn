package Contests.Week28;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class BoatTrips {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int c = in.readInt();
            int m = in.readInt();
            int total = c * m;
            boolean ans = true;
            for (int i = 0; i < n; i++) {
                int p = in.readInt();
                if (p > total) {
                    ans = false;
                }
            }
            if (ans){
                out.write("Yes");
            }
            else
                out.write("No");
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
