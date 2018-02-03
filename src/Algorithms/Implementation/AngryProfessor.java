package Algorithms.Implementation;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class AngryProfessor {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                int n = in.readInt();
                int k = in.readInt();
                int count = 0;
                for (int i = 0; i < n; i++) {
                    int time = in.readInt();
                    if (time <= 0) {
                        count++;
                    }
                }
                if (count >= k) {
                    System.out.println("NO");
                }
                else
                    System.out.println("YES");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
